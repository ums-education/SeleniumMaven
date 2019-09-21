package special_elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsWithEtsy {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		

		// get the page
		driver.get("https://www.etsy.com");
		// define implicit wait
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		WebElement searchBox = driver
				.findElement(By.name("search_query"));
		
		WebElement textToDrop = driver
				.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/ul/li/a/div[1]/div/div/h2/span"));
		
		WebElement jewelryDropDown = driver
				.findElement(By.id("catnav-primary-link-10855"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(jewelryDropDown)
			.build().perform();
		
		
		
		// adding wait to see where my driver is
		Thread.sleep(3000);
		// destroy driver instance
		driver.quit();
	}

}
