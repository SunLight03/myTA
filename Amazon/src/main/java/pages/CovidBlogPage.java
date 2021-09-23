package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CovidBlogPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement covidBlogTitle;
    @FindBy(xpath = "//a[@class='Link signupLink']")
    WebElement sigUpButton;

    @FindBy(xpath = "//div[@class='main-form']")
    WebElement emailInputField;

    public CovidBlogPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCovidBlogTitle() {
        waitVisibilityOfElement(300, covidBlogTitle);
        return covidBlogTitle.isDisplayed();
    }

    public void signUpButton() {
        sigUpButton.click();
    }

    public boolean emailInputFieldIsDispleyed() {
        return emailInputField.isDisplayed();
    }
}
