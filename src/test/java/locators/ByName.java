package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByName {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("demonstrating that we actually found the search box" + Keys.ENTER);
		
//		driver.findElement(By.name("btnK")).click();
		
	}

}
