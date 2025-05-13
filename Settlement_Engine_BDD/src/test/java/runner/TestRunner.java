// Test Runner for executing Cucumber tests with Extent Report integration

package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ReportUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/ReferenceLookUp/Tp_Mapping.feature",
    glue = {"steps", "hooks", "listeners"},
    monochrome = true,
    tags = "not @skip",
    plugin = {"pretty", "listeners.ExtentReportListener", "html:target/cucumber-reports.html"}
)
public class TestRunner {
	
	@BeforeClass
	public static void setup() {
		// Initialize the Extent Report
		ReportUtil.initReport();
	}
	
	@AfterClass
	public static void tearDown() {
		// Flush and finalize the Extent Report
		ReportUtil.flushReport();
	}
}
