package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ProductListingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class ProductDetailsSteps {
    ProductListingPage productListingPage;
    ProductDetailsPage productDetailsPage;


    @Step
    public void openPageWithProducts() {
        productListingPage.open();
    }

    @Step
    public ProductEntity getDetailsRandomProductFromListingPage() {
        ProductEntity product = productListingPage.getDetailsRandomProduct();
        return product;
    }

    @Step
    public void clickViewDetailsButton(ProductEntity product){
        productListingPage.clickViewDetailButton(product);
    }

    @Step
    public ProductEntity getDetailProductFromDetailsPage(){
        ProductEntity product = productDetailsPage.getProductDetailsFromDetailsPage();
        return product;
    }

    @Step
    public void clickAddToCartButton(){
        productDetailsPage.clickAddToCartButton();
    }



    @StepGroup
    public void verifyDetailsRandomProduct(){
        ProductEntity randomProductDetails = getDetailsRandomProductFromListingPage();
        clickViewDetailsButton(randomProductDetails);
        ProductEntity productDetails = getDetailProductFromDetailsPage();
        Assert.assertEquals(randomProductDetails.getName(),productDetails.getName());
        Assert.assertEquals(randomProductDetails.getPrice(),randomProductDetails.getPrice());

    }





}
