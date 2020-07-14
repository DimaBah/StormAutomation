package project.by.stormnet.functional.entities.helpers.serial_helpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.serial_pages.SerialHomePage;

public class SerialHomeHelper extends AbstractHelper {
    private SerialHomePage serialHomePage = new SerialHomePage();

    public SerialHomeHelper navigateToHomePage(){
        System.out.println("Navigate to gyglya page");
        serialHomePage.navigateToSerialHomePage();
        return this;
    }

    public SerialSearchHelper searchSerials(String searchKey){
        navigateToHomePage();
        serialHomePage.fillSearchField(searchKey).clickSearchButton();
        return new SerialSearchHelper();
    }

    public SerialSearchHelper searchAltSerials(String searchKey){
        navigateToHomePage();
        serialHomePage.enterSearch(searchKey);
        return new SerialSearchHelper();
    }
}
