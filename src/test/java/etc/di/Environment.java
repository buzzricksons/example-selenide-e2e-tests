package etc.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import etc.Env;

/**
 * {@link Env 環境}の情報を持っているアノテーション
 *
 * @author Hyungcheol Kim
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Environment {
    /**
     * {@link Env 環境}を返す
     *
     * @return {@link Env}
     */
    Env environment() default Env.LOCAL;
}
