import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import etc.AbstractTests;
import etc.di.DependencyFactory;
import etc.di.PageSupplier;
import etc.key.impl.ConfigKey;
import etc.setting.ConfigSetting;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * トップページのテストを行う
 *
 * @author Hyungcheol Kim
 */
@DisplayName("トップページのテスト")
public class TestTopPage extends AbstractTests {
    private final ConfigSetting settings = ConfigSetting.INSTANCE;
    private final PageSupplier page = DependencyFactory.loadDependencyByEnvAnnotaion(PageSupplier.class);

    @AfterEach
    public void cleanCookies() {
        clearBrowserCookies();
    }

    @Test
    @DisplayName("ユーザーIDが一致するかをテスト")
    public void testUserID() {
        page.top().storeAccount().shouldBe(text(settings.get(ConfigKey.USER_ID)));
    }


    @Test
    @DisplayName("特定のクッキーが存在するかをテスト")
    public void testCookie() {
        assertFalse(page.top().someCookie().isEmpty(), () -> "クッキーが存在しません。");
    }

    @Test
    @DisplayName("トップのタブが選択されているかをテスト")
    public void testSelectedTab() {
        page.top().selectedTab().shouldBe(text("トップ"));
    }

    @Test
    @DisplayName("タイトルが正しいかをテスト")
    public void testTitle() {
        assertEquals("Google", page.top().pageTitle());
    }
}
