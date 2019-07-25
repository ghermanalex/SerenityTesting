package com.evozon.Factory;

import com.evozon.model.ShippingInformation;
import org.apache.commons.lang3.RandomStringUtils;

public class ShippingInformationFactory {

    public static ShippingInformation getShippingInformationInstance() {
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
