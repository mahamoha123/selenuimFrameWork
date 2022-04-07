package Tests;
import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTestWithDDTandExcel extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        ExcelReader er = new ExcelReader();
            return er.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void UserRegisterSuccessfully(String firstname, String lastname, String email, String password){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstname, lastname, email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        homeObject.userLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogIn(email, password);
        homeObject.userLogout();
    }



}
