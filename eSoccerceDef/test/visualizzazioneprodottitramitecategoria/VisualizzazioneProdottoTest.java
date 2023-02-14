package visualizzazioneprodottitramitecategoria;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualizzazioneProdottoTest {

	private WebDriver driver;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "test/visualizzazioneprodottitramitecategoria/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	@Test
	public void testVisualizzazioneProdotto() throws InterruptedException{
		 driver.get("http://localhost:8080/eSoccerce/site/index.jsp");
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector("li:nth-child(2) > .dropdown")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Scarpe da running")).click();
		    assertThat(driver.getTitle(), is("eSoccerce - Scarpe running"));
		    Thread.sleep(3000);
	}
}
