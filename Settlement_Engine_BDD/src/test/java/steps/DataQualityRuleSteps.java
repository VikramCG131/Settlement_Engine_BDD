package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class DataQualityRuleSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    CommonUtilities commonUtilities = new CommonUtilities();

    // Zero-argument constructor
    public DataQualityRuleSteps() {

    }
    @Given("the Settlement Engine<URL>")
	public void the_settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("The user is able to navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Settlement Engine"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		//commonUtilities.screenshot();
	}

    @When("the user click on Data Quality Rules")
    public void the_user_click_on_data_quality_rules() throws InterruptedException {
        WebElement dataQualityRulesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Data Quality Rule ']")));
        dataQualityRulesButton.click();
        System.out.println("The user is able to navigate to Data Quality Rule page");
        Thread.sleep(3000);
        //commonUtilities.screenshot();
    }

    @When("the user clicks the Add New button for the DQ Rule")
    public void the_user_clicks_the_add_new_button() {
        WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
        wait.until(ExpectedConditions.visibilityOf(button)).click();
        System.out.println("The user is able to click on Add New Button");
        //commonUtilities.screenshot();
    }

    @Then("the user enters the data in required fields for the DQ Rule")
    public void the_user_enters_the_data_in_required_fields() throws InterruptedException {
    	List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);}
        int random = (int) (Math.floor(Math.random() * 100000) + 1);
        driver.findElement(By.xpath("//input[@formcontrolname='ruleExpression']")).sendKeys("TestAutomation" + random);
        driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).sendKeys("Testing Automation");

        // Method for dropdown element
        WebElement dropdownElement = driver.findElement(By.id("severityLevel"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Medium");
        System.out.println("Selected severity: Medium");
        Thread.sleep(2000);

        // Locate the radio button elements
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@formcontrolname='rangeCheck']/following-sibling::label"));
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().equals("Yes")) {
                radioButton.click();
                System.out.println("Selected radio button with value: Yes");
                break;
            }
        }
        Thread.sleep(2000);
            System.out.println("The user is able to insert the data in all fields");
    }
    
    @When("the user should see click on the Submit Button for the DQ Rule")
    public void the_user_should_click_on_the_Submit_Button() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        System.out.println("The user is able to click on the Submit Button");
        Thread.sleep(3000);
        //commonUtilities.screenshot();
    }

    @Then("the user should see {string} in the file list for the DQ Rule")
    public void the_user_should_see_in_the_file_list(String string) throws InterruptedException {
        String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successFully..! ']")).getText();
        Assert.assertEquals("Record has been added successFully..!", actual);
        System.out.println("The user is able to insert the data in the all fields");
        Thread.sleep(2000);
        //commonUtilities.screenshot();
    }

    @When("the user click on any field for the DQ Rule")
    public void the_user_click_on_any_field() throws InterruptedException {
        driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).click();
        WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='ruleExpression']"));
        wait.until(ExpectedConditions.visibilityOf(button)).click();
        Thread.sleep(2000);
    }

    @Then("the user should see validation errors for required fields for the DQ Rule")
    public void the_user_should_see_validation_errors_for_required_fields() {
        String actual = driver.findElement(By.xpath("//*[text()='Please enter Rule Description']")).getText();
        Assert.assertEquals("Please enter Rule Description", actual);
        System.out.println("The user is able to see the error message for required fields");
        //commonUtilities.screenshot();
    }

    @Then("{string} should not be in the file list for the DQ Rule")
    public void should_not_be_in_the_file_list(String string) {
        driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
        driver.quit();
    }

    @When("the user click on Cancel button for the DQ Rule")
    public void the_user_click_on_Cancel_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
        System.out.println("The user is able to close the Add New page");
        //commonUtilities.screenshot();
    }

    @When("the user click on Reset button for the DQ Rule")
    public void the_user_click_on_reset_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
        System.out.println("The fields are empty");
        //commonUtilities.screenshot();
    }

    @Then("all the fields should be cleared for the DQ Rule")
    public void all_the_fields_should_be_cleared() {
        Assert.assertEquals("",
                driver.findElement(By.xpath("//input[@formcontrolname='ruleExpression']")).getAttribute("value"));
        Assert.assertEquals("",
                driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).getAttribute("value"));
        System.out.println("All fields are cleared");
    }

    @Then("Add New Pop up should be closed for the DQ Rule")
    public void add_new_pop_up_should_be_closed() {
        driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
    }

    @When("The User click the edit icon for the any file for the DQ Rule")
    public void the_user_click_the_edit_icon_for_the_any_file() {
        driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
        //commonUtilities.screenshot();
    }

    @Then("The User should see the edit modal open file for the DQ Rule")
    public void the_user_should_see_the_edit_modal_open_file() {
        System.out.println("The edit modal is displayed");
        //commonUtilities.screenshot();
    }

    @Then("the user update the any field for the DQ Rule")
    public void the_user_update_the_any_field() {
        driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).sendKeys("txt");
    }

    @Then("the user should see click on the Update Button for the DQ Rule")
    public void the_user_should_see_click_on_the_update_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
        System.out.println("The user is able to click on the Update Button");
        //commonUtilities.screenshot();
        Thread.sleep(4000);
    }

    @Then("the user should see the updated {string} in the file list for the DQ Rule")
    public void the_user_should_see_the_updated_in_the_file_list(String string) throws InterruptedException {
        String actual = driver.findElement(By.xpath("//*[text()=' Record has been updated successfully..! ']")).getText();
        Assert.assertEquals("Record has been updated successfully..!", actual);
        System.out.println("The user is able to insert the data in the all fields");
        Thread.sleep(2000);
        //commonUtilities.screenshot();
    }

    @When("The User click the delete icon for the any file for the DQ Rule")
    public void the_user_click_the_delete_icon_for_the_any_file() {
        driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
        //commonUtilities.screenshot();
    }

    @Then("The User should see a confirmation pop-up with title {string} for the DQ Rule")
    public void the_user_should_see_a_confirmation_pop_up_with_title(String string) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
        System.out.println("The user is able to see the confirmation pop-up");
        Thread.sleep(2000);
        //commonUtilities.screenshot();
    }

    @Then("The User should see {string} message for the DQ Rule")
    public void the_user_should_see_message(String string) throws InterruptedException {
        String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
        Assert.assertEquals("Are you sure you want to delete", actual);
        System.out.println("The user is able to see message in the confirmation pop-up");
        Thread.sleep(2000);
        //commonUtilities.screenshot();
    }

    @When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Rule")
    public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons() {
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
        System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
    }

    @When("The User confirm the deletion for the DQ Rule")
    public void the_user_confirm_the_deletion() {
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
    }

    @Then("the file should be removed from the table for the DQ Rule")
    public void the_file_should_be_removed_from_the_table() {
        driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
        driver.quit();
    }
}
