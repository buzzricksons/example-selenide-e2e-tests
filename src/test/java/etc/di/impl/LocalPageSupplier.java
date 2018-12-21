package etc.di.impl;

import etc.Env;
import etc.di.Environment;
import etc.di.PageSupplier;
import etc.key.impl.ConfigKey;
import etc.setting.ConfigSetting;
import lombok.NoArgsConstructor;
import page.basic.BeginPage;
import page.basic.TopPage;

import static com.codeborne.selenide.Selenide.open;

/**
 * staging環境用の{@link PageSupplier}
 *
 * @author Hyungcheol Kim
 */
@Environment(environment = Env.LOCAL)
@NoArgsConstructor
public class LocalPageSupplier implements PageSupplier {
    private final ConfigSetting setting = ConfigSetting.INSTANCE;
    private TopPage top;

    @Override
    public BeginPage begin() {
        return open(setting.get(ConfigKey.HOST) + setting.get(ConfigKey.PAGE_BEGIN), BeginPage.class);
    }

    @Override
    public TopPage top() {//lazy
        if (top == null) {
            this.top = begin().goToTop();
        }
        return top;
    }
}
