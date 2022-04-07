package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class PageBase {
    protected static WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    public  PageBase(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageBase.driver = driver;
    }

    public void clickbutton(WebElement button){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    protected static void setText(WebElement textElement, String value){
        textElement.sendKeys(value);
    }

    public void scrollToBottom(){
        jse.executeScript("scrollBy(0, 2500)");

    }
}
