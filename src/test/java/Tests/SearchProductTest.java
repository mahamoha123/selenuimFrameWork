package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.ProductSearch(productName);
        searchObject.openProductDetailsPage();
        Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));

    }

}
