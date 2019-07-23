package com.evozon.steps.serenity;

import com.evozon.model.BillingInformation;
import com.evozon.model.ShippingInformation;
import com.evozon.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage;

    @Step
    public BillingInformation countryBillingInformation(){
        try {
            wait(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.open();
        BillingInformation billingInformation = new BillingInformation();
        String firstName= RandomStringUtils.random(10);
        String lastName = RandomStringUtils.random(5);
        String address = RandomStringUtils.random(10);
        String city = RandomStringUtils.random(5);
        String postalCode = RandomStringUtils.random(7);
        String telephone = RandomStringUtils.randomNumeric(10);

        checkoutPage.typeBillingFirstName(firstName);
        checkoutPage.typeBillingLastName(lastName);
        checkoutPage.typeBillingAddress(address);
        checkoutPage.typeBillingCity(city);
        checkoutPage.typeBillingPostalCode(postalCode);
        checkoutPage.typeBillingTelephone(telephone);

        return billingInformation;

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
    public void clickEditShipping(){
        checkoutPage.clickOnEditShippingInformation();
    }

    @Step
    public ShippingInformation shippingInformation(){
        ShippingInformation shippingInformation = new ShippingInformation();
        String firstName= RandomStringUtils.random(10);
        String lastName = RandomStringUtils.random(5);
        String address = RandomStringUtils.random(10);
        String city = RandomStringUtils.random(5);
        String postalCode = RandomStringUtils.random(7);
        String telephone = RandomStringUtils.randomNumeric(10);

        checkoutPage.typeShippingFirstName(firstName);
        checkoutPage.typeShippingLastName(lastName);
        checkoutPage.typeBillingLastName(lastName);
        checkoutPage.typeShippingAddress(address);
        checkoutPage.typeShippingCityField(city);
        checkoutPage.typeShippingPostal(postalCode);
        checkoutPage.typeShippingTelephone(telephone);

        return shippingInformation;
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
    public void checkPropertyValue(String propertyGroupName,String  expectedPropertyValue){
        Assert.assertTrue("The property value was not found",checkoutPage.getCheckoutDetailsContainer(propertyGroupName).getText().contains(expectedPropertyValue));
    }







}
