package project.by.stormnet.functional.entities.helpers.onliner_helpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.onliner_pages.OnlinerLaptopPage;

public class OnlinerLaptopHelper extends AbstractHelper {
    private OnlinerLaptopPage onlinerLaptopPage = new OnlinerLaptopPage();

    public OnlinerLaptopHelper filterAsus(){
        onlinerLaptopPage.clickCheckboxAsus();
        return this;
    }

    public OnlinerLaptopHelper filterYear2019() {
        onlinerLaptopPage.clickCheckboxYear2019();
        return this;
    }

    public OnlinerLaptopHelper filterFromField(String fromNumber){
        onlinerLaptopPage.fillFromField(fromNumber);
        return this;
    }

    public OnlinerLaptopHelper filterToField(String toNumber) {
        onlinerLaptopPage.fillToField(toNumber);
        return this;
    }

    public int getSearchResultsCountPerPage(){
        return onlinerLaptopPage.getResultsPerPage();
    }
}
