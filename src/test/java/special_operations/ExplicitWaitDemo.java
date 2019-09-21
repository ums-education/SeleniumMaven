package special_operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDemo {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		
		
		// get the page
		driver.get("https://www.amazon.com/");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

		WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
		actions.moveToElement(signIn).build().perform();
				
		
		WebElement yourAccount = explicitWait.until(ExpectedConditions.visibilityOf( 
				driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span"))
				));
		
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
