package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {

    private final SelenideElement fastSearch = $x("//form" +
            "[@class='fast-search__form']//input[@class='fast-search__input']");


    public FastSearchFrame setFastSearchValue(String productCategory) {
        fastSearch.shouldBe(visible, ofSeconds(30)).setValue(format(productCategory));
        return new FastSearchFrame();
    }

}
