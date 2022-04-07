package Tests;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("maha","waffle","maha@15.com","12345678");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test (dependsOnMethods = {"UserRegisterSuccessfully"})
    public void RegisterdUserCanLogout(){
        homeObject.userLogout();
    }
    @Test(dependsOnMethods = {"RegisterdUserCanLogout"})
    public void RegisterdUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogIn("maha@15.com", "12345678");


    }

}
