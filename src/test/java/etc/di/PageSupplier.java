package etc.di;

import page.basic.BeginPage;
import page.basic.TopPage;

/**
 * ページを提供するインタフェース
 *
 * @author Hyungcheol Kim
 */
public interface PageSupplier {
    /**
     * ストクリProのbeginページ
     *
     * @return
     */
    BeginPage begin();
    /**
     * トップページを返す
     *
     * @return
     */
    TopPage top();
}
