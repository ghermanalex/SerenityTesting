package com.evozon.steps.serenity;

import com.evozon.model.ProductEntity;
import com.evozon.pages.SearchPage;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SearchSteps {
    SearchPage searchPage;

    @Step
    public void searchProduct(String product) {
        searchPage.typeInSearchField(product);
        searchPage.typeEnterinSearchField();
    }

    @Step
    public void openHomepage() {
        searchPage.open();
    }

    @Step
    public void checkThatResultPageIsShown(String product) {
        Assert.assertTrue("The result page is not shown", searchPage.isOnResultPageByTitle(product));
    }

    @Step
    public void checkThatNumberOfItemsIsValid() {
        Assert.assertTrue("The number of items shown is not the same as the number of items", searchPage.isOnResultPageByNumberOfItems());
    }

}
