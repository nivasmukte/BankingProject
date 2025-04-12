package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void enterCredentials(String userName,String Password){
        username.clear();
        username.sendKeys(userName);
        password.clear();
        password.sendKeys(Password);
    }
    public void clickLoginBtn(){
        loginButton.click();
    }


}
