package page;

import static com.codeborne.selenide.Selenide.page;

/**
 * 最初にランディングするページのクラス
 *
 * @author Hyungcheol Kim
 */
public class BeginPage {
    /**
     * 検索ページに移動する
     *
     * @return 検索ページ
     */
    public SearchPage goToSearchPage() {
        return page(SearchPage.class);
    }
}
