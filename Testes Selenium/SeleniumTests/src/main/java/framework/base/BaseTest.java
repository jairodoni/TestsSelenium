package framework.base;

import static framework.base.Drivers.killDriver;

import org.junit.After;

public class BaseTest {

	@After
	public void finish() {
//		TakesScreenshot ss = (TakesScreenshot) getDriver();
//		File arquivo = ss.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
//				File.separator + testName.getMethodName() + ".jpg"));

		if (Properties.CLOSE_BROWSER) {
			killDriver();
		}
	}

}
