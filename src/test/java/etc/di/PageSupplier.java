package etc.di;

import page.BeginPage;
import page.SearchPage;
import page.SearchResultPage;

/**
 * ページを提供するインタフェース
 *
 * @author Hyungcheol Kim
 */
public interface PageSupplier {
    /**
     * beginページ
     *
     * @return beginページ
     */
    BeginPage begin();
    /**
     * 検索ページを返す
     *
     * @return 検索ページ
     */
    SearchPage searchPage();
    /**
     * 検索結果ページを返す
     *
     * @return 検索結果ページ
     */
    SearchResultPage searchResultPage(String keyword);
}
