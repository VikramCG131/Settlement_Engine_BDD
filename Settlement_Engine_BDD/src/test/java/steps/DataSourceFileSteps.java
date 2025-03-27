package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class DataSourceFileSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;

	@Given("The Settlement Engine<URL>")
	public void the_settlement_engine_url() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("user hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("the user is able to Navigate to the Settlement Engine homepage")
	public void the_user_is_able_to_Navigate_to_the_settlement_engine_homepage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}

	@When("the user click on Data Source File")
	public void the_user_click_on_data_source_file() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Data Source File')]")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Data Source File page");
		commonUtilities.screenshot();
	}

	@When("the user clicks the Add New button from the Data Source File page")
	public void the_user_clicks_the_add_new_button() {
		WebElement button = driver.findElement(By.xpath("//*[text()='Add New']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}

	@Then("the user enters the data in required fields for the Data Source File")
	public void the_user_enters_the_data_in_required_fields() {
		int random = (int) (Math.floor(Math.random() * 100000) + 1);
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);
		}
		driver.findElement(By.xpath("//input[@formcontrolname='fileName']")).sendKeys("TestAutomation" + random);
		driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("csv");
		driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).sendKeys("raw");
		driver.findElement(By.xpath("//input[@formcontrolname='filePathRaw']")).sendKeys("C://local");
		driver.findElement(By.xpath("//input[@formcontrolname='filePathCleansed']")).sendKeys("D://local");
		driver.findElement(By.xpath("//input[@formcontrolname='fileSizeMB']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@formcontrolname='stagingTableName']")).sendKeys("MetadataSourceFile");
		driver.findElement(By.xpath("//input[@formcontrolname='fileDelimiter']")).sendKeys(",");
		driver.findElement(By.xpath("//input[@formcontrolname='headerIdentifier']")).sendKeys(",");
		driver.findElement(By.xpath("//input[@formcontrolname='columnIdentifier']")).sendKeys(",");
		System.out.println("The user is able to insert the data in the all fields");
	}

	@When("the user should see click on the Submit Button for the file")
	public void the_user_should_click_on_the_Submit_Button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("the user should see {string} in the file list for the file")
	public void the_user_should_see_in_the_file_list(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successFully ']")).getText();
		Assert.assertEquals("Record has been added successFully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("the user click on any field for the file")
	public void the_user_click_on_any_field() throws InterruptedException {
		driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).click();
		WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='fileName']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);

	}

	@Then("the user should see validation errors for required fields for the file")
	public void the_user_should_see_validation_errors_for_required_fields() {
		String actual = driver.findElement(By.xpath("//*[text()='Please enter File Pattern']")).getText();
		Assert.assertEquals("Please enter File Pattern", actual);
		System.out.println("The user is able to see the error message for required fields");
		commonUtilities.screenshot();
	}

	@Then("{string} should not be in the file list for the file")
	public void should_not_be_in_the_file_list(String string) {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
	}

	@When("the user click on Cancel button for the file")
	public void the_user_click_on_Cancel_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}

	@When("the user click on Reset button for the file")
	public void the_user_click_on_reset_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		commonUtilities.screenshot();
	}

	@Then("all the fields should be cleared for the file")
	public void all_the_fields_should_be_cleared() {
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='fileName']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='filePathRaw']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='filePathCleansed']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='fileSizeMB']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='stagingTableName']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='fileDelimiter']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='headerIdentifier']")).getAttribute("value"));
		Assert.assertEquals("",
				driver.findElement(By.xpath("//input[@formcontrolname='columnIdentifier']")).getAttribute("value"));
		System.out.println("All fields are cleared");
	}

	@Then("Add New Pop up should be closed for the file")
	public void add_new_pop_up_should_be_closed() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
	}

	@When("The User click the edit icon for the any Data Source file")
	public void the_user_click_the_edit_icon_for_the_any_file() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see the edit modal open Data Source file")
	public void the_user_should_see_the_edit_modal_open_file() {
		boolean file = driver.findElement(By.xpath("//*[text()='File Information']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='File Information']")).getText();
		Assert.assertEquals("File Information", actual);		
		System.out.println("The edit modal is displayed");
		commonUtilities.screenshot();
	}

	@Then("the user update the any field for the file")
	public void the_user_update_the_any_field() {
		driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("txt");
	}

	@Then("the user should see click on the Update Button for the file")
	public void the_user_should_see_click_on_the_update_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(2000);
	}

	@Then("the user should see the updated {string} in the file list for the Data Source file")
	public void the_user_should_see_the_updated_in_the_file_list(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//*[text()=' Record has been Updated successFully ']")).getText();
		Assert.assertEquals("Record has been Updated successFully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User click the delete icon for the any Data Source file")
	public void the_user_click_the_delete_icon_for_the_any_file() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the file")
	public void the_user_should_see_a_confirmation_pop_up_with_title(String string) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@Then("The User should see {string} message for the file")
	public void the_user_should_see_message(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
		Assert.assertEquals("Are you sure you want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}

	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Data Source file")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
	}

	@When("The User confirm the deletion for the Data Source file")
	public void the_user_confirm_the_deletion() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	}

	@Then("the file should be removed from the table for the Data Source file")
	public void the_file_should_be_removed_from_the_table() {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
	}
}
