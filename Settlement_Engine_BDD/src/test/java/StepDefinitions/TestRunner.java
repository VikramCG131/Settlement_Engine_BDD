//Extent report + regression suite

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = 
    		"src/test/resources/Features/Ref"
    , //the path of the feature files			  
    		
    glue = "StepDefinitions",
   tags="not @skip",
    monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
    
)
public class TestRunner {}
//This is the test runner class for running the cucumber tests.
