package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.navigation.OnlinerNavigation;

import com.it_academy.pageobject.onliner.FastSearchFrame;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FastSearchFrameTest extends SwitchToFrame {

    @BeforeClass
    public void navigateToOnlinerWebsite(){
        OnlinerNavigation.navigateToPortalPage();
    }

    private FastSearchFrame fastSearchFrame = new FastSearchFrame();

    @Test
    public void checkIframeFastSearchTabs() {

        ElementsCollection fastSearchResults = fastSearchFrame
                .getFastSearchTabs();

        fastSearchResults.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("в каталоге", "в новостях", "на барахолке", "на форуме"));

    }

    @Test
    public void checkHeadPhonesIframeFastSearchCategory() {

        String regex = "\\d*"; /* description content pattern, where:
        \\d* - any number of digits,  eg : 8130 */

        ElementsCollection fastSearchCategoryResults = fastSearchFrame
                .getFastSearchCategoryResults();

        fastSearchCategoryResults.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("Наушники и гарнитуры"));

        ElementsCollection fastSearchCategoryNumberOfResults = fastSearchFrame
                .getFastSearchCategoryNumberOfResults();

        List<String> categoryCounts = fastSearchCategoryNumberOfResults.texts();
        assertThat(categoryCounts.stream().
                allMatch(element -> element.matches(regex)))
                .as("Description is not contain number of products")
                .isTrue();
    }

    @Test
    public void checkIframeFastSearchTabNewsFilters() {

        ElementsCollection fastSearchTabFilters = fastSearchFrame
                .selectFastSearchTab("в новостях")
                .getFastSearchTabFilters();

        fastSearchTabFilters.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("В любом разделе", "За полгода", "Сначала релевантные"));
    }

    @Test
    public void checkCloseFastSearchFrameByIcon() {
        fastSearchFrame
                .closeFastSearchFrameByIcon()
                .checkFastSearchFrameNotVisible();
    }

    @Test
    public void checkCloseFastSearchFrameByEscape() {
        fastSearchFrame
                .closeFastSearchFrameByEscape()
                .checkFastSearchFrameNotVisible();
    }

}
