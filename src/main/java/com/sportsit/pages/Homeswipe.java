package com.sportsit.pages;

import com.sportsit.base.TestBase;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Homeswipe extends TestBase {
    Homeswipe homeswipe;

    @FindBy(id = "grit.storytel.app:id/carousel_title")
    WebElement welcomeToStorytel;
    @FindBy(id = "grit.storytel.app:id/carousel_title")
    WebElement readTheWayYouWant;

    WebDriverWait wait = new WebDriverWait(driver, 100);


    public Homeswipe() { PageFactory.initElements(driver, this); }

    // To Swipe left and right
    public void carouselswipe() throws InterruptedException
    {
        System.out.println("Initiated Carousel swipe");

        wait.until(ExpectedConditions.visibilityOf(welcomeToStorytel));
        swipeToElementAndroid(welcomeToStorytel, Direction.RIGHT);
        wait.until(ExpectedConditions.visibilityOf(readTheWayYouWant));
        String actual = readTheWayYouWant.getText();
        Assert.assertEquals(actual, "Read the way you want");
        Thread.sleep(3000);
        swipeToElementAndroid(readTheWayYouWant, Direction.LEFT);
        wait.until(ExpectedConditions.visibilityOf(welcomeToStorytel));
        String Actual2 = welcomeToStorytel.getText();
        Assert.assertEquals(Actual2, "Welcome to Storytel.");
        System.out.println("Completed Carousel swipe");

    }


}

