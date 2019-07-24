package com.evozon.model;

import org.apache.commons.lang3.RandomStringUtils;

public class ShippingData {


    public ShippingInformation setShippingInformation() {
        ShippingInformation shippingInformation = new ShippingInformation();
        shippingInformation.setFirstName(RandomStringUtils.randomAlphabetic(10));
        shippingInformation.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingInformation.setAddress(RandomStringUtils.randomAlphabetic(10));
        shippingInformation.setCity(RandomStringUtils.randomAlphabetic(5));
        shippingInformation.setPostalCode(RandomStringUtils.randomNumeric(7));
        shippingInformation.setPhoneNumber(RandomStringUtils.randomNumeric(10));

        return shippingInformation;
    }

}
