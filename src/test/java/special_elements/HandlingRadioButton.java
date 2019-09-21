package special_elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingRadioButton {
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// get the page
		driver.get("https://demoqa.com");
		// define implicit wait
		driver.manage()
			  .timeouts()
			  .implicitlyWait(6, TimeUnit.SECONDS);
		
		// on the Home page, find the menu item
		// and click
		WebElement goToCheckBoxSection = 
				driver
				.findElement(By.linkText("Checkboxradio"));
		goToCheckBoxSection.click();
		
		// wait for the page to load
				Thread.sleep(3000);
				
				
		// find and store all radio button WebElements
		WebElement newYorkRadioButton = 
				driver
				.findElement(By.cssSelector("label[for='radio-1']"));
		WebElement parisRadioButton =
				driver
				.findElement(By.cssSelector("label[for='radio-2']"));
		WebElement londonRadioButton =
				driver
				.findElement(By.cssSelector("label[for='radio-3']"));
		
		// click on Paris
		parisRadioButton.click();
		
		// make sure Paris is selected
		System.out.println("Paris is selected " +
				parisRadioButton.isSelected() );
		
		// and make sure New York is NOT selected
		System.out.println("New York is selected " + 
				newYorkRadioButton.isSelected() );
		
		// and make sure London is NOT selected
		System.out.println("London is selected " + 
				londonRadioButton.isSelected() );
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
