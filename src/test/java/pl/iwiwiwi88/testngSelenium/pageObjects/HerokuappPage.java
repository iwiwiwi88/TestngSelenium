package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class HerokuappPage extends BasePage {

    private String baseURL = "http://the-internet.herokuapp.com/";
    private String originalHandle;

    By topHeading = By.cssSelector(".heading");

    public HerokuappPage(WebDriver driver) {
        super(driver);
        visit(baseURL);
        assertTrue(isDisplayed(topHeading), "Page isn't displayed");
        originalHandle = driver.getWindowHandle();
    }

    public void visitBasePlus(String endingURL) {
        visit(baseURL+endingURL);
    }

    public void closeTabsAndOpenOriginalHandle() {
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(originalHandle);
    }
}
