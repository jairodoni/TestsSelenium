package TestsSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BuscaAmericanas {

	WebDriver driver;

	@Before
	public void criaDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 700));
	}

	@After
	public void closeDriver() {
		driver.quit();
	}
//Faz Busca no site e checa se todos os resultados correspondem ao que se espera da busca
	@Test
	public void fazerBusca() {
		// variavel contendo uma palavra de busca
		String termoBusca = "celular";
		// endereço de onde se encontra a aplicação web
		driver.get("https://www.americanas.com.br");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//busca os elementos do HTML
		driver.findElement(By.name("conteudo")).sendKeys(termoBusca.toLowerCase());
		driver.findElement(By.id("h_search-btn")).click();
		//o parametro recebe um elemento do HTML
		String result = driver.findElement(By.className("iXIDWU")).getText();
		result = result.toLowerCase();

		boolean resultadoTeste;

		// Se o resultado for equivalente ao termoBusca, 
		//significa q todos os resultados estão dentro do que foi buscado
		if (result.contains(termoBusca)) {
			System.out.println("Successful Test");
			resultadoTeste = true;
		} else {
			System.out.println("erro na busca");
			System.out.println("O resultado encontrado foi: " + result);
			resultadoTeste = false;
		}
		Assert.assertTrue(resultadoTeste);
	}

}
