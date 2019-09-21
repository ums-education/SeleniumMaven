package special_operations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiTabOperations {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// get the page
		driver.get("http://www.naukri.com/");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

		WebElement toClick = driver
				.findElement(By.partialLinkText("Naukri Resume"));
		
		toClick.click();
		
		// develop code that will command my driver to go to the next tab
		String currentTab = driver.getWindowHandle();
		System.out.println(currentTab);
		
		Set<String> allTabs = driver.getWindowHandles();
		
		System.out.println("Number of windows open: " + allTabs.size());
		
		for (String each : allTabs) {
			System.out.println( driver.switchTo().window(each).getTitle() );
			
			Thread.sleep(2000);
			
			String currentTitle = driver.getTitle();
			
			if (currentTitle.contains("Jobs") 
					|| currentTitle.contains("Adtran") 
					|| currentTitle.contains("Toyo")) {
				driver.close();
			}
			
		}
		
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
