package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    SignInPage signInPage;
    CreateNewAccounPage createNewAccounPage;
    HomeAudioPage homeAudioPage;
    SellPage sellPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @And("User opens {string} page")
        public void openPage(final String url) {
            homePage = pageFactoryManager.getHomePage();
            homePage.openHomePage(url);
        }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
        homePage.clickSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User opens first product page")
    public void userOpensFirstProductPage() {
        searchResultPage = pageFactoryManager.getSearchResultsPage();
        searchResultPage.openFirstProductPage();
    }

    @And("User click add to cart")
    public void userClickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.addProductToCart();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that amount of products in cart icon {string} and list of products is visible")
    public void userChecksThatAmountOfProductsInCartIconAmountOfProducts(final String number) {
        assertTrue(productPage.listOfProductsInTheCartIsVisible());
        assertEquals(productPage.countOfProductsInTheCart(), number);
    }


    @Then("User checks that first search results {string}")
    public void userChecksThatSearchResultsKeyword(final String keyword) {
        searchResultPage = pageFactoryManager.getSearchResultsPage();
         assertTrue(searchResultPage.searchResultNamesOfProducts(keyword));
    }

    @And("User opens Sell page")
    public void userOpensSellPage() {
        homePage.clickSellButton();
    }


    @And("User opens Sign In page")
    public void userOpensSignInPage() {
        homePage.clickSignInButton();
    }

    @And("User choose to create new Amazon account")
    public void userChooseToCreateNewAmazonAccount() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.createNewAccount();
    }


    @And("User enter {string} in name field")
    public void userEnterNameInNameField(final String name) {
        createNewAccounPage = pageFactoryManager.getCreateNewAccountPage();
        createNewAccounPage.enterNameInNameField(name);
    }

    @And("User enter {string} in phone field")
    public void userEnterPhoneInPhoneField(final String phone) {
        createNewAccounPage.enterPhoneInPhoneField(phone);
    }

    @And("User enter {string} in password and re-enter password field")
    public void userEnterPasswordInPasswordAndReEnterPasswordField(final String password) {
        createNewAccounPage.enterPasswordInPasswordField(password);
        createNewAccounPage.enterPassworInReEnterPasswordField(password);
    }

    @When("User click on verify button")
    public void userClickOnVerifyButton() {
    createNewAccounPage.pressVerifyButton();
    }


    @Then("User see massage, that password invalid")
    public void userSeeMassageThatPasswordInvalid() {
        assertTrue(createNewAccounPage.checkInvalidPasswordMassege());
    }
    @And("User opens main menu")
    public void userOpensMainMenu() {
        homePage.openMainMenu();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @And("User opens menu item Electronic")
    public void userOpensMenuItemElectronic() {
        homePage.openElectronicsMenuIten();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @And("User opens menu item Home audio")
    public void userOpensMenuItemHomeAudio() {
        homePage.openHomeAudioMenuItem();

    }

    @When("User check in check box Climat Friendly")
    public void userCheckInCheckBoxClimatFriendly() {
        homeAudioPage = pageFactoryManager.getHomeAudioPage();
        homeAudioPage.setClimateFriendlyCheckbox();
    }

    @Then("label of check box is changed")
    public void labelOfCheckBoxIsChanged() {
        assertTrue(homeAudioPage.checkClimatFriendlyCheckboxLabel());
    }


}
