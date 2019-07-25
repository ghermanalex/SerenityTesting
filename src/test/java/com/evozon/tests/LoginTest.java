package com.evozon.tests;

import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value = "src/test/resources/csv/Login.csv" )
@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginValidCredentials(){
        loginSteps.openHomepage();
        setup();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkThatYouAreLoggedIn();

    }

    //public void loginAsCustomerShouldDisplayAppropiateMessage()



}
