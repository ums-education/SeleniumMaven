package commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// loads the web page in the existing browser window
		// if no windows exist, it will create one for us
		driver.get("https://www.google.com");
		
		/*
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		*/
		driver.navigate().to("https://www.amazon.com");
		driver.get("https://www.yahoo.com");
				
		
		driver.quit();
	}

}
