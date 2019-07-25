package com.evozon.pages;

import com.evozon.model.ProductEntity;
import com.evozon.utils.Utils;
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

        String name = getNameOfProduct(productFromShoppingCartList);
        Float price = getPriceOfProduct(productFromShoppingCartList);
        Float totalPrice = getTotalPriceOfProduct(productFromShoppingCartList);

        ProductEntity shoppingCartProduct = new ProductEntity( name, price, totalPrice);

        return shoppingCartProduct;
    }


    public WebElementFacade getProductWebElementFromShoppingCartList(String productName){
        WebElementFacade productFromShoppingCartList=null ;
        for(WebElementFacade prod:shoppingCartProductList){
            String nameProductFromShoppingCart = getChildWebElementFromParentByCssSelector(prod,".product-name a").getText();
            if(nameProductFromShoppingCart.toUpperCase().equals(productName.toUpperCase())){
                productFromShoppingCartList = prod;
                break;
            }
        }
        return productFromShoppingCartList;
    }



    public String getNameOfProduct(WebElementFacade product){
        return getChildWebElementFromParentByCssSelector(product,".product-name a").getText();
    }

    public Float getPriceOfProduct(WebElementFacade product){
        String stringPrice = getChildWebElementFromParentByCssSelector(product,".product-cart-price .price").getText();
        return Utils.fromStringToFloat(stringPrice);
    }

    public Float getTotalPriceOfProduct(WebElementFacade product){
        String stringPrice = getChildWebElementFromParentByCssSelector(product,".product-cart-total .price").getText();
        return Utils.fromStringToFloat(stringPrice);
    }




    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }


    public Integer setProductEntityQuantity(ProductEntity product){
        Integer randomQuantity = new Random().nextInt(5)+1;
        product.setQuantity(randomQuantity);
        return randomQuantity;
    }


    public void setProductQuantityInCart(ProductEntity product){
        WebElementFacade productFromShoppingCartList = getProductWebElementFromShoppingCartList(product.getName());

        WebElement inputQuantityWebElement = getChildWebElementFromParentByCssSelector(productFromShoppingCartList,".product-cart-actions input");

        Integer quantityValue = setProductEntityQuantity(product);

        inputQuantityWebElement.clear();
        inputQuantityWebElement.sendKeys(quantityValue.toString() + "\n");

    }

}
