package pl.iwiwiwi88.testngSelenium.tests;

import org.testng.annotations.Test;
import pl.iwiwiwi88.testngSelenium.pageObjects.TimVRoomPage;


import static org.testng.Assert.*;

public class TimVRoomTest extends BaseTest {

    TimVRoomPage timPage;
    private String pageTitle = "Selenium Playground";
    private int i = 1;

    @Test
    public void step01() {
        timPage = new TimVRoomPage(driver);
        // 1. Grab page title and place title text in answer slot #1
        String title = timPage.getTitle();
        assertEquals(pageTitle, title, "Title is incorrect");
        timPage.inputTextIntoId(title, "answer1");
    }

    @Test (dependsOnMethods = "step01")
    public void step02() {
        System.out.printf("Inside step02 "+ (++i));
        // 2. Fill out name section of form to be Kilgore Trout
    }

    @Test (dependsOnMethods = "step02")
    public void step03() {
        System.out.printf("Inside step03 "+ (++i));
        // 3. Set occupation on form to Sci-Fi Author
    }

    @Test (dependsOnMethods = "step03")
    public void step04() {
        System.out.printf("Inside step04 "+ (++i));
        // 4. Count number of blue_boxes on page after form and enter into answer box #4
    }

    @Test (dependsOnMethods = "step04")
    public void step05() {
        System.out.printf("Inside step05 "+ (++i));
        // 5. Click link that says 'click me'
    }

    @Test (dependsOnMethods = "step05")
    public void step06() {
        System.out.printf("Inside step06 "+ (++i));
        // 6. Find red box on its page find class applied to it, and enter into answer box #6
    }

    @Test (dependsOnMethods = "step06")
    public void step07() {
        System.out.printf("Inside step07 "+ (++i));
        // 7. Run JavaScript function as: ran_this_js_function() from your Selenium script
    }

    @Test (dependsOnMethods = "step07")
    public void step08() {
        System.out.printf("Inside step08 "+ (++i));
        // 8. Run JavaScript function as: got_return_from_js_function() from your Selenium script,
        // take returned value and place it in answer slot #8
    }

    @Test (dependsOnMethods = "step08")
    public void step09() {
        System.out.printf("Inside step09 "+ (++i));
        // 9. Mark radio button on form for written book? to Yes
    }

    @Test (dependsOnMethods = "step09")
    public void step10() {
        System.out.printf("Inside step10 "+ (++i));
        // 10. Get the text from the Red Box and place it in answer slot #10
    }

    @Test (dependsOnMethods = "step10")
    public void step11() {
        System.out.printf("Inside step11 "+ (++i));
        // 11. Which box is on top? orange or green -- place correct color in answer slot #11
    }

    @Test (dependsOnMethods = "step11")
    public void step12() {
        System.out.printf("Inside step12 "+ (++i));
        // 12. Set browser width to 850 and height to 650
    }

    @Test (dependsOnMethods = "step12")
    public void step13() {
        System.out.printf("Inside step13 "+ (++i));
        // 13. Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page
    }

    @Test (dependsOnMethods = "step13")
    public void step14() {
        System.out.printf("Inside step14 "+ (++i));
        // 14. Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible
    }

    @Test (dependsOnMethods = "step14")
    public void step15() {
        System.out.printf("Inside step15 "+ (++i));
        // 15. Waiting game: click the link with link text of 'click then wait' a random wait will occur
        // (up to 10 seconds) and then a new link will get added with link text of 'click after wait' -
        // click this new link within 500 ms of it appearing to pass this test
    }

    @Test (dependsOnMethods = "step15")
    public void step16() {
        // 16. Click OK on the confirm after completing task 15
        System.out.printf("Inside step16 "+ (++i));
    }

    @Test (dependsOnMethods = "step16")
    public void step17() {
        // 17. Click the submit button on the form
        System.out.printf("Inside step17 "+ (++i));
    }

}
