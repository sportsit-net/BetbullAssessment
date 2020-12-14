package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Countryselection;
import org.testng.annotations.Test;

public class SelectioncountryTest  extends TestBase {

    Countryselection countryselection;

    @Test(priority=3)
    public void  validatecountrypage() throws InterruptedException
    {
        countryselection=new Countryselection();
        countryselection.validatetryitnowclick();
        countryselection.validatecountrselection();

    }
}
