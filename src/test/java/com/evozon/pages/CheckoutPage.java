package com.evozon.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class CheckoutPage extends BasePage {

    @FindBy(id = "billing:firstname")
    private WebElementFacade billingFirstNameField;

    @FindBy(id = "billing:lastname")
    private WebElementFacade billingLastNameField;

    @FindBy(id = "billing:street1")
    private WebElementFacade billingAddressField;

    @FindBy(id = "billing:city")
    private WebElementFacade billingCitiField;

    @FindBy(id = "billing:region_id")
    private WebElementFacade billingStateDropdown;

    @FindBy(id = "billing:postcode")
    private WebElementFacade billingPostalCodeField;

    @FindBy(id = "billing:country_id")
    private WebElementFacade billingCountryDropdown;
    //String country = "United Kingdom";

    @FindBy(id = "billing:telephone")
    private WebElementFacade billingTelephoneField;

    @FindBy(css = "#billing-buttons-container >button")
    private WebElementFacade continueShippingbutton;

    @FindBy(css = "[title='Ship to different address']")
    private WebElementFacade shipToDifferentAddressRadioButton;

    @FindBy(css = "#opc-shipping div.step-title a")
    private WebElement editShippingInformationButton;

    @FindBy(id = "shipping:firstname")
    private WebElementFacade shippingFirstNameField;

    @FindBy(id = "shipping:lastname")
    private WebElementFacade shippingLastName;

    @FindBy(id = "shipping:street1")
    private WebElementFacade shippingAddressField;

    @FindBy(id = "shipping:city")
    private WebElementFacade shippingCityField;

    @FindBy(id = "shipping:region_id")
    private WebElementFacade shippingStateDropdown;

    @FindBy(id = "shipping:postcode")
    private WebElementFacade shippingPostalCodeField;

    @FindBy(id = "shipping:country_id")
    private WebElementFacade shippingCountryDropdown;

    @FindBy(id = "shipping:telephone")
    private WebElementFacade shippingTelephoneNumber;

    @FindBy(css = "#shipping-buttons-container .button")
    private WebElementFacade continueToShoppingMethodButton;

    @FindBy(id = "s_method_freeshipping_freeshipping")
    private WebElement freeShippingRadioButton;

    @FindBy(id = "s_method_flatrate_flatrate")
    private WebElementFacade flatRateShippingRadioButton;

    @FindBy(css = "#shipping-method-buttons-container .button")
    private WebElementFacade saveShippingButton;

    @FindBy(css = "#payment-buttons-container .button")
    private WebElement paymentContinueButton;

    @FindBy(css = ".button.btn-checkout")
    private WebElement placeOrderButton;

    @FindBy(css = "page-title")
    private WebElementFacade orderConfirmMsg;

    @FindBy(css = "#billing-address-select :last-child")
    private WebElementFacade newAddress;

    @FindBy(css = ".sp-methods label")
    private WebElementFacade notClickableShippingRate;

    public void typeBillingFirstName(String firstName) {
        billingTelephoneField.clear();
        billingFirstNameField.type(firstName);
    }

    public void typeBillingLastName(String lastName) {
        billingTelephoneField.clear();
        billingLastNameField.type(lastName);
    }

    public void typeBillingAddress(String address) {
        billingAddressField.type(address);
    }

    public void typeBillingCity(String city) {
        billingCitiField.type(city);
    }

    public void selectBillingCountry(int index) {
        Select select = new Select(billingStateDropdown);
        select.selectByIndex(index);
    }

    public void typeBillingPostalCode(String postalCode) {
        billingPostalCodeField.type(postalCode);
    }

    public void typeBillingTelephone(String number) {
        billingTelephoneField.type(number);
    }

    public void clickContinueShippingButton() {
        continueShippingbutton.click();
    }

    public void clickShipToDifferentAddress(){
        shipToDifferentAddressRadioButton.click();
    }

    public void clickOnEditShippingInformation() {
        waitForElementToBeClickable(100, editShippingInformationButton);
        editShippingInformationButton.click();
    }


    public void typeShippingFirstName(String firstName) {
        boolean textWasEntered = false;
        while (!textWasEntered) {
            try {
                shippingFirstNameField.clear();
                shippingFirstNameField.type(firstName);
                textWasEntered = true;
                break;
            } catch (ElementNotInteractableException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException z) {
                    continue;
                }
            }
        }

    }

    public void typeShippingLastName(String lastName) {
        shippingLastName.clear();
        shippingLastName.type(lastName);
    }

    public void typeShippingAddress(String address) {
        shippingAddressField.type(address);
    }

    public void typeShippingCityField(String city) {
        shippingCityField.type(city);
    }

    public void typeShippingPostal(String postalCode) {
        shippingPostalCodeField.type(postalCode);
    }

    public void selectShippingCountry(int index) {
        Select select = new Select(shippingCountryDropdown);
        select.selectByIndex(index);
    }

    public void typeShippingTelephone(String number) {
        shippingTelephoneNumber.type(number);
    }

    public void clickContinueToShippingMethod() {
        continueToShoppingMethodButton.click();
    }

    public void setShippingInformation() {
        waitForElementToBeVisible(15, notClickableShippingRate);
        saveShippingButton.click();
//        if (freeShippingRadioButton.isSelected()) {
//            saveShippingButton.click();
//        } else if(!freeShippingRadioButton.isSelected()){
//            flatRateShippingRadioButton.click();
//            saveShippingButton.click();
//        }else if (notClickableShippingRate.getText().toLowerCase().contains("Fixed".toLowerCase())){
//            saveShippingButton.click();
//        }
    }

    public void clickContinuePayment() {
        waitForElementToBeVisibleAndThenInvisible(20, paymentContinueButton);
        paymentContinueButton.click();
    }

    public void clickPlaceOrder() {
        element(placeOrderButton).waitUntilVisible();
        placeOrderButton.click();
    }

    public WebElement getCheckoutDetailsContainer(String propertyGroup) {
        List<WebElement> checkoutDetailsContainers = getDriver().findElements(By.cssSelector(".block-content>dl div"));
        System.out.println("list size is "+ checkoutDetailsContainers.size());
        for (WebElement checkoutDetailsContainer : checkoutDetailsContainers) {
            System.out.println(checkoutDetailsContainer.findElement(By.cssSelector("dt.complete")).getText());
            if (checkoutDetailsContainer.findElement(By.cssSelector("dt.complete")).getText().toLowerCase().contains(propertyGroup.toLowerCase())) {
                         return checkoutDetailsContainer;
            }
        }
        return null;
    }

    public boolean checkConfirmMessage(String message){
        if (orderConfirmMsg.getText().trim().toLowerCase().contentEquals(message.toLowerCase()));
            return true;

    }

}
