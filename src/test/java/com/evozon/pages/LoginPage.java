package com.evozon.pages;

import com.evozon.utils.Constants;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/login/")
public class LoginPage extends BasePage {

    @FindBy(css = "form#login-form input[type = 'email']")
    private WebElementFacade emailInput;

    @FindBy(css = "form#login-form input[type = 'password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "form#login-form button[type='submit']")
    private WebElementFacade loginSubmitButton;

    public void typeEmail(String email) {
        emailInput.clear();
        emailInput.type(email);
    }

    public void typePassword(String password) {
        passwordInput.clear();
        passwordInput.type(password);
    }

    public void clickSubmitButton() {
        loginSubmitButton.click();
    }

}