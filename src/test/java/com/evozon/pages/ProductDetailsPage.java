package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/ludlow-oxford-top-594.html")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = ".product-shop")
    WebElementFacade product;

    @FindBy(css = ".product-shop .product-name")
    WebElementFacade productName;

    @FindBy(css = ".product-shop .regular-price > span")
    WebElementFacade productPrice;

    @FindBy(css = "#configurable_swatch_size li a")
    List<WebElementFacade> sizeList;

    @FindBy(css = "#configurable_swatch_color li a")
    List<WebElementFacade> colorList;

    @FindBy(css = ".add-to-cart-buttons button")
    WebElementFacade addToCartButton;



    public ProductEntity getProductDetailsFromDetailsPage(){
        StringBuilder strPrice= new StringBuilder(productPrice.getText());
        Float floatPrice = Float.valueOf(strPrice.substring(1,strPrice.length()-1));
        ProductEntity productDetails = new ProductEntity(product, productName.getText(),floatPrice);
        return productDetails;

    }


    public void setProductColor(){
        colorList.get(0).click();
    }

    public void setProductSize(){
        sizeList.get(0).click();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }




}
