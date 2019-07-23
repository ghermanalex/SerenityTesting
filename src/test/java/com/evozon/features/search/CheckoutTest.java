package com.evozon.features.search;

import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.steps.serenity.CheckoutSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class CheckoutTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public CheckoutSteps checkoutSteps;

    @Test
    public void checkoutTest() {

        BillingInformation billInfo = checkoutSteps.countryBillingInformation();
        ShippingInformation shipInfo = checkoutSteps.shippingInformation();
        billInfo.getFirstName();
        billInfo.getLastname();
        billInfo.getAddress();
        billInfo.getCity();
        billInfo.getPostalCode();
        checkoutSteps.selectBillingCountry();
        billInfo.getPhoneNumber();
        checkoutSteps.clickContinueShipping();
        checkoutSteps.clickEditShipping();
        shipInfo.getFirstName();
        shipInfo.getLastName();
        shipInfo.getAddress();
        shipInfo.getCity();
        shipInfo.getPostalCode();
        checkoutSteps.selectShippingCountry();
        shipInfo.getPhoneNumber();
        checkoutSteps.clickContinueToShippingMethod();
        checkoutSteps.setShippingMethod();
        checkoutSteps.clickContinuePayment();
        checkoutSteps.placeOrder();
        checkoutSteps.checkPropertyValue("SHIPPING ADDRESS",billInfo.getFirstName());



    }


}
