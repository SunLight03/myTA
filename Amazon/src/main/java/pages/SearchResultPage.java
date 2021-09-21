package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//img[@class='s-image']")
    private List<WebElement> searchResult;

    @FindBy(xpath = "//div[contains(@data-component-type,'s-search')]//span[contains(@class,'a-text-normal')]")
    private List<WebElement> searchResultNames;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public void openFirstProductPage(){
        searchResult.get(0).click();
    }

    public boolean searchResultNamesOfProducts(String keyword){
         return searchResultNames.get(0).getText().contains(keyword);
    }



}
