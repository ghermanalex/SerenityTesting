package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ShoppingCartPage;
import com.evozon.utils.Constants;
import com.evozon.utils.Utils;
import net.serenitybdd.core.Serenity;
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
    public void getOnSessionDetailProductFromDetailsPage(){
        ProductEntity product = productDetailsPage.getProductDetailsFromDetailsPage();
        Serenity.setSessionVariable(Constants.PRODUCT_SESSION_KEY).to(product);

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
    public Integer setProductQuantity(){
        return productDetailsPage.setQuantity();
    }


    @Step
    public void clickCheckOutButton(){
        shoppingCartPage.clickProceedToCheckOutButton();
    }



    @Step
    public void selectProductColorInProductDetailsPage(){
        ProductEntity productDetails = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);
        if(productDetailsPage.checkProductHasColorOptions())
            selectColor();
    }

    @Step
    public void selectProductSizeInProductDetailsPage(){
        ProductEntity productDetails = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);
        if(productDetailsPage.checkProductHasSizeOptions())
            selectSize();
    }


    @Step
    public void getProductOnSessionFromShopingCartByName(String name){
        WebElementFacade productInShoppingCart = shoppingCartPage.getProductWebElementFromShoppingCartList(name);
        Serenity.setSessionVariable(Constants.WEB_ELEMENT_SESSION_KEY).to(productInShoppingCart);
    }

    @Step
    public String getNameOfProductFromShippingCart(WebElementFacade productInCart){
        return shoppingCartPage.getNameOfProduct(productInCart);
    }

    @Step
    public Float getPriceOfProductInShopingCart(WebElementFacade productInCart){
        return shoppingCartPage.getPriceOfProduct(productInCart);
    }


    @Step
    public Float getTotalPriceOfProductInShopingCart(WebElementFacade productInCart){
        return shoppingCartPage.getTotalPriceOfProduct(productInCart);
    }


    @StepGroup
    public void verfiyDetailsProductInShoppingCart(){
        getOnSessionDetailProductFromDetailsPage();
        ProductEntity productDetails = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);

        selectProductColorInProductDetailsPage();
        selectProductSizeInProductDetailsPage();

        clickAddToCartButton();

        WebElementFacade productInShoppingCart = shoppingCartPage.getProductWebElementFromShoppingCartList(productDetails.getName());
        String name = getNameOfProductFromShippingCart(productInShoppingCart);
        Float price = getPriceOfProductInShopingCart(productInShoppingCart);

        // ProductEntity productDetailsFromShoppingCart =getDetailProductFromShoppingCart(productDetails.getName());
        Assert.assertEquals(productDetails.getName().toUpperCase(),name);
        Assert.assertEquals(productDetails.getPrice(),price);
    }

    @StepGroup
    public void verifyPriceDependinOnRandomQuantity(){
        getOnSessionDetailProductFromDetailsPage();
        ProductEntity productDetails = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);

        selectProductColorInProductDetailsPage();
        selectProductSizeInProductDetailsPage();

        Integer quantity = setProductQuantity();
        clickAddToCartButton();

        getProductOnSessionFromShopingCartByName(productDetails.getName());
        WebElementFacade productInShoppingCart = Serenity.sessionVariableCalled(Constants.WEB_ELEMENT_SESSION_KEY);
        Float price = getPriceOfProductInShopingCart(productInShoppingCart);

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
