package com.it_academy.navigation;

import static com.codeborne.selenide.Selenide.open;

public class OnlinerNavigation {

     private static final String BASE_URL = "https://www.onliner.by/";

    private static final String CART = "https://cart.onliner.by/";

     public static void navigateToPortalPage() {
        open(BASE_URL);
    }

    public static void navigateToCartPage() {
        open(CART);
    }
}
