package project.by.stormnet.functional.tests.serial_tests;

import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.serial_helpers.SerialHomeHelper;

public class SerialSearchTest {
    private SerialHomeHelper serialHomeHelper = new SerialHomeHelper();

    private String param;

    @Factory(dataProvider = "searchKeyProvider")
    public SerialSearchTest (String param){
        this.param = param;
    }

    @DataProvider
    public static Object[][] searchKeyProvider(){
        return new Object[][]{{"сериалы про любовь"}, {"сериалы про роботов"}, {"видоизмененный углерод"}};
    }

    @Test//(priority = 1)
    public void performSearch() {
        serialHomeHelper.searchSerials(param);
        int countPerPage = serialHomeHelper.searchSerials(param).getSearchResultsCountPerPage();
        long countOverall = serialHomeHelper.searchSerials(param).getAllResultsCount();
        System.out.println("Найдено ответов на \"" + param + "\": " + countOverall);
        Assert.assertTrue(countPerPage>0, "no results were found");
    }

    @Test//(priority = 2)
    public void performSearch2(){
        int countPerPage = serialHomeHelper.searchAltSerials(param).getSearchResultsCountPerPage();
        long countOverall = serialHomeHelper.searchAltSerials(param).getAllResultsCount();
        System.out.println("Найдено ответов на \"" + param + "\": " + countOverall);
        Assert.assertTrue(countPerPage>0, "no results were found");
    }

    @AfterTest
    public void tearDown(){
        serialHomeHelper.quit();
    }
}
