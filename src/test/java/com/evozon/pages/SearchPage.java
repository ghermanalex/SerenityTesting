package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {
    @FindBy(css="div #search")
    private WebElementFacade searchInput;

    public void typeInSearchField(String item){
        searchInput.clear();
        searchInput.click();
        searchInput.type(item);
        searchInput.sendKeys("\n");
    }
}
