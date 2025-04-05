//Extent report + regression suite

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = 
    		"src/test/resources/Features/a_metadata_Data_Source_File.feature",
    		
    		
    
    glue = "StepDefinitions",
    name="Verify file Upload functionality"
    ,monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
    
)
public class TestRunner {}

