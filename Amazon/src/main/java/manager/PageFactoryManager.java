package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public SearchResultPage getSearchResultsPage() {
        return new SearchResultPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public CreateNewAccounPage getCreateNewAccountPage() {
        return new CreateNewAccounPage(driver);
    }

    public HomeAudioPage getHomeAudioPage() {
        return new HomeAudioPage(driver);
    }

    public CovidBlogPage getCovid19Page() {
        return new CovidBlogPage(driver);
    }

    public TabSwitchPage getTabSwitchPage() {
        return new TabSwitchPage(driver);
    }

}
