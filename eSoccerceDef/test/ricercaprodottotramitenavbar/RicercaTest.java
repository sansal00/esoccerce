package ricercaprodottotramitenavbar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RicercaTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/ricercaprodottotramitenavbar/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testRisultatoRicerca() throws InterruptedException{
		  driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).click();
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).sendKeys("maglia");
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
		  assertThat(driver.getTitle(), is("eSoccerce - Ricerca"));
		  Thread.sleep(3000);	  
	  }

	  @Test
	  public void testRicercaVuota() throws InterruptedException{
		  driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).click();
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).sendKeys("cammello");
		  Thread.sleep(500);
		  driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.id("messaggio")).getText(), is("Uhm, credo non ci siano articoli riguardo la ricerca appena effettuata. Puoi sempre ricercare altro!"));
		  Thread.sleep(3000);	  
	  }

}
