package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import tabs.DataQualityAssignmentTab;
import utils.DriverManager;
import io.cucumber.java.en.Then;

public class DataQualityAssignmentSteps {
	//WebDriver driver = DriverManager.getDriver();
	//CommonUtilities commonUtilities = new CommonUtilities();
	//WebDriverWait wait;
	DataQualityAssignmentTab DataQualityAssignmentTab = new DataQualityAssignmentTab();

	@Given("Settlement engine")
	public void Settlement_engine() {
		
		DataQualityAssignmentTab.openLoginPage();
	}

	@When("User click the Settlement Engine URL")
	public void User_click_the_Settlement_Engine_URL() {
		try {
			
			DataQualityAssignmentTab.verifyHealthCheck();
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("The User is able to navigate to the settlement Engine homepage")
	public void The_User_is_able_to_navigate_to_the_settlement_Engine_homepage() throws InterruptedException {
		DataQualityAssignmentTab.verifyTitle();
	}
	
	@When("User Clicks on MetaData Button")
	public void the_user_click_on_the_metadata_button() {
		
		DataQualityAssignmentTab.clickMetaDataButton();
	}
	
	@When("User Clicks on Hamburger Button")
	public void the_user_click_on_the_hamburger_icon() {
		
		DataQualityAssignmentTab.clickHamburgerMenuButton();
	}

	@When("the user click on Data Quality Assignment")
	public void the_user_click_on_data_quality_assignment(){
		
		DataQualityAssignmentTab.clickDataQualityAssignmentTab();
	}

	@When("the user clicks the Add New button for the DQ Assignment")
	public void the_user_clicks_the_add_new_button_for_the_dq_assignment() {
		DataQualityAssignmentTab.clickDQAAddNewButton();
	}

	@When("the user enters the data in required fields for the DQ Assignment")
	public void the_user_enters_the_data_in_required_fields_for_the_dq_assignment(){

		DataQualityAssignmentTab.enterDQACategoryFieldValue("tallyman_raw", "product_code");
		
	}
	

	@When("the user should see click on the Submit Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_submit_button_for_the_dq_assignment(){
		
		DataQualityAssignmentTab.clickDQASubmitButton();
	}

	@Then("the user should see {string} in the file list for the DQ Assignment")
	public void the_user_should_see_in_the_file_list_for_the_dq_assignment(String string) throws InterruptedException {
		
		DataQualityAssignmentTab.verifyDQASuccessPopupMessage();
	}

	@When("the user click on any field for the DQ Assignment and validate the mandatory required field message")
	public void the_user_click_on_any_field_for_the_dq_assignment() throws InterruptedException {
		
		DataQualityAssignmentTab.clickDQASourceTableDropdownandblankSelection();
		DataQualityAssignmentTab.clickDQADQRuleDropdownandBlankSelection();
	}

	@When("the user click on Reset button for the DQ Assignment")
	public void the_user_click_on_reset_button_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.clickDQAResetButton();
	}

	@Then("all the fields should be cleared for the DQ Assignment")
	public void all_the_fields_should_be_cleared_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the DQ Assignment")
	public void the_user_click_on_cancel_button_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.clickDQACancelButton();
	}

	@Then("Add New Pop up should be closed for the DQ Assignment")
	public void add_new_pop_up_should_be_closed_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.verifyDQAAssignmentGridVisibleandDataAssignmentCategoryNotVisible();		
	}

	@When("The User click the edit icon for the any file for the DQ Assignment")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.clickDQAEditButton();
	}

	@Then("The User should see the edit modal open file for the DQ Assignment")
	public void the_user_should_see_the_edit_modal_open_file_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.verifyDQACategoryTextVisible();
	}

	@Then("the user update the any field for the DQ Assignment")
	public void the_user_update_the_any_field_for_the_dq_assignment(){
		
		 DataQualityAssignmentTab.enterDQACategoryFieldValue("tallyman_raw", "client_code");
	}

	@Then("the user should see click on the Update Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_update_button_for_the_dq_assignment(){
		
		DataQualityAssignmentTab.clickDQAUpdateButton();	
	}

	@Then("the user should see the updated {string} in the file list for the DQ Assignment")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_dq_assignment(String string) {
		
		DataQualityAssignmentTab.verifyDQASuccessPopupMessage();		
	}

	@When("The User click the delete icon for the any file for the DQ Assignment")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.clickDQADeleteButton();
	}

	@Then("The User should see a confirmation pop-up with message {string} for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_dq_assignment(String string) {
		
		DataQualityAssignmentTab.verifyDQADeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.verifyDQADeleteConfirmationPopupCancelButton();
		DataQualityAssignmentTab.verifyDQADeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the DQ Assignment")
	public void the_user_confirm_the_deletion_for_the_dq_assignment() {
		
		DataQualityAssignmentTab.clickDQADeleteConfirmationPopupConfirmButton();	
	}

//	@Then("the file should be removed from the table for the DQ Assignment")
//	public void the_file_should_be_removed_from_the_table_for_the_dq_assignment() {
//		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
//		driver.quit();
//	}

}
