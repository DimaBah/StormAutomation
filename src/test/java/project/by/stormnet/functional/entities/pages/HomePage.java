package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends AbstractPage{
    private static String Logo = "//a[@class=\"header__logo\"]";
    private String searchField = "//input[@placeholder=\"Поиск\"]";
    private String searchButton = "//div[@class=\"button button_blue search__button js-search-button\"]";
    private String kidsLink = "//a[@data-genders=\"children\"]";
    private String boysLink = "//span[text()='Мальчикам']";
    private String middleKidsLink = "//a[@data-gender=\"children\"]";
    private String bucket = "//a[@href=\"/checkout/cart/\"]";
    private String genderBanner = "//a[@data-genders=\"men\"]"; ////a[@data-gender=\"men\"]";
    private String mainBanner = "//div[@class=\"main-banner__redesign js-slider left slick-initialized slick-slider\"]";
    private String newItems = "//span[text()='Новинки']";
    private String newJeans = "//a[@data-position=\"6\"]";
    //   private String newJeans = "//a[text()='Джинсы']";
    public String loginLink = "//span[@class=\"link user-nav__link js-auth-button\"]";


    public static  HomePage getHomePage(){
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(Logo));
        System.out.println("Home Page is opened");
        return homePage;
    }
    public HomePage navigateToHomePage (){
        openUrl(baseUrl);
        return getHomePage();
    }

    public HomePage fillSearchField(String searchKey){
        getElement(searchField).sendKeys(searchKey);
        return getHomePage();
    }

    public SearchPage enterSearchField(){
        waitForElementVisible(getElementBy(searchField));
        getElement(searchField).sendKeys(Keys.ENTER);
        return SearchPage.getSearchPage();
    }

    public SearchPage clickSearchButton(){
        waitForElementVisible(getElementBy(searchButton));
        getElement(searchButton).click();
        return SearchPage.getSearchPage();
    }

    public ProductPage enterArticul(String articul){
        getElement(searchField).sendKeys(articul);
        getElement(searchField).sendKeys(Keys.ENTER);
        return ProductPage.getProductPage();
    }

    public HomePage clickKidsLink(){
        waitForElementVisible(getElementBy(kidsLink));
        getElement(kidsLink).click();
        return getHomePage();
    }

    public SearchPage clickBoysLink(){
        waitForElementVisible(getElementBy(boysLink));
        getElement(boysLink).click();
        getElement(boysLink).click();
        return SearchPage.getSearchPage();
    }

    public HomePage clickMiddleKidsLink(){
        waitForElementVisible(getElementBy(middleKidsLink));
        getElement(middleKidsLink).click();
        return getHomePage();
    }

    public BucketPage clickBucket(){
        waitForElementVisible(getElementBy(bucket));
        getElement(bucket).click();
        return BucketPage.getBucketPage();
    }

    public SearchPage clickGenderBanner(){
        waitForElementVisible(getElementBy(genderBanner));
        getElement(genderBanner).click();
        return SearchPage.getSearchPage();
    }

    public By getGenderBanner(){
        waitForElementVisible(getElementBy(genderBanner));
        return getElementBy(genderBanner);
    }

    public SearchPage clickMainBanner(){
        waitForElementVisible(getElementBy(mainBanner));
        waitForElementClickable(getElementBy(mainBanner));
        getElement(mainBanner).click();
        return SearchPage.getSearchPage();
    }

    public SearchPage clickJeans(){
        waitForElementVisible(getElementBy(newItems));
        moveToMenu(newItems, newJeans);
        return SearchPage.getSearchPage();
    }

    public LoginPage clickLoginLink(){
        waitForElementClickable(getElementBy(loginLink));
        getElement(loginLink).click();
        return LoginPage.getLoginPage();
    }
}