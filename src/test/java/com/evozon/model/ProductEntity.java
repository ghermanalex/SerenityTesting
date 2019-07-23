package com.evozon.model;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductEntity {

    private WebElementFacade product;
    private String name;
    private List<Size> sizeList;
    private Float price;

    public ProductEntity(){}

    public ProductEntity(WebElementFacade product, String name, Float price){
        this.product = product;
        this.name = name;
        this.price= price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Size> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Size> sizeList) {
        this.sizeList = sizeList;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public WebElementFacade getProduct() {
        return product;
    }

    public void setProduct(WebElementFacade product) {
        this.product = product;
    }
}
