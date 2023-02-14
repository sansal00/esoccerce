package modificaemail;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CambioEmailTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/modificaemail/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testCambioEmailEffettuato() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("admin2@admin.it");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("admin2@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Cambio effettuato con successo!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testEmailErrata() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin@admin;it");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("admin2@admin.it");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("admin2@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Dato errato o dato nuovo già esistente!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testEmailEsistente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("brunofarano@outlook.it");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("brunofarano@outlook.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Dato errato o dato nuovo già esistente!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testEmailFormatoErrato() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("brunofa rano@outlook.it");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("brunofarano@outlook.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il formato della nuova email è errato! Riprova."));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testConfermaNonCoincidente() throws InterruptedException {
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
	    driver.findElement(By.linkText("Cambia email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("vecchiodato")).sendKeys("admin@admin.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nuovodato")).sendKeys("admin2@admin.it");	    
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermanuovodato")).sendKeys("admin2@adminne.it");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il campo del nuovo dato e della conferma non coincidono! Riprova."));
	    Thread.sleep(2000);
	  }
}
