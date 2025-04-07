//Extent report + regression suite

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
    		"src/test/resources/Features/client_LookUp.feature", 	
    		"src/test/resources/Features/Brand_mapping.feature"
    },
    glue = "StepDefinitions",
   
    monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
    
)
public class TestRunner {}

