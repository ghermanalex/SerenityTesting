package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//@DefaultUrl("http://qa1.dev.evozon.com/ludlow-oxford-top-594.html")
@DefaultUrl("http://qa1.dev.evozon.com/fashionnova-summer-dress.html")
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



    public ProductEntity getProductDetailsFromDetailsPage(){
        Float price = fromStringToFloat(productPrice.getText());
        ProductEntity productDetails = new ProductEntity(product, productName.getText(),price);
        return productDetails;

    }


    public void setProductColor()throws ElementNotSelectableException{
        Integer randomColorPostion = getRandomElementFromList(colorList);
        WebElementFacade randomColor = getWebElementFromList(colorList,randomColorPostion);
        if(randomColor.isEnabled()){
            randomColor.click();
        }
        else
            throw new ElementNotSelectableException("Product set color exception in ProductDetailsPage");
    }


    public void setProductSize(){
        Integer randomSizePostion = getRandomElementFromList(sizeList);
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




}
