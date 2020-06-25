package project.by.stormnet.functional.entities.pages.onliner_pages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class OnlinerCatalogPage extends AbstractPage {
    private static String computersLink = "//li[@data-id=\"2\"]";
    private static String laptopAndComputersLink = "//div[text()[normalize-space()='Ноутбуки, компьютеры, мониторы']]";
    private static String laptopLink = "//a[@href=\"https://catalog.onliner.by/notebook\"]";

    public static OnlinerCatalogPage getOnlinerCatalogPage(){
        OnlinerCatalogPage onlinerCatalogPage = new OnlinerCatalogPage();
        waitForElementVisible(getElementBy(computersLink));
        System.out.println("Catalog Page is opened");
        return onlinerCatalogPage;
    }

    public OnlinerCatalogPage clickComputersLink(){
        waitForElementClickable(getElementBy(computersLink));
        getElement(computersLink).click();
        return OnlinerCatalogPage.getOnlinerCatalogPage();
    }

    public OnlinerCatalogPage clickLaptopAndComputersLink(){
        waitForElementVisible(getElementBy(laptopAndComputersLink));
        getElement(laptopAndComputersLink).click();
        return OnlinerCatalogPage.getOnlinerCatalogPage();
    }

    public OnlinerLaptopPage clickLaptopLink(){
        waitForElementClickable(getElementBy(laptopLink));
        getElement(laptopLink).click();
        return OnlinerLaptopPage.getOnlinerLaptopPage();

    }
}
