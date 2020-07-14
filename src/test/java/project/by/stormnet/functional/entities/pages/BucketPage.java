package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BucketPage extends AbstractPage{

 //   private static String bucketLogo = "//div[@class=\"checkout-header__title js-checkout-title\"]";
    private static String bucketLogo = "//div[text()='Оформление заказа']";
    private String deleteBtn= "//button[@class=\"checkout__button cpi__action cpi__action_remove\"]";
    private String emptyBucketLabel = "//h2[@class=\"h2 cltgray\"]";
    private String plusItem = "//button[@data-action=\"increment_item\"]";
    private String quantity = "//span[@class=\"cpi__qty qty\"]";
    private String minusItem = "//button[@action=\"decrement_item\"]";
    private String oneItem = "//div[text()='  1  товар ']";
    private String totalPrice = "//span[@class=\"price price_current\"]";
    private String lastOne = "//span[text()='Последний']";


    public static BucketPage getBucketPage(){
        BucketPage bucketPage = new BucketPage();
        waitForElementVisible(getElementBy(bucketLogo));
        System.out.println("Bucket Page is opened");
        return bucketPage;
    }

    public By getBucketLogo(){
        waitForElementVisible(getElementBy(bucketLogo));
        return getElementBy(bucketLogo);
    }

    public boolean getEmptyBucketLogo(){
        waitForElementVisible(getElementBy(emptyBucketLabel));
        return isElementVisible(getElementBy(emptyBucketLabel));
    }

    public BucketPage clickDeleteBtn(){

        moveToEl(deleteBtn);
        waitForElementVisible(getElementBy(deleteBtn));
        getElement(deleteBtn).click();
        return getBucketPage();
    }

    public BucketPage clickPlusItem(){
        moveToEl(plusItem);
        waitForElementVisible(getElementBy(plusItem));
        getElement(plusItem).click();
        waitForElementClickable(getElementBy(deleteBtn));
        return getBucketPage();
    }

    public WebElement getQuantityField(){
        waitForElementVisible(getElementBy(quantity));
        return getElement(quantity);
    }

    public BucketPage clickMinusItem(){
        waitForElementVisible(getElementBy(minusItem));
        waitForElementClickable(getElementBy(minusItem));
        getElement(minusItem).click();
        waitForElementVisible(getElementBy(plusItem));
        waitForElementVisible(getElementBy(oneItem));
        return getBucketPage();
    }

    public WebElement getTotalPriceField(){
        waitForElementVisible(getElementBy(totalPrice));
        return getElement(totalPrice);
    }

    public By getLastOne(){
        waitForElementVisible(getElementBy(lastOne));
        return getElementBy(lastOne);
    }

    public By getPlusItem(){
        waitForElementVisible(getElementBy(plusItem));
        return getElementBy(plusItem);
    }

}
