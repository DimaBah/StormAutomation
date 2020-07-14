package project.by.stormnet.functional.entities.pages.serial_pages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class SerialSearchPage extends AbstractPage {
    private static String resultsCounter = "//div[@id=\"result-stats\"]";
    private static String results = "//div[@class=\"g\"]";

    public static SerialSearchPage getSerialSearchPage(){
        SerialSearchPage serialSearchPage = new SerialSearchPage();
        System.out.println("Serials Page is opened");
        return serialSearchPage;
    }

    public int getResultsPerPage(){
        waitForElementVisible(getElementBy(results));
        return getElements(results).size();
    }

    public String getResultsCount() {
        waitForElementVisible(getElementBy(results));
        return getElement(resultsCounter).getText();
    }

}
