package steps;

import java.io.IOException;

import Utilities.CommonUtilities;
import constants.ExceptionRulesMetadataConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.ExceptionRulesMetadataTab;

public class ExceptionRuleMetaDataSteps {
	ExceptionRulesMetadataTab ExceptionRulesMetadataTab = new ExceptionRulesMetadataTab();

	@Given("Settlement engine<URL> Exception")
	public void settlement_engine_url_exception() {
		ExceptionRulesMetadataTab.openLoginPage();
	}

	@When("User click the Settlement Engine URL on Exception")
	public void user_click_the_settlement_engine_url_on_exception() {
try {
			
	ExceptionRulesMetadataTab.verifyHealthCheck();
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("The User clicks on Metadata UI screen on Exception")
	public void the_user_clicks_on_metadata_ui_screen_on_exception() {
		ExceptionRulesMetadataTab.clickMetaDataButton();
	}

	@Then("The User is able to navigate to the settlement Engine homepage on Exception")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage_on_exception() {
		ExceptionRulesMetadataTab.verifyTitle();
	}

	@Then("User Clicks on Hamburger Button Icon for the Exception Rule")
	public void user_clicks_on_hamburger_button_icon_for_the_exception_rule() {
		ExceptionRulesMetadataTab.clickHamburgerMenuButton();
	}

	@When("the user click on Exception Rule Meta Data")
	public void the_user_click_on_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickExceptionRuleTab();
	}

	@When("the user clicks the Add New button for the Exception Rule Meta Data")
	public void the_user_clicks_the_add_new_button_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRAddNewButton();
	}

	@When("the user enters the data in required fields for the Exception Rule Meta Data")
	public void the_user_enters_the_data_in_required_fields_for_the_exception_rule_meta_data() {
		String random = CommonUtilities.getRandomInteger();
		ExceptionRulesMetadataTab.enterEXRCategoryFieldValue(ExceptionRulesMetadataConstants.RULE_TYPE.getValue(),
				ExceptionRulesMetadataConstants.SEVERITY.getValue(), ExceptionRulesMetadataConstants.EXCEPTION_OWNERS.getValue()+random,
				ExceptionRulesMetadataConstants.INPUT_SOURCE.getValue(), ExceptionRulesMetadataConstants.iNPUT_ATTRIBUTES.getValue(),
				ExceptionRulesMetadataConstants.REFERENCE_FILE.getValue(), ExceptionRulesMetadataConstants.REFERENCE_FILE_ATTRIBUTES.getValue());
	}

	@When("the user should see click on the Submit Button for the Exception Rule Meta Data")
	public void the_user_should_see_click_on_the_submit_button_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRSubmitButton();
	}

	@Then("the user should see {string} in the file list for the Exception Rule Meta Data")
	public void the_user_should_see_in_the_file_list_for_the_exception_rule_meta_data(String string) {
		ExceptionRulesMetadataTab.verifyEXRSuccessPopupMessage();
	}

	@When("the user click on any field for the Exception Rule Meta Data and the user should see validation errors for required fields for the Exception Rule Meta Data")
	public void the_user_click_on_any_field_for_the_exception_rule_meta_data_and_the_user_should_see_validation_errors_for_required_fields_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRRuleTypeblankSelection();
	}

	@When("the user click on Reset button for the Exception Rule Meta Data")
	public void the_user_click_on_reset_button_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRResetButton();
	}

	@Then("all the fields should be cleared for the Exception Rule Meta Data")
	public void all_the_fields_should_be_cleared_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Exception Rule Meta Data")
	public void the_user_click_on_cancel_button_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRCancelButton();
	}

	@Then("Add New Pop up should be closed for the Exception Rule Meta Data")
	public void add_new_pop_up_should_be_closed_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.verifyEXRCategoryTextVisible();;
	}

	@When("The User click the edit icon for the any file for the Exception Rule Meta Data")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXREditButton();
	}

	@Then("The User should see the edit modal open file for the Exception Rule Meta Data")
	public void the_user_should_see_the_edit_modal_open_file_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.verifyEXRCategoryTextVisible();
	}

	@Then("the user update the any field for the Exception Rule Meta Data")
	public void the_user_update_the_any_field_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.editExceptionOwnerValue();
	}

	@Then("the user should see click on the Update Button for the Exception Rule Meta Data")
	public void the_user_should_see_click_on_the_update_button_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the Exception Rule Meta Data")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_exception_rule_meta_data(String string) {
		ExceptionRulesMetadataTab.verifyEXRUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any file for the Exception Rule Meta Data")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_exception_rule_meta_data() {
		ExceptionRulesMetadataTab.clickEXRDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Exception Rule Meta Data")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_exception_rule_meta_data(String string) {
	  
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Exception Rule Meta Data")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_exception_rule_meta_data() {
	   
	}

	@Then("the file should be removed from the table for the Exception Rule Meta Data")
	public void the_file_should_be_removed_from_the_table_for_the_exception_rule_meta_data() {
	   
	}

	@When("user clicks the download button Exception Rule Meta Data")
	public void user_clicks_the_download_button_exception_rule_meta_data() {
	    
	}

	@Then("a file should be downloaded to the default download folder for the Exception Rule Meta Data")
	public void a_file_should_be_downloaded_to_the_default_download_folder_for_the_exception_rule_meta_data() {
	  
	}

}
