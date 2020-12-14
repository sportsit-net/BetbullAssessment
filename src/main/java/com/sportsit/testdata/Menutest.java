package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Burgermenu;
import com.sportsit.pages.Scrolltofeelgoodsection;
import org.testng.annotations.Test;

public class Menutest extends TestBase {

    Burgermenu burgermenu;

    @Test(priority=7)
    public void  scrollvalidate() throws InterruptedException
    {

        burgermenu=new Burgermenu();
        burgermenu.ValidateBookSavedInBookshelf();
        burgermenu.clickOnSearchlink();
        burgermenu.swipeToseries();
        burgermenu.searchingFunction();
        burgermenu.filterFunctionality();
    }
}
