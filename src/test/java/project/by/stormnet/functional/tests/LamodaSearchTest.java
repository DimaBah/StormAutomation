package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaSearchTest {
    private HomeHelper homeHelper = new HomeHelper();
    private String searchKey = "jeans";

    @Test
    public void performSearch(){
        int countPerPage = homeHelper.search(searchKey).getSearchResultsCountPerPage();
        Assert.assertTrue(countPerPage>0, "no results were found");
    }

    @AfterClass
    public void tearDown(){
        homeHelper.quit();
    }
}
