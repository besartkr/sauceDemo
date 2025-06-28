package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.WaitUtils;

public class ProductsPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    /**
     *  Selects item from the product page to add to cart - assertion can be added to check the quantity increased in Cart
     */
    public void addItemToCart() {
        wait.waitForElementToBeClickable(addBackpack).click();
    }

    /**
     * Selects Cart icon
     */
    public void openCart() {
        wait.waitForElementToBeClickable(cartIcon).click();
    }
}
