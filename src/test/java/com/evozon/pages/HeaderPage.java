package com.evozon.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@DefaultUrl("http://qa1.dev.evozon.com/customer/account/index/")
@DefaultUrl("http://qa1.dev.evozon.com/customer/account/login/")
public class HeaderPage extends BasePage {
    @FindBy(css = ".skip-account")
    private WebElement accountButton;

    @FindBy(css = "#header-account [title*=\"Log Out\"]")
    private WebElement logOutButton;

    @FindBy(css = "#header-account [title*=\"Log In\"]")
    private WebElement logInButton;

    public void clickOnAccountButton()  {
        accountButton.click();
    }

    public void clickOnLogOutLink() {
        logOutButton.click();
    }

    public void clickOnLogInLink() {
        logInButton.click();
    }


}
