package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabSwitchPage extends BasePage {

    public TabSwitchPage(WebDriver driver) {
        super(driver);
    }

    String oldTab = driver.getWindowHandle();

    public void checkNewTabOpens()  {

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

    }
}
