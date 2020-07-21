package framework.tests;

import static framework.base.Drivers.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.base.BaseTest;
import framework.base.DSL;

public class TestSincronismo extends BaseTest {

	private DSL dsl;

	@Before
	public void startDriver() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void interactionLoadingFixed() throws InterruptedException {
		dsl.clickButton("buttonDelay");
		Thread.sleep(5000);
		dsl.write("novoCampo", "Deu certo?");
	}

	@Test
	public void interactionLoadingImplicitly() {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dsl.clickButton("buttonDelay");
		dsl.write("novoCampo", "Deu certo?");
		// desliga a espera
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	@Test
	public void interactionLoadingExplicit() throws InterruptedException {
		dsl.clickButton("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.write("novoCampo", "Deu certo?");
	}
}
