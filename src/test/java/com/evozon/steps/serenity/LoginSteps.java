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
    public void typeEmail(String email)
    {
        loginPage.typeEmail(email);
    }

    @Step
    public void typePassword(String pass) {
        loginPage.typePassword(pass);
    }

    @Step
    public void clickLoginButton(){
        loginPage.clickSubmitButton();
    }


    @Step
    public void performLogin(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();

    }

    @Step
    public void checkThatYouAreLoggedIn(){


        Assert.assertTrue("You are not logged in", myAccountPage.isExpectedUrl(Constants.HOST + "/customer/account/"));
    }
}
