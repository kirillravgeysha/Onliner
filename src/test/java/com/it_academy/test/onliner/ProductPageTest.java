package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageTest extends BaseTest {

    protected static final Logger LOG = LoggerFactory.getLogger(ProductPageTest.class);

    private HomePage homePage = new HomePage();
    private ProductPage productPage = new ProductPage();

    @BeforeMethod
    public void navigateToOnlinerProductHeadphonesPage() {
        OnlinerNavigation.navigateToPortalPage();
        homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierItem("Аудиотехника")
                .clickOnProductLink("Наушники");

    }

    @Test
    public void checkHeadPhonesProducts() {

        ElementsCollection parentProducts = productPage
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

    @Test
    public void compareHeadphones() {

        productPage
//                .closeAd()
                .clickOnRandomProductCheckBox()
                .clickOnRandomProductCheckBox()
                .clickOnCompareButton()
                .clickOnHideEqualCheckbox();

        String firstProductTitle = productPage
                .getProductTitlesToCompare().stream().findFirst().get().getText();
        LOG.info("First Title: " + firstProductTitle);
        String secondProductTitle = productPage
                .getProductTitlesToCompare().stream().skip(1).findFirst().get().getText();
        LOG.info("Second Title: " + secondProductTitle);

        assertThat(firstProductTitle).isNotEqualTo(secondProductTitle);

    }

    @Test
    public void checkManufacturerProductFilter() {

        ElementsCollection filteredProductTitles = productPage
                .closeAd()
                .clickOnProductFilter("Apple")
                .getParentProductsTitles();
        filteredProductTitles.stream().map(el -> el.getText()).forEach(System.out::println);
        filteredProductTitles.shouldHave(CollectionCondition
                .allMatch("Filtered element", el -> el.getText().contains("Apple")));
    }

    @Test
    public void checkPriceFilter() {

        Random random = new Random();
        String regex = "[^\\d,]"; /* description content pattern, where:
         [^\\d,] - any not digit symbol and not , ;
         eg :  от 33 902,14 р.
                  33902,14 */

        String firstProductPrice = productPage
//                .closeAd()
                .clickOnDropdownFilter()
                .clickOnPriceDropdownFilterItem("Дорогие")
                .getParentProductsPrices().stream().findFirst().get().getText();

        Double firstProductPriceValue = Double.parseDouble(firstProductPrice
                .replaceAll(regex, "").replaceAll("[,]", "."));

        String anyProductPrice = productPage
                .getParentProductsPrices().get(random.nextInt(productPage.getParentProductsPrices().size())).getText();

        Double anyProductPriceValue = Double.parseDouble(anyProductPrice
                .replaceAll("[^\\d,]", "").replaceAll("[,]", "."));

        LOG.info("FirstProduct price: " + firstProductPriceValue);
        LOG.info("AnyProduct price: " + anyProductPriceValue);

        assertThat(firstProductPriceValue).isGreaterThanOrEqualTo(anyProductPriceValue);

    }

}
