package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    WebElement createNewAccountButton;

    public SignInPage (WebDriver driver){
        super(driver);
    }

    public void createNewAccount(){
        createNewAccountButton.click();
    }

    public boolean checkSignInPageIsOpened(){
        return createNewAccountButton.isDisplayed();
    }
}
