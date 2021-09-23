package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccounPage extends BasePage {
    @FindBy(xpath = "//input[@name='customerName']")
    WebElement nameField;

    @FindBy(xpath = "//input[@type='email']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    WebElement reEnterPasswordField;

    @FindBy(xpath = "//div[@id='auth-password-invalid-password-alert']")
    WebElement invalidPasswordMassage;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement verifyButton;

    @FindBy(xpath = "//h4[text()='Email address already in use']")
    WebElement emailInUseAlert;

    public CreateNewAccounPage(WebDriver driver) {
        super(driver);
    }

    public void enterNameInNameField(String name) {
        nameField.sendKeys(name);
    }

    public void enterPhoneInPhoneField(String phone) {
        phoneField.sendKeys(phone);
    }

    public void enterPasswordInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPassworInReEnterPasswordField(String password) {
        reEnterPasswordField.sendKeys(password);
    }

    public void pressVerifyButton() {
        verifyButton.click();
    }

    public boolean checkInvalidPasswordMassege() {
        return invalidPasswordMassage.isDisplayed();
    }

    public boolean checkEmailInUseAlert() {
        return emailInUseAlert.isDisplayed();
    }

}

