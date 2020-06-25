package project.by.stormnet.functional.entities.helpers.onliner_helpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.onliner_pages.OnlinerHomePage;

public class OnlinerHomeHelper extends AbstractHelper {
    private OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

    public OnlinerHomeHelper navigateToOnlinerHomePage(){
        System.out.println("Navigate to onliner home page");
        onlinerHomePage.navigateToHomePage();
        return this;
    }

    public OnlinerCatalogHelper navigateToOnlinerCatalog(){
        navigateToOnlinerHomePage();
        onlinerHomePage.clickCatalogButton();
        return new OnlinerCatalogHelper();
    }
}
