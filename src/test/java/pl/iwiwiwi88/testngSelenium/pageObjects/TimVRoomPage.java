package pl.iwiwiwi88.testngSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class TimVRoomPage extends BasePage {

    private final String pageURL = "http://timvroom.com/selenium/playground/";

    By topHeading = By.id("tophead");
    By occupation = By.id("occupation");
    By blueBox = By.cssSelector(".bluebox");
    By redBox = By.id("redbox");
    By writtenBook = By.xpath("//input[@value='wrotebook']");
    By noWrittenBook = By.xpath("//input[@value='didntwritebook']");
    By greenBox = By.id("greenbox");
    By orangeBox = By.id("orangebox");
    By checkResults = By.id("checkresults");
    By pass = By.cssSelector(".pass");
    By fail = By.cssSelector(".fail");

    public TimVRoomPage(WebDriver driver) {
        super(driver);
        visit(pageURL);
        assertTrue(isDisplayed(topHeading), "Page isn't displayed");
    }

    public void inputTextIntoId(String text, String id) {
        type(text, By.id(id));
    }

    public void chooseOccupation(String occupationOption) {
        selectOptionFromNonMultiselect(occupationOption, occupation);
    }

    public String getChosenOccupation() {
        List<WebElement> selectedOptions = getSelectedOptions(occupation);
        if (selectedOptions.size() == 1) {
            return selectedOptions.get(0).getText();

        } else {
            //TODO find a better way
            return "";
        }
    }

    public int countBlueBoxes() {
        return findList(blueBox).size();
    }

    public String getClassOfRedBox() {
        return find(redBox).getAttribute("class");
    }


    public void writtenBook(boolean wasBookWritten) {
        if (wasBookWritten) {
            click(writtenBook);
        } else {
            click(noWrittenBook);
        }
    }

    public String getTextFromRedBox() {
        return getText(redBox);
    }

    public String getColorOfHigherBox() {
        WebElement greenB = find(greenBox);
        WebElement oragngeB = find(orangeBox);
        if (greenB.getLocation().getY()>oragngeB.getLocation().getY()) {
            return "orange";
        } else {
            return "green";
        }
    }

    public void checkResults() {
        click(checkResults);
    }

    public boolean resultsOK() {
        int passCount = findList(pass).size();
        int failCount = findList(fail).size();
        System.out.println("Passed: "+passCount+" Failed: "+failCount);
        return failCount == 0;
    }
}
