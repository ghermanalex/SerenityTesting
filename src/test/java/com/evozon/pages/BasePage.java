package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage extends PageObject {

    public Integer getRandomElementFromList(List list){
        if(list.size() >1) {
            return new Random().nextInt(list.size() - 1);
        }
        else return 0;
    }

    public WebElementFacade getWebElementFromList(List<WebElementFacade> list, Integer position){
        return list.get(position);
    }


    public WebElementFacade getChildWebElementFromParentByCssSelector(WebElementFacade element, String cssSelector){
        return element.find(By.cssSelector(cssSelector));
    }

    public void waitForElementToBeVisible(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementToBeVisibleAndThenInvisible(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public boolean isExpectedUrl(String expectedUrl)
    {
        if(getDriver().getCurrentUrl().toLowerCase().contentEquals(expectedUrl.toLowerCase())) {
            return true;
        }
        return false;
    }



    public Float fromStringToFloat(String stringPrice){
        StringBuilder strPrice = new StringBuilder(stringPrice);
        Float price = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));
        return price;
    }

    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    public Integer getRandomElementFromWebElemList(List<WebElement> list){
        if(list.size() >1) {
            return new Random().nextInt(list.size() - 1);
        }
        else return 0;
    }
    




}
