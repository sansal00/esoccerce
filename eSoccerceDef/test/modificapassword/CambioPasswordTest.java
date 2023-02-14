package modificapassword;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CambioPasswordTest {
	
	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/modificapassword/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testCambioPasswordEffettuato() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Gianmichele2001");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Gianmichele2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Cambio effettuato con successo!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testPasswordNonPresente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("adminne");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Gianmichele2001");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Gianmichele2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Dato errato o dato nuovo già esistente!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testNuovaPasswordErrata() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("adminne");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("123");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("123");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("La password deve essere lunga almeno 5 caratteri!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testConfermaPasswordNonCoincidente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("adminne");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("Gianmichele2001");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("Gianmikele2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il campo del nuovo dato e della conferma non coincidono! Riprova."));
	    Thread.sleep(2000);
	  }
}


