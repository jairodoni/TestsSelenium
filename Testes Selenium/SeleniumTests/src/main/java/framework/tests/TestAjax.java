package framework.tests;

import static framework.base.Drivers.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.base.BaseTest;
import framework.base.DSL;

public class TestAjax extends BaseTest {

	private DSL dsl;

	@Before
	public void startDriver() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}

	@Test
	public void testAjax() {
		dsl.write("j_idt718:name", "Teste");
		dsl.clickButton("j_idt718:j_idt721");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt718:display"), "Teste"));
		Assert.assertEquals("Teste", dsl.getTexts("j_idt718:display"));
	}
}
