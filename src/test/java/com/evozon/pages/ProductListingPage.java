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
public class ProductListingPage extends PageObject {



    @FindBy( css = "ul.products-grid > li .product-info")
    private List<WebElementFacade> listAllProducts;



    public ProductEntity getDetailsRandomProduct(){
        Random r = new Random();
        System.out.println(listAllProducts.size());
        Integer random = r.nextInt(listAllProducts.size()-1-0) +0 ;
        System.out.println(random);
        WebElementFacade randomElementFromList = listAllProducts.get(random);
        String name = randomElementFromList.findElement(By.cssSelector("h2 a")).getText();
        String stringPrice = randomElementFromList.findElement(By.cssSelector(".price")).getText();
        StringBuilder strPrice= new StringBuilder(stringPrice);
        Float integerPrice = Float.valueOf(strPrice.substring(1,strPrice.length()-1));
        ProductEntity randomProduct = new ProductEntity(randomElementFromList,name,integerPrice);

        //randomElementFromList.findElement(By.cssSelector(".actions a")).click();

        return randomProduct;

    }


    public void clickViewDetailButton(ProductEntity product){
        product.getProduct().findElement(By.cssSelector(".actions a")).click();
    }






}
