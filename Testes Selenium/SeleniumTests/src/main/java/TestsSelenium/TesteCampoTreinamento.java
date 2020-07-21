package TestsSelenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class TesteCampoTreinamento {
	WebDriver driver;

	@Before
	public void criaDriver() {
		DriverFirefox wdriver = new DriverFirefox();
		driver = wdriver.Webdriver();
	}
	
	@After
	public void closeDriver() {
		driver.quit();
	}
	

	// Preenche um campo do formulario e faz comparações
	@Test
	public void testTextField01() {
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1000, 900));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		driver.get("file:///C:/Users/jairo/Documents/TestsSelenium/ExemploFormulario/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		driver.quit();
	}
	// Preenche um campo do formulario e faz comparações
	@Test
	public void testTextField02() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste Linha 1\n\nteste Linha 3 \nteste Linha 4");
		Assert.assertEquals("teste Linha 1\n\nteste Linha 3 \nteste Linha 4",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	// Teste para ver se botão radio elementosForm:sexo:0 esta corretamente
	// selecionado
	@Test
	public void interactionRadioButton() {

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	// Teste para ver se o input checkbox esta corretamente selecionado e com o
	// valor certo
	@Test
	public void interactionCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}
	// Teste para ver se o input combo box esta corretamente selecionado e com o
	// valor certo
	@Test
	public void interactionComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(4);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("Superior");

		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	}
	// Teste para ver se o input combo box esta corretamente selecionado e com o
	// valor certo de forma mais especifica
	@Test
	public void checksComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		// Lista todo o combo box
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		// Checka se uma opção especifica esta presente na lista de opções
		boolean found = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found);
	}
	// Teste para ver se o input combo box esta corretamente selecionado e com o
	// valor certo,seleciona mais de uma opção e deseleciona o item tb
	@Test
	public void checksComboBox2() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());

		combo.deselectByVisibleText("Corrida");
		allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectOptions.size());
	}
	//Clica um Botão
	@Test
	public void interactionButton() {
		WebElement button = driver.findElement(By.id("buttonSimple"));
		button.click();
		Assert.assertEquals("Obrigado!", button.getAttribute("value"));
	}
	//Ignore a função
	@Test
	@Ignore
	public void interactionLink01() {
		driver.findElement(By.linkText("Voltar")).click();
//		Assert.fail();
	}

	// Clica no link e compara retornos de Textos em Link
	@Test
	public void interactionLink02() {
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	// Faz uma busca por textos no site atraves de tags e classes
	@Test
	public void searchTexts() {
		System.out.println(driver.findElement(By.tagName("html")).getText());
//		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());

//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
//				driver.findElement(By.className("facilAchar")).getText());
	}
	
	
}
