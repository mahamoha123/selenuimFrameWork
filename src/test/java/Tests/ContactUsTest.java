package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contactUspage;
    String fullName = "waffle";
    String email = "maha@waffle.com";
    String enquiry = "wowowowowoww";

    @Test
    public void UserCanContactUs(){
        home = new HomePage(driver);
        home.openContactUsPage();
        contactUspage = new ContactUsPage(driver);
        contactUspage.ContactUs(fullName, email, enquiry);
        Assert.assertTrue(contactUspage.result.getText()
                .contains("Your enquiry has been successfully sent to the store owner."));
    }

}
