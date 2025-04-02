package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class DataQualityAssignmentSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;

	@Given("Settlement engine<URL>")
	public void Settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User click the Settlement Engine URL")
	public void User_click_the_Settlement_Engine_URL() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("The User is able to navigate to the settlement Engine homepage")
	public void The_User_is_able_to_navigate_to_the_settlement_Engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}
	@When("The User clicks on Metadata UI screen")
	public void The_User_clicks_on_metadata_ui_screen() {
		driver.findElement(By.xpath("//a[contains(text(),'Metadata')]")).click();
		System.out.println("The user is able to navigate to Metadata UI screen");
		commonUtilities.screenshot();
	    
	}

	@When("Click on the Expand button for the left panel")
	public void Click_on_the_Expand_button_for_the_left_panel() {
		    WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container collapsed']"));
		    boolean isCollapsed = panel.getAttribute("class").contains("collapsed");
		    if (isCollapsed) {
		        panel.findElement(By.xpath(".//button")).click();
		    } 
	}

	@Then("The User should see the left panel expanded")
	public void The_User_should_see_the_left_panel_expanded() throws InterruptedException {
		WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container']"));
		panel.isDisplayed();
		Thread.sleep(2000);
	}

	@Then("The Menu items should be visible")
	public void The_Menu_items_should_be_visible() {
	 List<WebElement> panel2 = driver.findElements(By.xpath("//div[@class=\"sidebar_container\"]/ul/li"));
	 for (WebElement element : panel2) {
	     System.out.println(element.getText());
	 }
	System.out.println("The user is able to see the left panel menu items");
	}

	@When("the user click on Data Quality Assignment")
	public void the_user_click_on_data_quality_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Data Quality Assignment')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Data Source File page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button for the DQ Assignment")
	public void the_user_clicks_the_add_new_button_for_the_dq_assignment() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the DQ Assignment")
	public void the_user_enters_the_data_in_required_fields_for_the_dq_assignment() throws InterruptedException {
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);}
		// Method for dropdown element
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='source1']"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("tallyman_raw");
		System.out.println("Selected Source Table: tallyman_raw");
		Thread.sleep(1000);
		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='source1Attribute']"));
		Select dropdown1 = new Select(dropdownElement1);
		dropdown1.selectByVisibleText("product_code");
		System.out.println("Selected Source Attribute: product_code");
		Thread.sleep(1000);
		WebElement dropdownElement2 = driver.findElement(By.xpath("//select[@formcontrolname='ruleId']"));
		Select dropdown2 = new Select(dropdownElement2);
		dropdown2.selectByIndex(2);
		System.out.println("Selected Rule ID:");
		Thread.sleep(1000);
		// Click the Datepicker toggle button to open the calendar
        WebElement datePickerToggle = driver.findElement(By.xpath("//button[@aria-label='Open calendar']"));
        datePickerToggle.click();
        Thread.sleep(1000);
 
        // Select a specific date (e.g., 1st of the current month)
        WebElement targetDate = driver.findElement(By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 1 ']"));
        targetDate.click();
 
        // Verify if the date is selected
        WebElement dateInput = driver.findElement(By.id("ruleStartTimeStamp"));
        String selectedDate = dateInput.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);
		Thread.sleep(3000);
		// Click the Datepicker toggle button to open the calendar
        WebElement datePickerToggle1 = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
        datePickerToggle1.click();
        Thread.sleep(1000);
 
        // Select a specific date (e.g., 1st of the current month)
        WebElement targetDate1 = driver.findElement(By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 15 ']"));
        targetDate1.click();
 
        // Verify if the date is selected
        WebElement dateInput1 = driver.findElement(By.id("ruleEndTimeStamp"));
        String selectedDate1 = dateInput1.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate1);
		Thread.sleep(3000);
		System.out.println("user is able to enter the data in the required fields");
	}
	

	@When("the user should see click on the Submit Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_submit_button_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(8000);
		commonUtilities.screenshot();
	}

	@Then("the user should see {string} in the file list for the DQ Assignment")
	public void the_user_should_see_in_the_file_list_for_the_dq_assignment(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Record has been added successFully..!')]")).getText();
		Assert.assertEquals("Record has been added successFully..!", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("the user click on any field for the DQ Assignment")
	public void the_user_click_on_any_field_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//select[@formcontrolname='source1']")).click();
		WebElement button = driver.findElement(By.xpath("//select[@formcontrolname='ruleId']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);
	}

	@Then("the user should see validation errors for required fields for the DQ Assignment")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_dq_assignment() {
		String actual = driver.findElement(By.xpath("//*[text()=' Please select Source Table ']")).getText();
		Assert.assertEquals("Please select Source Table", actual);
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();
	}

	@When("the user click on Reset button for the DQ Assignment")
	public void the_user_click_on_reset_button_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the DQ Assignment")
	public void all_the_fields_should_be_cleared_for_the_dq_assignment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ruleStartTimeStamp = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@formcontrolname='ruleStartTimeStamp']")));
		WebElement ruleEndTimeStamp = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='ruleEndTimeStamp']")));
		Assert.assertEquals("", ruleStartTimeStamp.getAttribute("value"));
		Assert.assertEquals("", ruleEndTimeStamp.getAttribute("value"));
		System.out.println("The user is able to clear the data in all fields");
	}

	@When("the user click on Cancel button for the DQ Assignment")
	public void the_user_click_on_cancel_button_for_the_dq_assignment() {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}

	@Then("Add New Pop up should be closed for the DQ Assignment")
	public void add_new_pop_up_should_be_closed_for_the_dq_assignment() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
	}

	@When("The User click the edit icon for the any file for the DQ Assignment")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_dq_assignment() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see the edit modal open file for the DQ Assignment")
	public void the_user_should_see_the_edit_modal_open_file_for_the_dq_assignment()throws  InterruptedException {
		boolean file = driver.findElement(By.xpath("//*[text()='Data quality assignment category ']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='Data quality assignment category ']")).getText();
		Assert.assertEquals("Data quality assignment category", actual);
		System.out.println("The edit modal is displayed");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("the user update the any field for the DQ Assignment")
	public void the_user_update_the_any_field_for_the_dq_assignment() throws  InterruptedException {
		WebElement dropdownElement2 = driver.findElement(By.xpath("//select[@formcontrolname='ruleId']"));
		Select dropdown2 = new Select(dropdownElement2);
		dropdown2.selectByIndex(3);
	    System.out.println("The user is able to update the data in the required fields");
	}

	@Then("the user should see click on the Update Button for the DQ Assignment")
	public void the_user_should_see_click_on_the_update_button_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(4000);
	}

	@Then("the user should see the updated {string} in the file list for the DQ Assignment")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_dq_assignment(String string)
			throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Record has been updated successfully..!')]"))
				.getText();
		Assert.assertEquals("Record has been updated successfully..!", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User click the delete icon for the any file for the DQ Assignment")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_dq_assignment() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_dq_assignment(String string)
			throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("The User should see {string} message for the DQ Assignment")
	public void the_user_should_see_message_for_the_dq_assignment(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
		Assert.assertEquals("Are you sure you want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the DQ Assignment")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_dq_assignment() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
	}

	@When("The User confirm the deletion for the DQ Assignment")
	public void the_user_confirm_the_deletion_for_the_dq_assignment() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	}

	@Then("the file should be removed from the table for the DQ Assignment")
	public void the_file_should_be_removed_from_the_table_for_the_dq_assignment() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
	}

}
