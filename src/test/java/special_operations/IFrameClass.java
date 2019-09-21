package special_operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameClass {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// get the page
		driver.get("http://demo.guru99.com/test/guru99home/");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

		
		
		// options to switch to an iframe
		// 1. index of the iframe related to its PARENT
		driver.switchTo().frame(0);
		// 2. String representation of the iframe's NAME or ID (name preferable)
		//    the iframe has to be found inside the PARENT that the driver is in
//		driver.switchTo().frame("_mN_main_224278574_0_n");
		// 3. WebElement representation of the iframe
//		WebElement myIFrame = driver.findElement(By.id("_mN_main_224278574_0_n"));
//		driver.switchTo().frame(myIFrame);
		
		WebElement csTraining = driver
				.findElement(By.linkText("Network Monitoring Tools"));
		
		csTraining.click();
		
		driver.switchTo().parentFrame();
		
		// adding wait to see where my driver is
		Thread.sleep(5000);
		// destroy driver instance
		driver.quit();
	}
}
