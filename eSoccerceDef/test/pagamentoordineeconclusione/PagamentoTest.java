package pagamentoordineeconclusione;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PagamentoTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/pagamentoordineeconclusione/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testPagamentoEffettuato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("5265434954437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12/24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("931");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Vai alla pagina ordini!")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Ordini"));
		    Thread.sleep(3000);
		  }
	  
	  @Test
	  public void testNumeroCartaErrato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("526543495437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12/24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("931");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il numero della carta deve essere composto da 16 cifre!"));
		    Thread.sleep(3000);
		  }
	  
	  @Test
	  public void testDataScadenzaErrata() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("5265434954437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12!24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("931");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Checkout"));
		    Thread.sleep(3000);
		  }
		  
	  @Test
	  public void testCVCErrato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("5265434954437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12/24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("93");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il codice CVC deve essere composto da 3 cifre!"));
		    Thread.sleep(3000);
		  }
		  
	  @Test
	  public void testNomeIntestatarioErrato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("5265434954437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12/24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("931");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore!");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Checkout"));
		    Thread.sleep(3000);
		  }
	  
	  @Test
	  public void testCognomeIntestatarioErrato() throws InterruptedException{
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
		    driver.findElement(By.cssSelector("li:nth-child(3) > .dropdown > .text")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Gadgets")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("table:nth-child(1) tr:nth-child(6) button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("a:nth-child(1) > button")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("numerocarta")).sendKeys("5265434954437002");
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("scadenza")).sendKeys("12/24");
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cvc")).sendKeys("931");
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("nomeintestatario")).sendKeys("Salvatore");
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("cognomeintestatario")).sendKeys("Santoriello!");
		    Thread.sleep(500);
		    driver.findElement(By.id("submit")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Checkout"));
		    Thread.sleep(3000);
		  }
		  
	  }
	  


