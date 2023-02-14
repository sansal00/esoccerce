package rimozioneprodotto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RimozioneProdottoTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/rimozioneprodotto/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testProdottoRimosso() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(1) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Rimuovi prodotto")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("code")).click();
		    Thread.sleep(500);
		    {
		      WebElement dropdown = driver.findElement(By.id("code"));
		      dropdown.findElement(By.xpath("//option[. = '123']")).click();
		    }
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Prodotto rimosso!"));
		    Thread.sleep(3000);
	  }
	  
	  @Test
	  public void testCodiceProdottoNonSelezionato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(1) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Rimuovi prodotto")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("code")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Per favore seleziona un codice prodotto!"));
		    Thread.sleep(3000);
	  }
}
