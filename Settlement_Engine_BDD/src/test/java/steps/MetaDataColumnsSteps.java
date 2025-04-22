package steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tabs.MetaDataColumnsTab;
import Utilities.CommonUtilities;
import constants.DataSourceFileConstants;
import constants.MetadataColumnConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MetaDataColumnsSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;
	MetaDataColumnsTab MetaDataColumnsTab = new MetaDataColumnsTab();
	
    @Given("Settlement Engine<URL>")
    public void the_settlement_engine_url() {
    	MetaDataColumnsTab.openLoginPage();
	}

	@When("the user hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		try {

			MetaDataColumnsTab.verifyHealthCheck();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("the User is able to navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		MetaDataColumnsTab.verifyTitle();
	}
	@When("the user clicks on Metadata UI screen")
	public void the_user_clicks_on_metadata_ui_screen() {
		MetaDataColumnsTab.clickMetaDataButton();
	}
	
	@When("User Clicks on Hamburger Button")
	public void click_on_hamburger_button() {
		MetaDataColumnsTab.clickHamburgerMenuButton();
	}
	@When("the user click on Metadata Column")
	public void the_user_click_on_metadata_column() throws InterruptedException {
		MetaDataColumnsTab.clickMetadataColumnTab();
	}
	
	@When("the user clicks the Add New button from the Metadata Column page")
	public void the_user_clicks_the_add_new_button_from_the_metadata_column_page() {
		MetaDataColumnsTab.clickMDCAddNewButton();
	}

	@When("the user enters the data in required fields for the Metadata Column")
	public void the_user_enters_the_data_in_required_fields_for_the_metadata_column() throws InterruptedException {
		String random = CommonUtilities.getRandomInteger();
		MetaDataColumnsTab.enterMDCFieldValue(MetadataColumnConstants.NAME.getValue() + random,
				MetadataColumnConstants.DATA_TYPE.getValue(), MetadataColumnConstants.IS_ACTIVE.getValue(),
				MetadataColumnConstants.IS_NULL.getValue(), MetadataColumnConstants.MIN_SIZE.getValue(),
				MetadataColumnConstants.MAX_SIZE.getValue(), MetadataColumnConstants.ORDER.getValue(),
				MetadataColumnConstants.DATE_FORMAT.getValue(),
				MetadataColumnConstants.TABLE_NAME.getValue());
		System.out.println("The user is able to enter the data in required fields");
	}

	@When("the user should see click on the Submit Button for the Metadata Column")
	public void the_user_should_see_click_on_the_submit_button_for_the_metadata_column() throws InterruptedException {
		MetaDataColumnsTab.clickMDCSubmitButton();
	}

	@Then("the user should see {string} in the file list for the Metadata Column")
	public void the_user_should_see_in_the_file_list_for_the_metadata_column(String string) throws InterruptedException {
		MetaDataColumnsTab.verifyDSFSuccessPopupMessage();
	}

	@When("the user click on any field for the Metadata Column")
	public void the_user_click_on_any_field_for_the_metadata_column() throws InterruptedException {
		MetaDataColumnsTab.clickMDCMinSizeandblankSelection();
	}

	@Then("the user should see validation errors for required fields for the Metadata Column")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_metadata_column() {
		MetaDataColumnsTab.clickMDCMinSizeandblankSelection();
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();
	}

	@When("the user click on Reset button for the Metadata Column")
	public void the_user_click_on_reset_button_for_the_metadata_column() throws InterruptedException {
		MetaDataColumnsTab.clickMDCResetButton();
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the Metadata Column")
	public void all_the_fields_should_be_cleared_for_the_metadata_column() {
		MetaDataColumnsTab.verifyAllFieldsClearedforResetButton();
	}

	@When("the user click on Cancel button for the Metadata Column")
	public void the_user_click_on_cancel_button_for_the_metadata_column() {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}

	@Then("Add New Pop up should be closed for the Metadata Column")
	public void add_new_pop_up_should_be_closed_for_the_metadata_column() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
	}

	@When("The User click the edit icon for the any Metadata Column")
	public void the_user_click_the_edit_icon_for_the_any_metadata_column() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see the edit modal open Metadata Column")
	public void the_user_should_see_the_edit_modal_open_metadata_column() {
		boolean file = driver.findElement(By.xpath("//*[text()='Columns Information ']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='Columns Information ']")).getText();
		Assert.assertEquals("Columns Information", actual);		
		System.out.println("The edit modal is displayed");
		commonUtilities.screenshot();
	}

	@Then("the user update the any field for the Metadata Column")
	public void the_user_update_the_any_field_for_the_metadata_column() {
		driver.findElement(By.xpath("//input[@formcontrolname='columnName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='maxSize']")).sendKeys("40");
	}

	@Then("the user should see click on the Update Button for the Metadata Column")
	public void the_user_should_see_click_on_the_update_button_for_the_metadata_column() {
	    
	}

	@Then("the user should see the updated {string} in the file list for the Metadata Column")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_metadata_column(String string) throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(2000);
	}

	@When("The User click the delete icon for the any Metadata Column")
	public void the_user_click_the_delete_icon_for_the_any_metadata_column() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Metadata Column")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_metadata_column(String string) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("The User should see {string} message for the Metadata Column")
	public void the_user_should_see_message_for_the_metadata_column(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
		Assert.assertEquals("Are you sure you want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Metadata Column")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_metadata_column() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
	}

	@When("The User confirm the deletion for the Metadata Column")
	public void the_user_confirm_the_deletion_for_the_metadata_column() {
	    driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	}

	@Then("the file should be removed from the table for the Metadata Column")
	public void the_file_should_be_removed_from_the_table_for_the_metadata_column() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
	}




}
