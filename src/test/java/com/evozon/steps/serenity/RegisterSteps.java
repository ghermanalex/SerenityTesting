package com.evozon.steps.serenity;

import com.evozon.model.RegisterData;
import com.evozon.model.RegisterInformation;
import com.evozon.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class RegisterSteps {

    RegisterPage registerPage;
    RegisterInformation registerInformation;
    RegisterData registerData = new RegisterData();

    @Step
    public void gotToRegisterPage(){
        registerPage.open();
    }

    @Step
    public void setRegisterFirstName(){
        registerInformation = registerData.setRegisterInformation();
        registerPage.typeFirstName(registerInformation.getFirstname());
    }

    @Step
    public void setRegisterLastName(){
        registerPage.typeLastName(registerInformation.getLastname());
    }

    @Step
    public void setRegisterEmailAddress(){
        registerPage.typeEmailAddress(registerInformation.getEmailAddress());
    }

    @Step
    public void setRegisterPassword(){
        registerPage.typePassword(registerInformation.getPassword());
    }

    @Step
    public void setRegisterConfirmPassword(){
        registerPage.typeConfirmPassword(registerInformation.getConfirmPassword());
    }

    @Step
    public void clickRegisterConfirmButton(){
        registerPage.clickRegisterConfirmButton();
    }

    @StepGroup
        public void register(){
        gotToRegisterPage();
        setRegisterFirstName();
        setRegisterLastName();
        setRegisterEmailAddress();
        setRegisterPassword();
        setRegisterConfirmPassword();
        clickRegisterConfirmButton();
    }

}
