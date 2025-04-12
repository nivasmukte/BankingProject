package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utility.configReader;
import utility.Hooks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class loginStepDefinitaion {

    WebDriver driver;
    LoginPage loginPage;
    Hooks hooks;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get(configReader.getProperty("baseURL"));
    }
    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(configReader.getProperty("userName"),configReader.getProperty("password"));
        loginPage.clickLoginBtn();
    }
    @Then("User logged in successfully")
    public void user_logged_in_successfully() throws IOException {
        hooks = new Hooks();
        hooks.screenShot(driver,"loginScreenShot");
    }

}
