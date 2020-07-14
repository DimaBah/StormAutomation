package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPage{
    private static String Logo = "//a[@class=\"header__logo\"]";
    private static String resultsCounter = "//span[@class = \"products-catalog__head-counter\"]";
    private static String results = "//div[@class = \"products-list-item dyother dyMonitor\"]";
    private static String resultsAlternative = "//div[@class = \"products-list-item\"]";
    private String recommendations = "//div[@class=\"wNkELe4sz6rXuEowGeFzp\"]";
    private String recAlternative = "//a[@class=\"slider__slide slick-slide slick-active\"]";
    private String boysLabel = "//h2[text()='Одежда, обувь и аксессуары для мальчиков']";
    private String brandLabel = "//h2";
    private String shoes = "//a[text()='Обувь']";
    private String rezShoes = "//a[text()='Резиновая обувь']";
    private String seasonList = "//span[text()='Сезон']";
    private String season = "//label[text()='лето']";
    private String price = "//span[text()='Цена']";
    private String maxPrice = "//input[@class=\"text-field range__value range__value_right\"]";
    private String minPrice = "//input[@class=\"text-field range__value range__value_left\"]";
    private String doPrice = "//span[@class=\"button button_s button_blue multifilter-actions__apply\"]";
    private String priceFilter = "(//span[@class=\"multifilter__title\"])[5]";
    private String shoesResult = "//div[@class=\"products-list-item\"]";
    private String noShoesResult = "//h2[text()='В выбранной категории ничего не найдено']";
    private String details = "//div[@class=\"zoomin products-list-item__qv\"]";


    public static SearchPage getSearchPage(){
        SearchPage searchPage = new SearchPage();
        waitForElementVisible(getElementBy(Logo));
        System.out.println("Search Page is opened");
        return searchPage;
    }

    public int getResultsPerPage(){
        if(getSearchPage().isElementVisible(getElementBy(resultsAlternative))){
            return getElements(resultsAlternative).size();
        } else {
            return getElements(results).size();
        }
    }

    public int getShoesResultsPerPage(){
        return getElements(shoesResult).size();
    }

    public String getResultsCount() {
        return getElement(resultsCounter).getText();
    }

    public boolean getRecommendations(){
//        waitForElementVisible(getElementBy(recommendations));
        return isElementVisible(getElementBy(recommendations)) || isElementVisible(getElementBy(recAlternative));
    }

    public boolean getBoysLabel(){
        waitForElementVisible(getElementBy(boysLabel));
        return isElementVisible(getElementBy(boysLabel));
    }

    public WebElement getBrandLabel(){
        waitForElementVisible(getElementBy(brandLabel));
        return getElement(brandLabel);
    }

    public SearchPage moveToRezShoes(){
        waitForElementVisible(getElementBy(shoes));
        waitForElementClickable(getElementBy(shoes));
        getElement(shoes).click();
        waitForElementVisible(getElementBy(rezShoes));
        waitForElementClickable(getElementBy(rezShoes));
        getElement(rezShoes).click();
        return SearchPage.getSearchPage();
    }

    public SearchPage filterShoesBySeason(){
        waitForElementVisible(getElementBy(seasonList));
        waitForElementClickable(getElementBy(seasonList));
        getElement(seasonList).click();
        waitForElementVisible(getElementBy(season));
        waitForElementClickable(getElementBy(season));
        getElement(season).click();
        return SearchPage.getSearchPage();
    }

    public SearchPage filterShoesByPrice(String minPr, String maxPr){
        waitForElementVisible(getElementBy(price));
        getElement(price).click();
        waitForElementVisible(getElementBy(maxPrice));
        getElement(minPrice).click();
        getElement(minPrice).sendKeys(minPr);
        getElement(maxPrice).click();
        getElement(maxPrice).sendKeys(maxPr);
        waitForElementVisible(getElementBy(doPrice));
        getElement(doPrice).click();
        waitForElementVisible(getElementBy(priceFilter));
        return SearchPage.getSearchPage();
    }

    public boolean getNoResultsLabel(){
        waitForElementVisible(getElementBy(noShoesResult));
        return isElementVisible(getElementBy(noShoesResult));
    }

    public ProductPage clickItem(){
        waitForElementVisible(getElementBy(results));
        getElement(results).click();
        return ProductPage.getProductPage();
    }

    public ProductPage clickDetails(){
        moveToEl(results);
        moveToEl(details);
        waitForElementVisible(getElementBy(details));
        waitForElementClickable(getElementBy(details));
        getElement(details).click();
        return ProductPage.getProductPage();
    }
}
