package Tests;
import Data.LoadProperities;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTestWithDDTandProperities extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    String firstname = LoadProperities.userData.getProperty("firstname");
    String lastname = LoadProperities.userData.getProperty("lastname");
    String email = LoadProperities.userData.getProperty("email");
    String password = LoadProperities.userData.getProperty("password");

    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstname,lastname,email, password);
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
        loginObject.UserLogIn(email, password);


    }

}
