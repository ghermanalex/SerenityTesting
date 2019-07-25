package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ProductListingPage;
import com.evozon.utils.Constants;
import com.evozon.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class ProductListingSteps {
    private ProductListingPage productListingPage;


    @Step
    public void openPageWithProducts() {
        productListingPage.open();
    }


    @Step
    public void getProductEntityByName(String productName){
        ProductEntity product = productListingPage.getProductEntityFromProductLisitingPage(productName);
        Serenity.setSessionVariable(Constants.PRODUCT_SESSION_KEY).to(product);
    }


    @StepGroup
    public void verifyPriceByName(String productName, String productPrice){
        Float priceF = Utils.fromStringToFloat(productPrice);
        getProductEntityByName(productName);
        ProductEntity productEntity = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);
        Assert.assertEquals(productEntity.getPrice(),priceF);
    }


    public String productName, productPrice;
    @StepGroup
    public void verfyPriceByNameOneSession(){
        Float priceF = Utils.fromStringToFloat(productPrice);
        getProductEntityByName(productName);
        ProductEntity productEntity = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);
        Assert.assertEquals(productEntity.getPrice(),priceF);
    }


}