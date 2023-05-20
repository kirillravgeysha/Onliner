package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.*;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class FastSearchFrame extends BasePage {

    private final SelenideElement frame = $x("//iframe[@class='modal-iframe']");
    private final SelenideElement frameActive = $x("//body");

    private final ElementsCollection fastSearchCategoryResults = $$x("//div" +
            "[@class='result__item result__item_category']/a");

    private final ElementsCollection fastSearchCategoryNumberOfResults = $$x("//div" +
            "[@class='result__item result__item_category']//span[@data-bind='text: $data.products_count']");

    private final ElementsCollection frameTabs = $$x("//div[@class='search__tabs-list']/div");

    private static final String FRAME_TAB_XPATH_PATTERN =
            "//div[@class='search__tabs-list']/div[contains(text(), '%s')]";

    private final ElementsCollection frameFilterList = $$x("//div" +
            "[@class='search__filter-list']//a[normalize-space(text())]");

    private final SelenideElement frameCloseIcon = $x("//span[@class='search__close']");

    private static final String FRAME_PRODUCT_OFFER_XPATH_PATTERN = "//div" +
            "[@class='product__offers__wrapper']/a[contains(@href, '%s')]";

    private final SelenideElement frameAddToCartButton = $x("//div[@class='offers-list__control" +
            " offers-list__control_default helpers_hide_tablet']//a[contains(text(), 'В корзину')]");

    private static final String FRAME_PRODUCT_TITLE_XPATH_PATTERN =
            "//a[contains(text(), '%s')]";

    private final SelenideElement frameCartButton = $x("//a[@title='Корзина']");

    public ElementsCollection getFastSearchCategoryResults() {
        return fastSearchCategoryResults.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getFastSearchCategoryNumberOfResults() {
        return fastSearchCategoryNumberOfResults.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getFastSearchTabs() {
        return frameTabs.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public FastSearchFrame selectFastSearchTab(String string) {
        $x(format(FRAME_TAB_XPATH_PATTERN, string)).shouldBe(visible, ofSeconds(30)).click();
        return new FastSearchFrame();
    }

    public ElementsCollection getFastSearchTabFilters() {
        return frameFilterList.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public FastSearchFrame switchToFrame() {
        getWebDriver().switchTo().frame(frame);
        return this;
    }

    public FastSearchFrame closeFastSearchFrameByIcon() {
        frameCloseIcon.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public FastSearchFrame closeFastSearchFrameByOffset() {
        frameActive.shouldBe(visible, ofSeconds(30)).click(ClickOptions.withOffset(-800, 0));
        return this;
    }

    public FastSearchFrame closeFastSearchFrameByEscape() {
        frameActive.pressEscape();
        return this;
    }

    public void checkFastSearchFrameNotVisible() {
        frame.shouldNotBe(visible, ofSeconds(30));
    }

    public FastSearchFrame clickOnProductOffer(String productName) {
        $x(format(FRAME_PRODUCT_OFFER_XPATH_PATTERN, productName)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public FastSearchFrame clickOnAddToCartButton() {
        frameAddToCartButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public FastSearchFrame clickOnCartButton() {
        frameCartButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public void checkProductWasAddedToCart(String productTitle) {
        $x(format(FRAME_PRODUCT_TITLE_XPATH_PATTERN, productTitle)).shouldBe(visible, ofSeconds(30));
    }


}
