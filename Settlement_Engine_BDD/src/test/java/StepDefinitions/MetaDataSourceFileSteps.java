package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class MetaDataSourceFileSteps {
    WebDriver driver;
    CommonUtilities commonUtilities = new CommonUtilities();
    WebDriverWait wait;

    @Given("The Settlement Engine<URL>")
    public void the_settlement_engine_url() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("user hit the Settlement Engine URL")
    public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
        Thread.sleep(3000);
        System.out.println("The user is able to login with Settlement Engine URL");
    }

    @Then("the user is able to navigate to the Settlement Engine homepage")
    public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
        Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
        Thread.sleep(3000);
        System.out.println("The user is able to navigate to the Settlement Engine homepage");
        commonUtilities.screenshot();
    }

    @Then("the user click on Data Source File")
    public void the_user_click_on_data_source_file() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Data Source File')]")).click();
        Thread.sleep(8000);
        System.out.println("The user is able to navigate to Data Source File page");
        commonUtilities.screenshot();
    }
    @When("the user clicks the Add New button")
    public void the_user_clicks_the_add_new_button() {
    	WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
        wait.until(ExpectedConditions.visibilityOf(button)).click(); 
        System.out.println("The user is able to click on Add New Button");
        commonUtilities.screenshot();
    }


    @Then("the user enters the data in required fields")
    public void the_user_enters_the_data_in_required_fields() {
    	int random =(int) (Math.floor(Math.random()*100000) + 1);
        driver.findElement(By.xpath("//input[@formcontrolname='fileName']")).sendKeys("TestAutomation"+random);
        driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("csv");
        driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).sendKeys("raw");
        driver.findElement(By.xpath("//input[@formcontrolname='filePathRaw']")).sendKeys("C://local");
        driver.findElement(By.xpath("//input[@formcontrolname='filePathCleansed']")).sendKeys("D://local");
        driver.findElement(By.xpath("//input[@formcontrolname='fileSizeMB']")).sendKeys("10");
        //driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("Type");
        driver.findElement(By.xpath("//input[@formcontrolname='stagingTableName']")).sendKeys("MetadataSourceFile");
        driver.findElement(By.xpath("//input[@formcontrolname='fileDelimiter']")).sendKeys(",");
        driver.findElement(By.xpath("//input[@formcontrolname='headerIdentifier']")).sendKeys(",");
        driver.findElement(By.xpath("//input[@formcontrolname='columnIdentifier']")).sendKeys(",");
    }

    @When("the user should see click on the Submit Button")
    public void the_user_should_click_on_the_Submit_Button() {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        System.out.println("The user is able to click on the Submit Button");
   	 	commonUtilities.screenshot();
    }
    @Then("the user should see {string} in the file list")
    public void the_user_should_see_in_the_file_list(String string) throws InterruptedException {
       String actual= driver.findElement(By.xpath("//*[text()=' Record has been added successFully ']")).getText();
       Assert.assertEquals("Record has been added successFully", actual);
        System.out.println("The user is able to insert the data in the all fields");
        Thread.sleep(2000);
        commonUtilities.screenshot();
    }

    @Then("the user should see validation errors for required fields")
    public void the_user_should_see_validation_errors_for_required_fields() {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        commonUtilities.screenshot();
    }

    @Then("{string} should not be in the file list")
    public void should_not_be_in_the_file_list(String string) {
        driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
        driver.quit();
    }

    @Then("the user click on {string}")
    public void the_user_click_on_button(String string) {
        driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
        System.out.println("The fields are empty");
        commonUtilities.screenshot();
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
        System.out.println("The user is able to close the Add New page");
        commonUtilities.screenshot();
    }

    @When("the user clicks the {string} buttons")
    public void the_user_clicks_the_buttons(String string) {
        // Implementation for this step
    }
}
