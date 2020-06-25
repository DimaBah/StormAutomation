package project.by.stormnet.functional.entities.pages;

public class SearchPage extends AbstractPage{
    private static String resultsCounter = "//span[@class = \"products-catalog__head-counter\"]";
    private static String results = "//div[@class = \"products-list-item dyother dyMonitor\"]";

    public static SearchPage getSearchPage(){
        SearchPage searchPage = new SearchPage();
        waitForElementVisible(getElementBy(results));
        System.out.println("Search Page is opened");
        return searchPage;
    }

    public int getResultsPerPage(){
        return getElements(results).size();
    }

    public String getResultsCount() {
        return getElement(resultsCounter).getText();
    }
}
