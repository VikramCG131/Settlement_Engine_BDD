package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.PricingLookUpConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.PricingLookUpTab;

public class PricingLookUpSteps {
	public static String random;
	PricingLookUpTab PricingLookUpTab = new PricingLookUpTab();
	
	@Given("Settlement_Engine <URL> Page")
	public void settlement_engine_url_Page() {
		PricingLookUpTab.openLoginPage();
	}

	@When("The User Clicks Settlement engine URL")
	public void The_User_clicks_Settlement_engine_url() {
		try {
			
			PricingLookUpTab.verifyHealthCheck();
					
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
	}

	@When("the User clicks on Reference lookUp UI screen")
	public void the_user_clicks_on_Reference_Look_up_Ui_Screen() {
		PricingLookUpTab.clickReferenceLookUpButton();
	}
	
	@Then("the User is able to navigate to the Settlement Engine Homepage for the Pricing LookUp & user is able to see the reference table dropdown")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_pricing_lookup_user_is_able_to_see_the_reference_table_dropdown() {
		PricingLookUpTab.verifyTitle();
	}

	@When("the user select pricing_lkp from the common reference table")
	public void the_user_select_pricing_lkp_from_the_common_reference_table() throws InterruptedException {
		PricingLookUpTab.Pricing_LkpSlectionFromReferenceTableDropdown();
	}

	@When("the user clicks the Add button from the Pricing LookUp page")
	public void the_user_clicks_the_add_button_from_the_pricing_lookup_page() {
		PricingLookUpTab.clickBMAddNewButton();
	}

	@When("the user enters the data in required fields for the Pricing LookUp")
	public void the_user_enters_the_data_in_required_fields_for_the_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.enterBMCategoryFieldValue(PricingLookUpConstants.CURRENCY.getValue(),
				PricingLookUpConstants.CLIENT_CODE.getValue(),PricingLookUpConstants.PRODUCT_CODE.getValue(),PricingLookUpConstants.INSTALEMENTS.getValue(),
				PricingLookUpConstants.OFFER_MONTHS.getValue(),PricingLookUpConstants.LOAN_AMOUNT_MIN.getValue(),PricingLookUpConstants.LOAN_AMOUNT_MAX.getValue(),
				PricingLookUpConstants.RULE.getValue(),PricingLookUpConstants.COMM_SUB_PCT.getValue(),PricingLookUpConstants.MIN_MAX_SUB_VAL.getValue(),
				PricingLookUpConstants.CNTDWN_RATE_PCT.getValue(),PricingLookUpConstants.MIN_CNTDWN_RATE_PCT.getValue(),PricingLookUpConstants.CNTDWN_ADJUST.getValue(),
				PricingLookUpConstants.THIRD_PARTY_1_ENCODING.getValue(),PricingLookUpConstants.THIRD_PARTY_1_RATE.getValue(),PricingLookUpConstants.THIRD_PARTY_2_ENCODING.getValue(),
				PricingLookUpConstants.THIRD_PARTY_2_RATE.getValue(),PricingLookUpConstants.THIRD_PARTY_3_ENCODING.getValue(),PricingLookUpConstants.THIRD_PARTY_3_RATE.getValue(),
				PricingLookUpConstants.VOL_BONUS_PCT.getValue(),PricingLookUpConstants.HEAD_OFFICE_REBATE.getValue());
				
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the Pricing LookUp")
	public void the_user_should_see_click_on_the_submit_button_for_the_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.clickBMSubmitButton();
	}
	
	@Then("the user should see {string} in the file list for the Pricing LookUp")
	public void the_user_should_see_in_the_file_list_for_the_pricing_lookup(String string) throws InterruptedException {
		PricingLookUpTab.verifyBMSuccessPopupMessage();
	}
	@Then("user can search and see the addded same record for the Pricing LookUp")
	public void user_can_search_and_see_the_addded_same_record_for_the_Pricing_LookUp() throws InterruptedException {
		PricingLookUpTab.AddedRecorddSearch();
	}
	
	@Then("the user click on any field for the Pricing LookUp and the user should see validation errors for required fields for the Pricing LookUp")
	public void the_user_click_on_any_field_for_the_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.clickBMClientCodeblankSelection();
	}

	@When("the user click on Reset button for the Pricing LookUp")
	public void the_user_click_on_reset_button_for_the_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.clickBMResetButton();
	}

	@Then("all the fields should be cleared for the Pricing LookUp")
	public void all_the_fields_should_be_cleared_for_the_pricing_lookup() {
		PricingLookUpTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Pricing LookUp")
	public void the_user_click_on_cancel_button_for_the_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.clickBMCancelButton();
	}

	@Then("Add Pop up should be closed for the Pricing LookUp")
	public void add_pop_up_should_be_closed_for_the_pricing_lookup() {
	   PricingLookUpTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("The User click the edit icon for the any Pricing LookUp")
	public void the_user_click_the_edit_icon_for_the_any_pricing_lookup() throws InterruptedException {
		PricingLookUpTab.clickBMEditButton();
	}

	@Then("The User should see the edit modal open Pricing LookUp")
	public void the_user_should_see_the_edit_modal_open_pricing_lookup() {
	   PricingLookUpTab.verifyBMCategoryTextVisible();
	}

	@Then("the user update the any field for the Pricing LookUp")
	public void the_user_update_the_any_field_for_the_pricing_lookup() throws InterruptedException {
	 PricingLookUpTab.editClientCodeValue();
	}

	@Then("the user should see click on the Update Button for the Pricing LookUp")
	public void the_user_should_see_click_on_the_update_button_for_the_pricing_lookup() {
		PricingLookUpTab.clickBMUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Pricing LookUp")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_pricing_lookup(String string) {
		PricingLookUpTab.verifyBMUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any Pricing LookUp")
	public void the_user_click_the_delete_icon_for_the_any_pricing_lookup() {
		PricingLookUpTab.clickBMDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Pricing LookUp")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_pricing_lookup(String string) {
		PricingLookUpTab.verifyBMDeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Pricing LookUp")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_pricing_lookup() {
		PricingLookUpTab.verifyBMDeleteConfirmationPopupCancelButton();
		PricingLookUpTab.verifyBMDeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the Pricing LookUp")
	public void the_user_confirm_the_deletion_for_the_pricing_lookup() {
		PricingLookUpTab.clickBMDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the Pricing LookUp")
	public void the_file_should_be_removed_from_the_table_for_the_pricing_lookup() {
		PricingLookUpTab.verifyBMGridVisibleandFileInformationNotVisible();
	}

	@When("user clicks the download all records button for the Pricing LookUp page")
	public void user_clicks_the_download_all_records_button_for_the_pricing_lookup_page() {
	   PricingLookUpTab.clickBMDownloadButton();
	}

	@Then("a file should be downloaded all the records to the default download folder for the Pricing LookUp Page")
	public void a_file_should_be_downloaded_all_the_records_to_the_default_download_folder_for_the_pricing_lookup_Page() {
		PricingLookUpTab.verifyFileDownloaded();
	}
	// download all approve records

	@When("user clicks the only approved records button for the Pricing LookUp page")
	public void user_clicks_the_only_approved_records_button_for_the_pricing_lookup_page() {
	   PricingLookUpTab.clickBMDownloadAllApproveRecord();
	}

	@Then("a file should be downloaded approved record to the default download folder for the Pricing LookUp page")
	public void a_file_should_be_downloaded_approved_record_to_the_default_download_folder_for_the_pricing_lookup_page() {
		PricingLookUpTab.verifyFileDownloadedAllApproveRecord();
	}
	
/*
	
	@When("the User Navigates to upload Button from the Pricing LookUp page")
	public void the_user_navigates_to_upload_button_from_the_pricing_lookup_page() {
		PricingLookUpTab.clickBMUploadButton();
	}

	@When("user selects a valid file to upload from the Pricing LookUp page")
	public void user_selects_a_valid_file_to_upload_from_the_pricing_lookup_page() {
		PricingLookUpTab.selectFileToUpload();
	}

	@When("the file should be successfully Uploaded from the Pricing LookUp page")
	public void the_file_should_be_successfully_uploaded_from_the_pricing_lookup_page() {
		PricingLookUpTab.verifyUploadSuccessMessage();
	}
*/
	@When("user click the Send for Approval button from the Pricing LookUp page")
	public void user_click_the_send_for_approval_button_from_the_pricing_lookup_page() {
		PricingLookUpTab.clickSendForApprovalButton();
	}

	@Then("the file should be submitted for Approval from the Pricing LookUp page")
	public void the_file_should_be_submitted_for_approval_from_the_pricing_lookup_page() {
		PricingLookUpTab.fileSubmittedForApproval();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Pricing LookUp")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_pricing_lookup() {
		PricingLookUpTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from Pricing LookUp page")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_pricing_lookup_page() {
		PricingLookUpTab.ConfirmButtonSentForApproval();
	}



}
