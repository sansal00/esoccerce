package visualizzazionecarrello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualizzazioneCarrelloTest {
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/rimozioneprodottodalcarrello/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testCarrelloVisualizzato() throws InterruptedException {
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
	    driver.findElement(By.cssSelector("button:nth-child(2)")).click();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector(".cart-button")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Carrello"));
	    Thread.sleep(3000);
	  }
	  
	  @Test
	  public void testCarrelloVuoto() throws InterruptedException{
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
		    driver.findElement(By.cssSelector(".cart-button")).click();
		    assertThat(driver.findElement(By.id("messaggiovuoto")).getText(), is("Il tuo carrello è vuoto! Scorri le pagine dei nostri prodotti per riempirlo!"));
		    Thread.sleep(3000);
	  }
	  
	  @Test
	  public void testCarrelloNonAutenticato() throws InterruptedException{
		  driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector(".cart-button")).click();
		    assertThat(driver.findElement(By.id("messaggionologin")).getText(), is("Spiacenti, per poter visualizzare il carrello occore essere loggati!"));
		    Thread.sleep(3000);
	  }
	  
	  
}
