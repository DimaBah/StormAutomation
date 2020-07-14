package project.by.stormnet.functional.entities.pages.serial_pages;

import org.openqa.selenium.Keys;
import project.by.stormnet.functional.entities.pages.AbstractPage;

public class SerialHomePage extends AbstractPage {
    private static String Logo = "//img[@alt=\"День Независимости Республики Беларусь 2020\"]";
    private String searchField = "//input[@type=\"text\"]";
    private String searchButton = "//input[@value=\"Поиск в Google\"]";

    public static SerialHomePage getSerialHomePage(){
        SerialHomePage serialHomePage = new SerialHomePage();
        waitForElementVisible(getElementBy(Logo));
        System.out.println("Guglya Page is opened");
        return serialHomePage;
    }

    public SerialHomePage navigateToSerialHomePage (){
        openUrl(googleUrl);
        return getSerialHomePage();
    }

    public SerialHomePage fillSearchField(String searchKey){
        getElement(searchField).sendKeys(searchKey);
        waitForElementVisible(getElementBy(Logo));
        waitForElementVisible(getElementBy(searchField));
        waitForElementVisible(getElementBy(searchButton));
        return getSerialHomePage();
    }

    public SerialSearchPage clickSearchButton(){
        getElement(searchButton).click();
        return SerialSearchPage.getSerialSearchPage();
    }

    public SerialSearchPage enterSearch(String searchKey){
        getElement(searchField).sendKeys(searchKey);
        getElement(searchField).sendKeys(Keys.ENTER);
        return SerialSearchPage.getSerialSearchPage();
    }
}
