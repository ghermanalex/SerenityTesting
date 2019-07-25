package com.evozon.pages;

import com.evozon.model.ProductEntity;
import com.evozon.utils.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/result/?q=a")
public class ProductListingPage extends BasePage {


    //lista cu toate produse impreuna cu imaginea lor
    @FindBy(css = ".category-products .products-grid > li")
    private List<WebElementFacade> listAllProductsWithImage;

    //lista de produce fara imagine
    @FindBy(css = "ul.products-grid > li .product-info")
    private List<WebElementFacade> listAllProducts;

    @FindBy(css = ".products-grid .product-name")
    private List<WebElementFacade> nameOfProductsInGridView;

    @FindBy(css = "button.btn-cart")
    private WebElementFacade addToCartFromGridView;

    private Integer randomProductPostion;

    public ProductEntity getProductEntityFromRandomProduct() {

        setRandom(Utils.getRandomElementFromList(listAllProductsWithImage));
        WebElementFacade randomElementFromList = getWebElementFromList(listAllProducts, randomProductPostion);

        String name = getNameOfProduct(randomElementFromList, "h2 a");
        Float price = getPriceOfProduct(randomElementFromList, ".price");

        ProductEntity randomProduct = new ProductEntity(name, price);

        return randomProduct;
    }

    public void clickOnProductImageToSeeDetails() {
        WebElementFacade productElement = getWebElementFromList(listAllProductsWithImage, getRandom());
        WebElementFacade productImage = getChildWebElementFromParentByCssSelector(productElement, "a.product-image");
        productImage.click();

    }

    public String getNameOfProduct(WebElementFacade product, String selector) {
        return getChildWebElementFromParentByCssSelector(product, selector).getText();
    }

    public Float getPriceOfProduct(WebElementFacade product, String selector) {
        String stringPrice = getChildWebElementFromParentByCssSelector(product, selector).getText();
        return Utils.fromStringToFloat(stringPrice);

    }

    public Integer getRandom() {
        return randomProductPostion;
    }

    public void setRandom(Integer random) {
        this.randomProductPostion = random;
    }

    public void findProduct(String name) {
        List<WebElementFacade> productName = nameOfProductsInGridView;
        for (WebElementFacade product : productName) {
            if (product.getText().toLowerCase().contentEquals(name.toLowerCase())) {
                addToCartFromGridView.click();
            }
        }
    }

}