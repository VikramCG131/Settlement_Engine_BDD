package steps;
 
import java.io.IOException;
 
import Utilities.CommonUtilities;
import constants.ClientLookUpConstants;
import constants.ClientMappingConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.ClientMappingTab;
 
public class ClientMappingSteps {
	ClientMappingTab ClientMappingTab = new ClientMappingTab();
 
	@Given("Settlement_Engine<URL>")
	public void settlement_engine_url() {
		ClientMappingTab.openLoginPage();
	}
 
	@When("the user clicks Settlement Engine URL for the Client Mapping")
	public void the_user_clicks_settlement_engine_url_for_the_client_mapping() {
		try {
 
			ClientMappingTab.verifyHealthCheck();
 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
 
	@When("the User clicks on Reference LookUp UI screen for the Client Mapping")
	public void the_user_clicks_on_reference_look_up_ui_screen_for_the_client_mapping() {
		ClientMappingTab.clickReferenceLookUpButton();
	}
 
	@Then("the User is able to navigate to the Settlement Engine Homepage for the Client Mapping")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_for_the_client_mapping() {
		ClientMappingTab.verifyTitle();
	}
 
	@When("the user click on the Client Mapping")
	public void the_user_click_on_the_client_mapping() throws InterruptedException {
		ClientMappingTab.client_map_lkpSlection();
	}
 
	@When("the user clicks the Add button from the Client Mapping page")
	public void the_user_clicks_the_add_button_from_the_client_mapping_page() {
		ClientMappingTab.clickCLMAddNewButton();
	}
 
	@When("the user enters the data in required fields for the Client Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_client_mapping() {
		String random = CommonUtilities.getRandomInteger();
		ClientMappingTab.enterCLMCategoryFieldValue(ClientMappingConstants.CLIENT_CODE.getValue()+random,ClientMappingConstants.SHOP_CODE.getValue()+random, ClientMappingConstants.MAPPED_CODE.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}
 
	@When("the user should see click on the Submit Button for the Client Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_client_mapping() {
		ClientMappingTab.clickCLMSubmitButton();
	}
 
	@Then("the user should see {string} in the file list for the Client Mapping")
	public void the_user_should_see_in_the_file_list_for_the_client_mapping(String string) {
		ClientMappingTab.verifyCLMSuccessPopupMessage();
	}
	
	@Then("user can search and see the addded same record for the Client Mapping")
	public void user_can_search_and_see_the_addded_same_record_for_the_Client_Mapping() throws InterruptedException {
		ClientMappingTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Client Mapping and the user should see validation errors for required fields for the Client Mapping")
	public void the_user_click_on_any_field_for_the_client_mapping_and_the_user_should_see_validation_errors_for_required_fields_for_the_client_mapping() {
		ClientMappingTab.clickCLMClientCodeblankSelection();
	}
 
	@When("the user click on Reset button for the Client Mapping")
	public void the_user_click_on_reset_button_for_the_client_mapping() {
		ClientMappingTab.clickCLMResetButton();
	}
 
	@Then("all the fields should be cleared for the Client Mapping")
	public void all_the_fields_should_be_cleared_for_the_client_mapping() {
		ClientMappingTab.verifyAllFieldsClearedforResetButton();
	}
 
	@When("the user click on Cancel button for the Client Mapping")
	public void the_user_click_on_cancel_button_for_the_client_mapping() {
		ClientMappingTab.clickCLMCancelButton();
	}
 
	@Then("Add Pop up should be closed for the Client Mapping")
	public void add_pop_up_should_be_closed_for_the_client_mapping() {
		ClientMappingTab.verifyCLMCategoryTextVisible();
	}
 
	@When("The User click the edit icon for the any Client Mapping")
	public void the_user_click_the_edit_icon_for_the_any_client_mapping() {
		ClientMappingTab.clickCLMEditButton();
	}
 
	@Then("The User should see the edit modal open Client Mapping")
	public void the_user_should_see_the_edit_modal_open_client_mapping() {
		ClientMappingTab.verifyCLMCategoryTextVisible();
	}
 
	@Then("the user update the any field for the Client Mapping")
	public void the_user_update_the_any_field_for_the_client_mapping() {
		ClientMappingTab.editShopCodeValue();
	}
 
	@Then("the user should see click on the Update Button for the Client Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_client_mapping() {
		ClientMappingTab.clickCLMUpdateButton();
	}
 
	@Then("the user should see the updated {string} in the file list for the Client Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_client_mapping(String string) {
		ClientMappingTab.verifyCLMUpdatePopupMessage();
	}
 
	@When("The User click the delete icon for the any Client Mapping")
	public void the_user_click_the_delete_icon_for_the_any_client_mapping() {
		ClientMappingTab.clickCLMDeleteButton();
	}
 
	@Then("The User should see a confirmation pop-up with title {string} for the Client Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_client_mapping(String string) {
		ClientMappingTab.verifyCLMDeleteConfirmationPopupMessage();
	}
 
	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_client_mapping() {
		ClientMappingTab.verifyCLMDeleteConfirmationPopupCancelButton();
		ClientMappingTab.verifyCLMDeleteConfirmationPopupConfirmButton();
	}
 
	@When("The User confirm the deletion for the Client Mapping")
	public void the_user_confirm_the_deletion_for_the_client_mapping() {
		ClientMappingTab.clickCLMDeleteConfirmationPopupConfirmButton();
	}
 
	@Then("the file should be removed from the table for the Client Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_client_mapping() {
		ClientMappingTab.verifyCLMFileRemoval();
	}
 
	@When("user clicks the download button for the Client Mapping page")
	public void user_clicks_the_download_button_for_the_client_mapping_page() {
		ClientMappingTab.clickCLMDownloadButton();
	}
 
	@Then("a file should be downloaded to the default download folder for the Client Mapping page")
	public void a_file_should_be_downloaded_to_the_default_download_folder_for_the_client_mapping_page() {
		ClientMappingTab.verifyFileDownloaded();
	}
 
	@When("the User Navigates to upload Button from the Client Mapping page")
	public void the_user_navigates_to_upload_button_from_the_client_mapping_page() {
		ClientMappingTab.clickCLMUploadButton();
	}
 
	@When("user selects a valid file to upload for the Client Mapping")
	public void user_selects_a_valid_file_to_upload_for_the_client_mapping() {
		ClientMappingTab.selectFileToUpload();
	}
 
	@When("the file should be successfully uploaded for the Client Mapping")
	public void the_file_should_be_successfully_uploaded_for_the_client_mapping() {
		ClientMappingTab.verifyUploadSuccessMessage();
	}
 
	@When("user click the Send for Approval button for the Client Mapping")
	public void user_click_the_send_for_approval_button_for_the_client_mapping() {
		ClientMappingTab.clickSendForApprovalButton();
	}
 
	@Then("the file should be submitted for approval for the Client Mapping")
	public void the_file_should_be_submitted_for_approval_for_the_client_mapping() {
		ClientMappingTab.fileSubmittedForApproval();
	}
 
	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Client Mapping")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_client_mapping() {
		ClientMappingTab.ConfirmationMessageConfirmAndCancelButtons();
	}
 
	@Then("by clicking on Confirm button the file should be sent for approval for the Client Mapping")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_for_the_client_mapping() {
		ClientMappingTab.ConfirmButtonSentForApproval();
	}
 
 
}