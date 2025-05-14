package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.DueDateLookupConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.DueDateLookupTab;

public class DueDateLookupSteps {
	public static String random;
	DueDateLookupTab DueDateLookupTab = new DueDateLookupTab();
	
	@Given("Settlement_Engine <URL> for Due Date Lookup")
	public void settlement_engine_ur_for_Due_Date_Lookup() {
		DueDateLookupTab.openLoginPage();
	}

	@When("the user clicks Settlement Engine_URL for Due Date Lookup")
	public void the_user_clicks_Settlement_Engine_URL_for_Due_Date_Lookup() {
		try {
			
			DueDateLookupTab.verifyHealthCheck();
					
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
	}

	@When("the User clicks on Reference LookUp UI Screen for Due Date LookUP")
	public void the_user_clicks_on_reference_look_up_ui_screen_for_due_Date_LookUP() {
		DueDateLookupTab.clickReferenceLookUpButton();
	}
	
	@Then("the User is able to navigate to the Settlement Engine Homepage for the Due Date LookUP & user is able to see the reference table dropdown")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_Due_Date_LookUP_user_is_able_to_see_the_reference_table_dropdown() {
		DueDateLookupTab.verifyTitle();
	}

	@When("the user select brand_map_lkp from the common reference table")
	public void the_user_Select_brand_map_lkp_from_the_common_reference_table() throws InterruptedException {
		DueDateLookupTab.Due_date_LkpSlectionFromReferenceTableDropdown();
	}

	@When("the user clicks the Add button from the Due Date LookUP page")
	public void the_user_clicks_the_add_button_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.clickBMAddNewButton();
	}

	@When("the user enters the data in required fields for the Due Date LookUP")
	public void the_user_enters_the_data_in_required_fields_for_the_Due_Date_LookUP() {
		DueDateLookupTab.enterBMCategoryFieldValue(DueDateLookupConstants.CLIENT_CODE.getValue(),
		DueDateLookupConstants.DATA_SET.getValue(),DueDateLookupConstants.CAPITAL_TERMS.getValue(),DueDateLookupConstants.MOVEMENT_TYPE.getValue(),
		DueDateLookupConstants.COMISSION_TERMS.getValue(),DueDateLookupConstants.RULE_TYPE.getValue()
		,DueDateLookupConstants.PRODUCE_CODE.getValue(),DueDateLookupConstants.RULE_EXPRESSION.getValue()
		);
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the Due Date LookUP")
	public void the_user_should_see_click_on_the_submit_button_for_the_Due_Date_LookUP() {
		DueDateLookupTab.clickBMSubmitButton();
	}
	
	@Then("the user should see {string} in the file list for the Due Date LookUP")
	public void the_user_should_see_in_the_file_list_for_the_Due_Date_LookUP(String string) throws InterruptedException {
		DueDateLookupTab.verifyBMSuccessPopupMessage();
	}
	@Then("user can search and see the addded same record")
	public void user_can_search_and_see_the_addded_same_record() throws InterruptedException {
		DueDateLookupTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Due Date LookUP and the user should see validation errors for required fields for the Due Date LookUP")
	public void the_user_click_on_any_field_for_the_Due_Date_LookUP() throws InterruptedException {
		DueDateLookupTab.clickBMClientCodeblankSelection();
	}

	@When("the user click on Reset button for the Due Date LookUP")
	public void the_user_click_on_reset_button_for_the_Due_Date_LookUP() {
		DueDateLookupTab.clickBMResetButton();
	}

	@Then("all the fields should be cleared for the Due Date LookUP")
	public void all_the_fields_should_be_cleared_for_the_Due_Date_LookUP() {
		DueDateLookupTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Due Date LookUP")
	public void the_user_click_on_cancel_button_for_the_Due_Date_LookUP() {
		DueDateLookupTab.clickBMCancelButton();
	}

	@Then("Add Pop up should be closed for the Due Date LookUP")
	public void add_pop_up_should_be_closed_for_the_Due_Date_LookUP() {
	   DueDateLookupTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Due Date LookUP")
	public void the_user_click_the_edit_icon_for_the_any_Due_Date_LookUP() {
		DueDateLookupTab.clickBMEditButton();
	}

	@Then("The User should see the edit modal open Due Date LookUP")
	public void the_user_should_see_the_edit_modal_open_Due_Date_LookUP() {
	   DueDateLookupTab.verifyBMCategoryTextVisible();
	}

	@Then("the user update the any field for the Due Date LookUP")
	public void the_user_update_the_any_field_for_the_Due_Date_LookUP() throws InterruptedException {
	 DueDateLookupTab.editClientCodeValue();
	}

	@Then("the user should see click on the Update Button for the Due Date LookUP")
	public void the_user_should_see_click_on_the_update_button_for_the_Due_Date_LookUP() {
		DueDateLookupTab.clickBMUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Due Date LookUP")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_Due_Date_LookUP(String string) {
		DueDateLookupTab.verifyBMUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Due Date LookUP")
	public void the_user_click_the_delete_icon_for_the_any_Due_Date_LookUP() {
		DueDateLookupTab.clickBMDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Due Date LookUP")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_Due_Date_LookUP(String string) {
		DueDateLookupTab.verifyBMDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Due Date LookUP")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_Due_Date_LookUP() {
		DueDateLookupTab.verifyBMDeleteConfirmationPopupCancelButton();
		DueDateLookupTab.verifyBMDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Due Date LookUP")
	public void the_user_confirm_the_deletion_for_the_Due_Date_LookUP() {
		DueDateLookupTab.clickBMDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Due Date LookUP")
	public void the_file_should_be_removed_from_the_table_for_the_Due_Date_LookUP() {
		DueDateLookupTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("user clicks the download all records button for the Due Date LookUP page")
	public void user_clicks_the_download_all_records_button_for_the_Due_Date_LookUP_page() {
	   DueDateLookupTab.clickBMDownloadButton();
	}

	@Then("a file should be downloaded all the records to the default download folder for the Due Date LookUP Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_Due_Date_LookUP_Page() {
		DueDateLookupTab.verifyFileDownloaded();
	}
	// download all approve records

	@When("user clicks the only approved records button for the Due Date LookUP page")
	public void user_clicks_the_only_approved_records_button_for_the_Due_Date_LookUP_page() {
	   DueDateLookupTab.clickBMDownloadAllApproveRecord();
	}

	@Then("a file should be downloaded approved record to the default download folder for the Due Date LookUP page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_Due_Date_LookUP_page() {
		DueDateLookupTab.verifyFileDownloadedAllApproveRecord();
	}
	

	
	@When("the User Navigates to upload Button from the Due Date LookUP page")
	public void the_user_navigates_to_upload_button_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.clickBMUploadButton();
	}

	@When("user selects a valid file to upload from the Due Date LookUP page")
	public void user_selects_a_valid_file_to_upload_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.selectFileToUpload();
	}

	@When("the file should be successfully Uploaded from the Due Date LookUP page")
	public void the_file_should_be_successfully_uploaded_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button from the Due Date LookUP page")
	public void user_click_the_send_for_approval_button_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.clickSendForApprovalButton();
	}

	@Then("the file should be submitted for Approval from the Due Date LookUP page")
	public void the_file_should_be_submitted_for_approval_from_the_Due_Date_LookUP_page() {
		DueDateLookupTab.fileSubmittedForApproval();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Due Date LookUP")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_Due_Date_LookUP() {
		DueDateLookupTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from Due Date LookUP page")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_Due_Date_LookUP_page() {
		DueDateLookupTab.ConfirmButtonSentForApproval();
	}



}
