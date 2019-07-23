package com.evozon.steps.serenity;

import com.evozon.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void openHomepage(){
        loginPage.open();
    }

    @Step
    public void performLogin(String email, String password) {
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickSubmitButton();
    }

}
