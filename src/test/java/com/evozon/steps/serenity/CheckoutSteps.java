package com.evozon.steps.serenity;

import com.evozon.model.BillingData;
import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingData;
import com.evozon.model.ShippingInformation;
import com.evozon.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage;
    BillingData billingData = new BillingData();
    BillingInformation billingInformation;
    ShippingData shippingData = new ShippingData();
    ShippingInformation shippingInformation;


    @Step
    public void goToCheckoutPage(){
        checkoutPage.open();
    }

    @Step
    public void billingInformation(){
        billingInformation = billingData.setBillingInformation();
        System.out.println(billingInformation.getFirstName() + " working, I guess?? " + billingInformation.getLastname());

        checkoutPage.typeBillingFirstName(billingInformation.getFirstName());
        checkoutPage.typeBillingLastName(billingInformation.getLastname());
        checkoutPage.typeBillingAddress(billingInformation.getAddress());
        checkoutPage.typeBillingCity(billingInformation.getCity());
        checkoutPage.typeBillingPostalCode(billingInformation.getPostalCode());
        checkoutPage.typeBillingTelephone(billingInformation.getPhoneNumber());

    }

    @Step
    public void selectBillingCountry(){
        checkoutPage.selectBillingCountry(5);
        System.out.println(billingInformation.getFirstName() + " working, I guess " + billingInformation.getLastname());
    }

    @Step
    public void clickContinueShipping (){
        checkoutPage.clickContinueShippingButton();
    }

    @Step
    public void clickEditShipping(){
        checkoutPage.clickOnEditShippingInformation();
    }

    @Step
    public void shippingInformation(){
        shippingInformation = shippingData.setShippingInformation();

        checkoutPage.typeShippingFirstName(shippingInformation.getFirstName());
        checkoutPage.typeShippingLastName(shippingInformation.getLastName());
        checkoutPage.typeShippingAddress(shippingInformation.getAddress());
        checkoutPage.typeShippingCityField(shippingInformation.getCity());
        checkoutPage.typeShippingPostal(shippingInformation.getPostalCode());
        checkoutPage.typeShippingTelephone(shippingInformation.getPhoneNumber());

    }

    @Step
    public void selectShippingCountry(){
        checkoutPage.selectShippingCountry(5);
    }

    @Step
    public void clickContinueToShippingMethod(){
        checkoutPage.clickContinueToShippingMethod();
    }

    @Step
    public void setShippingMethod(){
        checkoutPage.setShippingInformation();
    }

    @Step
    public void  clickContinuePayment(){
        checkoutPage.clickContinuePayment();
    }

    @Step
    public void placeOrder(){
        checkoutPage.clickPlaceOrder();
    }

    @Step
    public void checkPropertyValue(){
        Assert.assertTrue("The property value was not found",checkoutPage.getCheckoutDetailsContainer(billingInformation.getFirstName()).getText().contains("SHIPPING ADDRESS"));
    }







}
