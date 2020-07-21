package framework.tests;

import static framework.base.Drivers.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import framework.base.BaseTest;
import framework.page.PageCampoTreinamento;

public class TestCadastro extends BaseTest {

	private PageCampoTreinamento page;

	@Before
	public void startDriver() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new PageCampoTreinamento();
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.Cadastro();

		Assert.assertEquals("Cadastrado!", page.getResultadoCadastro());
		Assert.assertEquals("Wagner", page.getCadNome());
		Assert.assertEquals("Costa", page.getCadSobrenome());
		Assert.assertEquals("Masculino", page.getCadSexo());
		Assert.assertEquals("Pizza", page.getCadComida());
		Assert.assertEquals("mestrado", page.getCadEscolaridade());
		Assert.assertEquals("Natacao", page.getCadEsportes());
	}

	@Test
	public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("alert('Testendo js via selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrita via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

	}
}
