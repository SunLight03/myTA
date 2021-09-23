package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//img[@class='s-image']")
    private List<WebElement> searchResult;

    @FindBy(xpath = "//div[contains(@data-component-type,'s-search')]//span[contains(@class,'a-text-normal')]")
    private List<WebElement> searchResultNames;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> searchResultPrice;

    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement maxPriceField;

    @FindBy(id = "a-autoid-1")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='nav-subnav']//span[text()]")
    private List<WebElement> categories;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void openFirstProductPage() {
        searchResult.get(0).click();
    }

    public boolean searchResultNamesOfProducts(String keyword) {
        return searchResultNames.get(2).getText().contains(keyword);
    }

    public void setMaxPrice(String maxprice) {
        maxPriceField.sendKeys(maxprice);
    }

    public boolean checkSearchResultPrice(int number) {
        int i = Integer.parseInt(searchResultPrice.get(0).getText());
        return i <= number;
    }

    public void clickGoButton() {
        goButton.click();
    }

    public boolean checkFirstCategoryContainsCategoryName() {
        return categories.get(0).getText().contains("Books");
    }

}