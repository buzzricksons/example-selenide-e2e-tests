package etc;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.BiConsumer;

import etc.key.impl.ConfigKey;
import etc.setting.ConfigSetting;

/**
 * Initializationを行うクラス
 *
 * @see resources/config-prod.properties
 * @see resources/config-staging.properties
 * @see resources/config-local.properties
 *
 * @author Hyungcheol Kim
 */
public abstract class AbstractTests {
    private static final ConfigSetting config = ConfigSetting.INSTANCE;
    private static final BiConsumer<String, String> initSystemProperty = (k, v) -> Optional.of(v)
            .filter(value -> !value.isEmpty())
            .ifPresent(value -> System.setProperty(String.format("selenide.%s", k), value));
    private static boolean isNotInitialized = true;

    /**
     * テストを実行する前に一回のみinitializeを行う。
     *
     * @see com.codeborne.selenide.Configuration
     */
    @BeforeAll
    public static void initialize() {
        if (isNotInitialized) {
            initSystemProperty.accept("reportsFolder", config.get(ConfigKey.REPORTS_FOLDER) + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
            initSystemProperty.accept("headless", config.get(ConfigKey.IS_HEADLESS));
            initSystemProperty.accept("browser", config.get(ConfigKey.BROWSER));
            initSystemProperty.accept("timeout", config.get(ConfigKey.TIME_OUT));
            isNotInitialized = false;
        }
    }
}
