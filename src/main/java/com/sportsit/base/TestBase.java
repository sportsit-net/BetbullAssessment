package com.sportsit.base;


import com.sportsit.util.WebEventListener;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;


import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;


public class TestBase {
    //public static WebDriver dri;

    public static AndroidDriver<AndroidElement>  driver;

    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public TestBase() {  }
     //App intialisation
    public static void initialization() {
        try {
            DesiredCapabilities dcap = new DesiredCapabilities();
           dcap.setCapability("no", true);
            dcap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            //APK Path
            Path sourcePath = Paths.get("app\\Storytel.apk");
            dcap.setCapability(MobileCapabilityType.APP, sourcePath);

            Thread.sleep(3000);
            //Android driver intialisation//
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcap);

        } catch (Exception e) {
        }
    }
    public static void swipeToElementAndroid(WebElement el, Direction dir)
    {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 100; // ms
        final int PRESS_TIME = 70; // ms
        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;
        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }


}


