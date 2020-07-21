package framework.tests;

import static framework.base.Drivers.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.base.BaseTest;
import framework.base.DSL;

public class TestsFramesWindows extends BaseTest {

	DSL dsl;

	@Before
	public void startDriver() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void interactionFrames() {
		dsl.inFrame("frame1");
		dsl.clickButton("frameButton");
		String msg = dsl.alertGetTextAccept();
		Assert.assertEquals("Frame OK!", msg);

		dsl.outFrame();
		dsl.write("elementosForm:nome", msg);
	}

	@Test
	public void interactionHiddenFrames() {
		// desce a tela e clica no botão
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.useJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.inFrame("frame2");
		dsl.clickButton("frameButton");
		String msg = dsl.alertGetTextAccept();
		Assert.assertEquals("Frame OK!", msg);
	}

	@Test
	public void interactionWindows() {
		dsl.clickButton("buttonPopUpEasy");
		dsl.changeWindows("Popup");
		dsl.write(By.tagName("textarea"), "Deu certo?");
		getDriver().close();
		dsl.changeWindows("");
		dsl.write(By.tagName("textarea"), "e agora?");
	}

	@Test
	public void interactionWindowsUntitled() {
		dsl.clickButton("buttonPopUpHard");
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandles());
		dsl.changeWindows((String) getDriver().getWindowHandles().toArray()[1]);
		dsl.write(By.tagName("textarea"), "Deu certo?");
		dsl.changeWindows((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.write(By.tagName("textarea"), "e agora?");
	}
}
