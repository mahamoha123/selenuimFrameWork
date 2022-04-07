package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTextBox;

    @FindBy(css ="button.button-1.search-box-button" )
    WebElement searchBtn;

    @FindBy(id = "ui-id-1")
    List<WebElement> productList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void ProductSearch(String productName){
        setText(searchTextBox, productName);
        clickbutton(searchBtn);
    }
    public void openProductDetailsPage(){
        clickbutton(productTitle);
    }
    public void ProductSearchUsingAutoSuggest(String searchTxt){
        setText(searchTextBox, searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productList.get(0).click();
    }
}
