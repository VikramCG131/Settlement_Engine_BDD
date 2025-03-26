package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
public class DataQualityAssignmentSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;

	@Given("the Settlement Engine<URL>")
	public void the_settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:62963");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:62963"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}
	
	
	
	@Then("The user is able to navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}

	@When("the user click on Data Quality Assignment")
	public void the_user_click_on_data_quality_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Data Quality Assignment')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Data Source File page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button for the DQ Assignment")
	public void the_user_clicks_the_add_new_button_for_the_dq_assignment() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the DQ Assignment")
	public void the_user_enters_the_data_in_required_fields_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user should see click on the Submit Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_submit_button_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("the user should see {string} in the file list for the DQ Assignment")
	public void the_user_should_see_in_the_file_list_for_the_dq_assignment(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successFully ']")).getText();
		Assert.assertEquals("Record has been added successFully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("the user click on any field for the DQ Assignment")
	public void the_user_click_on_any_field_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see validation errors for required fields for the DQ Assignment")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user click on Reset button for the DQ Assignment")
	public void the_user_click_on_reset_button_for_the_dq_assignment() {
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the DQ Assignment")
	public void all_the_fields_should_be_cleared_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user click on Cancel button for the DQ Assignment")
	public void the_user_click_on_cancel_button_for_the_dq_assignment() {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}

	@Then("Add New Pop up should be closed for the DQ Assignment")
	public void add_new_pop_up_should_be_closed_for_the_dq_assignment() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
	}

	@When("The User click the edit icon for the any file for the DQ Assignment")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_dq_assignment() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see the edit modal open file for the DQ Assignment")
	public void the_user_should_see_the_edit_modal_open_file_for_the_dq_assignment() {
		boolean file = driver.findElement(By.xpath("//*[text()='File Information']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='File Information']")).getText();
		Assert.assertEquals("File Information", actual);		
		System.out.println("The edit modal is displayed");
		commonUtilities.screenshot();
	}

	@Then("the user update the any field for the DQ Assignment")
	public void the_user_update_the_any_field_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see click on the Update Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_update_button_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(2000);
	}

	@Then("the user should see the updated {string} in the file list for the DQ Assignment")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_dq_assignment(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been Updated successFully ']")).getText();
		Assert.assertEquals("Record has been Updated successFully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User click the delete icon for the any file for the DQ Assignment")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_dq_assignment() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_dq_assignment(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see {string} message for the DQ Assignment")
	public void the_user_should_see_message_for_the_dq_assignment(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User confirm the deletion for the DQ Assignment")
	public void the_user_confirm_the_deletion_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the file should be removed from the table for the DQ Assignment")
	public void the_file_should_be_removed_from_the_table_for_the_dq_assignment() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
