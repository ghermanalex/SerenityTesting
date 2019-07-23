package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

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
    public void selectSizeAndColor(){
        productDetailsPage.setProductColor();
        productDetailsPage.setProductSize();
    }


    @Step
    public void clickAddToCartButton(){
        productDetailsPage.clickAddToCartButton();
    }


    @Step
    public ProductEntity getDetailProductFromShoppingCart(String name){
        ProductEntity product = shoppingCartPage.getProductFromShoppingCartList(name);
        return product;
    }

    @Step
    public void clickCheckOutButton(){
        shoppingCartPage.clickProceedToCheckOutButton();
    }


    @StepGroup
    public void verfiyDetailsProductInShoppingCart(){
        ProductEntity productDetails = getDetailProductFromDetailsPage();
        selectSizeAndColor();
        clickAddToCartButton();
        ProductEntity productDetailsFromShoppingCart =getDetailProductFromShoppingCart(productDetails.getName());
        Assert.assertEquals(productDetails.getName().toUpperCase(),productDetailsFromShoppingCart.getName().toUpperCase());
        Assert.assertEquals(productDetails.getPrice(),productDetailsFromShoppingCart.getPrice());
    }







}
