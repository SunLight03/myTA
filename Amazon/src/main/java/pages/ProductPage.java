package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='nav-flyout-ewc']")
    WebElement listOfProductsInTheCart;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    WebElement countOfProductsInTheCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        waitVisibilityOfElement(3000, addToCartButton);
        addToCartButton.click();
    }

    public String countOfProductsInTheCart() {
        return countOfProductsInTheCart.getText();
    }

    public boolean listOfProductsInTheCartIsVisible() {
        return listOfProductsInTheCart.isDisplayed();
    }
}
