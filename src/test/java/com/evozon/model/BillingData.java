package com.evozon.model;

import org.apache.commons.lang3.RandomStringUtils;

public class BillingData {



    public BillingInformation setBillingInformation(){
        BillingInformation billingInformation = new BillingInformation();

        billingInformation.setFirstName(RandomStringUtils.randomAlphabetic(7));
        billingInformation.setLastname(RandomStringUtils.randomAlphabetic(7));
        billingInformation.setAddress(RandomStringUtils.randomAlphabetic(10));
        billingInformation.setCity(RandomStringUtils.randomAlphabetic(5));
        billingInformation.setPostalCode(RandomStringUtils.randomNumeric(7));
        billingInformation.setPhoneNumber(RandomStringUtils.randomNumeric(10));

        return billingInformation;
    }

}
