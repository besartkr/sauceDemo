package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import java.io.FileInputStream;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class ProductsStep {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    Properties props = new Properties();
    String selectedProductName;


    @And("user can remove the item from the cart")
    public void userCanRemoveTheItemFromTheCart() {
        cartPage.removeItem();
    }

    @When("User removes {string} from the cart")
    public void userRemovesItemFromCart() {
        cartPage.isProductInCart("Back");
    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty());
        ;
    }

    @And("user selects cart icon")
    public void userSelectsCartIcon() {
        cartPage.selectCartButton();
    }

    @And("Then User should see the inventory page title as {string}")
    public void thenUserShouldSeeTheInventoryPageTitleAs(String expectedTitle) {
        String actualTitle = productsPage.getPageTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("Product should be displayed in the cart")
    public void productShouldBedisplayedInCart() {
        boolean isInCart = cartPage.isProductInCart(selectedProductName);
        assertTrue("Product not found in cart!", isInCart);
    }
    @When("User adds a random product to the cart")
    public void userAddsRandomProductToCart() {
        selectedProductName = productsPage.addRandomProductToCart();
    }
}
