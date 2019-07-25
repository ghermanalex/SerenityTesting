package com.evozon.steps.serenity;

import com.evozon.pages.HeaderPage;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class HeaderSteps {

    HeaderPage headerPage;

    @Step
    public void openHomepage() {
        headerPage.open();
    }

    @Step
    public void clickOnAccountButton() {

        headerPage.clickOnAccountButton();
    }

    @Step
    public void clickOnLogOutLink() {
        headerPage.clickOnLogOutLink();
    }

    @Step
    public void clickOnLogInLink() {
        headerPage.clickOnLogInLink();
    }

    @Step
    public void checkThatYouAreLoggedOut() {
        Assert.assertTrue("You are not logged out", headerPage.containsExpectedUrl(Constants.HOST + "/customer/account/"));
    }

    @StepGroup
    public void performLogOut()  {

        clickOnAccountButton();
        clickOnLogOutLink();
        checkThatYouAreLoggedOut();
    }

    @StepGroup
    public void performLogOutAndRedirectToLogInPage() {
        performLogOut();
        clickOnLogInLink();
    }


}
