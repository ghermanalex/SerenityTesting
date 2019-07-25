package com.evozon.steps.serenity;

import com.evozon.pages.NavigationCategoryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebElement;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

public class NavigationCategorySteps {
    NavigationCategoryPage navigationCategoryPage;

    @Step
    public void openHomepage() {
        navigationCategoryPage.open();
    }


//    @Step
//    public void hoverOverRandomCategory() {
//        navigationCategoryPage.hoverOverElement(navigationCategoryPage.getRandomMenuItem());
//    }

//    @Step
//    public void clickOnRandomCategoty() {
//        navigationCategoryPage.accessRandomProductList();
//    }


}
