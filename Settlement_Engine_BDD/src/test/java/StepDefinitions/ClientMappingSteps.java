package StepDefinitions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
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
		driver.get("http://localhost:4200");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
	}

	@When("the user clicks Settlement Engine URL")
	public void the_user_clicks_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@When("the User clicks on Reference LookUp UI screen")
	public void the_user_clicks_on_reference_look_up_ui_screen() {
		driver.findElement(By.xpath("//a[contains(text(),'Reference LookUp')]")).click();
		System.out.println("The user is able to navigate to Reference LookUp UI screen");
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

	@When("the user click on the Client Mapping")
	public void the_user_click_on_the_client_mapping() throws InterruptedException {
		driver.findElement(By.xpath("//a/span[contains(text(),'Client Mapping')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Client Mapping page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add button from the Client Mapping page")
	public void the_user_clicks_the_add_button_from_the_client_mapping_page() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[text()=' Add ']"))).click().perform();
		System.out.println("The user is able to click on Add Button");
		commonUtilities.screenshot();
	}

	@When("the user enters the data in required fields for the Client Mapping")
	public void the_user_enters_the_data_in_required_fields_for_the_client_mapping() {
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);
		}
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
	   driver.findElement(By.xpath("//input[@formcontrolname='payableEl2']")).sendKeys("500"+random);
	   driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).sendKeys("0.5");
	   driver.findElement(By.xpath("//input[@formcontrolname='shopCode']")).sendKeys("Shop"+random);
	   driver.findElement(By.xpath("//input[@formcontrolname='shopName']")).sendKeys("Test");	  
       driver.findElement(By.xpath("//input[@formcontrolname='dStype']")).sendKeys("Automation"+random);
	}

	@When("the user should see click on the Submit Button for the Client Mapping")
	public void the_user_should_see_click_on_the_submit_button_for_the_client_mapping() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(2000);
		commonUtilities.screenshot(); 
	}

	@Then("the user should see {string} in the file list for the Client Mapping")
	public void the_user_should_see_in_the_file_list_for_the_client_mapping(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successfully..! ']")).getText();
		Assert.assertEquals("Record has been added successfully..!", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("the user click on any field for the Client Mapping")
	public void the_user_click_on_any_field_for_the_client_mapping() throws InterruptedException {
		driver.findElement(By.xpath("//input[@formcontrolname='payableEl2']")).click();
		WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);
	}

	@Then("the user should see validation errors for required fields for the Client Mapping")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_client_mapping() {
		String actual = driver.findElement(By.xpath("//*[text()='Please Enter Payable El2']")).getText();
		Assert.assertEquals("Please Enter Payable El2", actual);
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();	   
	}
	
	@When("user clicks the Upload button")
	public void user_clicks_the_upload_button() throws InterruptedException {
		WebElement uploadButton = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
		uploadButton.click();
		System.out.println("The user is able to click on Upload Button");
		commonUtilities.screenshot();
		wait.until(ExpectedConditions.visibilityOf(uploadButton));
		System.out.println("The user is able to see the Upload button");
		Thread.sleep(6000);
		commonUtilities.screenshot();	   
	}

	@Then("file selection dialog should appear")
	public void file_selection_dialog_should_appear() {
	    WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
	    Assert.assertTrue(fileInput.isDisplayed());
	    System.out.println("The user is able to see the file selection dialog");
	    commonUtilities.screenshot();
	    wait.until(ExpectedConditions.visibilityOf(fileInput));
	    fileInput.sendKeys("C:\\Users\\userdev13\\Downloads\\clinet_Map.csv");
	    System.out.println("The user is able to select the file");
	    commonUtilities.screenshot();
	}

	@Then("user selects a valid file to upload")
	public void user_selects_a_valid_file_to_upload() {
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		Assert.assertTrue(fileInput.isDisplayed());
		System.out.println("The user is able to select a valid file to upload");
		commonUtilities.screenshot();
		wait.until(ExpectedConditions.visibilityOf(fileInput));
		System.out.println("The user is able to select a valid file to upload");
		commonUtilities.screenshot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		fileInput.sendKeys("C:\\Users\\userdev13\\Downloads\\clinet_Map.csv");
		System.out.println("The user is able to select the file");
		commonUtilities.screenshot();
	   
	}

	@Then("the file should be successfully uploaded")
	public void the_file_should_be_successfully_uploaded() {
		 /*   String actual = driver.findElement(By.xpath("//*[text()='File uploaded successfully..!']")).getText();
		Assert.assertEquals("File uploaded successfully..!", actual);
		System.out.println("The user is able to upload the file successfully");
		commonUtilities.screenshot();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='File uploaded successfully..!']"))));
		System.out.println("The user is able to upload the file successfully");
		commonUtilities.screenshot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		System.out.println("The user is able to click on OK button");
		commonUtilities.screenshot();*/
	}

	@When("user click the Send for Approval button")
	public void user_click_the_send_for_approval_button() {
		WebElement sendForApprovalButton = driver.findElement(By.xpath("//button[contains(text(),'Send for Approval')]"));
		wait.until(ExpectedConditions.visibilityOf(sendForApprovalButton)); 
		sendForApprovalButton.click();
		System.out.println("The user is able to click on Send for Approval Button");
		commonUtilities.screenshot(); 
	}

	@Then("the file should be submitted for approval")
	public void the_file_should_be_submitted_for_approval() {
		WebElement popup = driver.findElement(By.xpath("//div[@class='modal-content']"));
		wait.until(ExpectedConditions.visibilityOf(popup));
		Assert.assertTrue(popup.isDisplayed());
	   
	}

	@Then("a confirmation message should be displayed with Confirm and Cancel buttons")
	public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons() {
		WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		WebElement cancelButton = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
		Assert.assertTrue(confirmButton.isDisplayed());
		Assert.assertTrue(cancelButton.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(confirmButton));
		wait.until(ExpectedConditions.visibilityOf(cancelButton));
		System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
		commonUtilities.screenshot();
	 
	}

	@Then("by clicking on Confirm button the file should be sent for approval")
	public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval() {
		WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		wait.until(ExpectedConditions.visibilityOf(confirmButton));
		confirmButton.click();
		System.out.println("The user is able to click on Confirm button");
		commonUtilities.screenshot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actual = driver.findElement(By.xpath("//*[text()='File sent for approval successfully..!']")).getText();
		Assert.assertEquals("File sent for approval successfully..!", actual);
		System.out.println("The user is able to send the file for approval successfully");
		commonUtilities.screenshot();
	    
	}

	@Given("I navigate to the Client Mapping Grid")
	public void i_navigate_to_the_client_mapping_grid() {
	   
	}

	@When("I select {string} from the filter dropdown")
	public void i_select_from_the_filter_dropdown(String string) {
	  
	}

	@When("I enter {string} in the filter input \\(if applicable)")
	public void i_enter_in_the_filter_input_if_applicable(String string) {
	    
	}

	@When("I apply the filter")
	public void i_apply_the_filter() {
	    
	}

	@Then("the displayed rows should match the \"Rows where Shop Code contains \"S\"\"")
	public void the_displayed_rows_should_match_the_rows_where_shop_code_contains_s() {
	  
	}

	@Then("the displayed rows should match the \"Rows where Shop Code does not contain \"S\"\"")
	public void the_displayed_rows_should_match_the_rows_where_shop_code_does_not_contain_s() {
	 
	}

	@Then("the displayed rows should match the \"Only rows where Shop Code is \"YY\"\"")
	public void the_displayed_rows_should_match_the_only_rows_where_shop_code_is_yy() {
	    
	}

	@Then("the displayed rows should match the \"Rows where Shop Code is not \"YY\"\"")
	public void the_displayed_rows_should_match_the_rows_where_shop_code_is_not_yy() {
	    
	}

	@Then("the displayed rows should match the \"Rows where Shop Code starts with \"S\"\"")
	public void the_displayed_rows_should_match_the_rows_where_shop_code_starts_with_s() {
	    
	}

	@Then("the displayed rows should match the \"Rows where Shop Code ends with \"Y\"\"")
	public void the_displayed_rows_should_match_the_rows_where_shop_code_ends_with_y() {
	
	}

	@Then("the displayed rows should match the {string}")
	public void the_displayed_rows_should_match_the(String string) {
	   
	}


}
