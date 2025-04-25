//Extent report + regression suite

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = 
    		"src/test/resources/Features" //the path of the feature files
    , //the path of the feature files			  
    		
    glue = "StepDefinitions",
    monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
    
)
public class TestRunner {}
//This is the test runner class for running the cucumber tests.
