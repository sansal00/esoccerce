package rimozioneprodottodalcarrello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RimozioneCarrelloTest {
	
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
	  public void testProdottoRimossoDalCarrello() throws InterruptedException {
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
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Prodotto rimosso con successo dal carrello!"));
	    Thread.sleep(3000);
	  }

}
