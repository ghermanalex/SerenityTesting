package com.evozon.utils;

import java.util.List;
import java.util.Random;

public class Utils {

    public static Integer getRandomElementFromList(List list){
        if(list.size() >1) {
            return new Random().nextInt(list.size() - 1);
        }
        else return 0;
    }

    public static Float fromStringToFloat(String stringPrice){
        StringBuilder strPrice = new StringBuilder(stringPrice);
        Float price = Float.valueOf(strPrice.substring(1, strPrice.length() - 1));
        return price;
    }


}
