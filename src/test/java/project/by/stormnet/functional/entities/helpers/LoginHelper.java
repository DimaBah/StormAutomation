package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.LoginPage;

public class LoginHelper extends AbstractHelper{
    private LoginPage loginPage = new LoginPage();

    public boolean isLoginLogo(){
        return loginPage.isElementVisible(loginPage.getLoginLabel());
    }

    public LoginHelper makeLogin(){
        loginPage.clickLoginBtn();
        return new LoginHelper();
    }

    public boolean isAlertLabel(){
        return loginPage.isElementVisible(loginPage.getAlertLabel());
    }

    public LoginHelper makeLoginWithEmail(String email){
        loginPage.fillEmailField(email).clickLoginBtn();
        return new LoginHelper();
    }

    public LoginHelper makeLoginWithEmailAndPass(String email, String pass){
        loginPage.fillEmailField(email).fillPassField(pass).clickLoginBtn();
        return new LoginHelper();
    }

    public LoginHelper forgetPass(){
        loginPage.clickLostPass();
        return new LoginHelper();
    }

    public boolean isLostPass(){
        return loginPage.isElementVisible(loginPage.getLostPass());
    }

    public LoginHelper rememberPass(){
        loginPage.clickRememberPassLink();
        return new LoginHelper();
    }
}
