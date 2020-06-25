package project.by.stormnet.functional.tests.onliner_tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.onliner_helpers.OnlinerHomeHelper;

public class OnlinerSearchTest {
    private OnlinerHomeHelper onlinerHomeHelper = new OnlinerHomeHelper();

    @Test
    public void laptopSearch() {
//        onlinerHomeHelper.navigateToOnlinerCatalog();
//        onlinerCatalogHelper.navigateToOnlinerComputersPage();
//        onlinerCatalogHelper.navigateToOnlinerLaptopAndComputerPage();
//        onlinerCatalogHelper.navigateToOnlinerLaptopPage();
//        onlinerLaptopHelper.filterAsus();
//        onlinerLaptopHelper.filterYear2019();
//        int countPerPage = onlinerLaptopHelper.getSearchResultsCountPerPage();
        int countPerPage = onlinerHomeHelper.navigateToOnlinerCatalog().navigateToOnlinerComputersPage()
                .navigateToOnlinerLaptopAndComputerPage().navigateToOnlinerLaptopPage()
                .filterAsus().filterYear2019().filterFromField("1000").filterToField("2000")
                .getSearchResultsCountPerPage();
        System.out.println("There are " + countPerPage + " laptops");
//        Assert.assertFalse(countPerPage > 0, "Catalog links is not shown");
        Assert.assertTrue(countPerPage > 0, "Catalog links is not shown");
    }

    @AfterClass
    public void tearDown(){
        onlinerHomeHelper.quit();
    }
}
