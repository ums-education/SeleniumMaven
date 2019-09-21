package special_operations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	/**
	 * A simple Thread.sleep wrapped around a try-catch
	 * and user input in seconds multiplied by 1000
	 * passed in as a parameter
	 * @param secs as an int which will 'sleep' the Thread
	 */
	public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
        }
    }
	
	/**
     * switches to new window by the exact title
     * returns to original window if windows with given title not found
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for ( String handle : driver.getWindowHandles() ) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    // possibility to OVERLOAD the switchToWindow above
    // int index 
    // WebDriver driver, String title, Boolean titleIsExactMatch
    
    
    public static void hover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    // double_click
    // drag_n_drop
    
    
    
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<String>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    
    public static List<String> getElementsText(WebDriver driver, By locator) {

        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<String>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    
    
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(WebDriver driver, long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception e) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

   /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    wait(1);
                } catch (WebDriverException we) {
                    y++;
                    wait(1);
                }
        }
    }
    
    
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    
    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    
    /**
     * performs a click action on a web element using JavaScript
     *
     * @param element
     */
    public static void clickUsingJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebDriver driver, WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(WebDriver driver, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);
    }
    
}
