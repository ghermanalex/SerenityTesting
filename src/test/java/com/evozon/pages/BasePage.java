package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

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



    public Float fromStringToFloat(String stringPrice){
        StringBuilder strPrice = new StringBuilder(stringPrice);
        Float price = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));
        return price;
    }




}
