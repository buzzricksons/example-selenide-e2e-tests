import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import etc.AbstractTests;
import page.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 検索ページのテストを行う
 *
 * @author Hyungcheol Kim
 */
@DisplayName("検索ページのテスト")
public class TestSearchPage extends AbstractTests {
    private final SearchPage searchPage = page.searchPage();
//    @AfterEach
//    public void cleanCookies() {
//        clearBrowserCookies();
//    }

    @Test
    @DisplayName("検索ページのタイトルテスト")
    public void testTitle() {
        assertEquals("Google", searchPage.pageTitle());
    }
}
