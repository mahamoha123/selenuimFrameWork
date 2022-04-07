package Tests;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTestWithDDTandJavaFaker extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstname, lastname, email, password);
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
