package special_operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);

		// get the page
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		
		WebElement alertGenerator = driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button"));
		alertGenerator.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(1000);
		WebElement positiveAlert = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
		positiveAlert.click();
		Thread.sleep(1000);
		Alert anotherOne = driver.switchTo().alert();
		anotherOne.dismiss();
		
//		alertGenerator.sendKeys(Keys.ESCAPE);
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
