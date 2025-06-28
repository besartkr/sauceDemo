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


    @And("user can remove the item from the cart")
    public void userCanRemoveTheItemFromTheCart() {
        cartPage.removeItem();
    }
    @Then("User should see {string} in the cart")
    public void userShouldSeeItemInCart(String itemName) {
        Assert.assertTrue(cartPage.isItemInCart(itemName));
    }

    @When("User removes {string} from the cart")
    public void userRemovesItemFromCart(String itemName) {
        cartPage.removeItem(itemName);
    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty());;
    }

    @And("user selects cart icon")
    public void userSelectsCartIcon() {
        cartPage.selectCartButton();
    }
}
