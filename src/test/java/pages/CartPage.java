package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.WaitUtils;

public class CartPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);
    private By checkoutBtn = By.id("checkout");
    private By removeBtn = By.id("remove-sauce-labs-backpack");
    private By cartBtn = By.cssSelector(".shopping_cart_link");

    /**
     * Selects the Checkout button on Checkout journey
     */
    public void clickCheckout() {
        wait.waitForElementToBeClickable(checkoutBtn).click();
    }

    /**
     * Selects the remove button on Checkout journey
     */
    public void removeItem() {
        wait.waitForElementToBeClickable(removeBtn).click();
    }

    /**
     * Selects the Checkout button on Checkout journey
     */
    private By cartItemName = By.className("inventory_item_name");

    /**
     * Selects an item from the products page based on the name provided in BBD -
     */
    public boolean isItemInCart(String itemName) {
        return driver.findElements(cartItemName)
                .stream()
                .anyMatch(element -> element.getText().equalsIgnoreCase(itemName));
    }

    /**
     * Removes product from the checkout journey - name of the product provided in BDD
     * @param itemName
     */
    public void removeItem(String itemName) {
        wait.waitForElementToBeVisible(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='cart_item']//button")).click();
    }

    /**
     * Checks the cart is empty on the checkout journey
     * @return
     */

    public boolean isCartEmpty() {
        return driver.findElements(cartItemName).isEmpty();
    }

    /**
     * Selects Cart button - Assertion would require to confirm the action
     */
    public void selectCartButton(){
        wait.waitForElementToBeVisible(cartBtn).click();
    }

}
