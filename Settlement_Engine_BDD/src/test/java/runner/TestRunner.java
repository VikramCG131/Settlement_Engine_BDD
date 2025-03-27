//Extent report 

package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/metdata_Data_Quality_Assignment.feature",
    glue = "steps",monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
)
public class TestRunner {}