package com.evozon.tests;


import com.evozon.steps.serenity.ProductDetailsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ProductDetailsTest extends BaseTest {


    @Steps
    public ProductDetailsSteps productDetailsSteps;

    @Test
    public void verifiyDetailsRandomProduct() {
        productDetailsSteps.openPageWithProducts();
        productDetailsSteps.verifyDetailsRandomProduct();

    }
}
