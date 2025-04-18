package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class EmailAlertStep {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;

	@Given("The Settlement Engine<URL> for email alert")
	public void the_settlement_engine_url_Email_Alert() {
		driver = WebDriverManager.chromedriver().create(); //user can use multiple browser drivers  
		driver.manage().window().maximize(); //maximize the window
		driver.get("http://localhost:4200"); //local host URL
		//Login for main page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait for 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smart-card"))).sendKeys("12345");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]"))).click();
		 //wait for 10 seconds	
	}

	@When("user hit the Settlement Engine URL for email alert")
	public void the_user_hits_the_settlement_engine_url_Email_Alert() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("the user is able to Navigate to the Settlement Engine Email Alert page")
	public void the_user_is_able_to_Navigate_to_the_settlement_engine_homepage_Email_Alert() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Settlement Engine"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}

	@When("the user clicks on Email Alert UI screen")
	public void the_user_clicks_on_Email_Alert_ui_screen() {
		driver.findElement(By.xpath("//a[contains(text(),'Metadata')]")).click();
		System.out.println("The user is able to navigate to Metadata UI screen");
		commonUtilities.screenshot();
	    
	}

	@When("click on the expand button for the left panel Email")
	public void click_on_the_expand_button_for_the_left_panel_Email() {
		    WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container collapsed']"));
		    boolean isCollapsed = panel.getAttribute("class").contains("collapsed");
		    if (isCollapsed) {
		        panel.findElement(By.xpath(".//button")).click();
		    } 
	}

	@Then("the user should see the left panel expanded email")
	public void the_user_should_see_the_left_panel_expanded_Email() throws InterruptedException {
		WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container']"));
		panel.isDisplayed();
		Thread.sleep(2000);
	}

	@Then("the menu items should be visible email")
	public void the_menu_items_should_be_visible_email() {
	 List<WebElement> panel2 = driver.findElements(By.xpath("//div[@class=\"sidebar_container\"]/ul/li"));
	 for (WebElement element : panel2) {
	     System.out.println(element.getText());
	 }
	System.out.println("The user is able to see the left panel menu items");
	}


	@When("the user click on Email Alert")
	public void the_user_click_on_Email_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Email Alert')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Email page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button for the Email Alert")
	public void the_user_clicks_the_add_new_button_Email_Alert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait for 10 seconds
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@Then("the user enters the data in required fields for the Email Alert")
	public void the_user_enters_the_data_in_required_fields_Email_Alet() throws InterruptedException {
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group mb-3']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);
		}
		//Enter the Templete type dropdown
		WebElement Templetetypedropdown = driver.findElement(By.id("templateType"));
		Select dropdown = new Select(Templetetypedropdown);
		List<WebElement> options = dropdown.getOptions();
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(options.size());
		dropdown.selectByIndex(randomIndex);
		//Enter the email text box
		
		int random1 = (int) (Math.floor(Math.random() * 100000) + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("abc"+random1+"@gmail.com");
		
		//Entrer the subject text box
		int random2 = (int) (Math.floor(Math.random() * 100000) + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='subject']")).sendKeys("Test"+random2);
		//Enter the comment text box
		int random3 = (int) (Math.floor(Math.random() * 100000) + 1);
		driver.findElement(By.xpath("//div[@data-placeholder='Insert text here ...']")).sendKeys("Testing is in progress"+random3);
	
	}

	@When("the user should see click on the Submit Button for the file for the Email Alert")
	public void the_user_should_click_on_the_Submit_Button_the_Email_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("the user should see {string} in the file list for the file email")
	public void the_user_should_see_in_the_file_list_Email(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successfully ']")).getText();
		Assert.assertEquals("Record has been added successfully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(2000);
	}

	@When("the user click on any field for the Email Alert")
	public void the_user_click_on_any_field_for_the_Email_Alert() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).click();
		WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='subject']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);
	}

	@Then("the user should see validation errors for required fields for the Email Alert")
	public void the_user_should_see_validation_errors_for_required_fields_for_the_Email_Alert() throws InterruptedException {
		String actual = driver.findElement(By.xpath("//span[contains(text(),'Please Enter EmailAddress')]")).getText();
		Assert.assertEquals("Please Enter EmailAddress", actual);
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(2000);
	}

	@When("the user click on Reset button for the Email Alert")
	public void the_user_click_on_reset_button_for_the_Email_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the Email Alert")
	public void all_the_fields_should_be_cleared_for_the_Email_Alert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement templatedrop = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("templateType")));
		WebElement email = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='emailAddress']")));
		WebElement subject = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='subject']")));
		Assert.assertEquals("", templatedrop.getAttribute("value"));
		Assert.assertEquals("", email.getAttribute("value"));
		Assert.assertEquals("", subject.getAttribute("value"));
		System.out.println("The user is able to clear the data in all fields");
		driver.quit();
		Thread.sleep(2000);
	}

	@When("the user click on Cancel button for the Email Alert")
	public void the_user_click_on_cancel_button_for_the_Email_Alert() {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}

	@Then("Add New Pop up should be closed for the Email Alert")
	public void add_new_pop_up_should_be_closed_for_the_Email_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
		Thread.sleep(5000);
	}

	@When("The User click the edit icon for the any file for the Email Alert")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_Email_Alert() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see the edit modal open file for the Email Alert")
	public void the_user_should_see_the_edit_modal_open_file_for_the_Email_Alert()throws  InterruptedException {
		boolean file = driver.findElement(By.xpath("//h6[contains(text(),'Compose Email')]")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//h6[contains(text(),'Compose Email')]")).getText();
		Assert.assertEquals("Compose Email", actual);
		System.out.println("The edit modal is displayed");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("the user update the any field for the Email Alert")
	public void the_user_update_the_any_field_for_the_Email_Aler() throws  InterruptedException {
		int random4 = (int) (Math.floor(Math.random() * 10) + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='subject']")).sendKeys("Test"+random4);
	    System.out.println("The user is able to update the data in the required fields");
	}

	@Then("the user should see click on the Update Button for the Email Alert")
	public void the_user_should_see_click_on_the_update_button_for_the_Email_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(4000);
	}

	@Then("the user should see the updated {string} in the file list for the Email Alert")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_Email_Alert(String string)
			throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[contains(text(),' Record has been updated successfully ')]"))
				.getText();
		Assert.assertEquals("Record has been updated successfully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(5000);
	}

	@When("The User click the delete icon for the any file for the Email Alert")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_Email_Alert() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Email Alert")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_Email_Alert(String string)
			throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("The User should see {string} message for the Email Alert")
	public void the_user_should_see_message_for_the_Email_Alert(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
		Assert.assertEquals("Are you sure you want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(2000);
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Email Alert")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_Email_Alert() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
	}

	@When("The User confirm the deletion for the Email Alert")
	public void the_user_confirm_the_deletion_for_the__Email_Alert() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	}

	@Then("the file should be removed from the table for the Email Alert")
	public void the_file_should_be_removed_from_the_table_for_the_Eail_Alert() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
		Thread.sleep(2000);
	}
}
