package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverMenuTest extends TestBase{
    HomePage homeObject;

    @Test
    public void UserCanSelectCategoryFromMenu(){
        homeObject = new HomePage(driver);
        homeObject.SelectNotebookMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }

}
