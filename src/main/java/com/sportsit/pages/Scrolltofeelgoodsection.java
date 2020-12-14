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
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Scrolltofeelgoodsection extends TestBase {

    Scrolltofeelgoodsection scrolltofeelgoodsection;
    Countryselection countryselection;

    public static WebElement textOf7THIteam;
    public static String expectedTextOf7THIteam;

    WebDriverWait wait = new  WebDriverWait(driver,50);
    @FindBy(xpath = "//*[@class = 'android.widget.TextView']")
    WebElement titleText;  //android.widget.TextView

    @FindBy(xpath = "//*[@text='Feelgood']")
    WebElement feelgoodText;//
    @FindBy(xpath = "//*[@class = 'android.widget.ImageView']")
    List<WebElement> iteamsOfFeelgood;

    /*@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Paris for One\"]")
    WebElement first;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Eleanor Oliphant is Completely Fine\"]")
    WebElement second;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"If Cats Disappeared From The World\"]")
    WebElement third;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Finding Destiny\"]")
    WebElement four;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Rainey Royal\"]")
    WebElement five;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Ibiza's Child\"]")
    WebElement six;
    @FindBy(xpath = "//*[@text='What Luck, This Life']")
    WebElement textOf7THIteam;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Ibiza's Child\"]")
    WebElement seven;
   // @FindBy(xpath = "//*[@text='Ibiza's Child']")
    //WebElement textOf7THIteam;*/
    @FindBy(xpath = "//*[@text='Feelgood']//following::android.widget.ImageView[1]")
    WebElement first;
    @FindBy(xpath = "//*[@text='Feelgood']//following::android.widget.ImageView[5]")
    WebElement third;
    @FindBy(xpath = "//*[@text='Feelgood']//following::android.widget.ImageView[2]")
    WebElement third2;
    @FindBy(xpath = "//*[@text='Feelgood']//following::android.widget.ImageView[6]")
    WebElement five;
    @FindBy(xpath = "//*[@text='Feelgood']//following::android.widget.ImageView[7]")
    WebElement seven;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
    WebElement likeBtn2;
    @FindBy(xpath ="//*[@text='Create account']")
    WebElement signup;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")
    WebElement backArrow;

    public Scrolltofeelgoodsection() { PageFactory.initElements(driver, this);}

    //Scrolling to specific text element
    public void scrollToVisbleText(String visibleText)
    {
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
                if (count == 10) {
                    break;
                }
            }

        }
    }

    /*validating whether scrolled to required element or not
    and selecting 7th element by sipe*/
    public void validatefeelgood() throws InterruptedException
    {
        System.out.println("Initiated validatefeelgood");

        Thread.sleep(1500);
        scrollToVisbleText("Feelgood");
        wait.until(ExpectedConditions.visibilityOf(feelgoodText));
        Assert.assertEquals(feelgoodText.getText(),"Feelgood");
        Thread.sleep(2000);
        System.out.println("Completed validatefeelgood");
    }

    public void select7THItemOfFeelgood() throws InterruptedException {
        System.out.println("Initiated Horizontal scroll fro 7th element");
        Thread.sleep(2000);
        assertEquals(feelgoodText.getText(),"Feelgood");//
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        int startY = first.getLocation().getY() + (first.getSize().getHeight() / 2);
        int startX = first.getLocation().getX() + (first.getSize().getWidth() / 2);
        int thirdX = third.getLocation().getX() + (third.getSize().getWidth() / 2);
        int thirdY = third.getLocation().getY() + (third.getSize().getHeight() / 2);

        action.press(PointOption.point(thirdX,thirdY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startX, startY))
                .release().perform();
        Thread.sleep(2000);
        int third2Y = third2.getLocation().getY() + (third2.getSize().getHeight() / 2);
        int third2X = third2.getLocation().getX() + (third2.getSize().getWidth() / 2);
        int fiveY = five.getLocation().getY() + (five.getSize().getHeight() / 2);
        int fiveX = five.getLocation().getX() + (five.getSize().getWidth() / 2);

        action.press(PointOption.point(fiveX,fiveY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(third2X, third2Y))
                .release().perform();
        expectedTextOf7THIteam = seven.getAttribute("content-desc");
        seven.click();
        Thread.sleep(3000);
        textOf7THIteam= driver.findElement(By.xpath("//*[@text='"+expectedTextOf7THIteam+"']"));
        assertEquals(textOf7THIteam.getText(),expectedTextOf7THIteam);
        System.out.println("Completed Horizontal scroll for 7th element");
    }







































































































































       // -----------------------------------
        /*TouchAction action = new TouchAction(driver);
        int startY = first.getLocation().getY() + (first.getSize().getHeight() / 2);
        int startX = first.getLocation().getX() + (first.getSize().getWidth() / 2);
        int secondY = second.getLocation().getY() + (second.getSize().getHeight() / 2);
        int secondX = second.getLocation().getX() + (second.getSize().getWidth() / 2);
        int thirdX = third.getLocation().getX() + (third.getSize().getWidth() / 2);
        int thirdY = third.getLocation().getY() + (third.getSize().getHeight() / 2);
        System.out.println("firstitem   == "+first.getAttribute("content-desc"));
        System.out.println("firstitem   == "+second.getAttribute("content-desc"));
        System.out.println("firstitem   == "+third.getAttribute("content-desc"));

        action.press(PointOption.point(thirdX,thirdY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startX, startY))
                .release().perform();
        Thread.sleep(2000);
        int fourY = four.getLocation().getY() + (four.getSize().getHeight() / 2);
        int fourX = four.getLocation().getX() + (four.getSize().getWidth() / 2);
        System.out.println("firstitem   == "+four.getAttribute("content-desc"));

        action.press(PointOption.point(fourX,fourY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(thirdX, thirdY))
                .release().perform();
        Thread.sleep(2000);
        int fiveY = five.getLocation().getY() + (five.getSize().getHeight() / 2);
        int fiveX = five.getLocation().getX() + (five.getSize().getWidth() / 2);
        System.out.println("firstitem   == "+five.getAttribute("content-desc"));
        action.press(PointOption.point(fiveX,fiveY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(fourX, fourY))
                .release().perform();
        Thread.sleep(4000);
        /*int sixY = six.getLocation().getY() + (six.getSize().getHeight() / 2);
        int sixX = six.getLocation().getX() + (six.getSize().getWidth() / 2);
        action.press(PointOption.point(fiveX,fiveY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(thirdX, thirdY))
                .release().perform();
        Thread.sleep(2000);
        action.press(PointOption.point(sixX,sixY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(fourX,fourY))
                .release().perform();
        Thread.sleep(2000);
        action.press(PointOption.point(sixX,sixY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(fiveX,fiveY))
                .release().perform();
        //Thread.sleep(2000);
        //assertEquals(textOf7THIteam.getText(),"What Luck, This Life");*/


    //like button click
    public void clickOnLikeButton() throws InterruptedException
    {
        Thread.sleep(2000);
        likeBtn2.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.getText(),"Create account");
        Thread.sleep(2000);
    }


}

