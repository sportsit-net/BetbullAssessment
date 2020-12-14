package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Apphomescreen;
import com.sportsit.pages.Homeswipe;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppswipeTest extends TestBase
{

    Homeswipe apphomeswipe;

    @Test(priority =2)
    public void appswipe() throws InterruptedException {
        apphomeswipe=new Homeswipe();
        apphomeswipe.carouselswipe();


    }
}
