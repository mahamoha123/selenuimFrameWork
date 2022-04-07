package Tests;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTestWithDDT extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @DataProvider(name = "testData")
    public static Object[][] userData(){
        return new Object [][] {
                {"Maha" , "waffle", "maha@1567.com" , "12345678"}
                ,{"saad", "tooz", "saad@toozz.com", "1234567"}
        };
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
    public void UserRegisterSuccessfully(String fname, String lname, String email, String password){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(fname, lname, email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        homeObject.userLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogIn(email, password);
        homeObject.userLogout();
    }
}

