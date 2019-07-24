package com.evozon.tests;

import com.evozon.steps.serenity.NavigationCategorySteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest extends BaseTest{

    @Steps
    public SearchSteps searchSteps;
    @Steps
    public NavigationCategorySteps navigationCategorySteps;

//    @Test
//    public void searchValidItem (){
//        searchSteps.openHomepage();
//        setup();
//        searchSteps.searchProduct(Constants.VALID_PRODUCT);
//        searchSteps.checkThatResultPageIsShown(Constants.VALID_PRODUCT);
//        searchSteps.checkThatNumberOfItemsIsValid();
//
//    }
//
//    @Test
//    public void searchInvalidItem() {
//        searchSteps.openHomepage();
//        setup();
//        searchSteps.searchProduct(Constants.INVALID_PRODUCT);
//        searchSteps.checkThatResultPageIsShown(Constants.INVALID_PRODUCT);
//    }

    @Test
    public void chooseRandomCategory() {
        searchSteps.openHomepage();
        //navigationCategorySteps.hoverOverRandomCategory();
        navigationCategorySteps.clickOnRandomCategoty();
    }



}
