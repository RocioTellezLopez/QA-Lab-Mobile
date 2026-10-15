package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartDetailScreen extends BaseScreen {

    // items  id = com.saucelabs.mydemoapp.android:id/itemsTV
    // productos en el carrito xpath: //androidx.recyclerview.widget.RecyclerView[@content-desc="Displays list of selected products"]/android.view.ViewGroup[1]


    private final By titleCart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");

    private final By quantityCart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV");

    private final By nameProduct = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");

    public String getTitleCart () {
        return waitForVisible(titleCart).getText();
    }

    public String getQuantityCart () {
        return waitForVisible(quantityCart).getText();
    }

    public String getNameProduct () {
        return waitForVisible(nameProduct).getText();
    }



}
