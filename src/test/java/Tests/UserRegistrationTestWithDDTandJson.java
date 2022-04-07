package Tests;
import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTestWithDDTandJson extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully() throws IOException, ParseException {

        JsonDataReader JsonReader = new JsonDataReader();
        JsonReader.jsonReader();
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);


        registerObject.userRegistration(JsonReader.firstname, JsonReader.lastname, JsonReader.email, JsonReader.password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        homeObject.userLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogIn(JsonReader.email, JsonReader.password);
        homeObject.userLogout();
    }



}
