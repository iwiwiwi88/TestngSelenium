package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.WebDriver;

public class TimVRoomPage extends BasePage {

    public TimVRoomPage(WebDriver driver) {
        super(driver);
        driver.get("http://timvroom.com/selenium/playground/");

        //TODO add assertion
    }
}
