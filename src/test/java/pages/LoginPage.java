package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import utils.DriverManager;
import utils.WaitUtils;
import org.openqa.selenium.Alert;

public class LoginPage {
    private WebDriver driver = DriverManager.getDriver();
    private WaitUtils wait = new WaitUtils(driver);

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By error = By.cssSelector("[data-test='error']");
    private By menuBtn = By.id(("react-burger-menu-btn"));
    private By menuList = By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]");
    private By menuSideBarLogout = By.id("logout_sidebar_link");
    /**
     * sends valid username / password from config file
     */
    public void login(String user, String pass) {
        wait.waitForElementToBeVisible(username).sendKeys(user);
        wait.waitForElementToBeVisible(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void multiUserlogin(String user, String pass) {
              wait.waitForElementToBeVisible(username).sendKeys(user);
        wait.waitForElementToBeVisible(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        selectAlertIfPresent();
    }

    /**
     * check the user is logged out of the application
     */
    public void assertErrorMessage() {
        String errText = wait.waitForElementToBeVisible(error).getText();
        Assert.assertTrue(errText.contains("this user has been locked out."));
    }

     public void selectMenuSideBar()
    {
        wait.waitForElementToBeVisible(menuBtn);
        wait.waitForElementToBeClickable(menuBtn).click();
    }

    public void selectLogOutFromSideBar(){
        wait.waitForElementToBeVisible(menuList);
        wait.waitForElementToBeClickable(menuSideBarLogout).click();

    }

    public void logoutFromApplication() {
        selectMenuSideBar();
        selectLogOutFromSideBar();
    }

    public void selectAlertIfPresent(){
        WaitUtils.handleAlertIfPresent(driver);
    }

}
