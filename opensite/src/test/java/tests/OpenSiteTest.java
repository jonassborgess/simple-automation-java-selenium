package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSiteTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://marcelodebittencourt.com/demopages/demosimplesearch/");
		assertTrue("Titulo da pagina difere do esperado",
				driver.getTitle().contentEquals("Demo Simple Search using JavaScript"));
		WebElement textbox = driver.findElement(By.id("textbox"));
		textbox.sendKeys("selenium");
		WebElement button1 = driver.findElement(By.id("button1"));
		button1.click();
		WebElement result = driver.findElement(By.id("result"));
		assertTrue("Conteudo diferente do esperado", result.getText().contentEquals("selenium"));
		Thread.sleep(3000);
	}
}
