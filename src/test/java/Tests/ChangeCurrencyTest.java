package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{

    HomePage homeObject;
    ProductDetailsPage detailsObject;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;


    @Test(priority = 1)
    public void UserCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();

    }
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest(){
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("MacB");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
            Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
        }catch (Exception e){
            System.out.println("Error occured"+ e.getMessage());
        }
    }
}
