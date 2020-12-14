package com.sportsit.testdata;

import com.sportsit.base.TestBase;
import com.sportsit.pages.Register;
import org.testng.annotations.Test;

public class Registertest extends TestBase {

    Register register;

    @Test(priority=6)
   public void registervalidation() throws InterruptedException {
        register=new Register();
       register.validateregister();
       Thread.sleep(2000);
       register.closeWelcomePage();
        Thread.sleep(2000);
       register.saveBook();
        Thread.sleep(2000);
        register.backToBookTips();
        Thread.sleep(2000);

   }
}
