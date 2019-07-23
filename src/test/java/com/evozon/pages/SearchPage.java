package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("http://qa1.dev.evozon.com")
public class SearchPage extends PageObject {

    @FindBy(css="div #search")
    private WebElementFacade searchInput;



    public void typeInSearchField(String item){

        searchInput.sendKeys(item);

    }

    public void typeEnterinSearchField() {
        searchInput.sendKeys("\n");
    }
}
