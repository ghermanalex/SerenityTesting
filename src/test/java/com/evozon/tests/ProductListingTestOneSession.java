package com.evozon.tests;

import com.evozon.steps.serenity.ProductListingSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class ProductListingTestOneSession extends BaseTest {


    @Steps
    private ProductListingSteps productListingSteps;

    private String productName, productPrice;

    @Test
    public void verifyPriceByNameOneSession()throws IOException {
        productListingSteps.openPageWithProducts();
        withTestDataFrom("src/test/resources/csv/search.csv").run(productListingSteps)
        .verfyPriceByNameOneSession();

    }
}
