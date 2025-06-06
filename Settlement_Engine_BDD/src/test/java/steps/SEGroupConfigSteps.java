package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.SEGroupConfigTab;

import java.io.IOException;

import constants.EmailAlertConstants;


public class SEGroupConfigSteps {
	public static String random;
	SEGroupConfigTab SEGroupConfigTab = new SEGroupConfigTab();
	
	@Given("The Settlement Engine<URL> for SE Group Config UI")
	public void the_settlement_engine_url_for_SE_Group_Config() {
		SEGroupConfigTab.openLoginPage();
	}

	@When("user hit the Settlement Engine URL for SE Group Config UI")
	public void user_hit_the_settlement_engine_url_for_SE_Group_Config() {	
		try {

			SEGroupConfigTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("the user clicks on MetaData UI screen")
	public void the_user_clicks_on_SE_Group_Config_ui_screen() {
		SEGroupConfigTab.clickMetaDataButton();
	}

	@Then("the user is able to Navigate to the Settlement Engine SE Group Config page UI")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_SE_Group_Config_UI() {
		SEGroupConfigTab.verifyTitle();
	}

	@Then("User clicks on Hamburger Button for SE Group Config UI")
	public void user_clicks_on_hamburger_button_for_SE_Group_Config() {
		SEGroupConfigTab.clickHamburgerMenuButton();
	}

	@When("the user click on SE Group Config")
	public void the_user_click_on_SE_Group_Config() {
		SEGroupConfigTab.clickSeGroupConfigTab();
	}

	@When("the user clicks the Add New button for the Email Alert")
	public void the_user_clicks_the_add_new_button_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEAAddNewButton();
	}

	@When("the user enters the data in required fields for the Email Alert")
	public void the_user_enters_the_data_in_required_fields_for_the_SE_Group_Config() {
		
		SEGroupConfigTab.enterEAFieldValue(EmailAlertConstants.TEMPLATE_TYPE.getValue(),
				EmailAlertConstants.EMAIL_ADDRESS.getValue(), EmailAlertConstants.SUBJECT.getValue(),
				EmailAlertConstants.INSERT_TEXT.getValue());
		System.out.println("The user is able to enter the data in required fields");
	}

	@When("the user should see click on the Submit Button for the file for the Email Alert")
	public void the_user_should_see_click_on_the_submit_button_for_the_file_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEASubmitButton();
	}

	@Then("the user should see {string} in the file list for the file email")
	public void the_user_should_see_in_the_file_list_for_the_file_email(String string) {
		SEGroupConfigTab.verifyEASuccessPopupMessage();
	}

	@Then("user can search and see the addded same record for Email Record")
	public void user_can_search_and_see_the_addded_same_record_for_Email_Record() throws InterruptedException {
		SEGroupConfigTab.AddedRecorddSearch();
	}
	@When("the user click on any field for the Email Alert and the user should see validation errors for required fields for the Email Alert")
	public void the_user_click_on_any_field_for_the_SE_Group_Config_and_the_user_should_see_validation_errors_for_required_fields_for_the_SE_Group_Config() {
     SEGroupConfigTab.clickSEGroupConfigblankSelection();
	}

	@When("the user click on Reset button for the Email Alert")
	public void the_user_click_on_reset_button_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEAResetButton();
	}

	@Then("all the fields should be cleared for the Email Alert")
	public void all_the_fields_should_be_cleared_for_the_SE_Group_Config() {
		SEGroupConfigTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Email Alert")
	public void the_user_click_on_cancel_button_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEACancelButton();
	}

	@Then("Add New Pop up should be closed for the Email Alert")
	public void add_new_pop_up_should_be_closed_for_the_SE_Group_Config() {
		SEGroupConfigTab.verifyEACategoryTextVisible();
	}

	@When("The User click the edit icon for the any file for the Email Alert")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEAEditButton();
	}

	@Then("The User should see the edit modal open file for the Email Alert")
	public void the_user_should_see_the_edit_modal_open_file_for_the_SE_Group_Config() {
		SEGroupConfigTab.verifyEACategoryTextVisible();
	}

	@Then("the user update the any field for the Email Alert")
	public void the_user_update_the_any_field_for_the_SE_Group_Config() {
		SEGroupConfigTab.editEmailAddressValue();
	}

	@Then("the user should see click on the Update Button for the Email Alert")
	public void the_user_should_see_click_on_the_update_button_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEAUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Email Alert")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_SE_Group_Config(String string) {
		SEGroupConfigTab.verifyEAUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any file for the Email Alert")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEADeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Email Alert")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_SE_Group_Config(String string) {
		SEGroupConfigTab.verifyEADeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Email Alert")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_SE_Group_Config() {
		SEGroupConfigTab.verifyEADeleteConfirmationPopupCancelButton();
		SEGroupConfigTab.verifyEADeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Email Alert")
	public void the_user_confirm_the_deletion_for_the_SE_Group_Config() {
		SEGroupConfigTab.clickEADeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Email Alert")
	public void the_file_should_be_removed_from_the_table_for_the_SE_Group_Config() {
		SEGroupConfigTab.verifyEAFileRemoval();
	}



}
