package etc;

import lombok.Getter;

/**
 * 環境を定義するクラス
 *
 * @author Hyungcheol Kim
 */
@Getter
public enum Env {
    /**
     * 本番環境
     */
    PROD("config-prod"),
    /**
     * staging環境
     */
    STAGING("config-staging"),
    /**
     * ローカル環境
     */
    LOCAL("config-local"),
    ;

    private final String filePrefix;
    Env(String filePrefix) {
        this.filePrefix = filePrefix;
    }
}
