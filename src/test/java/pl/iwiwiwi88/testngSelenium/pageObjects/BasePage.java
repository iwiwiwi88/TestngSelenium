package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
