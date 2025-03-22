package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class MetaDataSteps {
    WebDriver driver;

    @Given("I navigate to the {string} page")
    public void navigateToMetaData(String page) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:52960/" + page.toLowerCase());
    }

    @When("I click on {string}")
    public void clickButton(String buttonText) {
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
    }

    @When("I enter {string} in the {string} field")
    public void enterText(String value, String fieldName) {
        String fieldXpath = "//label[contains(text(),'" + fieldName + "')]/following-sibling::input";
        WebElement inputField = driver.findElement(By.xpath(fieldXpath));
        inputField.sendKeys(value);
    }

    @Then("I should see {string} in the file list")
    public void verifyFileInList(String fileName) {
        boolean fileExists = driver.getPageSource().contains(fileName);
        assertTrue("File name not found in list!", fileExists);
        driver.quit();
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
}

