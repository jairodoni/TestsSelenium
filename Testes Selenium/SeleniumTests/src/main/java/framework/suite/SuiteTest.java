package framework.suite;

import static framework.base.Drivers.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import framework.tests.TestAjax;
import framework.tests.TestCadastro;
import framework.tests.TestPrime;
import framework.tests.TestRegrasCadastro;
import framework.tests.TestSincronismo;
import framework.tests.TestsAlertPage;
import framework.tests.TestsFramesWindows;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestCadastro.class,
	TestRegrasCadastro.class,
	TestsAlertPage.class,
	TestsFramesWindows.class,
	TestSincronismo.class,
	TestPrime.class,
	TestAjax.class,
})

public class SuiteTest {
	@AfterClass
	public static void finishClass() {
		killDriver();
	}
}
