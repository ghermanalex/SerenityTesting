package com.evozon.steps.serenity;

import com.evozon.pages.SearchPage;
import net.thucydides.core.annotations.Step;

public class SearchSteps {
    SearchPage searchPage;

    @Step
    public void searchProduct(String product){
        searchPage.typeInSearchField(product);
        searchPage.typeEnterinSearchField();
    }
}
