package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeAudioPage extends BasePage{

    @FindBy (xpath = "//li[@aria-label='Climate Pledge Friendly']//div[contains(@class,'a-checkbox')]")
    WebElement climateFriendlyCheckbox;
    @FindBy (xpath = "//li[@aria-label='Climate Pledge Friendly']//div[contains(@class,'a-checkbox')]//input")
    WebElement climateFriendlyCheckboxInput;

    public HomeAudioPage(WebDriver driver) {
        super(driver);
    }

    public void setClimateFriendlyCheckbox(){
        waitVisibilityOfElement(3000, climateFriendlyCheckbox);
        climateFriendlyCheckbox.click();
    }

    public boolean checkClimatFriendlyCheckboxLabel(){
        return climateFriendlyCheckboxInput.isSelected();
    }
}
