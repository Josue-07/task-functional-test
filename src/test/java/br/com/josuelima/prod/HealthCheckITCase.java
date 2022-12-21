package br.com.josuelima.prod;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HealthCheckITCase {

	WebDriver driver;
	ChromeOptions options;

	@Test
	public void healthCheck() {
		try {
			options = new ChromeOptions().setHeadless(true);
			
			driver = new ChromeDriver(options);
			driver.get("http://localhost:9999/tasks");

			driver.findElement(By.id("version")).isDisplayed();

		} finally {
			driver.quit();
		}
	}
}
