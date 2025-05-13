package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.BrandMappingConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.BrandMappingTab;

public class BrandMappingSteps {
	public static String random;
	BrandMappingTab BrandMappingTab = new BrandMappingTab();
	
	@Given("Settlement_Engine <URL>")
	public void settlement_engine_url() {
		BrandMappingTab.openLoginPage();
	}

	@When("the user clicks Settlement Engine_URL")
	public void the_user_clicks_settlement_engine_url() {
		try {
			
			BrandMappingTab.verifyHealthCheck();
					
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
	}

	@When("the User clicks on Reference LookUp UI Screen")
	public void the_user_clicks_on_reference_look_up_ui_screen() {
		BrandMappingTab.clickReferenceLookUpButton();
	}
	
	@Then("the User is able to navigate to the Settlement Engine Homepage for the Brand Mapping & user is able to see the reference table dropdown")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_Brand_Mapping_user_is_able_to_see_the_reference_table_dropdown() {
		BrandMappingTab.verifyTitle();
	}

	@When("the user select brand_map_lkp from the common reference table")
	public void the_user_Select_brand_map_lkp_from_the_common_reference_table() throws InterruptedException {
		BrandMappingTab.Brand_Map_LkpSlectionFromReferenceTableDropdown();
	}

	@When("the user clicks the Add button from the Brand Mapping page")
	public void the_user_clicks_the_add_button_from_the_brand_mapping_page() {
		BrandMappingTab.clickBMAddNewButton();
	}

	@When("the user enters the data in required fields for the Brand Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_brand_mapping() {
		BrandMappingTab.enterBMCategoryFieldValue(BrandMappingConstants.CLIENT_CODE.getValue(),
		BrandMappingConstants.BRAND_CODE.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the Brand Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_brand_mapping() {
		BrandMappingTab.clickBMSubmitButton();
	}
	
	@Then("the user should see {string} in the file list for the Brand Mapping")
	public void the_user_should_see_in_the_file_list_for_the_brand_mapping(String string) throws InterruptedException {
		BrandMappingTab.verifyBMSuccessPopupMessage();
	}
	@Then("user can search and see the addded same record")
	public void user_can_search_and_see_the_addded_same_record() throws InterruptedException {
		BrandMappingTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Brand Mapping and the user should see validation errors for required fields for the Brand Mapping")
	public void the_user_click_on_any_field_for_the_brand_mapping() {
		BrandMappingTab.clickBMClientCodeblankSelection();
	}

	@When("the user click on Reset button for the Brand Mapping")
	public void the_user_click_on_reset_button_for_the_brand_mapping() {
		BrandMappingTab.clickBMResetButton();
	}

	@Then("all the fields should be cleared for the Brand Mapping")
	public void all_the_fields_should_be_cleared_for_the_brand_mapping() {
		BrandMappingTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Brand Mapping")
	public void the_user_click_on_cancel_button_for_the_brand_mapping() {
		BrandMappingTab.clickBMCancelButton();
	}

	@Then("Add Pop up should be closed for the Brand Mapping")
	public void add_pop_up_should_be_closed_for_the_brand_mapping() {
	   BrandMappingTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Brand Mapping")
	public void the_user_click_the_edit_icon_for_the_any_brand_mapping() {
		BrandMappingTab.clickBMEditButton();
	}

	@Then("The User should see the edit modal open Brand Mapping")
	public void the_user_should_see_the_edit_modal_open_brand_mapping() {
	   BrandMappingTab.verifyBMCategoryTextVisible();
	}

	@Then("the user update the any field for the Brand Mapping")
	public void the_user_update_the_any_field_for_the_brand_mapping() {
	 BrandMappingTab.editClientCodeValue();
	}

	@Then("the user should see click on the Update Button for the Brand Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_brand_mapping() {
		BrandMappingTab.clickBMUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Brand Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_brand_mapping(String string) {
		BrandMappingTab.verifyBMUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Brand Mapping")
	public void the_user_click_the_delete_icon_for_the_any_brand_mapping() {
		BrandMappingTab.clickBMDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Brand Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_brand_mapping(String string) {
		BrandMappingTab.verifyBMDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Brand Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_brand_mapping() {
		BrandMappingTab.verifyBMDeleteConfirmationPopupCancelButton();
		BrandMappingTab.verifyBMDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Brand Mapping")
	public void the_user_confirm_the_deletion_for_the_brand_mapping() {
		BrandMappingTab.clickBMDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Brand Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_brand_mapping() {
		BrandMappingTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("user clicks the download all records button for the Brand Mapping page")
	public void user_clicks_the_download_all_records_button_for_the_Brand_Mapping_page() {
	   BrandMappingTab.clickBMDownloadButton();
	}

	@Then("a file should be downloaded all the records to the default download folder for the Brand Mapping Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_Brand_Mapping_Page() {
		BrandMappingTab.verifyFileDownloaded();
	}
	// download all approve records

	@When("user clicks the only approved records button for the Brand Mapping page")
	public void user_clicks_the_only_approved_records_button_for_the_Brand_Mapping_page() {
	   BrandMappingTab.clickBMDownloadAllApproveRecord();
	}

	@Then("a file should be downloaded approved record to the default download folder for the Brand Mapping page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_Brand_Mapping_page() {
		BrandMappingTab.verifyFileDownloadedAllApproveRecord();
	}
	

	
	@When("the User Navigates to upload Button from the Brand Mapping page")
	public void the_user_navigates_to_upload_button_from_the_brand_mapping_page() {
		BrandMappingTab.clickBMUploadButton();
	}

	@When("user selects a valid file to upload from the Brand Mapping page")
	public void user_selects_a_valid_file_to_upload_from_the_brand_mapping_page() {
		BrandMappingTab.selectFileToUpload();
	}

	@When("the file should be successfully Uploaded from the Brand Mapping page")
	public void the_file_should_be_successfully_uploaded_from_the_brand_mapping_page() {
		BrandMappingTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button from the Brand Mapping page")
	public void user_click_the_send_for_approval_button_from_the_brand_mapping_page() {
		BrandMappingTab.clickSendForApprovalButton();
	}

	@Then("the file should be submitted for Approval from the Brand Mapping page")
	public void the_file_should_be_submitted_for_approval_from_the_brand_mapping_page() {
		BrandMappingTab.fileSubmittedForApproval();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Brand Mapping")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_brand_mapping() {
		BrandMappingTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from brand mapping page")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_brand_mapping_page() {
		BrandMappingTab.ConfirmButtonSentForApproval();
	}



}
