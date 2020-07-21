package TestsSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;



public class TestAlert {
	WebDriver driver;
    
	@Before
    public void criaDriver(){
		DriverFirefox wdriver = new DriverFirefox();
		driver = wdriver.Webdriver();
        driver.manage().window().setSize(new Dimension(1000, 900));
    }
	@After
    public void fecharDriver(){ 
		driver.quit(); 
	}
	//Interage com Alerts
	@Test
	public void interactionAlertSimple() {
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("Alert Simples", text);
		//clica ok no alert
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(text);
	}
	//Interage com Alerts
	@Test
	public void interactionAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
//		Assert.assertEquals("Confirm Simples", alert.getText());
//		alert.accept();
//		Assert.assertEquals("Confirmado", alert.getText());
//		alert.accept();
		
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.dismiss();
	}
	//Interage com Alerts
	@Test
	public void interactionAlertPrompt() {
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
	}

}
