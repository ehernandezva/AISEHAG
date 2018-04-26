package pruebaSistema;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import es.codeurjc.ais.tictactoe.WebApp;
import io.github.bonigarcia.wdm.ChromeDriverManager;


public class PruebaSistemaGanarTest {
	private WebDriver driver1;
	private WebDriver driver2;

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}
	
	@Before
	public void setupTest() {
		driver1 = new ChromeDriver();
		driver2 = new ChromeDriver();
		
	}

	@After
	public void teardown() {
		if (driver1 != null) {
			driver1.quit();
		}
		if (driver2 != null) {
			driver2.quit();
		}
	}

	
	@Test
	public void test() {
		WebApp.start();
		
		driver1.get("localhost:8080/");
        WebElement searchInput1 = driver1.findElement(By.id("nickname"));
        searchInput1.sendKeys("Jugador 1");      
        WebElement playbutton1 = driver1.findElement(By.id("startBtn"));
        playbutton1.click();

	
		driver2.get("localhost:8080/");
		WebElement searchInput2 = driver2.findElement(By.id("nickname"));
	    searchInput2.sendKeys("Jugador 2");      
	    WebElement playbutton2 = driver2.findElement(By.id("startBtn"));
	    playbutton2.click();

	    WebElement cell_1 = driver1.findElement(By.id("cell-0"));
        cell_1.click();
	    
        WebElement cell_2 = driver2.findElement(By.id("cell-2"));
        cell_2.click();
        
        cell_1 = driver1.findElement(By.id("cell-3"));
        cell_1.click();
        
        cell_2 = driver2.findElement(By.id("cell-4"));
        cell_2.click();
        
        cell_1 = driver1.findElement(By.id("cell-6"));
        cell_1.click();
        
        

        String res = "Jugador 1 wins! Jugador 2 looses.";
        assertThat(res).isEqualTo("Jugador 1 wins! Jugador 2 looses.");
		
	}
        

}

