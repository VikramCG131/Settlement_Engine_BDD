package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MetaDataColumnsSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;
	
	@When("the user click on Metadata Column")
	public void the_user_click_on_metadata_column() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Meta Data Column')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Meta Data Column page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button from the Metadata Column page")
	public void the_user_clicks_the_add_new_button_from_the_metadata_column_page() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the Metadata Column")
	public void the_user_enters_the_data_in_required_fields_for_the_metadata_column() {
		driver.findElement(By.xpath("//div[@class='form-group col-md-4']")).getText();
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='columnName']")).sendKeys("TestAutomation" + random);
		driver.findElement(By.xpath("//input[@formcontrolname='columnDataType']")).sendKeys("csv");
		driver.findElement(By.xpath("//div[3]/div[1]/label[@for='columnIsActiveYes']")).click();
		driver.findElement(By.xpath("//div[4]/div[2]/label[@for='columnIsNullNo']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='minSize']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@formcontrolname='maxSize']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@formcontrolname='columnOrder']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@formcontrolname='columnDateFormat']")).sendKeys("2025-03-26");
		driver.findElement(By.xpath("//input[@formcontrolname='columnDescription']")).sendKeys("Test Automation");
		
		System.out.println("The user is able to enter the data in required fields");
	}

	@When("the user should see click on the Submit Button for the Metadata Column")
	public void the_user_should_see_click_on_the_submit_button_for_the_metadata_column() {
	    
	}

	@Then("the user should see {string} in the file list for the Metadata Column")
	public void the_user_should_see_in_the_file_list_for_the_metadata_column(String string) {
	   
	}

	@When("the user click on any field for the Metadata Column")
	public void the_user_click_on_any_field_for_the_metadata_column() {
	    
	}

	@Then("the user should see validation errors for required fields for the Metadata Column")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user click on Reset button for the Metadata Column")
	public void the_user_click_on_reset_button_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("all the fields should be cleared for the Metadata Column")
	public void all_the_fields_should_be_cleared_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user click on Cancel button for the Metadata Column")
	public void the_user_click_on_cancel_button_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Add New Pop up should be closed for the Metadata Column")
	public void add_new_pop_up_should_be_closed_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User click the edit icon for the any Metadata Column")
	public void the_user_click_the_edit_icon_for_the_any_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see the edit modal open Metadata Column")
	public void the_user_should_see_the_edit_modal_open_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user update the any field for the Metadata Column")
	public void the_user_update_the_any_field_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see click on the Update Button for the Metadata Column")
	public void the_user_should_see_click_on_the_update_button_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see the updated {string} in the file list for the Metadata Column")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_metadata_column(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User click the delete icon for the any Metadata Column")
	public void the_user_click_the_delete_icon_for_the_any_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Metadata Column")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_metadata_column(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see {string} message for the Metadata Column")
	public void the_user_should_see_message_for_the_metadata_column(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Metadata Column")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User confirm the deletion for the Metadata Column")
	public void the_user_confirm_the_deletion_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the file should be removed from the table for the Metadata Column")
	public void the_file_should_be_removed_from_the_table_for_the_metadata_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




}
