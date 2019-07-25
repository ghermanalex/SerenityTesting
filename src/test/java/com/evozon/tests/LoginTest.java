package com.evozon.tests;

import com.evozon.pages.HeaderPage;
import com.evozon.steps.serenity.HeaderSteps;
import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.IOException;

import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;


@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;
    @Steps
    public HeaderSteps headerSteps;

    @Test
    public void loginValidCredentials(){
        loginSteps.openHomepage();
        setup();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkThatYouAreLoggedIn();

    }

    @Test
    public void loginAsCustomerShouldBeOnCorrectUrlCsvWithOneBrowserSession() throws IOException, InterruptedException {
        loginSteps.openHomepage();
        withTestDataFrom("src/test/resources/csv/Login.csv").run(loginSteps).performLoginAndLogoutAndRedirectToLogInPage();
        System.out.println("x");


    }

    @Test
    public void logout() throws InterruptedException {
        loginValidCredentials();
        headerSteps.performLogOut();

    }

}
