package com.evozon.tests;

import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.steps.serenity.CheckoutSteps;
import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)

public class CheckoutTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public CheckoutSteps checkoutSteps;

    @Steps
    public LoginSteps loginSteps;


    @Test
    public void checkoutTest() {
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginSteps.openHomepage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        checkoutSteps.goToCheckoutPage();
        checkoutSteps.billingInformation();
        checkoutSteps.selectBillingCountry();
        checkoutSteps.clickContinueShipping();
        checkoutSteps.clickEditShipping();
        checkoutSteps.shippingInformation();
        checkoutSteps.selectShippingCountry();
        checkoutSteps.clickContinueToShippingMethod();
        checkoutSteps.setShippingMethod();
        checkoutSteps.clickContinuePayment();
        checkoutSteps.placeOrder();
        //checkoutSteps.checkPropertyValue("SHIPPING ADDRESS",billInfo.getFirstName());



    }


}
