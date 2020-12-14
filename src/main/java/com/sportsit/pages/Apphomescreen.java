package com.sportsit.pages;

import com.sportsit.base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Apphomescreen extends TestBase {

    Apphomescreen apphomescreen;

    @FindBy(xpath="//*[@text='Try it out']")
    WebElement tryitoutbtn;
    @FindBy(xpath="//*[@text='Log in']")
    WebElement loginbtn;

    public Apphomescreen()
    {
        PageFactory.initElements(driver, this);
    }

    //Validating home screen elements after launching
    public void validateapphomescreendisplay()
    {
        System.out.println("Home screen validation initiated");
        Assert.assertTrue(tryitoutbtn.isDisplayed());
        Assert.assertTrue(loginbtn.isDisplayed());
        System.out.println("Home scrren validation completed");
    }
       //Method for app close
         @AfterSuite
      public void closeapp()
     {
       driver.quit();
      }

}
