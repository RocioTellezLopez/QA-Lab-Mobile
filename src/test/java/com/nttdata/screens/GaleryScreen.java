package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GaleryScreen extends BaseScreen {

    private final By productList = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productRV");

    private final By productItem(String productName) {
        return AppiumBy.accessibilityId(productName);
    };

    private final By buttonCart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartRL");

    private final By titleProducts = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");

    private final By namesProducts = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");


    public void validateListProduct () {
        waitForVisible(productList);
    };

    public void goProductItem (String productName) {
        WebElement product = waitForVisible(productItem(productName));
        product.click();
    }

    public void goCart () {
        waitForVisible(buttonCart).click();
    };

    public String getTitleProduct () {
        return waitForVisible(titleProducts).getText();
    }

    public int getSizeProducts (){
     return driver().findElements(namesProducts).size();
    }
}


