package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    EmailPage emailObject;
//register
    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("maha","waffle","maha@12.com","12345678");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
 //search
 @Test(priority = 2)
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
 //sendEmail
    @Test(priority = 3)
 public void UserCanSendEmailToFriend(){
        detailsObject.openSendEmail();
         emailObject = new EmailPage(driver);
         emailObject.SendEmailToFriend("saad@tooz.com", "Toooz");
         Assert.assertTrue(emailObject.resultMsg.getText().contains("Your message has been sent."));


 }


//logout
    @Test (priority = 4)
    public void RegisterdUserCanLogout(){
        homeObject.userLogout();
    }

}
