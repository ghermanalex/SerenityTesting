package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ProductListingPage;
import com.evozon.utils.Utils;
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
    public ProductEntity getProductEntityByName(String productName){
        ProductEntity product = productListingPage.getProductEntityFromProductLisitingPage(productName);
        return product;
    }


    @StepGroup
    public void verifyPriceByName(String productName, String productPrice){
        Float priceF = Utils.fromStringToFloat(productPrice);
        ProductEntity productEntity = getProductEntityByName(productName);
        Assert.assertEquals(productEntity.getPrice(),priceF);
    }

    public String productName, productPrice;


    @StepGroup
    public void verfyPriceByNameOneSession(){
        Float priceF = Utils.fromStringToFloat(productPrice);
        ProductEntity productEntity = getProductEntityByName(productName);
        Assert.assertEquals(productEntity.getPrice(),priceF);
    }


}