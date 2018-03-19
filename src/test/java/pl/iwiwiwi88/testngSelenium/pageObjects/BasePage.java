package pl.iwiwiwi88.testngSelenium.pageObjects;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
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

    public List<WebElement> findList(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void click(String linkText) {
        click(By.xpath("//a[text()='" + linkText + "']"));
    }

    public void submit() {
        driver.findElement(By.name("submit")).click();
    }


    public void selectOptionFromNonMultiselect(String option, By locator) {
        (new Select(find(locator))).selectByVisibleText(option);
    }

    public List<WebElement> getSelectedOptions(By locator) {
        return (new Select(find(locator))).getAllSelectedOptions();
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public String getStyleElementOf(WebElement element, String property) {
        return element.getCssValue(property);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public Boolean isDisplayedById(String id) {
        return isDisplayed(By.id(id));
    }

    public Boolean isEnabled(By locator) {
        try {
            return find(locator).isEnabled();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public Boolean isEnabledById(String id) {
        return isEnabled(By.id(id));
    }

    public void runJS(String functionName) {
        ((JavascriptExecutor) driver).executeScript(functionName + "();");
    }

    public String runJSReturn(String functionName) {
        String result = ((JavascriptExecutor) driver).executeScript("return " + functionName + "();").toString();
        System.out.println(result);
        return result;
    }

    public void setBrowserSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public String getBrowsersInfo(String info) {
        if (info.equals("width")) {
            return driver.manage().window().getSize().getWidth() + "";
        } else if (info.equals("height")) {
            return driver.manage().window().getSize().getHeight() + "";
        } else {
            return "";
        }
    }

    public void waitUntilLinkTextWillAppear(String linkTextToAppear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkTextToAppear)));
    }

    public void waitUntilPageIsLoaded() {
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
        System.out.println(driver.getCurrentUrl());
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void assertNewTabOpenedWithURL(String newTabURL, int expectedTabCount) {
        if (driver instanceof FirefoxDriver) {
            waitForDebug(5);
        }
        Set<String> tabs = driver.getWindowHandles();
        assertEquals(tabs.size(), expectedTabCount, "No two tabs opened");
        assertTrue(checkIfUrlIsLoaded(newTabURL, tabs), "Tab with url: " + newTabURL + " isn't opened.");
    }

    private boolean checkIfUrlIsLoaded(String newTabURL, Set<String> tabs) {
        boolean isUrlPresent = false;
        for (String handle : tabs) {
            if (driver.switchTo().window(handle).getCurrentUrl().equals(newTabURL)) {
                isUrlPresent = true;
                break;
            }
        }
        return isUrlPresent;
    }

    private void waitForDebug(int seconds) {
        System.out.println("Waiting for " + seconds + " seconds...");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
