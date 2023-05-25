package com.it_academy.test.steps;

import com.codeborne.selenide.Configuration;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.pageobject.onliner.FastSearchFrame;
import com.it_academy.pageobject.onliner.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartSteps {

    private HomePage homePage = new HomePage();

    private FastSearchFrame fastSearchFrame = new FastSearchFrame();

    private String productTitle;

    private String cartProductTitle;

    @Given("the user opens Onliner website")
    public void userOpensOnlinerWebsite() {
        OnlinerNavigation.navigateToPortalPage();
    }


    @When("the user set {string} in search menu")
    public void userSetProductCategoryInSearchMenu(String productCategory) {
        homePage.setFastSearchValue(productCategory)
                .switchToFrame();
    }

    @When("the user clicks on the product offer button")
    public void userClicksOnTheProductOfferButton() {
        fastSearchFrame.clickOnProductOffer();
    }

    @When("the user clicks on the AddToCart button")
    public void userClicksOnTheAddToCartButton() {
        productTitle = fastSearchFrame
                .clickOnAddToCartButton()
                .getCatalogProductTitleName();
    }

    @When("the user opens Cart page")
    public void userOpensCartPage() {
        fastSearchFrame.clickOnCartButton();
    }

    @Then("product is displayed on cart")
    public void verifyProductTitleIsDisplayed() {
        cartProductTitle = fastSearchFrame.getCartProductTitle();
    }

    @Then("the user verify product name")
    public void verifyProductName() {
        assertThat(productTitle.toLowerCase(), anyOf(containsString(cartProductTitle.toLowerCase(Locale.ROOT))));
        Configuration.holdBrowserOpen = true;
    }

}
