package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.BrandMappingConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.CommonReferenceLookupTab;


public class CommonReferenceLookupStep {
	CommonReferenceLookupTab CommonReferenceLookupTab = new CommonReferenceLookupTab();
	
	@Given("Settlement_Engine <URL> for commonreference")
	public void settlement_engine_url_for_commonreference() {
		CommonReferenceLookupTab.openLoginPage();
	}

	@When("the user clicks Settlement Engine_URL for commonreference")
	public void the_user_clicks_settlement_engine_url_for_commonreference() {
		try {
			
			CommonReferenceLookupTab.verifyHealthCheck();
					
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
	}

	@When("the User clicks on Reference LookUp UI Screen for commonreference")
	public void the_user_clicks_on_reference_look_up_ui_screen_for_commonreference() {
		CommonReferenceLookupTab.clickReferenceLookUpButton();
	}
	
	@When("User Clicks On Hamburger Button Icon Brand for commonreference")
	public void the_user_click_on_the_hamburger_Icon_Brand_for_commonreference() {

		CommonReferenceLookupTab.clickHamburgerMenuButton();
	}
	
	@Then("the User is able to navigate to the Settlement_Engine Homepage for commonreference")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_for_commonreference() {
		CommonReferenceLookupTab.verifyTitle();
	}

	@When("the user click on the Common_Reference_Lookup")
	public void the_user_click_on_the_brand_mapping() {
		CommonReferenceLookupTab.clickBrandMapingTab();
	}

	@When("the user clicks the Add button from the Common_Reference_Lookup page")
	public void the_user_clicks_the_add_button_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.clickCRLAddNewButton();
	}

	@When("the user enters the data in required fields for the Common_Reference_Lookup")
	public void the_user_enters_the_data_in_required_fields_for_the_brand_mapping() {
		String random = CommonUtilities.getRandomInteger();
		CommonReferenceLookupTab.enterCRLCategoryFieldValue(BrandMappingConstants.CLIENT_CODE.getValue()+ random,
				BrandMappingConstants.BRAND_CODE.getValue());
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the SuCRLit Button for the Common_Reference_Lookup")
	public void the_user_should_see_click_on_the_suCRLit_button_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLSuCRLitButton();
	}
	
	@Then("the user should see {string} in the file list for the Common_Reference_Lookup")
	public void the_user_should_see_in_the_file_list_for_the_brand_mapping(String string) throws InterruptedException {
		CommonReferenceLookupTab.verifyCRLSuccessPopupMessage();
	}
	@Then("user can search and see the addded same record for Common Reference")
	public void user_can_search_and_see_the_addded_same_record() throws InterruptedException {
		CommonReferenceLookupTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Brand Mapping and the user should see validation errors for required fields for the Common_Reference_Lookup")
	public void the_user_click_on_any_field_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLClientCodeblankSelection();
	}

	@When("the user click on Reset button for the Common_Reference_Lookup")
	public void the_user_click_on_reset_button_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLResetButton();
	}

	@Then("all the fields should be cleared for the Common_Reference_Lookup")
	public void all_the_fields_should_be_cleared_for_the_brand_mapping() {
		CommonReferenceLookupTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Common_Reference_Lookup")
	public void the_user_click_on_cancel_button_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLCancelButton();
	}

	@Then("Add Pop up should be closed for the Common_Reference_Lookup")
	public void add_pop_up_should_be_closed_for_the_brand_mapping() {
	   CommonReferenceLookupTab.verifyCRLGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Common_Reference_Lookup")
	public void the_user_click_the_edit_icon_for_the_any_brand_mapping() {
		CommonReferenceLookupTab.clickCRLEditButton();
	}

	@Then("The User should see the edit modal open Common_Reference_Lookup")
	public void the_user_should_see_the_edit_modal_open_brand_mapping() {
	   CommonReferenceLookupTab.verifyCRLCategoryTextVisible();
	}

	@Then("the user update the any field for the Common_Reference_Lookup")
	public void the_user_update_the_any_field_for_the_brand_mapping() {
	 CommonReferenceLookupTab.editClientCodeValue();
	}

	@Then("the user should see click on the Update Button for the Common_Reference_Lookup")
	public void the_user_should_see_click_on_the_update_button_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Common_Reference_Lookup")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_brand_mapping(String string) {
		CommonReferenceLookupTab.verifyCRLUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Common_Reference_Lookup")
	public void the_user_click_the_delete_icon_for_the_any_brand_mapping() {
		CommonReferenceLookupTab.clickCRLDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Common_Reference_Lookup")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_brand_mapping(String string) {
		CommonReferenceLookupTab.verifyCRLDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Common_Reference_Lookup")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_brand_mapping() {
		CommonReferenceLookupTab.verifyCRLDeleteConfirmationPopupCancelButton();
		CommonReferenceLookupTab.verifyCRLDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Common_Reference_Lookup")
	public void the_user_confirm_the_deletion_for_the_brand_mapping() {
		CommonReferenceLookupTab.clickCRLDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Common_Reference_Lookup")
	public void the_file_should_be_removed_from_the_table_for_the_brand_mapping() {
		CommonReferenceLookupTab.verifyCRLGridVisibleandFileInformationNotVisible();
	}

	@When("user clicks the download button from the Common_Reference_Lookup")
	public void user_clicks_the_download_button_from_the_brand_mapping_page() {
	   CommonReferenceLookupTab.clickCRLDownloadButton();
	}

	@Then("a file should be downloaded to the default download folder from the Common_Reference_Lookup")
	public void a_file_should_be_downloaded_to_the_default_download_folder_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.verifyFileDownloaded();
	}

	@When("the User Navigates to upload Button from the Common_Reference_Lookup")
	public void the_user_navigates_to_upload_button_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.clickCRLUploadButton();
	}

	@When("user selects a valid file to upload from the Common_Reference_Lookup")
	public void user_selects_a_valid_file_to_upload_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.selectFileToUpload();
	}

	@When("the file should be successfully Uploaded from the Common_Reference_Lookup")
	public void the_file_should_be_successfully_uploaded_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button from the Common_Reference_Lookup")
	public void user_click_the_send_for_approval_button_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.clickSendForApprovalButton();
	}

	@Then("the file should be suCRLitted for Approval from the Common_Reference_Lookup")
	public void the_file_should_be_suCRLitted_for_approval_from_the_brand_mapping_page() {
		CommonReferenceLookupTab.fileSuCRLittedForApproval();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Common_Reference_Lookup")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_brand_mapping() {
		CommonReferenceLookupTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from Common_Reference_Lookup")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_brand_mapping_page() {
		CommonReferenceLookupTab.ConfirmButtonSentForApproval();
	}



}
