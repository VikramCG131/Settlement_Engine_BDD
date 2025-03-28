//Extent report 

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
    		"src/test/resources/Features/a_metadata_Data_Source_File.feature",
    		"src/test/resources/Features/b_meta_data_Column.feature",
    		"src/test/resources/Features/c_data_Quality_Rule.feature",
    		"src/test/resources/Features/d_metdata_Data_Quality_Assignment.feature"
    },
    glue = "StepDefinitions",monochrome = true,
    		plugin = {"pretty","html:target/cucumber-reports.html" }
)
public class TestRunner {}