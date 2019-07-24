package com.evozon.tests;

import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.steps.serenity.CheckoutSteps;
import com.evozon.steps.serenity.LoginSteps;
import com.evozon.steps.serenity.RegisterSteps;
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
    ProductDetailsPage productDetailsPage;


    @Test
    public void checkoutTest() {
        loginSteps.openHomepage();

        registerSteps.register();
        loginSteps.performLoginWithNewRegister();
        //productDetailsPage.

        loginSteps.checkThatYouAreLoggedIn(Constants.USER_EMAIL, Constants.USER_PASS);

        checkoutSteps.goToCheckoutPage();
        checkoutSteps.billingInformation();
        checkoutSteps.selectBillingCountry();
        checkoutSteps.clickContinueShipping();
        checkoutSteps.shippingInformation();
        checkoutSteps.selectShippingCountry();
        checkoutSteps.clickContinueToShippingMethod();
        checkoutSteps.setShippingMethod();
        checkoutSteps.clickContinuePayment();
        checkoutSteps.placeOrder();
        //checkoutSteps.checkPropertyValue("SHIPPING ADDRESS",billInfo.getFirstName());



    }


}
