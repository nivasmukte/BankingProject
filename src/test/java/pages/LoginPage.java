package pages;

import gherkin.lexer.Ja;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(name="uid")
    private WebElement username;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name="btnLogin")
    private WebElement loginButton;
    @FindBy(xpath = "/html/body/div[3]/div/ul/li[10]/a")
    WebElement logoutBtn;

    public void enterCredentials(String userName,String Password){
        username.clear();
        username.sendKeys(userName);
        password.clear();
        password.sendKeys(Password);
    }
    public void clickLoginBtn(){
        loginButton.click();
    }
    public void clickLogoutBtn() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",logoutBtn);
        logoutBtn.click();
    }


}
