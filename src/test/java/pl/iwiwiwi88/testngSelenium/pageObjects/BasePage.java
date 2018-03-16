package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
