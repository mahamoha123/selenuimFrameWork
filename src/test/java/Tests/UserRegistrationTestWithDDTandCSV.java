package Tests;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDDTandCSV extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    CSVReader reader ;


    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully() throws IOException, CsvValidationException {
        String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\userDataCSV.csv";
        reader = new CSVReader(new FileReader(CSV_file));
        String[] csvCell;

        while((csvCell = reader.readNext()) != null){

                String firstname = csvCell[0];
                String lastname = csvCell[1];
                String email = csvCell[2];
                String password = csvCell[3];
            homeObject = new HomePage(driver);
            homeObject.openRegisterPage();
            registerObject = new UserRegistrationPage(driver);
            registerObject.userRegistration(firstname,lastname,email,password);
            Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
            homeObject.userLogout();
            homeObject.openLoginPage();
            loginObject = new LoginPage(driver);
            loginObject.UserLogIn(email, password);
            homeObject.userLogout();
        }
    }
}
