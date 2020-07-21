package framework.tests;

import static framework.base.Drivers.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import framework.base.BaseTest;
import framework.base.DSL;

public class TestsAlertPage  extends BaseTest{

	WebDriver driver;
	DSL dsl;

	@Before
	public void startDriver() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void deveInteragirComAlertSimples() {
		dsl.clickButton("alert");
		String texto = dsl.alertGetTextAccept();
		Assert.assertEquals("Alert Simples", texto);

		dsl.write("elementosForm:nome", texto);
	}

	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clickButton("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertGetTextAccept());
		Assert.assertEquals("Confirmado", dsl.alertGetTextAccept());

		dsl.clickButton("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertGetTextDeny());
		Assert.assertEquals("Negado", dsl.alertGetTextDeny());
	}

	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clickButton("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertGetText());
		dsl.alertWrite("12");
		Assert.assertEquals("Era 12?", dsl.alertGetTextAccept());
		Assert.assertEquals(":D", dsl.alertGetTextAccept());
	}
}
