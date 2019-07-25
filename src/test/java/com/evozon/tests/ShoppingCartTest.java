package com.evozon.tests;

import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ShoppingCartTest extends BaseTest{

    @Steps
    public ProductDetailsSteps productDetailsSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;

    @Steps
    SearchSteps searchSteps;

    private String name,price;

    @Test
    public void verifyDetailsRandomProduct() {
        shoppingCartSteps.openProductDetailsPage();
        shoppingCartSteps.verfiyDetailsProductInShoppingCart();
    }

    @Test
    public void verifyProductPriceDependingOnQuantity() {
        shoppingCartSteps.openProductDetailsPage();
        shoppingCartSteps.verifyPriceDependinOnRandomQuantity();
    }

}
