package com.evozon.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/create/")
public class RegisterPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElementFacade registerFirstNameField;

    @FindBy(id = "lastname")
    private WebElementFacade registerLastNameField;

    @FindBy (id = "email_address")
    private WebElementFacade registerEmailAddressField;

    @FindBy (id = "password")
    private WebElementFacade registerPasswordField;

    @FindBy(id = "confirmation")
    private WebElementFacade registerConfirmPasswordField;

    @FindBy(css = ".buttons-set [title='Register']")
    private WebElementFacade registerConfirmButton;

    public void typeFirstName(String firstName){
        registerFirstNameField.type(firstName);
    }

    public void typeLastName(String lastName){
        registerLastNameField.type(lastName);
    }

    public void typeEmailAddress(String email){
        registerEmailAddressField.type(email);
    }

    public void typePassword(String password){
        registerPasswordField.type(password);
    }

    public void typeConfirmPassword(String password){
        registerConfirmPasswordField.type(password);
    }

    public void clickRegisterConfirmButton(){
        registerConfirmButton.click();
    }
}
