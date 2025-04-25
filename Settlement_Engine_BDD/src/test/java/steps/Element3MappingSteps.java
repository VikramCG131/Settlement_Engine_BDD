package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.ClientLookUpConstants;
import constants.Element3MappingConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.Element3MappingTab;

public class Element3MappingSteps {
	Element3MappingTab Element3MappingTab = new Element3MappingTab();

	
	@Given("Settlement_Engine<URL> EL3_Mapping")
	public void settlement_engine_url_el3_mapping() {
		Element3MappingTab.openLoginPage();
	}

	@When("The user Clicks Settlement Engine URL")
	public void the_user_clicks_settlement_engine_url() {
		try {

			Element3MappingTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("the User Clicks on Reference LookUp UI screen")
	public void the_user_clicks_on_reference_look_up_ui_screen() {
		Element3MappingTab.clickReferenceLookUpButton();
	}

	@Then("The User is able to navigate to the Settlement Engine Homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() {
		Element3MappingTab.verifyTitle();
	}

	@Then("User Clicks on Hamburger Button Icon for the EL3 Mapping")
	public void user_clicks_on_hamburger_button_icon_for_the_el3_mapping() {
		Element3MappingTab.clickHamburgerMenuButton();
	}

	@When("the user click on the EL3 Mapping")
	public void the_user_click_on_the_el3_mapping() {
		Element3MappingTab.clickElement3MappingTab();
	}

	@When("the user clicks the Add button from the EL3 Mapping page")
	public void the_user_clicks_the_add_button_from_the_el3_mapping_page() {
		Element3MappingTab.clickEL3AddNewButton();
	}

	@When("the user enters the data in required fields for the EL3 Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_el3_mapping() {
		String random = CommonUtilities.getRandomInteger();
		Element3MappingTab.enterEL3CategoryFieldValue(Element3MappingConstants.PRODUCT_CODE.getValue(),Element3MappingConstants.ELEMENT3_CODE.getValue()+random);
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the EL3 Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_el3_mapping() {
		Element3MappingTab.clickEL3SubmitButton();
	}

	@Then("the user should see {string} in the file list for the EL3 Mapping")
	public void the_user_should_see_in_the_file_list_for_the_el3_mapping(String string) {
		Element3MappingTab.verifyEL3SuccessPopupMessage();
	}

	@Then("the user click on any field for the EL3 Mapping and the user should see validation errors for required fields for the EL3 Mapping")
	public void the_user_click_on_any_field_for_the_el3_mapping_and_the_user_should_see_validation_errors_for_required_fields_for_the_el3_mapping() {
		Element3MappingTab.clickEL3ElementCodeblankSelection();
	}

	@When("the user click on Reset button for the EL3 Mapping")
	public void the_user_click_on_reset_button_for_the_el3_mapping() {
		Element3MappingTab.clickEL3ResetButton();
	}

	@Then("all the fields should be cleared for the EL3 Mapping")
	public void all_the_fields_should_be_cleared_for_the_el3_mapping() {
		Element3MappingTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the EL3 Mapping")
	public void the_user_click_on_cancel_button_for_the_el3_mapping() {
		Element3MappingTab.clickEL3CancelButton();
	}

	@Then("Add Pop up should be closed for the EL3 Mapping")
	public void add_pop_up_should_be_closed_for_the_el3_mapping() {
		Element3MappingTab.verifyEL3CategoryTextVisible();
	}

	@When("The User click the edit icon for the any EL3 Mapping")
	public void the_user_click_the_edit_icon_for_the_any_el3_mapping() {
		Element3MappingTab.clickEL3EditButton();
	}

	@Then("The User should see the edit modal open EL3 Mapping")
	public void the_user_should_see_the_edit_modal_open_el3_mapping() {
		Element3MappingTab.verifyEL3CategoryTextVisible();
	}

	@Then("the user update the any field for the EL3 Mapping")
	public void the_user_update_the_any_field_for_the_el3_mapping() {
		Element3MappingTab.editShopCodeValue();
	}

	@Then("the user should see click on the Update Button for the EL3 Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_el3_mapping() {
		Element3MappingTab.clickEL3UpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the EL3 Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_el3_mapping(String string) {
		Element3MappingTab.verifyEL3UpdatePopupMessage();
	}

	@When("The User click the delete icon for the any EL3 Mapping")
	public void the_user_click_the_delete_icon_for_the_any_el3_mapping() {
		Element3MappingTab.clickEL3DeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the EL3 Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_el3_mapping(String string) {
		Element3MappingTab.verifyEL3DeleteConfirmationPopupMessage();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the EL3 Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_el3_mapping() {
		Element3MappingTab.verifyEL3DeleteConfirmationPopupCancelButton();
		Element3MappingTab.verifyEL3DeleteConfirmationPopupConfirmButton();
	}

	@When("The User confirm the deletion for the EL3 Mapping")
	public void the_user_confirm_the_deletion_for_the_el3_mapping() {
		Element3MappingTab.clickEL3DeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the EL3 Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_el3_mapping() {
		Element3MappingTab.verifyEL3FileRemoval();
	}

	@When("user clicks the download button EL3 Mapping")
	public void user_clicks_the_download_button_el3_mapping() {
		Element3MappingTab.clickEL3DownloadButton();
	}

	@Then("a file should be downloaded to the default download folder for the EL3 Mapping")
	public void a_file_should_be_downloaded_to_the_default_download_folder_for_the_el3_mapping() {
		Element3MappingTab.verifyFileDownloaded();
	}

	@When("the User Navigates to upload Button from the EL3 Mapping page")
	public void the_user_navigates_to_upload_button_from_the_el3_mapping_page() {
		Element3MappingTab.clickEL3UploadButton();
	}

	@When("user selects a valid file to upload for the EL3 Mapping")
	public void user_selects_a_valid_file_to_upload_for_the_el3_mapping() {
		Element3MappingTab.selectFileToUpload();
	}

	@When("the file should be successfully uploaded for EL3 Client Mapping")
	public void the_file_should_be_successfully_uploaded_for_el3_client_mapping() {
		Element3MappingTab.verifyUploadSuccessMessage();
	}

	@When("user click the Send for Approval button EL3 Mapping")
	public void user_click_the_send_for_approval_button_el3_mapping() {
		Element3MappingTab.clickSendForApprovalButton();
	}

	@Then("the file should be submitted for approval EL3 Mapping")
	public void the_file_should_be_submitted_for_approval_el3_mapping() {
		Element3MappingTab.fileSubmittedForApproval();
		}

	@Then("a confirmation message should be displayed with Confirm and Cancel Buttons")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons() {
		Element3MappingTab.ConfirmationMessageConfirmAndCancelButtons();
	}

	@Then("by clicking on Confirm button the file should be sent for Approval")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval() {
		Element3MappingTab.ConfirmButtonSentForApproval();
	}



}
