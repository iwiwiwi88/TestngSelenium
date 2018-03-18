package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findList(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void selectOptionFromNonMultiselect(String option, By locator) {
        (new Select(find(locator))).selectByVisibleText(option);
    }

    public List<WebElement> getSelectedOptions(By locator) {
        return (new Select(find(locator))).getAllSelectedOptions();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    public void runJS(String functionName) {
        ((JavascriptExecutor) driver).executeScript(functionName+"();");
    }

    public String runJSReturn(String functionName) {
        String result = ((JavascriptExecutor) driver).executeScript("return "+functionName+"();").toString();
        System.out.println(result);
        return result;
    }
}
