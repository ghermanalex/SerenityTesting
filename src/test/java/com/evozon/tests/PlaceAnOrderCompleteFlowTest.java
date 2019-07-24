package com.evozon.tests;

import com.evozon.pages.ProductListingPage;
import com.evozon.steps.serenity.LoginSteps;
import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.ShoppingCartSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class PlaceAnOrderCompleteFlowTest extends BaseTest{

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private ProductDetailsSteps productDetailsSteps;

    @Steps
    private ShoppingCartSteps shoppingCartSteps;



    @Test
    public void verifyProductDetailsAndProductShoppingCartDetails() {
        loginSteps.openHomepage();
        loginSteps.checkThatYouAreLoggedIn(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.searchProduct(Constants.VALID_PRODUCT);
        searchSteps.checkThatResultPageIsShown(Constants.VALID_PRODUCT);
        //productDetailsSteps.openPageWithProducts();
        productDetailsSteps.verifyDetailsRandomProduct();
        shoppingCartSteps.verfiyDetailsProductInShoppingCart();
    }



}