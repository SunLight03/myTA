package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    private WebElement mainMenuButton;

    @FindBy(xpath = "//ul/li/a/div[text() = 'Electronics']")
    private WebElement electronicsMenuItem;

    @FindBy(xpath = "//ul/li/a[text() = 'Home Audio']")
    private WebElement homeAudioMenuItem;

    @FindBy(xpath = "//a[text()='Sell']")
    private WebElement sellButton;

    public HomePage (WebDriver driver){
        super(driver);
    }
    public void openHomePage(String url) {
        driver.get(url);
    }
    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }
    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }
    public void clickSearchButton() {
        searchButton.click();
    }
    public void clickSellButton() {sellButton.click();}
    public void openMainMenu(){mainMenuButton.click();}
    public void openElectronicsMenuIten(){electronicsMenuItem.click(); }
    public void openHomeAudioMenuItem(){homeAudioMenuItem.click();}


}
