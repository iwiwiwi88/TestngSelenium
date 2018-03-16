package pl.iwiwiwi88.testngSelenium.tests;

import org.testng.annotations.Test;
import pl.iwiwiwi88.testngSelenium.pageObjects.TimVRoomPage;

public class TimVRoomTest extends BaseTest {

    @Test
    public void goThroughTheSteps() {
        TimVRoomPage timPage = new TimVRoomPage(driver);
        // 1. Grab page title and place title text in answer slot #1
        // 2. Fill out name section of form to be Kilgore Trout
        // 3. Set occupation on form to Sci-Fi Author
        // 4. Count number of blue_boxes on page after form and enter into answer box #4
        // 5. Click link that says 'click me'
        // 6. Find red box on its page find class applied to it, and enter into answer box #6
        // 7. Run JavaScript function as: ran_this_js_function() from your Selenium script
        // 8. Run JavaScript function as: got_return_from_js_function() from your Selenium script, take returned value and place it in answer slot #8
        // 9. Mark radio button on form for written book? to Yes
        // 10. Get the text from the Red Box and place it in answer slot #10
        // 11. Which box is on top? orange or green -- place correct color in answer slot #11
        // 12. Set browser width to 850 and height to 650
        // 13. Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page
        // 14. Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible
        // 15. Waiting game: click the link with link text of 'click then wait' a random wait will occur (up to 10 seconds) and then a new link will get added with link text of 'click after wait' - click this new link within 500 ms of it appearing to pass this test
        // 16. Click OK on the confirm after completing task 15
        // 17. Click the submit button on the form

    }

}
