package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import utils.DriverManager;
import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By error = By.cssSelector("[data-test='error']");

    /**
     * sends valid username / password from config file
     */
    public void login(String user, String pass) {
        wait.waitForElementToBeVisible(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    /**
     * check the user is logged out of the application
     */
    public void assertErrorMessage() {
        String errText = wait.waitForElementToBeVisible(error).getText();
        Assert.assertTrue(errText.contains("this user has been locked out."));
    }
}
