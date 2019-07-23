package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShoppingCartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table tbody > tr")
    List<WebElementFacade> shoppingCartProductList;

    @FindBy(css = ".checkout-types.top button")
    WebElementFacade proceedToCheckOutButton;

    public ProductEntity getProductFromShoppingCartList(String productName) {

        WebElementFacade productFromShoppingCartList=null ;
        for(WebElementFacade prod:shoppingCartProductList){
            String nameProductFromCart = prod.findElement(By.cssSelector(".product-name a")).getText();
            if(nameProductFromCart.toUpperCase().equals(productName.toUpperCase())){
                productFromShoppingCartList = prod;
                break;
            }
        }

        String name = productFromShoppingCartList.findElement(By.cssSelector(".product-name a")).getText();
        String stringPrice = productFromShoppingCartList.findElement(By.cssSelector(".product-cart-price .price")).getText();
        StringBuilder strPrice = new StringBuilder(stringPrice);
        Float integerPrice = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));
        ProductEntity shoppingCartProduct = new ProductEntity(productFromShoppingCartList, name, integerPrice);

        //randomElementFromList.findElement(By.cssSelector(".actions a")).click();

        return shoppingCartProduct;
    }


    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }


}
