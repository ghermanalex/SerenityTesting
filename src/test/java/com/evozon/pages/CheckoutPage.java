package com.evozon.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class CheckoutPage extends PageObject {

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

    @FindBy(css = "#opc-shipping div.step-title a")
    private WebElementFacade editShippingInformationButton;

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

    @FindBy (id = "shipping:telephone")
    private WebElementFacade shippingTelephoneNumber;

    @FindBy(css = "#shipping-buttons-container .button")
    private WebElementFacade continueToShoppingMethodButton;

    @FindBy(id = "s_method_freeshipping_freeshipping")
    private WebElementFacade freeShippingRadioButton;

    @FindBy(css = "#shipping-method-buttons-container .button")
    private WebElementFacade saveShippingButton;

    @FindBy(css = "#payment-buttons-container .button")
    private WebElementFacade paymentContinueButton;

    @FindBy(css = ".button.btn-checkout")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "page-title")
    private WebElementFacade orderConfirmMsg;

    public void typeBillingFirstName(String firstName){
        billingTelephoneField.clear();
        billingFirstNameField.type(firstName);
    }

    public void typeBillingLastName(String lastName){
        billingTelephoneField.clear();
        billingLastNameField.type(lastName);
    }

    public void typeBillingAddress(String address){
        billingAddressField.type(address);
    }

    public void typeBillingCity(String city){
        billingCitiField.type(city);
    }

    public void selectBillingCountry(int index){
        Select select = new Select(billingStateDropdown);
        select.selectByIndex(index);
    }

    public void typeBillingPostalCode(String postalCode){
        billingPostalCodeField.type(postalCode);
    }

    public void typeBillingTelephone(String number){
        billingTelephoneField.type(number);
    }

    public void clickContinueShippingButton(){
        continueShippingbutton.click();
    }

    public void clickOnEditShippingInformation(){
        editShippingInformationButton.waitUntilClickable();
        editShippingInformationButton.click();
    }

    public void typeShippingFirstName(String firstName){
        shippingFirstNameField.waitUntilVisible();
        shippingFirstNameField.clear();
        shippingFirstNameField.type(firstName);
    }

    public void typeShippingLastName(String lastName){
        shippingLastName.clear();
        shippingLastName.type(lastName);
    }

    public void typeShippingAddress(String address){
        shippingAddressField.type(address);
    }

    public void typeShippingCityField(String city){
        shippingCityField.type(city);
    }

    public void typeShippingPostal(String postalCode){
        shippingPostalCodeField.type(postalCode);
    }

    public void selectShippingCountry(int index){
        Select select = new Select(shippingCountryDropdown);
        select.selectByIndex(index);
    }

    public void typeShippingTelephone(String number){
        shippingTelephoneNumber.type(number);
    }

    public void clickContinueToShippingMethod(){
        continueToShoppingMethodButton.click();
    }

    public void setShippingInformation(){
        freeShippingRadioButton.waitUntilClickable();
        freeShippingRadioButton.click();
        saveShippingButton.click();
    }

    public void clickContinuePayment(){
        paymentContinueButton.waitUntilClickable();
        paymentContinueButton.click();
    }

    public void clickPlaceOrder(){
        placeOrderButton.click();
    }

    public WebElement getCheckoutDetailsContainer(String propertyGroupName){
        List<WebElement> checkoutDetailsContainers = getDriver().findElements(By.cssSelector("#checkout-step-review dl>div"));
        for(WebElement checkoutDetailsContainer:checkoutDetailsContainers){
            if(checkoutDetailsContainer.findElement(By.cssSelector("dt.complete")).getText().toLowerCase().contentEquals(propertyGroupName)){
                return checkoutDetailsContainer;
            }
        }
        return null;
    }



}
