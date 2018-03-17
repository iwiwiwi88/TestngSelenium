package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }

    }
}
