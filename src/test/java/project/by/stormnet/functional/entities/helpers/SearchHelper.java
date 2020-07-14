package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.SearchPage;

public class SearchHelper extends AbstractHelper{
    private SearchPage searchPage = new SearchPage();

    public int getSearchResultsCountPerPage(){
        return searchPage.getResultsPerPage();
    }

    public int getShoesResult(){
        return searchPage.getShoesResultsPerPage();
    }

    public int getAllResultsCount(){
        return Integer.parseInt(searchPage.getResultsCount().split(" ")[0]);
    }

    public boolean isRecommendations(){
        return searchPage.getRecommendations();
    }

    public boolean isBoysLabel(){
        return searchPage.getBoysLabel();
    }

    public String brandLabelText(){
        return searchPage.getBrandLabel().getText();
    }

    public SearchHelper chooseSeason(){
        searchPage.moveToRezShoes().filterShoesBySeason();
        return new SearchHelper();
    }

    public SearchHelper choosePrice(String minPr, String maxPr){
        searchPage.moveToRezShoes().filterShoesByPrice(minPr, maxPr);
        return new SearchHelper();
    }

    public ProductHelper moveToItem(){
        searchPage.clickItem();
        return new ProductHelper();
    }

    public boolean isNoresultsLabel(){
        return searchPage.getNoResultsLabel();
    }

    public ProductHelper moveToItemDetails(){
        searchPage.clickDetails();
        return new ProductHelper();
    }
}
