package com.evozon.tests;

import com.evozon.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/csv/Login.csv")

public class LoginTestCsv extends BaseTest {

    @Steps
    public LoginSteps loginSteps;

    private String userEmail;
    private String userPassword;

    @Test
    public void loginAsCustomerShouldBeOnCorrectUrlCsv() {
        loginSteps.openHomepage();
        loginSteps.performLogin(userEmail, userPassword);
        loginSteps.checkThatYouAreLoggedIn();
    }


}
