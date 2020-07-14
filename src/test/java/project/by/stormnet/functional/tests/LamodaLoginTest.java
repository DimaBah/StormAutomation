package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaLoginTest {
    private HomeHelper homeHelper = new HomeHelper();

    @Test
    public void toLoginPage(){
        boolean isLoginPage = homeHelper.moveToLoginPage().isLoginLogo();
        Assert.assertTrue(isLoginPage, "It`s not login page");
    }

    @Test
    public void loginWithNoEmailAndPass(){
        boolean isAlert = homeHelper.moveToLoginPage().makeLogin().isAlertLabel();
        Assert.assertTrue(isAlert, "No alert");
    }

    @Test
    public void loginWithNoPass(){
        boolean isAlert = homeHelper.moveToLoginPage().makeLoginWithEmail("bahdiman@mail.ru").isAlertLabel();
        Assert.assertTrue(isAlert, "No alert");
    }

//    @Test
//    public void loginWithBadPass(){
//        boolean isAlert = homeHelper.moveToLoginPage().makeLoginWithEmailAndPass("bahdiman@mail.ru", "zzzzzzzz").isAlertLabel();
//        Assert.assertTrue(isAlert, "It`s not login page");
//    }

    @Test
    public void refreshPass(){
        boolean isPassRecovery = homeHelper.moveToLoginPage().forgetPass().isLostPass();
        Assert.assertTrue(isPassRecovery, "It`s not login page");
    }

    @Test
    public void rememberPass(){
        boolean isLoginPage = homeHelper.moveToLoginPage().forgetPass().rememberPass().isLoginLogo();
        Assert.assertTrue(isLoginPage, "It`s not login page");
    }


    @AfterTest
    public void tearDown(){
        homeHelper.quit();
    }
}
