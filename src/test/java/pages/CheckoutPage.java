package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import utils.DriverManager;
import utils.WaitUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class CheckoutPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By pCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By confirmMsg = By.className("complete-header");
    private By backToHomeBtn = By.id("back-to-products");
    public String thankYouConfirmation = "Thank you";
    Properties props = new Properties();

    /**
     * Fills customer details taken from the config file
     *
     * @param fName
     * @param lName
     * @param postCode
     */
    public void fillDetails(String fName, String lName, String postCode) {
        wait.waitForElementToBeVisible(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(pCode).sendKeys(postCode);
    }

    /**
     * selects Continue button on the checkout journey
     */
    public void continueCheckout() {
        wait.waitForElementToBeClickable(continueBtn).click();

    }

    /**
     * Clicks Finish button on the checkout journey
     */
    public void finishCheckout() {
        wait.waitForElementToBeClickable(finishBtn).click();
    }

    /**
     * Confirms the validation message of successful order
     */
    public void verifyConfirmation() {
        String msg = wait.waitForElementToBeVisible(confirmMsg).getText();
        Assert.assertTrue(msg.contains(thankYouConfirmation));
    }

    /**
     * Checks the validation to enter Last Name in checkout is required
     */
    public void assertCheckOutErrorMessage() {
        String errText = wait.waitForElementToBeVisible(errorMessage).getText();
        Assert.assertTrue(errText.contains("Last Name is required"));
    }

    public void selectBackToHomeBtn() {
        wait.waitForElementToBeVisible(backToHomeBtn);
        wait.waitForElementToBeClickable(backToHomeBtn).click();
    }
}
