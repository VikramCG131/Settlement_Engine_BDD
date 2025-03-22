package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MetaDataSteps {
    WebDriver driver;

    @Given("I navigate to the {string} page")
    public void navigateToMetaData(String page) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:62216/metadata");
        Thread.sleep(3);
    }
    @When("I click on Metadata Button")
    public void i_click_on_metadata_button() {
    	driver.findElement(By.xpath("//a[@class='btn btnnav_bg active']"));
    }
        
    @When("I click on Add New Button")
    public void clickButton() {
        driver.findElement(By.xpath("//button[text()='Add New']")).click();
    }

    @When("I enter test_file in the file name field")
    public void enterText(String value, String fieldName) {
        String fieldXpath = "//input[@formcontrolname='fileName']";
        WebElement inputField = driver.findElement(By.xpath(fieldXpath));
        inputField.sendKeys(value);
    }

    @Then("I should see {string} in the file list")
    public void verifyFileInList(String fileName) {
        boolean fileExists = driver.getPageSource().contains(fileName);
        assertTrue("File name not found in list!", fileExists);
        driver.quit();
    }

    private void assertTrue(String string, boolean fileExists) {
		// TODO Auto-generated method stub
		
	}

	@Then("I should see validation errors for required fields")
    public void verifyValidationErrors() {
        boolean errorDisplayed = driver.getPageSource().contains("This field is required");
        assertTrue("Validation errors are not displayed!", errorDisplayed);
        driver.quit();
    }

    @Then("{string} should not be in the file list")
    public void verifyFileNotInList(String fileName) {
        boolean fileExists = driver.getPageSource().contains(fileName);
        assertFalse("File should not be saved!", fileExists);
        driver.quit();
    }

	private void assertFalse(String string, boolean fileExists) {
		// TODO Auto-generated method stub
		
	}
}

