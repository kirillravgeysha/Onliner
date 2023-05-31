package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;


public class ProductPage extends BasePage {

    private final ElementsCollection parentProducts = $$x("//div[@class='schema-product']");

    private final ElementsCollection childProducts = $$x("//div" +
            "[@class='schema-product schema-product_children']");

    private final ElementsCollection parentProductsTitle = $$x("//div" +
            "[@class='schema-product__title']//span[contains(@data-bind, 'product')]");

    //div[@class='schema-product__title']//span[contains(@data-bind, 'product')]

    private final ElementsCollection childProductsTitle = $$x("//div" +
            "[@class='schema-product__title']//span[contains(@data-bind, 'children')]");

    private final ElementsCollection parentProductsDescription = $$x("//div" +
            "[@class='schema-products']//div[@class='schema-product__title']//span" +
            "[@data-bind='html: product.extended_name || product.full_name']");

    private final ElementsCollection parentProductsRating = $$x("//div" +
            "[@class='schema-products']//div[@class='schema-product__title']//span" +
            "[@data-bind='html: product.extended_name || product.full_name']");

    private final ElementsCollection parentProductsPrice = $$x("//div" +
            "[@class='schema-product__group']//div[contains(@data-bind, 'data: product')]//a" +
            "[contains(@class, 'value_primary') or contains(@class, 'value_additional')]");

    private final ElementsCollection childProductsPrice = $$x("//div" +
            "[@class='schema-product schema-product_children']//div[contains(@data-bind, 'data: children')]//a" +
            "[contains(@class, 'value_primary') or contains(@class, 'value_additional')]");

    private final ElementsCollection parentProductsImage = $$x("//div" +
            "[@class='schema-product__group']//a[@class='js-product-image-link']/img" +
            "[contains(@data-bind, 'alt: product')]");

    private final ElementsCollection childProductsImage = $$x("//div" +
            "[@class='schema-product__group']//a[@class='js-product-image-link']/img" +
            "[contains(@data-bind, 'alt: children')]");

    private final ElementsCollection parentProductsCheckbox = $$x("//div" +
            "[@class='schema-product__group']//div[@class='schema-product__compare']/div" +
            "[contains(@data-bind, 'data: product')]");

    private final ElementsCollection childProductsCheckbox = $$x("//div" +
            "[@class='schema-product__group']//div[@class='schema-product__compare']/div" +
            "[contains(@data-bind, 'data: children')]");

    private final SelenideElement compareButton = $x("//a" +
            "[@class='compare-button__sub compare-button__sub_main']");

    private final SelenideElement closeAdButton = $x("//span[contains(text(), 'Супер, спасибо')]");

    private final SelenideElement hideEqualCheckbox = $x("//input[@id='product-table__hide-equal']");

    private final ElementsCollection productTitlesCompare = $$x("//tr" +
            "[@class='product-table__row product-table__row_header product-table__row_top']//span" +
            "[@class='product-summary__caption']");

    private static final String PRODUCT_FILTER_XPATH_PATTERN =
            "//ul//label[@class='schema-filter__checkbox-item']//span[text()='%s']";

    private final SelenideElement priceDropdownFilter = $x("//a[@class='schema-order__link']");

    private static final String PRICE_DROPDOWN_FILTER_ITEM_XPATH_PATTERN =
            "//div[@class='schema-order__popover']//span[text()='%s']";

    public ElementsCollection getParentProducts() {
        return parentProducts.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getChildProducts() {
        return childProducts.shouldHave(sizeGreaterThan(0), ofSeconds(30));

    }

    public ElementsCollection getParentProductsTitles() {
        return parentProductsTitle.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getChildProductsTitles() {
        return childProductsTitle.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getParentProductsDescriptions() {
        return parentProductsDescription.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getParentProductsRatings() {
        return parentProductsRating.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getParentProductsPrices() {
        return parentProductsPrice.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getChildProductsPrices() {
        return childProductsPrice.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getParentProductsImages() {
        return parentProductsImage.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getChildProductsImages() {
        return childProductsImage.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getParentProductsCheckboxes() {
        return parentProductsCheckbox.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ElementsCollection getChildProductsCheckboxes() {
        return childProductsCheckbox.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ProductPage closeAd() {
        closeAdButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ProductPage clickOnRandomProductCheckBox(){
        Random random = new Random();
        parentProductsCheckbox.shouldHave(CollectionCondition.sizeGreaterThan(0), ofSeconds(30))
                .get(random.nextInt(parentProductsCheckbox.size()))
                .click();
        return this;
    }

    public ProductPage clickOnCompareButton(){
        compareButton.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ProductPage clickOnHideEqualCheckbox(){
        hideEqualCheckbox.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ElementsCollection getProductTitlesToCompare(){
      return  productTitlesCompare.shouldHave(sizeGreaterThan(0), ofSeconds(30));
    }

    public ProductPage clickOnProductFilter(String manufacturer) {
        $x(format(PRODUCT_FILTER_XPATH_PATTERN, manufacturer)).shouldBe(visible, ofSeconds(30)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ProductPage clickOnDropdownFilter(){
        priceDropdownFilter.shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ProductPage clickOnPriceDropdownFilterItem(String item){
        $x(format(PRICE_DROPDOWN_FILTER_ITEM_XPATH_PATTERN, item)).shouldBe(visible, ofSeconds(30)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
