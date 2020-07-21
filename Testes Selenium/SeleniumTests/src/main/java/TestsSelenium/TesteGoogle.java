package TestsSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	@Test
	public void buscaGoogle() {
		//local do driver(navegador de teste)
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver/chromedriver.exe");
		//Instancia de objeto
		WebDriver driver= new FirefoxDriver();
		//Site que o browser ira acessar
		driver.get("http://www.google.com");
		
		//maximiza a tela
		driver.manage().window().maximize();
		
		//Faz comparação do titulo, se esta ou não de acordo com o titulo esperado
		Assert.assertEquals("Google", driver.getTitle());
		System.out.print(driver.getTitle());
		//escreve e faz a busca e compara se esta escrevendo o esperado
		driver.findElement(By.name("q")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.name("q")).getAttribute("value"));
		
//		feche todas as abas do driver
		//driver.close();
//		fecha todas as abas do driver e todas as instancias
		driver.quit();
	}
}














