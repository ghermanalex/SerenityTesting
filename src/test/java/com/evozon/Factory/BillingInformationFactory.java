package com.evozon.Factory;

import com.evozon.model.BillingInformation;
import org.apache.commons.lang3.RandomStringUtils;

public class BillingInformationFactory {

    public static BillingInformation getBillingInformationInstance() {

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
