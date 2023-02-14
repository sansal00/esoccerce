package aggiuntaprodottoalcarrello;

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

public class AggiuntaCarrelloTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/aggiuntaprodottoalcarrello/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testProdottoAggiuntoAlCarrello() throws InterruptedException {
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
	    driver.findElement(By.linkText("Scarpe da running")).click();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("table:nth-child(2) tr:nth-child(6) button")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Prodotto aggiunto con successo al carrello!"));
	    Thread.sleep(3000);
	  }
	  
	  @Test
	  public void testProdottoNonAggiuntoAlCarrello() throws InterruptedException{
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
		    driver.findElement(By.linkText("Scarpe da running")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(2) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Scarpe da running")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(2) tr:nth-child(6) button")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il prodotto è già presente nel carrello. Vuoi acquistarne altri? Usa l'apposito tool nel carrello!"));
		    Thread.sleep(3000);
	  }
}
