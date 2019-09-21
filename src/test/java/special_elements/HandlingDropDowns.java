package special_elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDowns {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// get the page
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		WebElement daysDropDownElement = driver.findElement(By.id("select-demo"));

		Select daysDropDownList = new Select(daysDropDownElement);
//		Select daysDropDownList = new Select(driver.findElement(By.id("select-demo")));

		daysDropDownList.selectByVisibleText("Sunday");
		Thread.sleep(2000);
		

		daysDropDownList.selectByValue("Wednesday");
		Thread.sleep(2000);

		daysDropDownList.selectByIndex(5);

		
		//TODO -> Homework
		// experiment with other Select options
		// especially getOptions()
		// getAllSelectedOptions()
		// and deselection methods
		// and VERIFY the selected value by printing it
		
		// verify that Sunday is selected
		System.out.println("Selected day: " +
				daysDropDownList
				.getFirstSelectedOption()
				.getText());
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
