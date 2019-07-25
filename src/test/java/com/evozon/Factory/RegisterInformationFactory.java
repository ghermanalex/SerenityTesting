package com.evozon.Factory;

import com.evozon.model.RegisterInformation;
import com.evozon.utils.Constants;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterInformationFactory {


    public static RegisterInformation getRegisterInformationInstance(){
        RegisterInformation registerInformation = new RegisterInformation();

        registerInformation.setFirstname(Constants.FIRST_NAME);
        registerInformation.setLastname(Constants.LAST_NAME);
        registerInformation.setEmailAddress(RandomStringUtils.randomAlphabetic(5)+ "@mailinator.com");
        registerInformation.setPassword(Constants.USER_PASS);
        registerInformation.setConfirmPassword(Constants.USER_PASS);

        return registerInformation;
    }
}
