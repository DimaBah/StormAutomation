package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.BucketPage;

public class BucketHelper extends AbstractHelper{
    private BucketPage bucketPage = new BucketPage();

    public boolean isEmptyBucketLogo(){
        return bucketPage.getEmptyBucketLogo();
    }

    public boolean isBucketLogo(){
        return bucketPage.isElementVisible(bucketPage.getBucketLogo());
    }

    public BucketHelper deleteItem(){

        bucketPage.clickDeleteBtn();
        return new BucketHelper();
    }

    public BucketHelper incrementItem(){
        if(!bucketPage.isElementVisible(bucketPage.getLastOne())) {
            bucketPage.clickPlusItem();
        }
        return new BucketHelper();
    }

    public int getQuantity(){
        return Integer.parseInt(bucketPage.getQuantityField().getText());
    }

    public BucketHelper decrementItem(){
        bucketPage.clickMinusItem();
        return new BucketHelper();
    }

    public double getPrice(){
        return Double.parseDouble(bucketPage.getTotalPriceField().getText().split(" ")[0]);
    }

    public boolean isNoPlusItem(){
        return !(bucketPage.isElementVisible(bucketPage.getLastOne()) & bucketPage.isElementVisible(bucketPage.getPlusItem()));
    }
}
