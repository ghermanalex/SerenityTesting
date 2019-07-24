package com.evozon.tests;

import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.steps.serenity.*;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)

public class CheckoutTest extends BaseTest {


    @Steps
    CheckoutSteps checkoutSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    RegisterSteps registerSteps;

    @Steps
    ProductDetailsSteps productDetailsSteps;

    @Steps
    SearchSteps searchSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;


    @Test
    public void checkoutTest() {
        registerSteps.register();
        searchSteps.searchProduct(Constants.VALID_PRODUCT);
        productDetailsSteps.verifyDetailsRandomProduct();
        shoppingCartSteps.verfiyDetailsProductInShoppingCart();
        checkoutSteps.goToCheckoutPage();
        checkoutSteps.billingInformation();
        checkoutSteps.selectBillingCountry();
        checkoutSteps.clickShipToDifferentAddress();
        checkoutSteps.clickContinueShipping();
        checkoutSteps.shippingInformation();
        checkoutSteps.selectShippingCountry();
        checkoutSteps.clickContinueToShippingMethod();
        checkoutSteps.setShippingMethod();
        checkoutSteps.clickContinuePayment();
        checkoutSteps.verifyCheckoutDetails();
        checkoutSteps.placeOrder();



    }


}
