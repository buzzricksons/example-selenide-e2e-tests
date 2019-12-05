package etc.key.impl;

import etc.key.Key;

/**
 * {@link etc.setting.ConfigSetting}で利用するKey
 *
 * @see /src/test/resources/config-local.properties
 * @see /src/test/resources/config-staging.properties
 * @see /src/test/resources/config-prod.properties
 *
 * @author Hyungcheol Kim
 */
public enum ConfigKey implements Key {
    /**
     * ブラウザ
     */
    BROWSER,
    /**
     * キャプチャーを保存するフォルダ名
     */
    REPORTS_FOLDER,
    /**
     * ヘッドレス
     */
    IS_HEADLESS,
    /**
     * タイムアウト
     */
    TIME_OUT,
    /**
     * ユーザーID
     */
    USER_ID,
    /**
     * ホスト
     */
    HOST,
    /**
     * 最初に接続するページ
     */
    PAGE_BEGIN
    ;

    @Override
    public Key of(String key) {
        return ConfigKey.valueOf(key);
    }
}
