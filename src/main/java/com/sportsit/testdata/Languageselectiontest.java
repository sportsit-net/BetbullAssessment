package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Countryselection;
import com.sportsit.pages.Languageselection;
import org.testng.annotations.Test;

public class Languageselectiontest extends TestBase
{
    Languageselection languageselection;

    @Test(priority=4)
    public void  validatelanguageselction() throws InterruptedException {
        languageselection=new Languageselection();
        languageselection.languageselection();

    }
}
