package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @FindBy(linkText = "Log out")
    public WebElement logoutLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id = "customerCurrency")
    WebElement currencyList;
    @FindBy(linkText = "Computers")
    WebElement computermenu;
    @FindBy(linkText = "Notebooks")
    WebElement notebookmenu;


    public void openRegisterPage(){
        clickbutton(registerLink);
    }
    public void userLogout(){
        clickbutton(logoutLink);
    }
    public void openLoginPage(){
        clickbutton(loginLink);
    }
    public void openContactUsPage(){
        clickbutton(contactUsLink);
    }
    public void changeCurrency(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }
    public void SelectNotebookMenu(){
        action.moveToElement(computermenu)
                .build()
                .perform();
        action.moveToElement(notebookmenu)
                .click().build().perform();
    }
}
