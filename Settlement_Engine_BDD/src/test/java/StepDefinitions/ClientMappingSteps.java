package StepDefinitions;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClientMappingSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;
	
	@Given("Settlement_Engine<URL>")
	public void settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:50448");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
	}

	@When("the user clicks Settlement Engine URL")
	public void the_user_clicks_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:50448"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@When("the User clicks on Reference LookUp UI screen")
	public void the_user_clicks_on_reference_look_up_ui_screen() {
		driver.findElement(By.xpath("//a[contains(text(),'Metadata')]")).click();
		System.out.println("The user is able to navigate to Metadata UI screen");
		commonUtilities.screenshot();
	}

	@When("clicks on the Expand button for the left panel")
	public void clicks_on_the_expand_button_for_the_left_panel() {
		 WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container collapsed']"));
		    boolean isCollapsed = panel.getAttribute("class").contains("collapsed");
		    if (isCollapsed) {
		        panel.findElement(By.xpath(".//button")).click();
		    }
	}

	@Then("the User is able to navigate to the Settlement Engine Homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}

	@Then("the User should see the Left panel expanded")
	public void the_user_should_see_the_left_panel_expanded() throws InterruptedException {
		WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container']"));
		panel.isDisplayed();
		Thread.sleep(2000);
	}

	@Then("the Menu Items should be visible")
	public void the_menu_items_should_be_visible() {
		List<WebElement> panel2 = driver.findElements(By.xpath("//div[@class=\"sidebar_container\"]/ul/li"));
		 for (WebElement element : panel2) {
		     System.out.println(element.getText());
		 }
		System.out.println("The user is able to see the left panel menu items");
	}

	@When("the user click on Client Mapping")
	public void the_user_click_on_client_mapping() throws InterruptedException {
		driver.findElement(By.xpath("//a/span[contains(text(),'Client Mapping')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Client Mapping page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button from the Client Mapping page")
	public void the_user_clicks_the_add_new_button_from_the_client_mapping_page() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the Client Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_client_mapping() {
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
	   driver.findElement(By.xpath("//input[@formcontrolname='payable_e2']")).sendKeys("500"+random);
	   driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).sendKeys("0.5");
	   dri
	}

	@When("the user should see click on the Submit Button for the Client Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_client_mapping() {
	 
	}

	@Then("the user should see {string} in the file list for the Client Mapping")
	public void the_user_should_see_in_the_file_list_for_the_client_mapping(String string) {
	   
	}

	@When("the user click on any field for the Client Mapping")
	public void the_user_click_on_any_field_for_the_client_mapping() {
	
	}

	@Then("the user should see validation errors for required fields for the Client Mapping")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_client_mapping() {
	   
	}

	@When("the user click on Reset button for the Client Mapping")
	public void the_user_click_on_reset_button_for_the_client_mapping() {
	  
	}

	@Then("all the fields should be cleared for the Client Mapping")
	public void all_the_fields_should_be_cleared_for_the_client_mapping() {
	   
	}

	@When("the user click on Cancel button for the Client Mapping")
	public void the_user_click_on_cancel_button_for_the_client_mapping() {
	  
	}

	@Then("Add New Pop up should be closed for the Client Mapping")
	public void add_new_pop_up_should_be_closed_for_the_client_mapping() {
	   
	}

	@When("The User click the edit icon for the any Client Mapping")
	public void the_user_click_the_edit_icon_for_the_any_client_mapping() {
	  
	}

	@Then("The User should see the edit modal open Client Mapping")
	public void the_user_should_see_the_edit_modal_open_client_mapping() {
	  
	}

	@Then("the user update the any field for the Client Mapping")
	public void the_user_update_the_any_field_for_the_client_mapping() {
	
	}

	@Then("the user should see click on the Update Button for the Client Mapping")
	public void the_user_should_see_click_on_the_update_button_for_the_client_mapping() {
	  
	}

	@Then("the user should see the updated {string} in the file list for the Client Mapping")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_client_mapping(String string) {
	   
	}

	@When("The User click the delete icon for the any Client Mapping")
	public void the_user_click_the_delete_icon_for_the_any_client_mapping() {
	  
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Client Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_client_mapping(String string) {
	   
	}

	@Then("The User should see {string} message for the Client Mapping")
	public void the_user_should_see_message_for_the_client_mapping(String string) {
	 
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client Mapping")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_client_mapping() {
	  
	}

	@When("The User confirm the deletion for the Client Mapping")
	public void the_user_confirm_the_deletion_for_the_client_mapping() {
	   
	}

	@Then("the file should be removed from the table for the Client Mapping")
	public void the_file_should_be_removed_from_the_table_for_the_client_mapping() {
	
	}


}
