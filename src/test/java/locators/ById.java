package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ById {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));
		searchButton.click();
		searchButton.sendKeys("testing a very long string to demo that Selenium imitates human behavior on browser. So this whole String will be populated as if someone is typing it.");

	}

}
