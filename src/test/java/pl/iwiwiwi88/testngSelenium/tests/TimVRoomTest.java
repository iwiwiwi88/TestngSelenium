package pl.iwiwiwi88.testngSelenium.tests;

import org.testng.annotations.Test;
import pl.iwiwiwi88.testngSelenium.pageObjects.TimVRoomPage;


import static org.testng.Assert.*;

public class TimVRoomTest extends BaseTest {

    private TimVRoomPage timPage;
    private String pageTitle = "Selenium Playground";
    private String kilgore = "Kilgore Trout";
    private String occupationOption = "Science Fiction Author";

    @Test
    public void step01() {
        timPage = new TimVRoomPage(driver);
        // 1. Grab page title and place title text in answer slot #1
        String title = timPage.getTitle();
        assertEquals(pageTitle, title, "Title is incorrect");
        timPage.inputTextIntoId(title, "answer1");
    }

    @Test(dependsOnMethods = "step01")
    public void step02() {
        // 2. Fill out name section of form to be Kilgore Trout
        timPage.inputTextIntoId(kilgore, "name");
    }

    @Test(dependsOnMethods = "step02")
    public void step03() {
        // 3. Set occupation on form to Sci-Fi Author
        timPage.chooseOccupation(occupationOption);
        assertEquals(occupationOption, timPage.getChosenOccupation(), "Occupation wasn't set correctly");
    }

    @Test(dependsOnMethods = "step03")
    public void step04() {
        // 4. Count number of blue_boxes on page after form and enter into answer box #4
        int blueBoxesCount = timPage.countBlueBoxes();
        timPage.inputTextIntoId(blueBoxesCount + "", "answer4");
    }

    @Test(dependsOnMethods = "step04")
    public void step05() {
        // 5. Click link that says 'click me'
        timPage.click("click me");
    }

    @Test(dependsOnMethods = "step05")
    public void step06() {
        // 6. Find red box on its page find class applied to it, and enter into answer box #6
        String redBoxClass = timPage.getClassOfRedBox();
        assertEquals("red", redBoxClass, "Class isn't correct");
        timPage.inputTextIntoId(redBoxClass, "answer6");
    }

    @Test(dependsOnMethods = "step06")
    public void step07() {
        fail();
        // 7. Run JavaScript function as: ran_this_js_function() from your Selenium script
    }

    @Test(dependsOnMethods = "step07")
    public void step08() {
        // 8. Run JavaScript function as: got_return_from_js_function() from your Selenium script,
        // take returned value and place it in answer slot #8
    }

    @Test(dependsOnMethods = "step08")
    public void step09() {
        // 9. Mark radio button on form for written book? to Yes
    }

    @Test(dependsOnMethods = "step09")
    public void step10() {
        // 10. Get the text from the Red Box and place it in answer slot #10
    }

    @Test(dependsOnMethods = "step10")
    public void step11() {
        // 11. Which box is on top? orange or green -- place correct color in answer slot #11
    }

    @Test(dependsOnMethods = "step11")
    public void step12() {
        // 12. Set browser width to 850 and height to 650
    }

    @Test(dependsOnMethods = "step12")
    public void step13() {
        // 13. Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page
    }

    @Test(dependsOnMethods = "step13")
    public void step14() {
        // 14. Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible
    }

    @Test(dependsOnMethods = "step14")
    public void step15() {
        // 15. Waiting game: click the link with link text of 'click then wait' a random wait will occur
        // (up to 10 seconds) and then a new link will get added with link text of 'click after wait' -
        // click this new link within 500 ms of it appearing to pass this test
    }

    @Test(dependsOnMethods = "step15")
    public void step16() {
        // 16. Click OK on the confirm after completing task 15
    }

    @Test(dependsOnMethods = "step16")
    public void step17() {
        // 17. Click the submit button on the form
    }

}
