package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage{
    public  static String loginLabel = "//form[@class=\"form login-form\"]";
    public String loginBtn = "(//button[@type=\"submit\"])[1]";
    public String alertLabel = "//div[text()='Это поле обязательно для заполнения']";
    public String emailField = "(//input[@name=\"email\"])[2]";
    public String passField = "(//input[@name=\"password\"])[1]";
    public String lostPassLink = "//div[@class=\"login-form__lost link link_blue\"]";
    public String lostPassForm = "//form[@class=\"form lost-form\"]";
    public String rememberPassLink = "//span[@class=\"lost-form__login link link_blue\"]";

    public static LoginPage getLoginPage(){
        LoginPage loginPage = new LoginPage();
        waitForElementVisible(getElementBy(loginLabel));
        System.out.println("Login Page is opened");
        return loginPage;
    }

    public By getLoginLabel(){
        waitForElementVisible(getElementBy(loginLabel));
        return getElementBy(loginLabel);
    }

    public LoginPage clickLoginBtn(){
        waitForElementClickable(getElementBy(loginBtn));
        getElement(loginBtn).click();
        return LoginPage.getLoginPage();
    }

    public By getAlertLabel(){
        waitForElementVisible(getElementBy(alertLabel));
        return getElementBy(alertLabel);
    }

    public LoginPage fillEmailField(String email){
        waitForElementVisible(getElementBy(emailField));
        getElement(emailField).sendKeys(email);
        return LoginPage.getLoginPage();
    }

    public LoginPage fillPassField(String pass){
//        waitForElementVisible(getElementBy(emailField));
        waitForElementVisible(getElementBy(passField));
  //      moveToEl(passField);
        getElement(passField).sendKeys(pass);
        return LoginPage.getLoginPage();
    }

    public By getLostPass(){
        waitForElementVisible(getElementBy(lostPassForm));
        return getElementBy(lostPassForm);
    }

    public LoginPage clickLostPass(){
        waitForElementClickable(getElementBy(lostPassLink));
        getElement(lostPassLink).click();
        return LoginPage.getLoginPage();
    }

    public LoginPage clickRememberPassLink(){
        waitForElementClickable(getElementBy(rememberPassLink));
        getElement(rememberPassLink).click();
        return LoginPage.getLoginPage();
    }
}
