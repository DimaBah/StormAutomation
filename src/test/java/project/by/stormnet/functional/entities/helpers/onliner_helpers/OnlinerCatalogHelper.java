package project.by.stormnet.functional.entities.helpers.onliner_helpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.onliner_pages.OnlinerCatalogPage;

public class OnlinerCatalogHelper extends AbstractHelper {
    private OnlinerCatalogPage onlinerCatalogPage = new OnlinerCatalogPage();

    public OnlinerCatalogHelper navigateToOnlinerComputersPage(){
        System.out.println("Navigate to Onliner Computers Page");
        onlinerCatalogPage.clickComputersLink();
        return this;
    }

    public OnlinerCatalogHelper navigateToOnlinerLaptopAndComputerPage(){
        System.out.println("Navigate to Onliner Laptops & Computers page");
        onlinerCatalogPage.clickLaptopAndComputersLink();
        return this;
    }

    public OnlinerLaptopHelper navigateToOnlinerLaptopPage(){
        System.out.println("Navigate to Onliner Laptops Page");
        onlinerCatalogPage.clickLaptopLink();
        return new OnlinerLaptopHelper();
    }
}
