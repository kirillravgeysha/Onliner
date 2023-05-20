package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private ProductPage productPage = new ProductPage();

    @Test
    public void checkHeadPhonesProducts() {

        OnlinerNavigation.navigateToPortalPage();
        ElementsCollection parentProducts = homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierItem(" Аудиотехника ")
                .clickOnProductLink("Наушники")
                .closeAd()
                .getParentProducts();

        ElementsCollection parentProductsTitles = productPage.getParentProductsTitles();
        ElementsCollection parentProductsDescriptions = productPage.getParentProductsDescriptions();
        ElementsCollection parentProductsRatings = productPage.getParentProductsRatings();
        ElementsCollection parentProductsPrices = productPage.getParentProductsPrices();
        ElementsCollection parentProductsImages = productPage.getParentProductsImages();
        ElementsCollection parentProductsCheckboxes = productPage.getParentProductsCheckboxes();

        parentProductsTitles.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsDescriptions.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsRatings.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsPrices.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsImages.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsCheckboxes.shouldHave(CollectionCondition.size(parentProducts.size()));

        ElementsCollection childProducts = productPage
                .getChildProducts();

        ElementsCollection childProductsTitles = productPage.getChildProductsTitles();
        ElementsCollection childProductsPrices = productPage.getChildProductsPrices();
        ElementsCollection childProductsImages = productPage.getChildProductsImages();
        ElementsCollection childProductsCheckboxes = productPage.getChildProductsCheckboxes();

        childProductsTitles.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsPrices.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsImages.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsCheckboxes.shouldHave(CollectionCondition.size(childProducts.size()));

    }

}
