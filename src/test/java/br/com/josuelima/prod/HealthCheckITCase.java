package br.com.josuelima.prod;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckITCase {

	WebDriver driver;

	@Test
	public void healthCheck() {
		try {
			driver = new ChromeDriver();
			driver.get("http://localhost:9999/tasks");

			driver.findElement(By.id("version")).isDisplayed();

		} finally {
			driver.quit();
		}
	}
}
