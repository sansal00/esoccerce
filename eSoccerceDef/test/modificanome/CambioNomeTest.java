package modificanome;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CambioNomeTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/modificanome/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testCambioNomeEffettuato() throws InterruptedException {
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
	    driver.findElement(By.linkText("Il mio profilo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.linkText("Cambia nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("Administrator");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Emanuele");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Emanuele");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Cambio effettuato con successo!"));
	    Thread.sleep(2000);
	  }

	  @Test
	  public void testNomeNonPresente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Il mio profilo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.linkText("Cambia nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("Adminne");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Emanuele");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Emanuele");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Dato errato o dato nuovo già esistente!"));
	    Thread.sleep(2000);
	  }
	  

	  @Test
	  public void testNuovoNomeErrato() throws InterruptedException {
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
	    driver.findElement(By.linkText("Il mio profilo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.linkText("Cambia nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("Administrator");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Emanuele!");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Emanuele");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Cambio nome"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testConfermaNomeNonCoincidente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Il mio profilo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.linkText("Cambia nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("Administrator");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Emanuele");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Emanuelo");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il campo del nuovo dato e della conferma non coincidono! Riprova."));
	    Thread.sleep(2000);
	  }
}
