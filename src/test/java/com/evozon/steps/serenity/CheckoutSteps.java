package com.evozon.steps.serenity;

import com.evozon.Factory.BillingInformationFactory;
import com.evozon.Factory.ShippingInformationFactory;
import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage;
    BillingInformation billingInformation = BillingInformationFactory.getBillingInformationInstance();
    ShippingInformation shippingInformation = ShippingInformationFactory.getShippingInformationInstance();


    @Step
    public void goToCheckoutPage(){
        checkoutPage.open();
    }

    @Step
    public void billingInformation(){
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
    }

    @Step
    public void clickContinueShipping (){
        checkoutPage.clickContinueShippingButton();
    }

    @Step
    public void clickEditShippingInformation(){
        checkoutPage.clickOnEditShippingInformation();
    }

    @Step
    public void clickShipToDifferentAddress(){
        checkoutPage.clickShipToDifferentAddress();
    }

    @Step
    public void shippingInformation() {

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
    public void verifyCheckoutDetails(){
        Assert.assertTrue("First name was not found",checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getFirstName()));
        Assert.assertTrue("Last name was not found",checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getLastname()));
        Assert.assertTrue("Address was not found",checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getAddress()));
        Assert.assertTrue("City name was not found", checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getCity()));
        Assert.assertTrue("Postal code was not found", checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getPostalCode()));
        Assert.assertTrue("Phone number was not found", checkoutPage.getCheckoutDetailsContainer("BILLING ADDRESS").getText().contains(billingInformation.getPhoneNumber()));

    }

    @Step
    public void checkConfirmOrderMessage(){
        Assert.assertTrue("The message is not visible", checkoutPage.checkConfirmMessage("YOUR ORDER HAS BEEN RECEIVED."));
    }









}
