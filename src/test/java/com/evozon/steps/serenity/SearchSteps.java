package com.evozon.steps.serenity;

import com.evozon.pages.SearchPage;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps {
    SearchPage searchPage;

    @Step
    public void searchProduct(String product){
        searchPage.typeInSearchField(product);
        searchPage.typeEnterinSearchField();
    }

    @Step
    public void openHomepage(){
        searchPage.open();
    }

    @Step
    public void checkThatResultPageIsShown() {
        Assert.assertTrue("The result page is not shown",searchPage.isOnResultPageByTitle(Constants.PRODUCT));
    }

    @Step
    public void checkThatNumberOfItemsIsValid() {
        Assert.assertTrue("The number of items shown is not the same as the number of items",searchPage.isOnResultPageByNumberOfItems());
    }
}
