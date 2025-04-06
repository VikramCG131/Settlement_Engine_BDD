package hooks;
 
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ReportUtil;
 
public class Hooks {
    private WebDriver driver;
 
    @Before
    public void setup(Scenario scenario) {
        DriverManager.initializeDriver();
        driver = DriverManager.getDriver();
 
        // Start Feature & Scenario Logging
        String featureFile = scenario.getUri().getPath();
        String[] parts = featureFile.split("/");
        String featureName = parts[parts.length - 1].replace(".feature", "");
        ReportUtil.createFeature(featureName);
        ReportUtil.createScenario(scenario.getName());
        ReportUtil.logInfo("Starting Scenario: " + scenario.getName());
    }
 
    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            ReportUtil.logFail("Test Failed: " + scenario.getName(), driver);
        } else {
            ReportUtil.logPass("Test Passed: " + scenario.getName(), driver);
        }
 
        DriverManager.closeDriver();
    }
}
 