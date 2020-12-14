package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Scrolltofeelgoodsection;
import org.testng.annotations.Test;

public class TestScrolltofeelgoodsection extends TestBase {

    Scrolltofeelgoodsection scrolltofeelgoodsection;

    @Test(priority=5)
    public void  scrollvalidate() throws InterruptedException
    {

        scrolltofeelgoodsection=new Scrolltofeelgoodsection();
        scrolltofeelgoodsection.validatefeelgood();
        scrolltofeelgoodsection.select7THItemOfFeelgood();
        scrolltofeelgoodsection.clickOnLikeButton();


    }
}
