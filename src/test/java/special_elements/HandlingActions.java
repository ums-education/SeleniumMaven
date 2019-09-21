package special_elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingActions {
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// get the page
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		// define your from and to WebElements
		WebElement dragFrom = 
				driver
				.findElement(By.cssSelector("#todrag span:nth-of-type(1)"));
		WebElement dropTo =
				driver
				.findElement(By.id("mydropzone"));
		
		// initialize the Actions class object
		Actions actions = new Actions(driver);
		
		// using Actions object, drag-and-drop
//		actions.dragAndDrop(dragFrom, dropTo)
//			.build()
//			.perform();
		
		
		actions.dragAndDropBy(dragFrom, 750, -20)
			.build()
			.perform();
		
		// adding wait to see where my driver is
		Thread.sleep(3000);
		// destroy driver instance
		driver.quit();
	}
}
