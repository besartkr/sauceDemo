package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverManager;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage();
    Properties props = new Properties();

    @Given("user navigates to the login page")
    public void navigateToLoginPage() throws Exception {
        props.load(new FileInputStream("src/test/resources/config.properties"));
        driver.get(props.getProperty("base.url"));
    }

    @When("user logs in with valid credentials")
    public void setValidUsernameAndPassword() throws Exception {
        props.load(new FileInputStream("src/test/resources/config.properties"));
        loginPage.login(props.getProperty("username"), props.getProperty("password"));
    }

    @When("user logs in with invalid credentials")
    public void setInvalidUsernameAndPassword() {
        loginPage.login("locked_out_user", "secret_sauce");
    }


    @Then("user should be logged in")
    public void loggedInConfirmation() {
      new ProductsPage().openCart();
    }

    @Then("user should see a error message")
    public void loginErrorMessageDisplayed() {
        loginPage.assertErrorMessage();
    }

    @And("user logs in with problem_username")
    public void userLogsInWithProblem_username() {
        loginPage.login("problem_user", "secret_sauce");
    }


    @When("user logs in with valid username \"([^\\\"]*)\" and password as \"([^\"]*)\"$")
    public void userLogsInWithValidUsernameUsernameAndPasswordPasswordCredentials(String user, String pass) {

        loginPage.multiUserlogin(user, pass);
    }

    @And("logout from the application")
    public void logoutFromTheApplication() {
        loginPage.logoutFromApplication();
    }
}
