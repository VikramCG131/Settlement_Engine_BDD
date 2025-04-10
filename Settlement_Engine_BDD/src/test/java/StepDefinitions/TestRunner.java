//Extent report + regression suite

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = 
    		"src/test/resources/Features/ExceptionRuleMetaData.feature", 	
    		name="Verify validation errors when mandatory fields are missing for the Exception Rule Meta Data",
    
    glue = "StepDefinitions",
   
    monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
    
)
public class TestRunner {}

