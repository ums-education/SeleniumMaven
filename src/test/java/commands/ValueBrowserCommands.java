package commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValueBrowserCommands {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		// how to get a page's title
		String pageTitle = driver.getTitle();
		
		// how to get current URL
		String pageURL = driver.getCurrentUrl();
		
		// how to get the whole source of the page
		String pageSource = driver.getPageSource();
		
		System.out.println("* PRINTING THE PAGE TITLE *");
		System.out.println(pageTitle);
		
		System.out.println("* PRINTING THE PAGE URL *");
		System.out.println(pageURL);
//		
		System.out.println("* PRINTING THE PAGE SOURCE *");
		System.out.println(pageSource);
		
		driver.quit();
	}
}
