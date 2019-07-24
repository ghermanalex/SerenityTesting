package com.evozon.tests;

import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginValidCredentials(){
        loginSteps.openHomepage();
        setup();
        loginSteps.checkThatYouAreLoggedIn(Constants.USER_EMAIL, Constants.USER_PASS);

    }



}
