package com.evozon.pages;

import com.evozon.model.ProductEntity;
import com.evozon.utils.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

//@DefaultUrl("http://qa1.dev.evozon.com/ludlow-oxford-top-594.html")
//@DefaultUrl("http://qa1.dev.evozon.com/fashionnova-summer-dress.html")
//@DefaultUrl("http://qa1.dev.evozon.com/classic-crocs.html")
//@DefaultUrl("http://qa1.dev.evozon.com/bluza-noua.html")
//@DefaultUrl("http://qa1.dev.evozon.com/jingle-dress.html")
@DefaultUrl("http://qa1.dev.evozon.com/fashionnova-leather-dress.html")
public class ProductDetailsPage extends BasePage {

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


    @FindBy(css ="[name=\"qty\"]")
    WebElementFacade quantity;


    public ProductEntity getProductDetailsFromDetailsPage(){
        Float price = Utils.fromStringToFloat(productPrice.getText());
        ProductEntity productDetails = new ProductEntity( productName.getText(),price);
        return productDetails;
    }


    public String getProductName(){
        return productName.getText();
    }

    public Float getProdutPrice(){
        Float price = Utils.fromStringToFloat(productPrice.getText());
        return price;
    }


    public void setProductColor()throws ElementNotSelectableException{
        Integer randomColorPostion = Utils.getRandomElementFromList(colorList);
        WebElementFacade randomColor = getWebElementFromList(colorList,randomColorPostion);
        if(randomColor.isEnabled()){
            randomColor.click();
        }
        else
            throw new ElementNotSelectableException("Product set color exception in ProductDetailsPage");
    }


    public void setProductSize(){
        Integer randomSizePostion = Utils.getRandomElementFromList(sizeList);
        WebElementFacade randomSize = getWebElementFromList(sizeList,randomSizePostion);
        if(randomSize.isEnabled()){
            randomSize.click();
        }
        else
         throw new ElementNotSelectableException("Prodcut set size exception in ProductDetailsPage");


    }

    public Boolean checkProductHasColorOptions(){
        if(colorList.size()==0){
            return false;
        }
        return true;
    }

    public Boolean checkProductHasSizeOptions(){
        if(sizeList.size()==0){
            return false;
        }
        return true;
    }


    public void clickAddToCartButton()throws ElementNotSelectableException{
        addToCartButton.waitUntilVisible();
        if(addToCartButton.isEnabled())
            addToCartButton.click();
        else throw new ElementNotSelectableException("Button not available");

    }


    public Integer setQuantity(){
        Integer ranndomQuantiy =  new Random().nextInt(5)+1;
        quantity.clear();
        quantity.type(ranndomQuantiy.toString());
        return ranndomQuantiy;
    }



}
