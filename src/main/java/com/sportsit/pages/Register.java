package com.sportsit.pages;

import com.sportsit.base.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Register extends TestBase {


    @FindBy(xpath = "//*[@class = 'android.widget.TextView']")
    WebElement titleText;  //android.widget.TextView
    @FindBy(xpath="//*[@text='E-mail']")
    WebElement email;
    @FindBy(xpath="//*[@text='Password']")
    WebElement password;
    @FindBy(xpath="//*[@text='Continue']")
    WebElement continuebtn;
    @FindBy(xpath="//*[@text='Ég samþykki']")
    WebElement icelandaccept;
    @FindBy(id="grit.storytel.app:id/button_positive")
    WebElement acceptidbtn;
    @FindBy(xpath = "No thanks")
    WebElement nothanks;
    @FindBy(id="grit.storytel.app:id/button_negative")
    WebElement nothanksidbutton;
    @FindBy(xpath = "//*[@text='No Good Asking']")
    WebElement textOf7THIteam;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
    WebElement likeBtn2;
    @FindBy(xpath ="//*[@text='Create account']")
    WebElement signup;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")
    WebElement backArrow;

    public Register() {
        PageFactory.initElements(driver, this);
    }

    //VRegistration
    public void validateregister() throws InterruptedException
    {
        System.out.println("Initiated validate registartion");
        email.sendKeys(generateRandomEmailId());
        Thread.sleep(2000);
        password.sendKeys("Test1234");
        System.out.println("password = Test1234");
        Thread.sleep(2000);
        continuebtn.click();
        Thread.sleep(2000);
        acceptidbtn.click();
       // icelandaccept.click();
        Thread.sleep(3000);
        nothanksidbutton.click();
        Thread.sleep(3000);
        System.out.println("Completed  registartion");
   }
   //Generating random email
    public String generateRandomEmailId() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println("generatedString   === "+generatedString);
        String generateEmail = generatedString+"@gmail.com";
        System.out.println("generateEmail  == "+generateEmail);
        return generateEmail;
    }
    //close welcome page of story tell
    public void closeWelcomePage() throws InterruptedException {
        System.out.println(" Initaited closewelcome page");

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(1000);
       // assertEquals(textOf7THIteam.getText(),"No Good Asking");
        System.out.println("closed welcome page");
    }

    //back button navigation
    public  void backToBookTips() throws InterruptedException {
        System.out.println("Initiated back to book tips");
        Thread.sleep(3000);
        backArrow.click();
        Thread.sleep(2000);
        assertEquals(titleText.getText(),"Book tips");
        System.out.println("Completed back to book tips");
    }
    //Save a book
    public void saveBook() throws InterruptedException {
        System.out.println("Initiated save book");
        Thread.sleep(3000);
        // assertEquals(textOf7THIteam.getText(),"No Good Asking");
        likeBtn2.click();
        Thread.sleep(2000);
        System.out.println("Completed save book");

    }
}


