package com.sportsit.pages;

import com.sportsit.base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Burgermenu extends TestBase
{

    public Burgermenu()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='android.widget.ImageButton']")
    WebElement sideMenu;
    @FindBy(xpath = "//*[@text='Your Bookshelf']")
    WebElement yourBookshelf; //
    @FindBy(xpath = "//*[@text='No Good Asking']")
    WebElement bookDetailsInBookshelf;
    // hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton
    @FindBy(xpath = "//*[@text='CURRENT BOOK']")
    WebElement currectBookTitle;
    @FindBy(xpath = "//*[@text='Search']")
    WebElement searchLink;
    @FindBy(xpath = "//*[@text='Series']")
    WebElement seriesLink;
    @FindBy(xpath = "//*[@text='Search']") //*[@id='autoCompleteTextView']
    WebElement topSearch;
    @FindBy(xpath = "//*[@text='Filter']")
    WebElement filter;
    @FindBy(xpath = "//*[@text='Ebook']")
    WebElement ebook;
    @FindBy(xpath = "//*[@text='Done']")
    WebElement done;
    @FindBy(id = "grit.storytel.app:id/textViewNoResult")
    WebElement oopsText;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Top\"]")
    WebElement topLink;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Narrators\"]")
    WebElement narratorsLink;
    @FindBy(xpath = "//*[@text='Adventures of Harry Stevenson']")
    WebElement adventuresOfHarryStevenson;
    @FindBy(id = "grit.storytel.app:id/headerTitleTextView")
    WebElement headerTitleTextView;
    // The Adventures of Harry Stevenson
    @FindBy(xpath = "//*[@text='Harry Denton']")
    WebElement first;
    @FindBy(xpath = "//*[@text='Harry Stoner']")
    WebElement four;  //
    @FindBy(xpath = "//*[@text='Harry Devlin']")
    WebElement seven;

    //Burger Menu display validation
    public void openSideMenu() throws InterruptedException
    {
        System.out.println("Open side menu initiated");

        Thread.sleep(2000);
        sideMenu.click();
        Thread.sleep(2000);
        Assert.assertEquals(currectBookTitle.getText(),"CURRENT BOOK");
        System.out.println("Open side menu completed");

    }
    //search link
    public void clickOnSearchlink() throws InterruptedException
    {
        System.out.println("search link initiated");

        Thread.sleep(2000);
        openSideMenu();
        Thread.sleep(2000);
        searchLink.click();
        Thread.sleep(2000);
        Assert.assertEquals(topLink.getAttribute("content-desc"),"Top");
        System.out.println("search link completed");

    }
    //to check whether books saved or not
    public void ValidateBookSavedInBookshelf() throws InterruptedException
    {
        System.out.println("initiated book saved in bookshelf");

        Thread.sleep(2000);
        openSideMenu();
        yourBookshelf.click();
        Thread.sleep(2000);
        System.out.println("Completed book saved in bookshelf");
    }
    public void swipeToseries() throws InterruptedException
    {
        System.out.println("initiated Swipe to series");
        Thread.sleep(3000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(topLink));
        Thread.sleep(2000);
        topSearch.click();
        TouchAction action = new TouchAction(driver);
        int topLinkY = topLink.getLocation().getY() + (topLink.getSize().getHeight() / 2);
        int topLinkX = topLink.getLocation().getX() + (topLink.getSize().getWidth() / 2);
        int narratorsLinkX = narratorsLink.getLocation().getX() + (narratorsLink.getSize().getWidth() / 2);
        int narratorsLinkY = narratorsLink.getLocation().getY() + (narratorsLink.getSize().getHeight() / 2);
        action.press(PointOption.point(narratorsLinkX,narratorsLinkY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(topLinkX, topLinkY))
                .release().perform();
            Thread.sleep(2000);
            Assert.assertEquals(seriesLink.getText(),"Series");
        System.out.println("Completed  Swipe to series");

    }
        //Searching book
        public void searchingFunction() throws InterruptedException
        {
            System.out.println("Initiated search");

            Thread.sleep(2000);
            seriesLink.click();
            topSearch.click();
            Thread.sleep(2000);
            topSearch.sendKeys("Harry");
            Thread.sleep(2000);
            TouchAction action = new TouchAction(driver);
            int firstY = first.getLocation().getY() + (first.getSize().getHeight() / 2);
            int firstX = first.getLocation().getX() + (first.getSize().getWidth() / 2);
            int fourX = four.getLocation().getX() + (four.getSize().getWidth() / 2);
            int fourY = four.getLocation().getY() + (four.getSize().getHeight() / 2);
            action.press(PointOption.point(fourX,fourY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(firstX, firstY))
                    .release().perform();
            Thread.sleep(2000);
            int sevenX = seven.getLocation().getX() + (seven.getSize().getWidth() / 2);
            int sevenY = seven.getLocation().getY() + (seven.getSize().getHeight() / 2);
            Thread.sleep(2000);
            action.press(PointOption.point(sevenX,sevenY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(fourX,fourY))
                    .release().perform();
            Thread.sleep(2000);
            adventuresOfHarryStevenson.click();
            Thread.sleep(2000);
            Assert.assertEquals(headerTitleTextView.getText(),"Adventures of Harry Stevenson");
            System.out.println("Completed search");


        }
        //Filters
        public void filterFunctionality() throws InterruptedException
        {
            System.out.println("Initiated filterfunctionality");

            Thread.sleep(2000);
            filter.click();
            Thread.sleep(2000);
            ebook.click();
            Thread.sleep(2000);
            done.click();
            Thread.sleep(2000);
            Assert.assertEquals(oopsText.getText(),"Oops! It seems you've filtered a bit too much.");
            System.out.println("Completed  filter functionality");


        }
    }
