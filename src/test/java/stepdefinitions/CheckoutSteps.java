package stepdefinitions;

import io.cucumber.java.en.*;
import pages.*;

import java.io.FileInputStream;
import java.util.Properties;

public class CheckoutSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    Properties props = new Properties();

    @And("user adds an item to the cart")
    public void addToCartStep() {
        productsPage.addItemToCart();
    }

    @And("user proceeds to checkout")
    public void proceedToCheckOutStep() {
        cartPage.selectCartButton();
        productsPage.openCart();
        cartPage.clickCheckout();
    }

    @When("user completes the customer details in checkout process")
    public void enterCustomerFullDetails() throws Exception {
        props.load(new FileInputStream("src/test/resources/config.properties"));
        checkoutPage.fillDetails(props.getProperty("lastName"), props.getProperty("firstName"), props.getProperty("pCode"));


    }

    @And("user selects Continue Checkout button")
    public void selectContinueCheckoutButton() throws Exception {
        checkoutPage.continueCheckout();

    }

    @And("user selects Finish Checkout button")
    public void selectFinishCheckoutButton() throws Exception {
        checkoutPage.finishCheckout();

    }

    @Then("user should see the confirmation message")
    public void verifyCheckoutStep() {
        checkoutPage.verifyConfirmation();
    }
    @Then("user should see enter lastName error message")
    public void checkoutErrorMessageDisplayed() {
        checkoutPage.assertCheckOutErrorMessage();
    }

    @And("user can navigate back to products page")
    public void userCanNavigateBackToProductsPage() {
        checkoutPage.selectBackToHomeBtn();
        productsPage.getPageTitle();
    }
}
