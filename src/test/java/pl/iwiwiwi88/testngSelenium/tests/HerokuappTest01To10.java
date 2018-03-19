package pl.iwiwiwi88.testngSelenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.iwiwiwi88.testngSelenium.pageObjects.HerokuappPage;

public class HerokuappTest01To10 extends BaseTest {

    HerokuappPage herokuPage;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) {
        super.setup(browser);
        herokuPage = new HerokuappPage(driver);
    }

    @Test
    public void abTest() {
        herokuPage.visitBasePlus("abtest");
        herokuPage.click("Elemental Selenium");
        herokuPage.assertNewTabOpenedWithURL("http://elementalselenium.com/", 2);
    }

    @Test
    public void newTest() {
        System.out.println(herokuPage.getTitle());
    }

    @AfterMethod
    public void cleanAfterAnyTest() {
        herokuPage.closeTabsAndOpenOriginalHandle();
    }
}
