package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.MovMappingLookupConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.MovMappingLookupTab;

public class MovMappingLookupSteps {
	public static String random;
	MovMappingLookupTab MovMappingLookupTab = new MovMappingLookupTab();
	
	@Given("Settlement_Engine <URL> for Mov Mapping LookUP")
	public void settlement_engine_url() {
		MovMappingLookupTab.openLoginPage();
	}

	@When("the user clicks settlement engine URL")
	public void the_user_clicks_settlement_engine_URL() {
		try {
			
			MovMappingLookupTab.verifyHealthCheck();
					
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
	}

	@When("the User clicks on reference lookUp UI Screen")
	public void the_User_clicks_on_reference_lookUp_UI_Screen() {
		MovMappingLookupTab.clickReferenceLookUpButton();
	}
	
	@Then("the User is able to navigate to the Settlement Engine Homepage for the Mov Mapping LookUP & user is able to see the reference table dropdown")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_move_mapping_user_is_able_to_see_the_reference_table_dropdown() {
		MovMappingLookupTab.verifyTitle();
	}

	@When("the user select move_mapping_lkp from the common reference table")
	public void the_user_select_move_mapping_lkp_from_the_common_reference_table() throws InterruptedException {
		MovMappingLookupTab.Move_Mapping_LkpSlectionFromReferenceTableDropdown();
	}

	@When("the user clicks the Add button from the Mov Mapping LookUP page")
	public void the_user_clicks_the_add_button_from_the_move_mapping_page() {
		MovMappingLookupTab.clickMMAddNewButton();
	}

	@When("the user enters the data in required fields for the Mov Mapping LookUP")
	public void the_user_enters_the_data_in_required_fields_for_the_move_mapping() {
		MovMappingLookupTab.enterMMCategoryFieldValue(MovMappingLookupConstants.MOVEMENT_TYPE.getValue(),
		MovMappingLookupConstants.DESCRIPTION.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the Mov Mapping LookUP")
	public void the_user_should_see_click_on_the_suMMit_button_for_the_move_mapping() {
		MovMappingLookupTab.clickMMSuMMitButton();
	}
	
	@Then("the user should see {string} in the file list for the Mov Mapping LookUP")
	public void the_user_should_see_in_the_file_list_for_the_move_mapping(String string) throws InterruptedException {
		MovMappingLookupTab.verifyMMSuccessPopupMessage();
	}
	@Then("user can search and see the addded same record for Mov Mapping LookUP")
	public void user_can_search_and_see_the_addded_same_record_for_move_mapping() throws InterruptedException {
		MovMappingLookupTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Mov Mapping LookUP and the user should see validation errors for required fields for the Mov Mapping LookUP")
	public void the_user_click_on_any_field_for_the_move_mapping() throws InterruptedException {
		MovMappingLookupTab.clickMMClientCodeblankSelection();
	}

	@When("the user click on Reset button for the Mov Mapping LookUP")
	public void the_user_click_on_reset_button_for_the_move_mapping() {
		MovMappingLookupTab.clickMMResetButton();
	}

	@Then("all the fields should be cleared for the Mov Mapping LookUP")
	public void all_the_fields_should_be_cleared_for_the_move_mapping() {
		MovMappingLookupTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Mov Mapping LookUP")
	public void the_user_click_on_cancel_button_for_the_move_mapping() {
		MovMappingLookupTab.clickMMCancelButton();
	}

	@Then("Add Pop up should be closed for the Mov Mapping LookUP")
	public void add_pop_up_should_be_closed_for_the_move_mapping() {
	   MovMappingLookupTab.verifyMMGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Mov Mapping LookUP")
	public void the_user_click_the_edit_icon_for_the_any_move_mapping() {
		MovMappingLookupTab.clickMMEditButton();
	}

	@Then("The User should see the edit modal open Mov Mapping LookUP")
	public void the_user_should_see_the_edit_modal_open_move_mapping() {
	   MovMappingLookupTab.verifyMMCategoryTextVisible();
	}

	@Then("the user update the any field for the Mov Mapping LookUP")
	public void the_user_update_the_any_field_for_the_move_mapping() {
	 MovMappingLookupTab.editClientCodeValue();
	}

	@Then("the user should see click on the Update Button for the Mov Mapping LookUP")
	public void the_user_should_see_click_on_the_update_button_for_the_move_mapping() {
		MovMappingLookupTab.clickMMUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Mov Mapping LookUP")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_move_mapping(String string) {
		MovMappingLookupTab.verifyMMUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Mov Mapping LookUP")
	public void the_user_click_the_delete_icon_for_the_any_move_mapping() {
		MovMappingLookupTab.clickMMDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Mov Mapping LookUP")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_move_mapping(String string) {
		MovMappingLookupTab.verifyMMDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Mov Mapping LookUP")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_move_mapping() {
		MovMappingLookupTab.verifyMMDeleteConfirmationPopupCancelButton();
		MovMappingLookupTab.verifyMMDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Mov Mapping LookUP")
	public void the_user_confirm_the_deletion_for_the_move_mapping() {
		MovMappingLookupTab.clickMMDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Mov Mapping LookUP")
	public void the_file_should_be_removed_from_the_table_for_the_move_mapping() {
		MovMappingLookupTab.verifyMMGridVisibleandFileInformationNotVisible();
	}

	@When("user clicks the download all records button for the Mov Mapping LookUP page")
	public void user_clicks_the_download_all_records_button_for_the_move_mapping_page() {
	   MovMappingLookupTab.clickMMDownloadButton();
	}

	@Then("a file should be downloaded all the records to the default download folder for the Mov Mapping LookUP Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_move_mapping_Page() {
		MovMappingLookupTab.verifyFileDownloaded();
	}
	// download all approve records

	@When("user clicks the only approved records button for the Mov Mapping LookUP page")
	public void user_clicks_the_only_approved_records_button_for_the_move_mapping_page() {
	   MovMappingLookupTab.clickMMDownloadAllApproveRecord();
	}

	@Then("a file should be downloaded approved record to the default download folder for the Mov Mapping LookUP page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_move_mapping_page() {
		MovMappingLookupTab.verifyFileDownloadedAllApproveRecord();
	}
	

	
	@When("the User Navigates to upload Button from the Mov Mapping LookUP page")
	public void the_user_navigates_to_upload_button_from_the_move_mapping_page() {
		MovMappingLookupTab.clickMMUploadButton();
	}

	@When("user selects a valid file to upload from the Mov Mapping LookUP page")
	public void user_selects_a_valid_file_to_upload_from_the_move_mapping_page() {
		MovMappingLookupTab.selectFileToUpload();
	}

	@When("the file should be successfully Uploaded from the Mov Mapping LookUP page")
	public void the_file_should_be_successfully_uploaded_from_the_move_mapping_page() {
		MovMappingLookupTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button from the Mov Mapping LookUP page")
	public void user_click_the_send_for_approval_button_from_the_move_mapping_page() {
		MovMappingLookupTab.clickSendForApprovalButton();
	}

	@Then("the file should be sumitted for Approval from the Mov Mapping LookUP page")
	public void the_file_should_be_sumitted_for_Approval_from_the_Mov_Mapping_LookUP_page() {
		MovMappingLookupTab.fileSuMMittedForApproval();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Mov Mapping LookUP")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_move_mapping() {
		MovMappingLookupTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from Mov Mapping LookUP page")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_move_mapping_page() {
		MovMappingLookupTab.ConfirmButtonSentForApproval();
	}



}
