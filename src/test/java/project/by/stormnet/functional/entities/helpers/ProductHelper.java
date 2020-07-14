package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.ProductPage;

public class ProductHelper extends AbstractHelper{
    ProductPage productPage = new ProductPage();

    public String getArticulValue() {
        return productPage.getArticul();
    }

    public BucketHelper moveToBucketBySizeFromPopup(){
        if(productPage.isElementVisible(productPage.getSizeList())){
            productPage.chooseSize();
        }
        if(productPage.isElementVisible(productPage.getToBucketBtn())){
            productPage.clickToBucketBtn();
        } else{
            productPage.clickAddToBucketBtn().clickToBucketBtn();
        }
        return new BucketHelper();
    }

    public BucketHelper moveToBucketByBucketBtn(){
        if(productPage.isElementVisible(productPage.getSizeList())){
            productPage.chooseSize();
        }
        productPage.clickAddToBucketBtn().clickToBucketBtn();
        return new BucketHelper();
    }

    public ProductHelper keepShopping(){
        if(productPage.isElementVisible(productPage.getSizeList())){
            productPage.chooseSize();
        }
        productPage.clickAddToBucketBtn().clickKeepShoppingBtn();
        return new ProductHelper();
    }

    public boolean isKeepShopping(){
        return productPage.isElementVisible(productPage.getItemTitle());
    }

    public BucketHelper keepShoppingAndCheckout(){
        if(productPage.isElementVisible(productPage.getSizeList())){
            productPage.chooseSize();
        }
        productPage.clickAddToBucketBtn().clickKeepShoppingBtn().clickBucket();
        return new BucketHelper();
    }

}
