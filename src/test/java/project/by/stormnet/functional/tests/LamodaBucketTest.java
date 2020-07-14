package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.BucketHelper;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaBucketTest {
    private HomeHelper homeHelper = new HomeHelper();
    private BucketHelper bucketHelper = new BucketHelper();

    @Test
    public void checkEmptyBucket(){
        boolean isBucket = homeHelper.moveToEmptyBucket().isEmptyBucketLogo();
        Assert.assertTrue(isBucket, "It`s not bucket");
    }

    @Test
    public void addItemToBucketFromMainbanner(){
        boolean isBucket = homeHelper.buyMainBanner().moveToItem().moveToBucketBySizeFromPopup().isBucketLogo();
        bucketHelper.deleteItem();
        Assert.assertTrue(isBucket, "It`s not bucket");
    }

    @Test
    public void addItemToBucketByBtn(){
        boolean isBucket = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().isBucketLogo();
        bucketHelper.deleteItem();
        Assert.assertTrue(isBucket, "It`s not bucket");
    }

    @Test
    public void deleteItemFromBucket(){
        boolean isEmptyBucket = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().deleteItem().isEmptyBucketLogo();
        Assert.assertTrue(isEmptyBucket, "Bucket is not empty");
    }

    @Test
    public void keepShopping(){
        boolean isKeepShopping = homeHelper.buyMainBanner().moveToItem().keepShopping().isKeepShopping();
        Assert.assertTrue(isKeepShopping, "Shopping is over");
    }

    @Test
    public void keepShoppingAndCheckout(){
        boolean isBucket = homeHelper.buyMainBanner().moveToItem().keepShoppingAndCheckout().isBucketLogo();
        Assert.assertTrue(isBucket, "Shopping is over");
    }

    @Test
    public void addItemToBucketViaDetails(){
        boolean isBucket = homeHelper.buyMainBanner().moveToItemDetails().moveToBucketByBucketBtn().isBucketLogo();
        bucketHelper.deleteItem();
        Assert.assertTrue(isBucket, "It`s not bucket");
    }

    @Test
    public void checkIncrementItem(){
        int quantity = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().incrementItem().getQuantity();
        bucketHelper.deleteItem();
        Assert.assertEquals(quantity, 2,"Increment does`nt work");
    }

    @Test
    public void checkDecrementItem(){
        int quantity = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().incrementItem().decrementItem().getQuantity();
        bucketHelper.deleteItem();
        Assert.assertEquals(quantity, 1,"Decrement does`nt work");
    }

    @Test
    public void checkPriceAfterIncrementItem(){
        double priceBefore = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().getPrice();
        double priceAfter = bucketHelper.incrementItem().getPrice();
        bucketHelper.deleteItem();
        Assert.assertEquals(priceBefore * 2, priceAfter,"Increment does`nt work");
    }

    @Test
    public void checkPriceAfterDecrementItem(){
        double priceBefore = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().incrementItem().getPrice();
        double priceAfter = bucketHelper.decrementItem().getPrice();
        bucketHelper.deleteItem();
        Assert.assertEquals(priceBefore, priceAfter * 2,"Decrement does`nt work");
    }

    @Test
    public void noIncrementWhenLast(){
        boolean isNoIncrement = homeHelper.buyMainBanner().moveToItem().moveToBucketByBucketBtn().isNoPlusItem();
        Assert.assertTrue(isNoIncrement, "It`s not bucket");
    }
    @AfterTest
    public void tearDown(){
        bucketHelper.deleteItem();
        homeHelper.quit();
    }
}
