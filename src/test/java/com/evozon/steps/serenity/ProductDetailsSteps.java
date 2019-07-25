package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ProductListingPage;
import net.serenitybdd.core.Serenity;
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
        ProductEntity product = productListingPage.getProductEntityFromRandomProduct();
        return product;
    }

    @Step
    public String getProductName(){
        return productDetailsPage.getProductName();
    }

    @Step
    public Float getProductPrice(){
        return productDetailsPage.getProdutPrice();
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


    @Step
    public void clickOnImageOfProductToSeeDetails(){
        productListingPage.clickOnProductImageToSeeDetails();
    }


    @StepGroup
    public void verifyDetailsRandomProduct(){
        ProductEntity randomProductDetails = getDetailsRandomProductFromListingPage();
        clickOnImageOfProductToSeeDetails();
      //  clickViewDetailsButton(randomProductDetails);
        //ProductEntity productDetails = getDetailProductFromDetailsPage();
        Assert.assertEquals(randomProductDetails.getName(),getProductName());
        Assert.assertEquals(randomProductDetails.getPrice(),getProductPrice());

    }





}
