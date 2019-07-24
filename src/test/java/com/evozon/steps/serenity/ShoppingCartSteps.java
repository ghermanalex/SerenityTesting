package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.ElementNotSelectableException;

public class ShoppingCartSteps {
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;

    @Step
    public void openProductDetailsPage(){
        productDetailsPage.open();
    }


    @Step
    public ProductEntity getDetailProductFromDetailsPage(){
        ProductEntity product = productDetailsPage.getProductDetailsFromDetailsPage();
        return product;
    }

    @Step
    public void selectSize()throws ElementNotSelectableException{
        productDetailsPage.setProductSize();
    }

    @Step
    public void selectColor()throws ElementNotSelectableException{
        productDetailsPage.setProductColor();
    }


    @Step
    public void clickAddToCartButton(){
        productDetailsPage.clickAddToCartButton();
    }


    @Step
    public ProductEntity getDetailProductFromShoppingCart(String name){
        ProductEntity product = shoppingCartPage.getProductEntityFromShoppingCartList(name);
        return product;
    }

    @Step
    public void clickCheckOutButton(){
        shoppingCartPage.clickProceedToCheckOutButton();
    }


    @StepGroup
    public void verfiyDetailsProductInShoppingCart(){
        ProductEntity productDetails = getDetailProductFromDetailsPage();
        if(productDetailsPage.checkProductHasColorOptions())
            selectColor();

        if(productDetailsPage.checkProductHasSizeOptions())
            selectSize();

        clickAddToCartButton();
        ProductEntity productDetailsFromShoppingCart =getDetailProductFromShoppingCart(productDetails.getName());
        Assert.assertEquals(productDetails.getName().toUpperCase(),productDetailsFromShoppingCart.getName().toUpperCase());
        Assert.assertEquals(productDetails.getPrice(),productDetailsFromShoppingCart.getPrice());
    }







}
