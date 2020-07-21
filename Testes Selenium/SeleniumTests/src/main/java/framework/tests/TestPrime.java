package framework.tests;

import static framework.base.Drivers.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.base.BaseTest;
import framework.base.DSL;

public class TestPrime extends BaseTest {
	WebDriver driver;
	DSL dsl;

	@Before
	public void startDriver() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void interactionRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clickRadio(By.xpath("//input[@id='j_idt719:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarked("j_idt719:console:0"));
		dsl.clickRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarked("j_idt719:console:1"));
	}

	@Test
	public void interactionSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selectComboPrime("j_idt719:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.getTexts("j_idt719:console_label"));
	}

}
