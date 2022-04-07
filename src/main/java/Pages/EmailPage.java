package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxt;

    @FindBy(id = "YourEmailAddress")
    WebElement emailTxt;

    @FindBy(id = "PersonalMessage")
    WebElement messageTxt;

    @FindBy(css = "button.button-1.send-email-a-friend-button")
    WebElement sendMailBtn;

    //"Your message has been sent."
    @FindBy(css = "div.result")
   public WebElement resultMsg;

    public void SendEmailToFriend(String friendEmail, String message){
        setText(friendEmailTxt, friendEmail);
       // setText(emailTxt, MyEmail);
        setText(messageTxt, message);
        clickbutton(sendMailBtn);
    }


}
