package TestsSelenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFirefox {

	public  WebDriver Webdriver(){
			WebDriver driver = new FirefoxDriver();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			driver.manage().window().setSize(new Dimension(1000, 900));
			return driver;
	}

}
