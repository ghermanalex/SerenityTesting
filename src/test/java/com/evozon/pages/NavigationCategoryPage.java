package com.evozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationCategoryPage extends BasePage {

    public void accessRandomProductList() {
        WebElement menuItem = getRandomMenuItem();
        hoverOverElement(menuItem);
        List<WebElement> subcategoriesOfAnMenuItem = null;
        if (!menuItem.findElements(By.cssSelector("level")).isEmpty()) {
            subcategoriesOfAnMenuItem.add(menuItem);
        }
        for (WebElement menuitem : subcategoriesOfAnMenuItem) {
            System.out.println(menuitem.getText());
        }

        if (!subcategoriesOfAnMenuItem.isEmpty()) {


            Integer indexForSubcategory = getRandomElementFromWebElemList(subcategoriesOfAnMenuItem);
            subcategoriesOfAnMenuItem.get(indexForSubcategory).click();
        } else menuItem.click();

    }


    public WebElement getRandomMenuItem() {
        List<WebElement> menuItems = getDriver().findElements(By.cssSelector("[class*='level0 nav']>a"));

        Integer indexForMenuItem = getRandomElementFromWebElemList(menuItems);
        return menuItems.get(indexForMenuItem);
    }

}
