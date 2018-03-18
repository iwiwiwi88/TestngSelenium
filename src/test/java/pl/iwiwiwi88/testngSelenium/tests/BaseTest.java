package pl.iwiwiwi88.testngSelenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/iwonasasak/Documents/selenium/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/iwonasasak/Documents/selenium/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    @AfterTest
    public void teardown() {
        //driver.quit();
    }
}
