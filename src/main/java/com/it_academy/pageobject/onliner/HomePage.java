package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {

    private static final String CATALOG_LINK_XPATH_PATTERN =
            "//span[@class='b-main-navigation__text' and text()='%s']";

    private final SelenideElement fastSearch = $x("//form" +
            "[@class='fast-search__form']//input[@class='fast-search__input']");

    public CatalogPage clickOnCatalogLink(String link) {
        $x(format(CATALOG_LINK_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return new CatalogPage();
    }

    public FastSearchFrame setFastSearchValue(String productCategory) {
        fastSearch.shouldBe(visible, ofSeconds(30)).setValue(format(productCategory));
        return new FastSearchFrame();
    }

}
