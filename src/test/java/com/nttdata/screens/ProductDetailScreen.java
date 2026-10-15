package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailScreen extends BaseScreen {

    // identidicador del producto
    private final By buttonAddCart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");

    private final By upButtonProduct = AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV");

    public void addQuantity(int quantity) {
        int i;
        for (i = 1; i < quantity; i++) {
            waitForVisible(upButtonProduct).click();
        }
    }

    public void clickAddCart() {
        WebElement buttonAdd = waitForVisible(buttonAddCart);
        buttonAdd.click();
    }

    public void addProductCart(int quantity) {
        addQuantity(quantity);
        clickAddCart();
    }
}
