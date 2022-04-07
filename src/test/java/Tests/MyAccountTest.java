package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;

    String oldPassword = "1234567";
    String newPassword = "12345678";
    String firstName = "maha";
    String lastName = "waffle";
    String email = "maha@saaadtooz.com";



    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName ,lastName,email,oldPassword);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods = {"UserRegisterSuccessfully"})
    public void RegistredUserCanChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.ChangePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.resltBar.getText().contains("Password was changed"));
        myAccountObject.clickbutton(myAccountObject.closeBar);
    }

    @Test (dependsOnMethods = {"RegistredUserCanChangePassword"})
    public void RegisterdUserCanLogout(){

        homeObject.userLogout();
    }
    @Test(dependsOnMethods = {"RegisterdUserCanLogout"})
    public void RegisterdUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogIn(email, newPassword);


    }

}
