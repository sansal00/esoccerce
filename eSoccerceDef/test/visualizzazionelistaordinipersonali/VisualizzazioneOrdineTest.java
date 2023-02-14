package visualizzazionelistaordinipersonali;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualizzazioneOrdineTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/visualizzazionelistaordinipersonali/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testVisualizzazioneOrdine() throws InterruptedException{
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
		    driver.findElement(By.linkText("I miei ordini")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Ordini"));
		    Thread.sleep(3000);
	  }
	  
	  @Test
	  public void testListaOrdiniVuota() throws InterruptedException{
		  driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Login")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).click();	    
		    Thread.sleep(500);
		    driver.findElement(By.id("email")).sendKeys("ciao@ciao.it");
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("password")).sendKeys("Ciao200");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("I miei ordini")).click();
		    assertThat(driver.findElement(By.id("noordini")).getText(), is("Non hai ancora effettuato ordini. Naviga nel nostro sito e acquista i nostri articoli!"));
		    Thread.sleep(3000);
	  }
}
