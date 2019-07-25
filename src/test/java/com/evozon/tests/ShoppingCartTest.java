package com.evozon.tests;

import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/csv/CartDetails.csv")
public class ShoppingCartTest extends BaseTest{

    @Steps
    public ProductDetailsSteps productDetailsSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;

    @Steps
    SearchSteps searchSteps;

    private String name;
    private String price;

//    @Test
//    public void verifyDetailsRandomProduct() {
//        shoppingCartSteps.openProductDetailsPage();
//        shoppingCartSteps.verfiyDetailsProductInShoppingCart();
//    }
//
//    @Test
//    public void verifyProductPriceDependingOnQuantity() {
//        shoppingCartSteps.openProductDetailsPage();
//        shoppingCartSteps.verifyPriceDependinOnRandomQuantity();
//    }

//    @Test
//    public void verifyProductDetailInCart(){
//        searchSteps.openHomepage();
//        searchSteps.searchProduct(name);
//        productDetailsSteps.chooseProductInGridView(name);
//        shoppingCartSteps.checkProductPrice(name, price);
//    }

}
