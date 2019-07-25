package com.evozon.tests;

import com.evozon.steps.serenity.ProductDetailsSteps;
import com.evozon.steps.serenity.ProductListingSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/csv/search.csv")
public class ProductListingTest extends BaseTest {


    @Steps
    private ProductListingSteps productListingSteps;

    private String productName, productPrice;

    @Test
    public void verifyPriceByName() {
        productListingSteps.openPageWithProducts();
        productListingSteps.verifyPriceByName(productName, productPrice);

    }
}

