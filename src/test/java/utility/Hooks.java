package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    configReader cd= new configReader();
    //public static WebDriver driver;


    public void screenShot(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
        File src =ts.getScreenshotAs(OutputType.FILE);
        File desc= new File(System.getProperty("user.dir")+"/screenshot/"+fileName+".png");
        FileUtils.copyFile(src,desc);
        System.out.println("ScreenShot Taken");
    }

}
