package com.evozon.suite;


import com.evozon.tests.ProductDetailsTest;
import com.evozon.tests.ShoppingCartTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProductDetailsTest.class,
        ShoppingCartTest.class
})
public class SearchTests {

}