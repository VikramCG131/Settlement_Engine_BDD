//Extent report 

package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ReportUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/brand_Mapping.feature",
    glue = {"steps", "hooks" , "listeners"},
    monochrome = true,
    		plugin = {"pretty","listeners.ExtentReportListener","html:target/cucumber-reports.html" }
)
public class TestRunner {
	
	@BeforeClass
	public static void setup() {
		// Initialize the report
		ReportUtil.initReport();
	}
	
	@AfterClass
	public static void tearDown() {
		// Flush the report
		ReportUtil.flushReport();
	}
}