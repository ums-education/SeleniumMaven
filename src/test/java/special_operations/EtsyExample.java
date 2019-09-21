package special_operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EtsyExample {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		
		// get the page
		driver.get("https://www.etsy.com/");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

		WebElement jewelry = driver.findElement(By.id("catnav-primary-link-10855"));
		actions.moveToElement(jewelry).build().perform();
		
		WebElement beanies = driver.findElement(By.id("catnav-l4-11098"));
		beanies.click();
		
		
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
