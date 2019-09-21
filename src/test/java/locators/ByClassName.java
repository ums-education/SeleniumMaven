package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ByClassName {
	
	public static void main(String[] args) throws Exception{

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		WebElement searchBox = driver.findElement(By.className("gLFyf"));
		searchBox.sendKeys("demonstrating that we actually found the search box" + Keys.ENTER);

		Thread.sleep(5000);
		
		driver.findElement(By.className("ellip")).click();
	}
}
