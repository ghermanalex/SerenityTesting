package com.evozon.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Managed(uniqueSession = true)
    private WebDriver webdriver;

    @Before
    public void setup(){
        webdriver.manage().window().maximize();
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void navigateTo(String url){
        webdriver.get(url);
    }
}
