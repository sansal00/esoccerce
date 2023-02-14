package aggiuntarecensione;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;


public class AggiuntaRecensioneTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/aggiuntarecensione/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testRecensioneAggiunta() throws InterruptedException{
		    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Login")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).sendKeys("brunofarano@outlook.it");
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).sendKeys("Bruno2000");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) li:nth-child(1) .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("eccellente")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("textarea")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("textarea")).sendKeys("Prodotto davvero comodo e performante!");
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(2) .btn")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Recensione aggiunta con successo!"));
		    Thread.sleep(2000);
	  }
	  

	  @Test
	  public void testRecensioneNonAggiunta() throws InterruptedException{
		    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Login")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).sendKeys("brunofarano@outlook.it");
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).sendKeys("Bruno2000");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) li:nth-child(1) .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("textarea")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("textarea")).sendKeys("Prodotto davvero comodo e performante!");
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(2) .btn")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Recensione non valida! Inserire tutti i campi correttamente!"));
		    Thread.sleep(2000);
	  }


}
