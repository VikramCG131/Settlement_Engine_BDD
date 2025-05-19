package steps;
 
import java.io.IOException;
 
import Utilities.CommonUtilities;
import constants.ClientLookUpConstants;
import constants.TpMappingConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.TpMappingTab;
 
public class TpMappingSteps {
	public static String random;
	
	TpMappingTab TpMappingTab = new TpMappingTab();
 
	@Given("Settlement_Engine<URL> for the TP Mapping")
	public void settlement_engine_url() {
		TpMappingTab.openLoginPage();
	}
 
	@When("the user clicks Settlement Engine URL for the TP Mapping")
	public void the_user_clicks_settlement_engine_url_for_the_TP_Mapping() {
		try {
 
			TpMappingTab.verifyHealthCheck();
 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
 
	@When("the User clicks on Reference LookUp UI screen for the TP Mapping")
	public void the_user_clicks_on_reference_look_up_ui_screen_for_the_TP_Mapping() {
		TpMappingTab.clickReferenceLookUpButton();
	}
 
	@Then("the User is able to navigate to the Settlement Engine Homepage for the TP Mapping & user is able to see the reference table dropdown")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_for_the_TP_Mapping() {
		TpMappingTab.verifyTitle();
	}
 
	@When("the user select tp_mapping_lkp from the common reference table")
	public void the_user_select_tp_mapping_lkp_from_the_common_reference_table() throws InterruptedException {
		TpMappingTab.Tp_Mapping_LkpSlectionFromReferenceTableDropdown();
	}
 
	@When("the user clicks the Add button from the TP Mapping page")
	public void the_user_clicks_the_add_button_from_the_TP_Mapping_page() {
		TpMappingTab.clickTPAddNewButton();
	}
 
	@When("the user enters the data in required fields for the TP Mapping")
	
	public void the_user_enters_the_data_in_required_fields_for_the_TP_Mapping() {
		TpMappingTab.enterTPCategoryFieldValue(TpMappingConstants.ELM_CODE.getValue(),TpMappingConstants.NAME.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}
 
	@When("the user should see click on the Submit Button for the TP Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_TP_Mapping() {
		TpMappingTab.clickTPSubmitButton();
	}
 
	@Then("the user should see {string} in the file list for the TP Mapping")
	public void the_user_should_see_in_the_file_list_for_the_TP_Mapping(String string) {
		TpMappingTab.verifyTPSuccessPopupMessage();
	}
	
	@Then("user can search and see the addded same record for the TP Mapping")
	public void user_can_search_and_see_the_addded_same_record_for_the_TP_Mapping() throws InterruptedException {
		TpMappingTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the TP Mapping and the user should see validation errors for required fields for the TP Mapping")
	public void the_user_click_on_any_field_for_the_TP_Mapping_and_the_user_should_see_validation_errors_for_required_fields_for_the_TP_Mapping() {
		TpMappingTab.clickTPClientCodeblankSelection();
	}
 
	@When("the user click on Reset button for the TP Mapping")
	public void the_user_click_on_reset_button_for_the_TP_Mapping() {
		TpMappingTab.clickTPResetButton();
	}
 
	@Then("all the fields should be cleared for the TP Mapping")
	public void all_the_fields_should_be_cleared_for_the_TP_Mapping() {
		TpMappingTab.verifyAllFieldsClearedforResetButton();
	}
 
	@When("the user click on Cancel button for the TP Mapping")
	public void the_user_click_on_cancel_button_for_the_TP_Mapping() {
		TpMappingTab.clickTPCancelButton();
	}
 
	@Then("Add Pop up should be closed for the TP Mapping")
	public void add_pop_up_should_be_closed_for_the_TP_Mapping() {
		TpMappingTab.verifyTPCategoryTextVisible();
	}
 
	@When("The User click the edit icon for the any TP Mapping")
	public void the_user_click_the_edit_icon_for_the_any_TP_Mapping() {
		TpMappingTab.clickTPEditButton();
	}
 
	@Then("The User should see the edit modal open TP Mapping")
	public void the_user_should_see_the_edit_modal_open_TP_Mapping() {
		TpMappingTab.verifyTPCategoryTextVisible();
	}
 
	@Then("the user update the any field for the TP Mapping")
	public void the_user_update_the_any_field_for_the_TP_Mapping() {
		TpMappingTab.editShopCodeValue();
	}
 
	@Then("the user should see click on the Update Button for the TP Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_TP_Mapping() {
		TpMappingTab.clickTPUpdateButton();
	}
 
	@Then("the user should see the updated {string} in the file list for the TP Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_TP_Mapping(String string) {
		TpMappingTab.verifyTPUpdatePopupMessage();
	}
 
	@When("The User click the delete icon for the any TP Mapping")
	public void the_user_click_the_delete_icon_for_the_any_TP_Mapping() {
		TpMappingTab.clickTPDeleteButton();
	}
 
	@Then("The User should see a confirmation pop-up with title {string} for the TP Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_TP_Mapping(String string) {
		TpMappingTab.verifyTPDeleteConfirmationPopupMessage();
	}
 
	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the TP Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_TP_Mapping() {
		TpMappingTab.verifyTPDeleteConfirmationPopupCancelButton();
		TpMappingTab.verifyTPDeleteConfirmationPopupConfirmButton();
	}
 
	@When("The User confirm the deletion for the TP Mapping")
	public void the_user_confirm_the_deletion_for_the_TP_Mapping() {
		TpMappingTab.clickTPDeleteConfirmationPopupConfirmButton();
	}
 
	@Then("the file should be removed from the table for the TP Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_TP_Mapping() {
		TpMappingTab.verifyTPFileRemoval();
	}
 
	@When("user clicks the download all records button for the TP Mapping page")
	public void user_clicks_the_download_button_for_the_TP_Mapping_page() {
		TpMappingTab.clickTPDownloadButton();
	}
 
	@Then("a file should be downloaded all the records to the default download folder for the TP Mapping Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_TP_Mapping_Page() {
		TpMappingTab.verifyFileDownloaded();
	}
	// approve record
	@When("user clicks the only approved records button for the TP Mapping page")
	public void user_clicks_the_only_approved_records_button_for_the_TP_Mapping_page() {
		TpMappingTab.clickTPDownloadButtonApproverecord();
	}
	
	@Then("a file should be downloaded approved record to the default download folder for the TP Mapping page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_TP_Mappin_page() {
		TpMappingTab.verifyFileDownloadedForApprove();
	}
/*	
 
	@When("the User Navigates to upload Button from the TP Mapping page")
	public void the_user_navigates_to_upload_button_from_the_TP_Mapping_page() {
		TpMappingTab.clickTPUploadButton();
	}
 
	@When("user selects a valid file to upload for the TP Mapping")
	public void user_selects_a_valid_file_to_upload_for_the_TP_Mapping() {
		TpMappingTab.selectFileToUpload();
	}
 
	@When("the file should be successfully uploaded for the TP Mapping")
	public void the_file_should_be_successfully_uploaded_for_the_TP_Mapping() {
		TpMappingTab.verifyUploadSuccessMessage();
	}
 */
	@When("user click the Send for Approval button for the TP Mapping")
	public void user_click_the_send_for_approval_button_for_the_TP_Mapping() {
		TpMappingTab.clickSendForApprovalButton();
	}
 
	@Then("the file should be submitted for approval for the TP Mapping")
	public void the_file_should_be_submitted_for_approval_for_the_TP_Mapping() {
		TpMappingTab.fileSubmittedForApproval();
	}
 
	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the TP Mapping")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_TP_Mapping() {
		TpMappingTab.ConfirmationMessageConfirmAndCancelButtons();
	}
 
	@Then("by clicking on Confirm button the file should be sent for approval for the TP Mapping")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_for_the_TP_Mapping() {
		TpMappingTab.ConfirmButtonSentForApproval();
	}
 
 
}