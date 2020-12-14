package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Apphomescreen;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Apphomescreentest extends TestBase
{
    Apphomescreen apphomescreen;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization(); }

    @Test(priority =1)
    public void apphomedisplay() throws IOException {

        apphomescreen=new Apphomescreen();
        apphomescreen.validateapphomescreendisplay();


    }

}
