package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed");
            System.out.println("Taking Screenshot...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
