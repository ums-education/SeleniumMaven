package special_elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckBoxes {
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// get the page
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		// define implicit wait
		driver.manage()
			  .timeouts()
			  .implicitlyWait(6, TimeUnit.SECONDS);
		
						
				
		// find and store all options WebElements
		WebElement opt1 = driver
				.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		WebElement opt2 = driver
				.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		WebElement opt3 = driver
				.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		WebElement opt4 = driver
				.findElement(By.xpath("(//input[@type='checkbox'])[5]"));
		
		// click on option 1
		opt1.click();
		
		// click option 1 again (unselect it)
		opt1.click();
		
		
		//TODO -> HOMEWORK
		// think of scenarios where multiple options are
		// selected or unselected, verify for each case
		
		
		// verify that option 1 IS selected
		System.out.println("Option 1 is selected? " + 
				opt1.isSelected() );
		
		
		
		// verify that option 4 is NOT selected
		System.out.println("Option 4 is selected? " +
				opt4.isSelected() );
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
