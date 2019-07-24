package com.evozon.pages;

import com.evozon.model.ProductEntity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/result/?q=blouses")
public class ProductListingPage extends BasePage {


    private Integer random ;

    //lista cu toate produse impreuna cu imaginea lor
    @FindBy(css = ".category-products .products-grid li ")
    private List<WebElementFacade> listAllProductsWithImage;

    //lista de produce fara imagine
    @FindBy(css = "ul.products-grid > li .product-info")
    private List<WebElementFacade> listAllProducts;


    public ProductEntity getProductEntityFromRandomProduct() {



        Integer randomProductPostion = getRandomElementFromList(listAllProducts);
        //Setam random ca sa stim pe ce produs sa dam click ca sa vedem detalile
        setRandom(randomProductPostion);
        WebElementFacade randomElementFromList = getWebElementFromList(listAllProducts,randomProductPostion);

        String name = getNameOfProduct(randomElementFromList,"h2 a");
        Float price = getPriceOfProduct(randomElementFromList,".price");

        ProductEntity randomProduct = new ProductEntity(randomElementFromList, name, price);

        return randomProduct;
    }


    public String getNameOfProduct(WebElementFacade product, String selector){
        return getChildWebElementFromParentByCssSelector(product,selector).getText();
    }


    public Float getPriceOfProduct(WebElementFacade product, String selector){
        String stringPrice = getChildWebElementFromParentByCssSelector(product,selector).getText();
        StringBuilder strPrice = new StringBuilder(stringPrice);
        Float price = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));
        return price;
    }



    public void clickViewDetailButton(ProductEntity product) {
        product.getProduct().findElement(By.cssSelector(".actions a")).click();
    }


    public void clickOnProductImageToSeeDetails()
    {
        WebElementFacade productElement = getWebElementFromList(listAllProductsWithImage,random);
        WebElementFacade productImage = getChildWebElementFromParentByCssSelector(productElement,"a");
        productImage.click();

    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }
}