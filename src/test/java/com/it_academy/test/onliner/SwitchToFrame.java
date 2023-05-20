package com.it_academy.test.onliner;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.pageobject.onliner.HomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

public class SwitchToFrame {

   private HomePage homePage = new HomePage();

    @BeforeMethod
    public void switchToFastSearchFrame(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        OnlinerNavigation.navigateToPortalPage();
        homePage
                .setFastSearchValue("Наушники")
                .switchToFrame();
    }
}
