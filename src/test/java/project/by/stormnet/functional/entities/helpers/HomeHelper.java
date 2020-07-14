package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.HomePage;

public class HomeHelper extends AbstractHelper{
    private HomePage homePage = new HomePage();

    public HomeHelper navigateToHomePage(){
        System.out.println("Navigate to home page");
        homePage.navigateToHomePage();
        return this;
    }

    public SearchHelper search(String searchKey){
        navigateToHomePage();
        homePage.fillSearchField(searchKey).clickSearchButton();
        return new SearchHelper();
    }

    public SearchHelper altSearch(String searchKey){
        navigateToHomePage();
        homePage.fillSearchField(searchKey).enterSearchField();
        return new SearchHelper();
    }

    public SearchHelper moveToBoys(){
        navigateToHomePage();
        homePage.clickKidsLink().clickBoysLink();
        return new SearchHelper();
    }

    public ProductHelper articulSearch(String articul){
        navigateToHomePage();
        homePage.enterArticul(articul);
        return new ProductHelper();
    }

    public SearchHelper moveToBoysSection(){
        navigateToHomePage();
        homePage.clickMiddleKidsLink().clickBoysLink();
        return new SearchHelper();
    }

    public SearchHelper moveToNewJeans(){
        navigateToHomePage();
        homePage.clickJeans();
        return new SearchHelper();
    }

    public BucketHelper moveToEmptyBucket(){
        navigateToHomePage();
        homePage.clickBucket();
        return new BucketHelper();
    }

    public SearchHelper buyMainBanner(){
        navigateToHomePage();
        if(homePage.isElementVisible(homePage.getGenderBanner())){
            homePage.clickGenderBanner();
        }
        homePage.clickMainBanner();
        return new SearchHelper();
    }

    public LoginHelper moveToLoginPage(){
        navigateToHomePage();
        homePage.clickLoginLink();
        return new LoginHelper();
    }

}
