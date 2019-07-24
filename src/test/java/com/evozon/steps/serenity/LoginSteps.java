package com.evozon.steps.serenity;

import com.evozon.pages.LoginPage;
import com.evozon.pages.MyAccountPage;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
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


    @StepGroup
    public void checkThatYouAreLoggedIn(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
        Assert.assertTrue("You are not logged in", myAccountPage.isExpectedUrl(Constants.HOST + "/customer/account/"));    }
}
