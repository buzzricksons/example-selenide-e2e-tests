package etc.di.impl;

import com.codeborne.selenide.Selenide;

import etc.Env;
import etc.di.Environment;
import etc.di.PageSupplier;
import etc.key.impl.ConfigKey;
import etc.setting.ConfigSetting;
import lombok.NoArgsConstructor;
import page.BeginPage;
import page.SearchPage;
import page.SearchResultPage;

import static com.codeborne.selenide.Selenide.open;

/**
 * local環境用の{@link PageSupplier}
 *
 * @author Hyungcheol Kim
 */
@Environment(environment = Env.LOCAL)
@NoArgsConstructor
public class LocalPageSupplier implements PageSupplier {
    private final ConfigSetting setting = ConfigSetting.INSTANCE;
    private final SearchPage searchPage = begin().goToSearchPage();

    @Override
    public BeginPage begin() {
        return open(setting.get(ConfigKey.HOST) + setting.get(ConfigKey.PAGE_BEGIN), BeginPage.class);
    }

    @Override
    public SearchPage searchPage() {
        return searchPage;
    }

    @Override
    public SearchResultPage searchResultPage(String keyword) {
        searchPage.searchBox().val(keyword);
        searchPage.searchButon().click();
        SearchResultPage searchResultPage = Selenide.page(new SearchResultPage());
        return searchResultPage;
    }
}
