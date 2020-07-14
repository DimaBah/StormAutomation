package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaSearchTest {
    private HomeHelper homeHelper = new HomeHelper();

    @Test(dataProvider = "negativeKeys")
    public void negativeSearch(String nKey){
        int countPerPage = homeHelper.search(nKey).getSearchResultsCountPerPage();
        System.out.println(nKey + " Neg res: " + countPerPage);
        Assert.assertEquals(countPerPage, 0, "Wrong results were found");
//        throw new SkipException("Skipping this test");
    }

    @DataProvider(name = "negativeKeys")
    public Object[][] negKeys(){
        return new Object[][]{{"zzzzzzz"}, {"______"}, {"++++"}};
    }

    @Test
    public void resultsCountCheck(){
        int count = homeHelper.altSearch("одежда").getAllResultsCount();
        System.out.println("Total clothes: " + count);
        Assert.assertTrue(count > 1000, "Too few results");
    }

    @Test
    public void recommendationCheck(){
        boolean isRecShown = homeHelper.search("----").isRecommendations();
        Assert.assertTrue(isRecShown, "No recomendations shown");
    }

    @Test
    public void searchByArticul(){
        String art = homeHelper.articulSearch("LE306EMFOUS0").getArticulValue();
        Assert.assertEquals(art, "LE306EMFOUS0", "Wrong articul");
    }

    @Test
    public void moveToBoysCategory(){
        boolean isBoysShown = homeHelper.moveToBoys().isBoysLabel();
        Assert.assertTrue(isBoysShown, "Boys category is not shown");
    }

    @Test
    public void checkBoysSection() {
        int countPerPage = homeHelper.moveToBoysSection().getSearchResultsCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

//    @Test
//    public void dropdownJeans(){
//        int countPerPage = homeHelper.moveToNewJeans().getSearchResultsCountPerPage();
//        Assert.assertTrue(countPerPage > 0, "No results were found");
//    }

    @Test
    public void searchBrand(){
        String brandLabelText = homeHelper.altSearch("nike").brandLabelText();
        Assert.assertTrue(brandLabelText.equalsIgnoreCase("nike"), "Brand section is not shown");
    }

    @Test
    public void filterShoesBySeason(){
        int countPerPage = homeHelper.altSearch("nike").chooseSeason().getSearchResultsCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

    @Test
    public void filterShoesByPrice(){
        int countPerPage = homeHelper.altSearch("nike").choosePrice("60", "100").getSearchResultsCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

    @Test
    public void filterShoesByPriceAlt(){
        int countPerPage = homeHelper.altSearch("nike").choosePrice("60", "100").getShoesResult();
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

    @Test
    public void badFilterByPrice(){
        boolean isNoResults = homeHelper.altSearch("nike").choosePrice("1", "2").isNoresultsLabel();
        Assert.assertTrue(isNoResults, "Wrong results were found");
    }

    @AfterTest
    public void tearDown(){
        homeHelper.quit();
    }
}
