package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;


public class CatalogPage extends BasePage {

    private final ElementsCollection catalogClassifierLinks
            = $$x("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");

    private final SelenideElement catalogClassifier = $x("//div[@class='catalog-navigation-list " +
            " catalog-navigation-list_active catalog-navigation-list_opened']");

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    private final ElementsCollection catalogClassifiers = $$x("//div" +
            "[@class='catalog-navigation-list__aside-list']/div/div[@class='catalog-navigation-list__aside-title']");

    private static final String CATALOG_CLASSIFIER_ITEM_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and text() = '%s']";

    private final ElementsCollection catalogProducts = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");


    private final ElementsCollection catalogProductsTitle = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]");

    private final ElementsCollection catalogProductsDescription = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]");

    private static final String CATALOG_PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public ElementsCollection getCatalogClassifierLinks() {
        return catalogClassifierLinks.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public void checkCatalogClassifierDisplayed() {
        catalogClassifier.shouldBe(visible, ofSeconds(30));
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierItem(String link) {
        $x(format(CATALOG_CLASSIFIER_ITEM_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ElementsCollection getCatalogClassifiers() {
        return catalogClassifiers.shouldBe(CollectionCondition.anyMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));

    }

    public ElementsCollection getCatalogProducts() {
        return catalogProducts.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getCatalogProductsTitle() {
        return catalogProductsTitle.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getCatalogProductsDescription() {
        return catalogProductsDescription.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ProductPage clickOnProductLink(String product) {
        $x(format(CATALOG_PRODUCT_XPATH_PATTERN, product)).shouldBe(visible, ofSeconds(30)).click();
        return new ProductPage();
    }

}
