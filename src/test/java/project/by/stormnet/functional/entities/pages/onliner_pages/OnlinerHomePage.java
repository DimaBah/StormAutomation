package project.by.stormnet.functional.entities.pages.onliner_pages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class OnlinerHomePage extends AbstractPage {
    private static String onlinerLogo = "//img[@class=\"onliner_logo\"]";
    private String catalogButton = "//span[@class=\"b-main-navigation__text\"]";

    public static  OnlinerHomePage getHomePage() {
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        waitForElementVisible(getElementBy(onlinerLogo));
        System.out.println("Onliner home Page is opened");
        return onlinerHomePage;
    }

    public OnlinerHomePage navigateToHomePage (){
        openUrl(onlinerUrl);
        return getHomePage();
    }

    public OnlinerCatalogPage clickCatalogButton(){
        getElement(catalogButton).click();
        return OnlinerCatalogPage.getOnlinerCatalogPage();
    }
}
