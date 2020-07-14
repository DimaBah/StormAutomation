package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends AbstractPage{
    private static String articul = "//span[text()='Артикул ']/following-sibling::span";
    private String sizeList = "//div[@class=\"product-sizes-select ii-select__value ii-select__value_2line\"]";
    private String size = "//div[@class=\"ii-select__option\"]";
    private String toBucketBtn = "//a[@class=\"button button_blue button_big post-cart-add__basket\"]";
    private String addToBucketBtn = "//span[text()='Добавить в корзину']";
    private String keepShoppingBtn = "//span[text()='Продолжить покупки']";
    private String itemTitle = "//span[@itemprop=\"name\"]";
    private String bucket = "//a[@href=\"/checkout/cart/\"]";

    public static ProductPage getProductPage(){
        ProductPage productPage = new ProductPage();
        waitForElementVisible(getElementBy(articul));
        System.out.println("Product Page is opened");
        return productPage;
    }

    public String getArticul() {
        return getElement(articul).getText();
    }

    public ProductPage chooseSize(){
        waitForElementVisible(getElementBy(sizeList));
        getElement(sizeList).click();
        waitForElementVisible(getElementBy(size));
        getElement(size).click();
        return getProductPage();
    }

    public BucketPage clickToBucketBtn(){
        waitForElementVisible(getElementBy(toBucketBtn));
        getElement(toBucketBtn).click();
        return BucketPage.getBucketPage();
    }

    public By getToBucketBtn(){
        waitForElementVisible(getElementBy(toBucketBtn));
        return getElementBy(toBucketBtn);
    }

    public ProductPage clickAddToBucketBtn(){
        waitForElementVisible(getElementBy(addToBucketBtn));
        getElement(addToBucketBtn).click();
        return ProductPage.getProductPage();
    }

    public ProductPage clickKeepShoppingBtn(){
        waitForElementVisible(getElementBy(keepShoppingBtn));
        getElement(keepShoppingBtn).click();
        return ProductPage.getProductPage();
    }

    public By getItemTitle(){
        waitForElementVisible(getElementBy(itemTitle));
        return getElementBy(itemTitle);
    }

    public BucketPage clickBucket(){
        waitForElementVisible(getElementBy(bucket));
        getElement(bucket).click();
        return BucketPage.getBucketPage();
    }

    public By getSizeList(){
        waitForElementVisible(getElementBy(sizeList));
        return getElementBy(sizeList);
    }
}
