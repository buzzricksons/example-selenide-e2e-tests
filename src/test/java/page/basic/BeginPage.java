package page.basic;

import static com.codeborne.selenide.Selenide.page;

/**
 * 最初にランディングするページのクラス
 *
 * @author Hyungcheol Kim
 */
public class BeginPage {
    /**
     * トップページに移動する
     *
     * @return トップページ
     */
    public TopPage goToTop() {
        //Your Top Page Code
        return page(TopPage.class);
    }
}
