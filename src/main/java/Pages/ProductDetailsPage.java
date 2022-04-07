package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement productNameBreadCrumb;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailBtn;

    @FindBy(id = "price-value-4")
    public WebElement productPriceLbl;

    public void openSendEmail(){
        clickbutton(emailBtn);
    }

}
