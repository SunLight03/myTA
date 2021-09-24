package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-fixed-left-grid']//input[@value='Delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    WebElement countOfProductsInTheCart;

    @FindBy(xpath = "//div[@id='sc-active-cart']//div[@data-action='delete']//span")
    WebElement shoppinCartText;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteItemFromShoppingCart() {
        waitVisibilityOfElement(3, deleteButton);
        deleteButton.click();
    }

    public boolean shoppingCartStatusMessage() {
        return shoppinCartText.getText().contains("was removed from Shopping Cart.");
    }
}
