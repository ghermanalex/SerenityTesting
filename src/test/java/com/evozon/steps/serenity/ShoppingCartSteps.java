package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ShoppingCartPage;
import com.evozon.utils.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.ElementNotSelectableException;

public class ShoppingCartSteps {
    private ProductDetailsPage productDetailsPage;
    private ShoppingCartPage shoppingCartPage;

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
    public Integer setProductQuantity(){
        return productDetailsPage.setQuantity();
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

        WebElementFacade productInShoppingCart = shoppingCartPage.getProductWebElementFromShoppingCartList(productDetails.getName());
        String name = shoppingCartPage.getNameOfProduct(productInShoppingCart);
        Float price = shoppingCartPage.getPriceOfProduct(productInShoppingCart);

       // ProductEntity productDetailsFromShoppingCart =getDetailProductFromShoppingCart(productDetails.getName());
        Assert.assertEquals(productDetails.getName().toUpperCase(),name);
        Assert.assertEquals(productDetails.getPrice(),price);
    }



    @StepGroup
    public void verifyPriceDependinOnRandomQuantity(){
        ProductEntity productDetails = getDetailProductFromDetailsPage();
        if(productDetailsPage.checkProductHasColorOptions())
            selectColor();
        if(productDetailsPage.checkProductHasSizeOptions())
            selectSize();
        Integer quantity = setProductQuantity();
        clickAddToCartButton();


        WebElementFacade productInShoppingCart = shoppingCartPage.getProductWebElementFromShoppingCartList(productDetails.getName());
        Float price = shoppingCartPage.getPriceOfProduct(productInShoppingCart);

        //ProductEntity productDetailsFromShoppingCart =getDetailProductFromShoppingCart(productDetails.getName());
        Float productPriceDepedingOnQuantity = productDetails.getPrice()* quantity;
        Float productTotalPriceInCart = price* quantity;

        Assert.assertEquals(productPriceDepedingOnQuantity,shoppingCartPage.getTotalPriceOfProduct(productInShoppingCart));
        Assert.assertEquals(productTotalPriceInCart,shoppingCartPage.getTotalPriceOfProduct(productInShoppingCart));
    }


    @Step
    public void checkProductPrice(String name,String expectedPrice) {
        Float expPrice = Utils.fromStringToFloat(expectedPrice);
        System.out.println(expPrice);
        System.out.println( shoppingCartPage.getPriceOfProductInCart(name));
        Assert.assertTrue("The price is not correct", shoppingCartPage.getPriceOfProductInCart(name).equals(expPrice));
    }











}
