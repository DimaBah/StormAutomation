package project.by.stormnet.functional.entities.helpers.serial_helpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.serial_pages.SerialSearchPage;

public class SerialSearchHelper extends AbstractHelper {
    private SerialSearchPage serialSearchPage = new SerialSearchPage();

    public int getSearchResultsCountPerPage(){
        return serialSearchPage.getResultsPerPage();
    }

    public long getAllResultsCount(){
//        return Integer.parseInt(serialSearchPage.getResultsCount().split(" ")[2]);
        return Long.parseLong(serialSearchPage.getResultsCount().replace("Результатов: примерно ", "").split("\\(")[0].replace(" ", ""));
    }
}
