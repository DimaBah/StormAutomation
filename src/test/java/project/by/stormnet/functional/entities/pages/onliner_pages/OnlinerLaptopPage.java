package project.by.stormnet.functional.entities.pages.onliner_pages;

import org.openqa.selenium.interactions.Actions;
import project.by.stormnet.functional.entities.pages.AbstractPage;

public class OnlinerLaptopPage extends AbstractPage {
    public static String result = "//div[@class=\"schema-product__part schema-product__part_2\"]";
    public static String checkboxAsus = "//label[@class=\"schema-filter__checkbox-item\"]/span[text()=\"ASUS\"][1]";
    public static String checkboxYear2019 = "//label[@class=\"schema-filter__checkbox-item\"]/span[text()=\"2019\"]";
    public static String bottomLabel = "//span[text()='Тип']";
    public static String fromField = "//input[@placeholder=\"от\"]";
    public static String toField = "//input[contains(@data-bind,'до')][1]";
 //   public static String toField = "//div[@class=\"schema-filter-control schema-filter-control_input\"][2]";
    public static String footerFlag = "//span[@data-bind=\"click: $root.doMoved.bind($root)\"]";

    public static OnlinerLaptopPage getOnlinerLaptopPage(){
        OnlinerLaptopPage onlinerLaptopPage = new OnlinerLaptopPage();
        waitForElementVisible(getElementBy(result));
        System.out.println("Laptop page is shown");
        return onlinerLaptopPage;
    }

    public OnlinerLaptopPage clickCheckboxAsus(){
        waitForElementVisible(getElementBy(checkboxAsus));
        getElement(checkboxAsus).click();
        return OnlinerLaptopPage.getOnlinerLaptopPage();
    }

    public OnlinerLaptopPage clickCheckboxYear2019() {
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(bottomLabel));
        scroll.perform();
        waitForElementVisible(getElementBy(checkboxYear2019));
        getElement(checkboxYear2019).click();
        return OnlinerLaptopPage.getOnlinerLaptopPage();
    }

    public OnlinerLaptopPage fillFromField(String fromNumber){
        waitForElementVisible(getElementBy(footerFlag));
        getElement(fromField).sendKeys(fromNumber);
        return OnlinerLaptopPage.getOnlinerLaptopPage();
    }

    public OnlinerLaptopPage fillToField(String toNumber) {
        waitForElementVisible(getElementBy(footerFlag));
        getElement(toField).sendKeys(toNumber);
        return OnlinerLaptopPage.getOnlinerLaptopPage();
    }

    public int getResultsPerPage(){
        return getElements(result).size();
    }
}
