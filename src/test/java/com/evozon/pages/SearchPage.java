package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DefaultUrl("http://qa1.dev.evozon.com")
public class SearchPage extends PageObject {

    @FindBy(css="div #search")
    private WebElementFacade searchInput;



    public void typeInSearchField(String item){

        searchInput.sendKeys(item);

    }

    public void typeEnterinSearchField() {
        searchInput.sendKeys("\n");
    }

    public boolean isOnResultPageByTitle(String itemName) {
        WebElement pageTitle = getDriver().findElement(By.cssSelector(".page-title"));
        if(pageTitle.getText().toLowerCase().contains(itemName))
            return true;
        return false;
    }

    public List<WebElement> getListOfProducts() {
        List<WebElement> listOfProducts = getDriver().findElements(By.cssSelector(".item.last"));
        return listOfProducts;

    }

    public boolean isOnResultPageByNumberOfItems() {
        WebElement numberOfItems = getDriver().findElement(By.cssSelector(".toolbar-bottom .amount"));
        if(numberOfItems.getText().contains(String.valueOf(getListOfProducts().size())))
            return true;
        return false;

    }

}
