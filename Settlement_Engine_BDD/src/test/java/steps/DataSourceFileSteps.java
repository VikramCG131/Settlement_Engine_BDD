package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import tabs.DataSourceFileTab;
import Utilities.CommonUtilities;
import constants.DataSourceFileConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import tabs.DataQualityAssignmentTab;
import io.cucumber.java.en.Then;

public class DataSourceFileSteps {
	WebDriver driver;
	public static String random;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;
	DataSourceFileTab DataSourceFileTab = new DataSourceFileTab();

	@Given("The Settlement Engine<URL>")
	public void the_settlement_engine_url() {
		DataSourceFileTab.openLoginPage();
	}

	@When("user hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		try {

			DataSourceFileTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("the user is able to Navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_Navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		DataSourceFileTab.verifyTitle();
	}

	@When("the user clicks on Metadata UI Screen")
	public void the_user_clicks_on_metadata_ui_screen() {
		DataSourceFileTab.clickMetaDataButton();
	}

	@When("User clicks on Hamburger Button")
	public void click_on_Hamburger_button() {
		DataSourceFileTab.clickHamburgerMenuButton();
	}

	@When("the user click on Data Source File")
	public void the_user_click_on_data_source_file() throws InterruptedException {
		DataSourceFileTab.clickDataSourceFileTab();
	}

	@When("the user clicks the Add New button from the Data Source File page")
	public void the_user_clicks_the_add_new_button() {
		DataSourceFileTab.clickDSFAddNewButton();
	}

	@Then("the user enters the data in required fields for the Data Source File")
	public void the_user_enters_the_data_in_required_fields() throws InterruptedException {
		
		DataSourceFileTab.enterDSFFieldValue(DataSourceFileConstants.FILE_NAME.getValue(),
				 DataSourceFileConstants.FILE_PATTERN.getValue(),
				
				DataSourceFileConstants.FILE_MAX_SIZE.getValue(), DataSourceFileConstants.FILE_TABLE_NAME.getValue());
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the file")
	public void the_user_should_click_on_the_Submit_Button() throws InterruptedException {
		DataSourceFileTab.clickDSFSubmitButton();
	}

	@Then("the user should see {string} in the file list for the file")
	public void the_user_should_see_in_the_file_list(String string) throws InterruptedException {
		DataSourceFileTab.verifyDSFSuccessPopupMessage();
	}
	
	
	
	@When("the user click on any field for the Data source file and validate the mandatory required field message")
	public void the_user_click_on_any_field() throws InterruptedException {
		DataSourceFileTab.clickDSFFilePatternblankSelection();
	}
/*
	@Then("{string} should not be in the file list for the file")
	public void should_not_be_in_the_file_list(String string) {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
	}
	*/

	@When("the user click on Cancel button for the file")
	public void the_user_click_on_Cancel_button() {
		DataSourceFileTab.clickDSFCancelButton();
	}

	@When("the user click on Reset button for the file")
	public void the_user_click_on_reset_button() {
		DataSourceFileTab.clickDSFResetButton();
	}

	@Then("all the fields should be cleared for the file")
	public void all_the_fields_should_be_cleared() {
		DataSourceFileTab.verifyAllFieldsClearedforResetButton();
	}

	@Then("Add New Pop up should be closed for the file")
	public void add_new_pop_up_should_be_closed() {
		DataSourceFileTab.verifyDSFGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Data Source file")
	public void the_user_click_the_edit_icon_for_the_any_file() {
		DataSourceFileTab.clickDSFEditButton();
	}

	@Then("The User should see the edit modal open Data Source file")
	public void the_user_should_see_the_edit_modal_open_file() {
		DataSourceFileTab.verifyDSFCategoryTextVisible();
	}

	@Then("the user update the any field for the file")
	public void the_user_update_the_any_field()throws InterruptedException {
		DataSourceFileTab.editDSFFieldValue();
	}

	@Then("the user should see click on the Update Button for the file")
	public void the_user_should_see_click_on_the_update_button() throws InterruptedException {
		DataSourceFileTab.clickDSFUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Data Source file")
	public void the_user_should_see_the_updated_in_the_file_list(String string) throws InterruptedException {
		DataSourceFileTab.verifyDSFUpdatePopupMessage();
	}

	
	@When("The User click the delete icon for the any Data Source file")
	public void the_user_click_the_delete_icon_for_the_any_file() {
		DataSourceFileTab.clickDSFDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the file")
	public void the_user_should_see_a_confirmation_pop_up_with_title(String string) throws InterruptedException {
		DataSourceFileTab.verifyDSFDeleteConfirmationPopupMessage();
	}

	@Then("The User should see {string} message for the file")
	public void the_user_should_see_message(String string) throws InterruptedException {
		DataSourceFileTab.clickDSFDeleteConfirmationPopupConfirmButton();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Data Source file")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons() {
		DataSourceFileTab.verifyDSFDeleteConfirmationPopupCancelButton();
		DataSourceFileTab.verifyDSFDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Data Source file")
	public void the_user_confirm_the_deletion() {
		DataSourceFileTab.clickDSFDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Data Source file")
	public void the_file_should_be_removed_from_the_table() {
		DataSourceFileTab.verifyDSFGridVisibleandFileInformationNotVisible();
	}
}
