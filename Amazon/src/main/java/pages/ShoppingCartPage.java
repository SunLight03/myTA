package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-fixed-left-grid']//input[@value='Delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    WebElement countOfProductsInTheCart;

    @FindBy(xpath = "//div[@id='sc-active-cart']//h1")
    WebElement shoppinCartText;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteItemFromShoppingCart() {
        waitVisibilityOfElement(3000, deleteButton);
        deleteButton.click();
    }

    public boolean shoppingCartStatusMessage() {
//        waitVisibilityOfElement(9000, shoppinCartText);
        return shoppinCartText.getText().contains("Cart is empty");
    }
}
