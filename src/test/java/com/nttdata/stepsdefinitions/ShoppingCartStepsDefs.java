package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ShoppingCartSteps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingCartStepsDefs {
    private final ShoppingCartSteps shoppingCartSteps = new ShoppingCartSteps();
    private Scenario scenario;

    private String expectProduct;
    private int expectQuantity;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        shoppingCartSteps.startApplication();
        ScreenshotAttacher.attach(scenario, "Pantalla inicial");
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        String titleProducts = shoppingCartSteps.getTitleProducts();
        int sizeProducts = shoppingCartSteps.sizeProducts();

        shoppingCartSteps.validListProducts();
        ScreenshotAttacher.attach(scenario, "Lista de productos");
        Assert.assertTrue(titleProducts.contains("Products"));
        Assert.assertTrue(sizeProducts>1);
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int quantity, String nameProduct) {
        this.expectQuantity = quantity;
        this.expectProduct = nameProduct;
        shoppingCartSteps.addQuantityProductCart(quantity, nameProduct);

        ScreenshotAttacher.attach(scenario, "Añado producto " +quantity + nameProduct );
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        shoppingCartSteps.goToCart();
        String titleCart = shoppingCartSteps.getTitleCart();
        int quantity = Integer.parseInt(shoppingCartSteps.getQuantityCart().trim());
        String nameProduct = shoppingCartSteps.getNameProduct();

        Assert.assertTrue(titleCart.contains("My Cart"));
        Assert.assertEquals(expectQuantity, quantity);
        Assert.assertEquals(expectProduct, nameProduct);

        shoppingCartSteps.closeAplication();

    }
}
