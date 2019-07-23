package com.evozon.tests;

import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShoppingCartTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public ProductDetailsSteps productDetailsSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;

    @Test
    public void verifiyDetailsRandomProduct() {
        shoppingCartSteps.openProductDetailsPage();
        shoppingCartSteps.verfiyDetailsProductInShoppingCart();
    }



}
