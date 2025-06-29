package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;
import utils.WaitUtils;
import java.util.List;
import java.util.Random;


public class ProductsPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);
    private By addBackpack = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    private By cartIcon = By.className("shopping_cart_link");
    private By addToCartButton = By.xpath(".//button[contains(text(),'Add to cart')]");
    private By cartItems = By.className("inventory_item_name");
    private By productsListClass = By.className("inventory_item");
    private By itemName = By.className("inventory_item_name");


    /**
     *  Selects item from the product page to add to cart - assertion can be added to check the quantity increased in Cart
     */
    public void addItemToCart() {
        wait.waitForElementToBeVisible(addBackpack);
        wait.waitForElementToBeClickable(addBackpack).click();
    }

        /**
     * Selects Cart icon
     */
    public void openCart() {
        wait.waitForElementToBeClickable(cartIcon).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String addRandomProductToCart() {
        wait.waitForElementToBeVisible(addToCartButton);

        List<WebElement> items = driver.findElements(productsListClass);

        if (items.isEmpty()) {
            throw new RuntimeException("No products found on the page");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(items.size());
        WebElement chosenItem = items.get(randomIndex);
        String productName = chosenItem.findElement(itemName).getText();
        chosenItem.findElement(addToCartButton).click();

        return productName;
    }

}
