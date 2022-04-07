package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
     WebElement oldPasswordtxt;

    @FindBy(id = "NewPassword")
     WebElement newPasswordtxt;

    @FindBy(id = "ConfirmNewPassword")
     WebElement confirmPasswordtxt;

    @FindBy(css = "button.button-1.change-password-button")
     WebElement changePasswordBtn;

    @FindBy(css = "div.bar-notification.success")
    public WebElement resltBar;

    @FindBy(css = "span.close")
     public WebElement closeBar;

    public void openChangePasswordPage(){

        clickbutton(changePasswordLink);
    }
    public void ChangePassword(String oldpassword, String newpassword){
        setText(oldPasswordtxt, oldpassword);
        setText(newPasswordtxt, newpassword);
        setText(confirmPasswordtxt, newpassword);
        clickbutton(changePasswordBtn);
        clickbutton(closeBar);

    }
}
