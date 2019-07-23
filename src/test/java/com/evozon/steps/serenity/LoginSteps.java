package com.evozon.steps.serenity;

import com.evozon.pages.LoginPage;
import com.evozon.pages.MyAccountPage;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Step
    public void openHomepage(){
        loginPage.open();
    }

    @Step
    public void performLogin(String email, String password) {
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickSubmitButton();
        String currentURL =
    }

    public void assertLoggedIn() {
        Assert.assertTrue(myAccountPage.checkUrl());

    }

}
