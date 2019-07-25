package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.ProductDetailsPage;
import com.evozon.pages.ProductListingPage;
import com.evozon.utils.Constants;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ProductDetailsSteps {
    ProductListingPage productListingPage;
    ProductDetailsPage productDetailsPage;



    @Step
    public void openPageWithProducts() {
        productListingPage.open();
    }

    @Step
    public void getDetailsRandomProductFromListingPage() {
        ProductEntity product = productListingPage.getProductEntityFromRandomProduct();

        Serenity.setSessionVariable(Constants.PRODUCT_SESSION_KEY).to(product);


    }

    @Step
    public String getProductNameFromProductDetailsPage(){
        return productDetailsPage.getProductName();
    }

    @Step
    public Float getProductPriceFromProductDetailsPage(){
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


    @Step
    public void verifyNameOfProducts(String nameFirstProduct,String nameSecondProduct){
        Assert.assertEquals(nameFirstProduct,nameSecondProduct);
    }

    @Step
    public void verifyPriceOfProducts(Float priceFirstProduct,Float priceSecondProduct){
        Assert.assertEquals(priceFirstProduct,priceSecondProduct);
    }


    @StepGroup
    public void verifyDetailsRandomProduct(){
        getDetailsRandomProductFromListingPage();
        ProductEntity randomProductDetails = Serenity.sessionVariableCalled(Constants.PRODUCT_SESSION_KEY);
        clickOnImageOfProductToSeeDetails();
        String name = getProductNameFromProductDetailsPage();
        Float price = getProductPriceFromProductDetailsPage();
        verifyNameOfProducts(randomProductDetails.getName(),name);
        verifyPriceOfProducts(randomProductDetails.getPrice(),price);

    }

    @Step
    public void chooseProductInGridView(String name){
        productListingPage.findProduct(name);
    }





}
