package br.com.josuelima.fuctional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		return driver;
	}

	@Test
	public void deveSalvarTarefeComSucesso() {

		WebDriver driver = acessarAplicacao();

		driver.findElement(By.xpath("//*[contains(text(), 'Add Todo')]")).click();
		driver.findElement(By.xpath("//input[@name='task']")).sendKeys("teste com selenium");
		driver.findElement(By.id("dueDate")).sendKeys("22/12/2023");
		driver.findElement(By.id("saveButton")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Success!')]")).isDisplayed();

		driver.quit();
	}

	@Test
	public void naoDeveSalvarTarefeSemDescricao() {

		WebDriver driver = acessarAplicacao();

		driver.findElement(By.xpath("//*[contains(text(), 'Add Todo')]")).click();
		// driver.findElement(By.xpath("//input[@name='task']")).sendKeys("teste com
		// selenium");
		driver.findElement(By.id("dueDate")).sendKeys("22/12/2023");
		driver.findElement(By.id("saveButton")).click();
		String menssageSemDescricao = driver.findElement(By.id("message")).getText();
		assertEquals("Fill the task description", menssageSemDescricao);
		driver.quit();
	}

	@Test
	public void naoDeveSalvarTarefeSemData() {

		WebDriver driver = acessarAplicacao();

		driver.findElement(By.xpath("//*[contains(text(), 'Add Todo')]")).click();
		driver.findElement(By.xpath("//input[@name='task']")).sendKeys("teste comselenium");
		//driver.findElement(By.id("dueDate")).sendKeys("22/12/2023");
		driver.findElement(By.id("saveButton")).click();
		String menssageSemDescricao = driver.findElement(By.id("message")).getText();
		assertEquals("Fill the due date", menssageSemDescricao);
		 driver.quit();
	}
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {

		WebDriver driver = acessarAplicacao();

		driver.findElement(By.xpath("//*[contains(text(), 'Add Todo')]")).click();
		driver.findElement(By.xpath("//input[@name='task']")).sendKeys("teste comselenium");
		driver.findElement(By.id("dueDate")).sendKeys("22/12/2020");
		driver.findElement(By.id("saveButton")).click();
		String menssageSemDescricao = driver.findElement(By.id("message")).getText();
		assertEquals("Due date must not be in past", menssageSemDescricao);
		driver.quit();
	}
}
