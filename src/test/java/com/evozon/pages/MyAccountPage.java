package com.evozon.pages;

import com.evozon.utils.Constants;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@DefaultUrl("http://qa1.dev.evozon.com/customer/account/index/")
public class MyAccountPage extends BasePage {
    @FindBy(css = "div.my-account  div.welcome-msg strong")
    private WebElement greetingMessage;

//    public boolean isExpectedUrl(String expectedUrl)
//    {
//         if(getDriver().getCurrentUrl().toLowerCase().contentEquals(expectedUrl.toLowerCase())) {
//             return true;
//         }
//         return false;
//    }



}
