package com.sportsit.pages;

import com.sportsit.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Languageselection  extends TestBase
{
    //Web elemwnts
    WebDriverWait wait = new  WebDriverWait(driver,50);
    @FindBy(xpath = "//*[@class='android.widget.CheckBox']")
    List<WebElement> languages;
    @FindBy(xpath = "//*[@text='Done']")
    WebElement donebtn;
    @FindBy(xpath = "//*[@text='Book tips']")
    WebElement booktipsappbar;

    public Languageselection()
    {
        PageFactory.initElements(driver, this);
    }

    /*Selecting specified language and unchecking remaining languages
     which are cheched by default in check box list */
    public void languageselection() throws InterruptedException
    {
        System.out.println("Initiated language selection");
        Thread.sleep(2000);
        for (int i = 0; i < languages.size(); i++)
        {
            String lang = languages.get(i).getText();
            if (!lang.equals("English"))
            {
                String status =   languages.get(i).getAttribute("checked");
                // System.out.println("status   "+lang+ "==  "+status);
                if (status.equals("true"))
                {
                    languages.get(i).click();
                }
            }
        }
        Thread.sleep(2000);
        donebtn.click();
        wait.until(ExpectedConditions.visibilityOf(booktipsappbar));
        Assert.assertEquals(booktipsappbar.getText(),"Book tips");
        System.out.println("Completed language selection");
    }
}

