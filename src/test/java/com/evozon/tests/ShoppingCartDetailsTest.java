package com.evozon.tests;

import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

public class ShoppingCartDetailsTest {
    @RunWith(SerenityParameterizedRunner.class)
    @UseTestDataFrom(value = "src/test/resources/csv/CartDetails.csv")
    public class ShoppingCartTest extends BaseTest {

        @Steps
        public ProductDetailsSteps productDetailsSteps;

        @Steps
        ShoppingCartSteps shoppingCartSteps;

        @Steps
        SearchSteps searchSteps;

        private String name, price;


        @Test
        public void verifyProductDetailInCart() {
            searchSteps.openHomepage();
            searchSteps.searchProduct(name);
            productDetailsSteps.chooseProductInGridView(name);
            shoppingCartSteps.checkProductPrice(name, price);
        }
    }

}
