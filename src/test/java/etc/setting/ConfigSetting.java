package etc.setting;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import etc.Env;
import etc.Utils;
import etc.key.impl.ConfigKey;
import lombok.Getter;

/**
 * 実行環境の設定を持っているクラス
 *
 * @author Hyungcheol Kim
 */
@Getter
public enum ConfigSetting {
    /**
     * シングルトン
     */
    INSTANCE
    ;

    private final Env currentEnvironment = Optional.ofNullable(System.getProperty("yoda.config"))
            .map(s -> Env.valueOf(s.toUpperCase()))
            .orElse(Env.LOCAL);

    private final Map<ConfigKey, String> config = setConfig();

    /**
     * 引数のキーに該当する設定値を返す。
     *
     * @param key
     * @return 設定値
     */
    public String get(ConfigKey key) {
        return config.get(key);
    }

    /**
     * 現在の環境に該当するpropertiesファイルの設定値をマップで返す
     *
     * @see resources/config-prod.properties
     * @see resources/config-staging.properties
     * @see resources/config-local.properties
     *
     * @return
     */
    private Map<ConfigKey, String> setConfig() {
        var configMap = new HashMap<ConfigKey, String>();
        Utils.properties(currentEnvironment.getFilePrefix())
                .forEach((k, v) -> configMap.put(ConfigKey.valueOf(k.toString().toUpperCase()), (String) v));
        return configMap;
    }
}
