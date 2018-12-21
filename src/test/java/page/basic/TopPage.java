package page.basic;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
/**
 * トップページのクラス
 *
 * @author Hyungcheol Kim
 */
public class TopPage {
    private Supplier<SelenideElement> result = () -> $(".ycFix");

    /**
     * ストアアカウントを返す
     * @return
     */
    public SelenideElement storeAccount() {
        return result.get().$(".ycMdItemAct").$$(By.tagName("span")).get(1);
    }

    /**
     * 現在選択されているタブを返す
     * @return
     */
    public SelenideElement selectedTab() {
        return result.get().$(".ycMdMenu").find(By.className("cur"));
    }

    /**
     * トップページのタイトルを返す
     *
     * @param title
     */
    public String pageTitle() {
        return title();
    }

    /**
     * トップページのSNAクッキーを返す
     *
     * @return
     */
    public String someCookie() {
        return WebDriverRunner.getWebDriver().manage().getCookieNamed("SNA").getValue();
    }

    /**
     * 引数のタブを返す
     * @param linkName
     * @return
     */
    public SelenideElement tabLink(String linkName) {
        return result.get().$(".ycMdMenu").find(By.linkText(linkName));
    }
}
