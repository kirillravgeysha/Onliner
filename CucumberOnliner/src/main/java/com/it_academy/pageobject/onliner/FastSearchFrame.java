package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
import com.it_academy.pageobject.BasePage;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;

public class FastSearchFrame extends BasePage {

    private final SelenideElement frame = $x("//iframe[@class='modal-iframe']");

    private final ElementsCollection frameProductOffers = $$x("//div" +
            "[@class='result__item result__item_product']//a[@class='button button_orange product__button']");

    private final SelenideElement catalogProductTitle = $x("//div[@class='catalog-masthead']//h1");

    private final SelenideElement frameAddToCartButton = $x("//div[@class='offers-list__control" +
            " offers-list__control_default helpers_hide_tablet']//a[contains(text(), 'В корзину')]");

    private final SelenideElement frameCartProductTitle = $x("//div" +
            "[@class='cart-form__offers-flex']//div[@class='cart-form__offers-part cart-form__offers-part_data']//a");

    private final SelenideElement frameCartButton = $x("//a[@title='Корзина']");


    public FastSearchFrame switchToFrame() {
        getWebDriver().switchTo().frame(frame);
        return this;
    }

    public FastSearchFrame clickOnProductOffer() {
        Random random = new Random();
        frameProductOffers.shouldHave(CollectionCondition.sizeGreaterThan(0), ofSeconds(30))
                .get(random.nextInt(frameProductOffers.size()))
                .click();
        return this;
    }

    public FastSearchFrame clickOnAddToCartButton() {
        frameAddToCartButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public String getCatalogProductTitleName() {
       return catalogProductTitle.shouldBe(visible, ofSeconds(30)).getText();
    }

    public FastSearchFrame clickOnCartButton() {
        frameCartButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public String getCartProductTitle() {
        return frameCartProductTitle.shouldBe(visible, ofSeconds(30))
                .getText();
    }

}
