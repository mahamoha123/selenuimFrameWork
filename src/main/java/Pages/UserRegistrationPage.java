package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender-female")
    WebElement genderRdoBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox;

    @FindBy(id = "LastName")
    WebElement lastNameTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    public void userRegistration(String firstName, String lastName, String email, String password ){
        clickbutton(genderRdoBtn);
        setText(firstNameTxtBox,firstName);
        setText(lastNameTxtBox,lastName);
        setText(emailTxtBox,email);
        setText(passwordTxtBox,password);
        setText(confirmPassword,password);
        clickbutton(registerBtn);
    }
    public void openMyAccountPage(){
        clickbutton(myAccountLink);
    }

}
