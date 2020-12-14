package com.sportsit.pages;

import com.sportsit.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Countryselection extends TestBase
{
    //Locatorss

    @FindBy(xpath = "//*[@text='Try it out']")
    WebElement btntryitout;
    @FindBy(id = "grit.storytel.app:id/appbar")
    WebElement appbar;
    @FindBy(xpath = "//*[@text='Germany']")
    WebElement germanycountry;
    @FindBy(xpath = "//*[@text='Iceland']")
    WebElement icelandcountry;
    @FindBy(xpath = "//*[@text='Done']")
    WebElement donebtn;

    @FindBy(xpath = "//*[@text='Select languages']")
    WebElement languagescreendisplay;

    //wait method
    WebDriverWait wait = new WebDriverWait(driver, 100);


    public Countryselection() { PageFactory.initElements(driver, this); }


    //Validiting whether country screen displayed or not after try it out click
    public void validatetryitnowclick() throws InterruptedException
    {
        System.out.println("Initiated country page");


        btntryitout.click();
        Thread.sleep(3000);
        Assert.assertTrue(appbar.isDisplayed());
        System.out.println("Completed country page");


    }

    //Selecting country after scroll to selected country location
    public void validatecountrselection() throws InterruptedException
    {
        System.out.println("Initiated country and language  selection");

        scrollToVisbleText("Iceland");
        wait.until(ExpectedConditions.visibilityOf(icelandcountry));
        Assert.assertEquals(icelandcountry.getText(), "Iceland");
        icelandcountry.click();
        Thread.sleep(2000);
        donebtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(languagescreendisplay.getText(), "Select languages");
        Assert.assertTrue(languagescreendisplay.isDisplayed());
        System.out.println("Completed country and language  selection");



    }
    // Vertical Scroll to specific text element
    public void scrollToVisbleText(String visibleText)
    {
        System.out.println("Initiated Scrolling to visible text");

        boolean flag = true;
        int count = 1;
        while (flag)
        {
            try
            {

                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                        ".scrollable(true).instance(0))." + "scrollIntoView(new UiSelector()." +
                        "textContains(\"" + visibleText + "\").instance(0))");//.click();
                flag = false;
                break;
            }
            catch (Exception NoSuchElementException)
            {
                if (count == 10)
                {
                    break;
                }
            }

        }
        System.out.println("Completed scroll to visisble text");

    }
}