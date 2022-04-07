package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserCanSearchWithAutoSuggest(){
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("MacB");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
        }catch (Exception e){
            System.out.println("Error occured"+ e.getMessage());
        }
    }

}
