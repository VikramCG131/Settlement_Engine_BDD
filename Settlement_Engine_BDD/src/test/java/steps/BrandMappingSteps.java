package steps;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabs.BrandMappingTab;


public class BrandMappingSteps {
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

	@Then("the User is able to navigate to the Settlement_Engine Homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() {
		BrandMappingTab.verifyTitle();
	}

	@Then("the User should see the Left Panel expanded")
	public void the_user_should_see_the_left_panel_expanded() {
		BrandMappingTab
	}

	@Then("the Menu Items should be Visible")
	public void the_menu_items_should_be_visible() {
		BrandMappingTab
	}

	@When("the user click on the Brand Mapping")
	public void the_user_click_on_the_brand_mapping() {
		BrandMappingTab
	}

	@When("the user clicks the Add button from the Brand Mapping page")
	public void the_user_clicks_the_add_button_from_the_brand_mapping_page() {
		BrandMappingTab
	}

	@When("the user enters the data in required fields for the Brand Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_brand_mapping() {
		BrandMappingTab
	}

	@When("the user should see click on the Submit Button for the Brand Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_brand_mapping() {
		BrandMappingTab
	}

	@Then("the user should see {string} in the file list for the Brand Mapping")
	public void the_user_should_see_in_the_file_list_for_the_brand_mapping(String string) {
		BrandMappingTab
	}

	@When("the user click on any field for the Brand Mapping")
	public void the_user_click_on_any_field_for_the_brand_mapping() {
		BrandMappingTab
	}

	@Then("the user should see validation errors for required fields for the Brand Mapping")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_brand_mapping() {
		BrandMappingTab
	}

	@When("the user click on Reset button for the Brand Mapping")
	public void the_user_click_on_reset_button_for_the_brand_mapping() {
		BrandMappingTab.clickResetButton();
	}

	@Then("all the fields should be cleared for the Brand Mapping")
	public void all_the_fields_should_be_cleared_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user click on Cancel button for the Brand Mapping")
	public void the_user_click_on_cancel_button_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Add Pop up should be closed for the Brand Mapping")
	public void add_pop_up_should_be_closed_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User click the edit icon for the any Brand Mapping")
	public void the_user_click_the_edit_icon_for_the_any_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see the edit modal open Brand Mapping")
	public void the_user_should_see_the_edit_modal_open_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user update the any field for the Brand Mapping")
	public void the_user_update_the_any_field_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see click on the Update Button for the Brand Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see the updated {string} in the file list for the Brand Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_brand_mapping(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User click the delete icon for the any Brand Mapping")
	public void the_user_click_the_delete_icon_for_the_any_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Brand Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_brand_mapping(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should see {string} message for the Brand Mapping")
	public void the_user_should_see_message_for_the_brand_mapping(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Brand Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The User confirm the deletion for the Brand Mapping")
	public void the_user_confirm_the_deletion_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the file should be removed from the table for the Brand Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks the download button from the Brand Mapping page")
	public void user_clicks_the_download_button_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a file should be downloaded to the default download folder from the Brand Mapping page")
	public void a_file_should_be_downloaded_to_the_default_download_folder_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User Navigates to upload Button from the Brand Mapping page")
	public void the_user_navigates_to_upload_button_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user selects a valid file to upload from the Brand Mapping page")
	public void user_selects_a_valid_file_to_upload_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the file should be successfully Uploaded from the Brand Mapping page")
	public void the_file_should_be_successfully_uploaded_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user click the Send for Approval button from the Brand Mapping page")
	public void user_click_the_send_for_approval_button_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the file should be submitted for Approval from the Brand Mapping page")
	public void the_file_should_be_submitted_for_approval_from_the_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons for the Brand Mapping")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons_for_the_brand_mapping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("by clicking on Confirm button the file should be sent for approval from brand mapping page")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval_from_brand_mapping_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
