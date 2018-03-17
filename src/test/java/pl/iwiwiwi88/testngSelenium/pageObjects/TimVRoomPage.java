package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class TimVRoomPage extends BasePage {

    private final String pageURL = "http://timvroom.com/selenium/playground/";

    By topHeading = By.id("tophead");

    public TimVRoomPage(WebDriver driver) {
        super(driver);
        visit(pageURL);
        assertTrue(isDisplayed(topHeading),"Page isn't displayed");
    }

    public void inputTextIntoId(String text, String id) {
        type(text, By.id(id));
    }
}
