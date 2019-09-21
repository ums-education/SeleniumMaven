package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByTagName {

	public static void main(String[] args) throws Exception{

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		WebElement aboutAnchorTag = driver.findElement(By.tagName("a"));
		aboutAnchorTag.click();

		
	}
	
}
