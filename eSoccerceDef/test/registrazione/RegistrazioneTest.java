package registrazione;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrazioneTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/registrazione/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testRegistrazioneEffettuata() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).sendKeys("mariorossi5@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(1000);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Registrazione conclusa!"));
	    Thread.sleep(5000);
	  }
	  
	  
	  @Test
	  public void testEmailErrata() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(1000);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("Il formato dell'email Ë errato! Riprova."));
	    Thread.sleep(5000);
	  }
	  
	  @Test
	  public void testEmailEsistente() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).sendKeys("admin@admin.it");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(1000);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Email esistente!"));
	    Thread.sleep(5000);
	  }
	  
	  @Test
	  public void testPasswordErrata() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mar");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mar");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("La password deve contenere almeno 5 caratteri!"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testConfermaErrata() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mar");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Mario2000");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.findElement(By.id("messaggio")).getText(), is("II campi di password e conferma password non coincidono! Riprova."));
	    Thread.sleep(2000);
	  }
	  
	  
	  
	  @Test
	  public void testNomeErrato() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Ma!!io");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Registrazione"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testCognomeErrato() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Ro!!i");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Registrazione"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testIndirizzoErrato() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde!, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Registrazione"));
	    Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testCitt‡Errata() throws InterruptedException {
	    driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
	    driver.findElement(By.linkText("Registrati")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("email")).sendKeys("mariorossi1@gmail.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("password")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("confermaPassword")).sendKeys("Mario2001");
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("nome")).sendKeys("Mario");
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("cognome")).sendKeys("Rossi");
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("indirizzo")).sendKeys("Via Verde, 12");
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("citt‡")).sendKeys("Salerno!");
	    Thread.sleep(500);
	    driver.findElement(By.id("submit")).click();
	    assertThat(driver.getTitle(), is("eSoccerce - Registrazione"));
	    Thread.sleep(2000);
	  }
	  
}
