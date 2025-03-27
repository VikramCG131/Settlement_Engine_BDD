package hooks;

import io.cucumber.java.Before;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import Utilities.ExtentManager;
import io.cucumber.java.After;

public class Hooks {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Before
	public void BeforeScenario(Scenario scenario) {
		System.out.println("Running @Before Hook: Initializing driver");
		DriverManager.initializeDriver();
		ExtentTest extentTest = extent.createTest(scenario.getName());
		test.set(extentTest);
		test.get().log(Status.INFO, "Scenario Started : " + scenario.getName());
		System.out.println("Setting up before the scenario");
	}

	@After
    public void AfterScenario(Scenario scenario) {
				DriverManager.closeDriver();
    	if (scenario.isFailed()) {
    		test.get().fail(scenario.getName() + " is failed");
    		} else { 
    		test.get().pass(scenario.getName() + " is passed");
    		
    		}
    		extent.flush();
    		 
        System.out.println("Tearing down after the scenario");
    }
}