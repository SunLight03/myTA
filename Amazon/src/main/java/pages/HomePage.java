package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-nav-role='signin']")
    private WebElement helloButton;

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement mainMenuButton;

    @FindBy(xpath = "//ul/li/a/div[text() = 'Electronics']")
    private WebElement electronicsMenuItem;

    @FindBy(xpath = "//ul/li/a/div[text() = 'Apple Music']")
    private WebElement appleMusicMenuItem;

    @FindBy(xpath = "//ul/li/a[text() = 'Home Audio']")
    private WebElement homeAudioMenuItem;

    @FindBy(id = "nav-cart")
    private WebElement shoppinCartButton;

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    private WebElement searchCategorySelector;

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']//option[text()='Books']")
    private WebElement booksCategory;

    @FindBy(xpath = "//a[@id='swm-link']")
    private WebElement covid19Info;

    @FindBy(id = "hmenu-customer-profile-link")
    private WebElement getSignInInMenuButton;

    public HomePage(WebDriver driver) {
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


    public void openMainMenu() {
        waitVisibilityOfElement(3000, mainMenuButton);
        mainMenuButton.click();
    }

    public void openElectronicsMenuIten() {
        waitVisibilityOfElement(3000, electronicsMenuItem);
        electronicsMenuItem.click();
    }

    public void openAppleMusicMenuItem() {
        appleMusicMenuItem.click();
    }

    public void openHomeAudioMenuItem() {
        homeAudioMenuItem.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void movetoHelloButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(helloButton);
        actions.perform();

    }

    public void openShoppinCart() {
        shoppinCartButton.click();
    }

    public void openSearchCategoryMenu() {
        searchCategorySelector.click();
    }

    public void chooseBooksCategory() {
        booksCategory.click();
    }

    public void openCovid19Info() {
        covid19Info.click();
    }

    public void openSignInPageFromMenu(){
        getSignInInMenuButton.click();
    }


}
