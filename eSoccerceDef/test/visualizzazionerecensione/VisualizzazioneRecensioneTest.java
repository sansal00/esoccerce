package visualizzazionerecensione;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualizzazioneRecensioneTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/visualizzazionerecensione/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testRecensioneVisualizzata() throws InterruptedException{
		    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Login")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).sendKeys("admin@admin.it");
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).sendKeys("admin");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Magliette")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(4) tr:nth-child(8) button")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Recensioni"));
		    Thread.sleep(3000);  
	  }
	  
	  @Test
	  public void testRecensioneNonVisualizzata() throws InterruptedException{
		    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Login")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).sendKeys("admin@admin.it");
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).sendKeys("admin");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Magliette")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(2) tr:nth-child(8) button")).click();
		    assertThat(driver.findElement(By.id("norecensioni")).getText(), is("Uhm, credo non ci siano recensioni per questo prodotto. Passa più tardi!"));
		    Thread.sleep(3000);  
	  }
}
