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

public class MetaDataColumnsSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;
	
    @Given("Settlement Engine<URL>")
	public void the_settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("the user hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("the User is able to navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}
	
	@When("the user click on Metadata Column")
	public void the_user_click_on_metadata_column() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Meta Data Column')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Meta Data Column page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button from the Metadata Column page")
	public void the_user_clicks_the_add_new_button_from_the_metadata_column_page() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the Metadata Column")
	public void the_user_enters_the_data_in_required_fields_for_the_metadata_column() throws InterruptedException {
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);
		}
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='columnName']")).sendKeys("TestAutomation" + random);
		 // Locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("columnDataType"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("BOOLEAN");
		driver.findElement(By.xpath("//div[3]/div[1]/label[@for='columnIsActiveYes']")).click();
		driver.findElement(By.xpath("//div[4]/div[2]/label[@for='columnIsNullNo']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='minSize']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@formcontrolname='maxSize']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@formcontrolname='columnOrder']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@formcontrolname='columnDateFormat']")).sendKeys("2025-03-26");
		Thread.sleep(2000);
		// Locate the dropdown element
		 WebElement dropdown1 = driver.findElement(By.xpath("//select[@formcontrolname='fileMetadataId']"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(2);	
		System.out.println("The user is able to enter the data in required fields");
	}

	@When("the user should see click on the Submit Button for the Metadata Column")
	public void the_user_should_see_click_on_the_submit_button_for_the_metadata_column() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(2000);
		commonUtilities.screenshot(); 
	}

	@Then("the user should see {string} in the file list for the Metadata Column")
	public void the_user_should_see_in_the_file_list_for_the_metadata_column(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successFully..! ']")).getText();
		Assert.assertEquals("Record has been added successFully..!", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("the user click on any field for the Metadata Column")
	public void the_user_click_on_any_field_for_the_metadata_column() throws InterruptedException {
		driver.findElement(By.xpath("//input[@formcontrolname='minSize']")).click();
		WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='maxSize']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);
	}

	@Then("the user should see validation errors for required fields for the Metadata Column")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_metadata_column() {
		String actual = driver.findElement(By.xpath("//*[text()='Min Size must be a number']")).getText();
		Assert.assertEquals("Min Size must be a number", actual);
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();
	}

	@When("the user click on Reset button for the Metadata Column")
	public void the_user_click_on_reset_button_for_the_metadata_column() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the Metadata Column")
	public void all_the_fields_should_be_cleared_for_the_metadata_column() {
		 // Verify that all fields are empty
	  Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='columnName']")).getAttribute("value"));
	    Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='minSize']")).getAttribute("value"));
	    Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='maxSize']")).getAttribute("value"));
	    System.out.println("The user is able to clear the fields");
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
		boolean file = driver.findElement(By.xpath("//*[text()='Columns information ']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='Columns information ']")).getText();
		Assert.assertEquals("Columns information", actual);	
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
