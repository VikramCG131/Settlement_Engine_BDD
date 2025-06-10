package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.SECalculationTab;

import java.io.IOException;

import constants.SECalculationConstants;
import constants.SEGroupConfigConstants;


public class SECalculationSteps {
	public static String random;
	SECalculationTab SECalculationTab = new SECalculationTab();
	
	@Given("The Settlement Engine<URL> for SE Calculation UI")
	public void The_Settlement_Engine_URL_for_SE_Calculation_UI() {
		SECalculationTab.openLoginPage();
	}

	@When("user hit the Settlement Engine URL for SE Calculation UI")
	public void user_hit_the__Settlement_Engine_URL_for_SE_Calculation_UI() {	
		try {

			SECalculationTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("the user clicks on MetaData UI screen for SE Calculation")
	public void the_user_clicks_on_MetaData_UI_screen_for_SE_Calculation() {
		SECalculationTab.clickMetaDataButton();
	}

	@Then("the user is able to Navigate to the Settlement Engine SE Calculation page UI")
	public void the_user_is_able_to_Navigate_to_the_Settlement_Engine_SE_Calculation_page_UI() {
		SECalculationTab.verifyTitle();
	}

	@Then("User clicks on Hamburger Button for SE Calculation UI")
	public void User_clicks_on_Hamburger_Button_for_SE_Calculation_UI() {
		SECalculationTab.clickHamburgerMenuButton();
	}

	@When("the user click on SE Calculation")
	public void the_user_click_on_SE_Calculation() {
		SECalculationTab.clickSCalulationTab();
	}


	
	@When("the user enters values in requried fields of Settlement Rules Config Metadata Category")
	public void the_user_enters_values_in_requried_fields_of_Settlement_Rules_Config_Metadata_Category() throws InterruptedException {
		SECalculationTab.enterSECalculationCategoryValues(SECalculationConstants.RULE_NAME.getValue(),SECalculationConstants.VARIABLE_NAME.getValue());
				
		System.out.println("The user is able to enter the data in required fields");
	}
	
	
	@When("the user enters required formula in requried field of Settlement Rules Config Metadata Explorer")
	public void user_move_any_rule_from_configured_rules_to_applied_rules() throws InterruptedException {
	    		SECalculationTab.enterRuleConfigMetaDataFieldWithFormula();
	}
	@When("the user clicks on VALIDATE button and see the success message")
	public void the_user_clicks_on_VALIDATE_button_and_see_the_success_message() throws InterruptedException {
	    		SECalculationTab.clickOnValidateButtonSeeValidateMessafe();
	}
	
	@When("the user clicks the Save button")
	public void the_user_clicks_the_Save_button() {
		SECalculationTab.clickEASubmitButton();
	}
	
	@Then("the rule should be saved successfully")
	public void the_rule_should_be_saved_successfully() {
		SECalculationTab.verifySECSuccessPopupMessage();
	}

	@When("the user click on VALIDATE Button for the SE Calculation and the user should see error for required fields for the SE Calculation")
	public void the_user_click_on_VALIDATE_Button_for_the_SE_Calculation_and_the_user_should_see_error_for_required_fields_for_the_SE_Calculation() {
     SECalculationTab.clickSECalCulationBlankSelection();
	}

	@When("the user click on Reset button for the SE Calculation")
	public void the_user_click_on_reset_button_for_the_SE_calculation() {
		SECalculationTab.clickSECResetButton();
	}

	@Then("all the fields should be cleared for the SE Calculation")
	public void all_the_fields_should_be_cleared_for_the_SE_calculation() {
		SECalculationTab.verifyAllFieldsClearedforResetButton();
	}


	@When("The User click the edit icon for the any record for the SE Calculation")
	public void The_User_click_the_edit_icon_for_the_any_record_for_the_SE_Calculation() {
		SECalculationTab.clickSECEditButton();
	}

	@Then("The User should see the edit modal open file for the SE Calculation")
	public void the_user_should_see_the_edit_modal_open_file_for_the_SE_Calculation() {
		SECalculationTab.verifySECalculationCategoryTextVisible();
	}

	@Then("the user update the any field for the SE Calculation")
	public void the_user_update_the_any_field_for_the_SE_Calculation() {
		SECalculationTab.editGroupNameValue();
	}
	
	@Then("the user should see click on the Update Button for the SE Calculation")
	public void the_user_should_see_click_on_the_Update_Button_for_the_SE_Calculation() {
		SECalculationTab.clickSECUpdateButton();
	}

	@Then("the user should see the updated {string} in the file list for the SE Calculation")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_SE_Calculation(String string) {
		SECalculationTab.verifySECUpdatePopupMessage();
	}

	@When("The User click the delete icon for the any file for the SE Calculation")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_SE_Calculation() {
		SECalculationTab.clickSECDeleteButton();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the SE Calculation")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_SE_Calculation(String string) {
		SECalculationTab.clickSECDeleteConfirmationPopupConfirmButton();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the SE Calculation")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_SE_Calculation() {
		SECalculationTab.verifySECDeleteConfirmationPopupCancelButton();
		SECalculationTab.verifySECDeleteConfirmationPopupConfirmButton();
	}
	
	@When("The User confirm the deletion for the SE Calculation")
	public void the_user_confirm_the_deletion_for_the_SE_Calculation() {
		SECalculationTab.clickSECDeleteConfirmationPopupConfirmButton();
	}

	@Then("the file should be removed from the table for the SE Calculation")
	public void the_file_should_be_removed_from_the_table_for_the_SE_Calculation() {
		SECalculationTab.verifySECFileRemoval();
	}



}
