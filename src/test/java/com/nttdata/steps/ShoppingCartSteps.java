package com.nttdata.steps;

import com.nttdata.driver.AppCapabilities;
import com.nttdata.driver.AppiumDriverManager;
import com.nttdata.screens.CartDetailScreen;
import com.nttdata.screens.GaleryScreen;
import com.nttdata.screens.ProductDetailScreen;
import org.junit.Assert;

public class ShoppingCartSteps {

    private static final String FILE_CONFIGURATION = "mda.properties";
    private static final String APP_ID = "com.saucelabs.mydemoapp.android";

    private final GaleryScreen galeryScreen = new GaleryScreen();
    private final ProductDetailScreen productDetailScreen = new ProductDetailScreen();
    private final CartDetailScreen cartDetailScreen = new CartDetailScreen();

    public void startApplication() {
        AppiumDriverManager manager = AppiumDriverManager.getInstance();

        manager.stopApp(APP_ID);

        AppCapabilities capabilities = AppCapabilities.from(FILE_CONFIGURATION);

        manager.startApp(capabilities);
    }

    public void validListProducts() {
        galeryScreen.validateListProduct();
    }

    public void addQuantityProductCart(int quantity, String nameProduct) {
        galeryScreen.goProductItem(nameProduct);
        productDetailScreen.addProductCart(quantity);
    }

    public void goToCart() {
        galeryScreen.goCart();
    }

    public String getTitleCart() {
        String title = cartDetailScreen.getTitleCart();
        System.out.println("mensaje:::" + title);
        return title;
    }

    public String getQuantityCart() {
        return cartDetailScreen.getQuantityCart();
    }

    public String getNameProduct() {
        return cartDetailScreen.getNameProduct();
    }

    public String getTitleProducts() {
        return galeryScreen.getTitleProduct();
    }

    public int sizeProducts() {
        return galeryScreen.getSizeProducts();
    }

    public void closeAplication() {
        AppiumDriverManager.getInstance().stopApp(APP_ID);
    }
}
