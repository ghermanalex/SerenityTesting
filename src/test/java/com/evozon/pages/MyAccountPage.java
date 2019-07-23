package com.evozon.pages;

import com.evozon.utils.Constants;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {
    @FindBy(css = "div.my-account  div.welcome-msg strong")
    private WebElement greetingMessage;

    public void assertLoggedIn() {
        Assert.assertTrue(getDriver().getCurrentUrl().contentEquals(Constants.HOST.concat("/customer/account/")));
        Assert.assertTrue(greetingMessage.getText().contains(Constants.USER_NAME));

    }
}
