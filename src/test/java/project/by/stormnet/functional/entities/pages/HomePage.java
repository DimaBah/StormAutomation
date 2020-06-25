package project.by.stormnet.functional.entities.pages;

public class HomePage extends AbstractPage{
    private static String Logo = "//a[@class=\"header__logo\"]";
    private String searchField = "//input[@class=\"text-field text-field_large search__input js-search-field\"]";
    private String searchButton = "//div[@class=\"button button_blue search__button js-search-button\"]";

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

public SearchPage clickSearchButton(){
    getElement(searchButton).click();
    return SearchPage.getSearchPage();
}

}

