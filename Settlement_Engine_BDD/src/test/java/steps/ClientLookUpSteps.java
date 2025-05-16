package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.ClientLookUpConstants;
import constants.DataSourceFileConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.ClientLookUpTab;

public class ClientLookUpSteps {
	public static String random;
	ClientLookUpTab ClientLookUpTab = new ClientLookUpTab();

	@Given("Settlement_Engine<URL> for Client LookUp page")
	public void settlement_engine_url_for_client_look_up_page() {
		ClientLookUpTab.openLoginPage();
	}

	@When("the user clicks Settlement Engine URL for Client LookUp page")
	public void the_user_clicks_settlement_engine_url_for_client_look_up_page() {
		try {

			ClientLookUpTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("the User clicks on Reference LookUp UI screen")
	public void the_User_clicks_on_Reference_LookUp_UI_screen() {
		ClientLookUpTab.clickReferenceLookUpButton();
	}

	@Then("the User is able to navigate to the Settlement Engine Homepage for the Client Lookup & user is able to see the reference table dropdown")
	public void The_User_is_able_to_navigate_to_the_settlement_Engine_Homepage() {
		ClientLookUpTab.verifyTitle();
	}

	@When("the user select client_lkp from the common reference table")
	public void the_user_select_client_lkp_from_the_common_reference_table() throws InterruptedException {
		ClientLookUpTab.Client_LkpSlectionFromReferenceTableDropdown();
	}

	@When("the user clicks the Add button from the Client LookUp page")
	public void the_user_clicks_the_add_button_from_the_client_look_up_page() {
		ClientLookUpTab.clickCLUAddNewButton();
	}

	@When("the user enters the data in required fields for the Client LookUp")
	
	public void the_user_enters_the_data_in_required_fields_for_the_client_look_up() throws InterruptedException {
		ClientLookUpTab.enterCLUCategoryFieldValue(ClientLookUpConstants.PAYABLE_ELEMENT_2.getValue(),ClientLookUpConstants.ADVANCE_COMMISSION.getValue(), ClientLookUpConstants.SHOP_CODE.getValue(),ClientLookUpConstants.SHOPE_NAME.getValue(),ClientLookUpConstants.DATA_SOURCE_TYPE.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}
		
	@When("the user should see click on the Submit Button for the Client LookUp")
	public void the_user_should_see_click_on_the_submit_button_for_the_client_look_up() {
		ClientLookUpTab.clickCLUSubmitButton();
	}

	@Then("the user should see {string} in the file list for the Client LookUp")
	public void the_user_should_see_in_the_file_list_for_the_client_look_up(String string) {
		ClientLookUpTab.verifyCLUSuccessPopupMessage();
	}

	@Then("user can search and see the addded same record for the Client Lookup")
	public void user_can_search_and_see_the_addded_same_recor_for_the_Client_Lookup() throws InterruptedException {
		ClientLookUpTab.AddedRecorddSearch();
	}

	@When("the user click on any field for the Client LookUp and the user should see validation errors for required fields for the Client LookUp")
	public void the_user_click_on_any_field_for_the_client_look_up() throws InterruptedException {
		ClientLookUpTab.clickCLUPayableElement2blankSelection();
	}

	@When("the user click on Reset button for the Client LookUp")
	public void the_user_click_on_reset_button_for_the_client_look_up() {
		ClientLookUpTab.clickCLUResetButton();
	}

	@Then("all the fields should be cleared for the Client LookUp")
	public void all_the_fields_should_be_cleared_for_the_client_look_up() {
		ClientLookUpTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Client LookUp")
	public void the_user_click_on_cancel_button_for_the_client_look_up() {
		ClientLookUpTab.clickCLUCancelButton();
	}

	@Then("Add Pop up should be closed for the Client LookUp")
	public void add_pop_up_should_be_closed_for_the_client_look_up() {
		ClientLookUpTab.verifyCLUCategoryTextVisible();
	}

	@When("The User click the edit icon for the any Client LookUp")
	public void the_user_click_the_edit_icon_for_the_any_client_look_up() throws InterruptedException {
		ClientLookUpTab.clickCLUEditButton();
	}

	@Then("The User should see the edit modal open Client LookUp")
	public void the_user_should_see_the_edit_modal_open_client_look_up() {
		ClientLookUpTab.verifyCLUCategoryTextVisible();
	}

	@Then("the user update the any field for the Client LookUp")
	public void the_user_update_the_any_field_for_the_client_look_up() {
		ClientLookUpTab.editadvanceComissionValue();
	}

	@Then("the user should see click on the Update Button for the Client LookUp")
	public void the_user_should_see_click_on_the_update_button_for_the_client_look_up() {
		ClientLookUpTab.clickCLUUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Client LookUp")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_client_look_up(String string) {
		ClientLookUpTab.verifyCLUUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Client LookUp")
	public void the_user_click_the_delete_icon_for_the_any_client_look_up() {
		ClientLookUpTab.clickCLUDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with message {string} for the Client LookUp")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_dq_assignment(String string) {
		ClientLookUpTab.verifyCLUDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client LookUp")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_client_look_up() {
		ClientLookUpTab.verifyCLUDeleteConfirmationPopupCancelButton();
		ClientLookUpTab.verifyCLUDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Client LookUp")
	public void the_user_confirm_the_deletion_for_the_client_look_up() {
		ClientLookUpTab.clickCLUDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Client LookUp")
	public void the_file_should_be_removed_from_the_table_for_the_client_look_up() {
		ClientLookUpTab.verifyCLUFileRemoval();
	}

	@When("user clicks the download all records button for the Client Lookup page")
	public void user_clicks_the_download_all_records_button_for_the_Client_Lookup_page() {
		ClientLookUpTab.clickCLUDownloadButton();
	}

	@Then("a file should be downloaded all the records to the default download folder for the Client Lookup Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_Client_Lookup_Page() {
		ClientLookUpTab.verifyFileDownloaded();
	}

	// download approve record only
	
	@When("user clicks the only approved records button for the Client Lookup page")
	public void user_clicks_the_only_approved_records_button_for_the_Client_Lookup_page() {
		ClientLookUpTab.clickCLUDownloadButtonAllapproverecord();
	}

	@Then("a file should be downloaded approved record to the default download folder for the Client Lookup page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_Client_Lookup_page() {
		ClientLookUpTab.verifyFileDownloadedAllApproveRecords();
	}
	
	
	@When("the User Navigates to upload Button")
	public void the_user_navigates_to_upload_button() {
		ClientLookUpTab.clickCLUUploadButton();
	}

	@When("user selects a valid file to upload")
	public void user_selects_a_valid_file_to_upload() {
		ClientLookUpTab.selectFileToUpload();
	}

	@When("the file should be successfully uploaded")
	public void the_file_should_be_successfully_uploaded() {
		ClientLookUpTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button")
	public void user_click_the_send_for_approval_button() {
		ClientLookUpTab.clickSendForApprovalButton();
	}

	@Then("the file should be submitted for approval")
	public void the_file_should_be_submitted_for_approval() {
		ClientLookUpTab.fileSubmittedForApproval();

	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons() {
		ClientLookUpTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval() {
		ClientLookUpTab.ConfirmButtonSentForApproval();
	}

}
