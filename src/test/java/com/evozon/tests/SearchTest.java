package com.evozon.tests;

import com.evozon.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public SearchSteps searchSteps;

    @Test
    public void searchItem (){
        searchSteps.openHomepage();
        searchSteps.searchProduct("blouses");

    }


}
