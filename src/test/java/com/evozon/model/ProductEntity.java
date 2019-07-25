package com.evozon.model;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductEntity {

    private String name;
    private List<Size> sizeList;
    private Integer quantity;
    private Float price;
    private Float totalPrice;

    public ProductEntity(){}

    public ProductEntity (String name, Float price){

        this.name = name;
        this.price= price;
    }

    public ProductEntity( String name, Float price,Float totalPrice){
        this.name = name;
        this.price= price;
        this.totalPrice = totalPrice;
    }

    public ProductEntity( String name,Integer quantity ,Float price,Float totalPrice){
        this.name = name;
        this.quantity = quantity;
        this.price= price;
        this.totalPrice = totalPrice;
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


    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
