package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = "#shopping-cart-table tbody > tr")
    List<WebElementFacade> shoppingCartProductList;

    @FindBy(css = ".checkout-types.top button")
    WebElementFacade proceedToCheckOutButton;

    public ProductEntity getProductEntityFromShoppingCartList(String productName) {

        WebElementFacade productFromShoppingCartList = getProductWebElementFromShoppingCartList(productName);
        String name = getNameOfProduct(productFromShoppingCartList,".product-name a");
       // String name = productFromShoppingCartList.findElement(By.cssSelector(".product-name a")).getText();
//        String stringPrice = productFromShoppingCartList.findElement(By.cssSelector(".product-cart-price .price")).getText();
//        StringBuilder strPrice = new StringBuilder(stringPrice);
//        Float integerPrice = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));

        Float price = getPriceOfProduct(productFromShoppingCartList,".product-cart-price .price");
        ProductEntity shoppingCartProduct = new ProductEntity(productFromShoppingCartList, name, price);

        //randomElementFromList.findElement(By.cssSelector(".actions a")).click();

        return shoppingCartProduct;
    }


    public WebElementFacade getProductWebElementFromShoppingCartList(String productName){
        WebElementFacade productFromShoppingCartList=null ;
        for(WebElementFacade prod:shoppingCartProductList){
            String nameProductFromShoppingCart = getChildWebElementFromParentByCssSelector(prod,".product-name a").getText();
         //   String nameProductFromCart = prod.findElement(By.cssSelector(".product-name a")).getText();
            if(nameProductFromShoppingCart.toUpperCase().equals(productName.toUpperCase())){
                productFromShoppingCartList = prod;
                break;
            }
        }
        return productFromShoppingCartList;
    }


    public String getNameOfProduct(WebElementFacade product, String selector){
        return getChildWebElementFromParentByCssSelector(product,selector).getText();
    }

    public Float getPriceOfProduct(WebElementFacade product, String selector){
        String stringPrice = getChildWebElementFromParentByCssSelector(product,selector).getText();
        return fromStringToFloat(stringPrice);

    }



    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }


}
