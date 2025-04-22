package tabs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.DataQualityAssignmentLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class DataQualityAssignmentTab {
	
	private WebDriver driver;
	public WebDriverWait wait;
	
	//Constructor to initialize the driver and wait
	public DataQualityAssignmentTab() {
		this.driver = DriverManager.getDriver();
		
		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public void openLoginPage() {
		driver.get("http://localhost:4200/login");
		System.out.println("The user is able to open the login page");
	}
	
	//Verify health check of the URL
	public void verifyHealthCheck() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:4200/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SettlementEngineLoginLocators.SESmartCarddata));
		driver.findElement(SettlementEngineLoginLocators.SESmartCarddata).sendKeys("12345");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SettlementEngineLoginLocators.SELoginButton));
		driver.findElement(SettlementEngineLoginLocators.SELoginButton).click();
		System.out.println("The user is able to verify the correct URL");
//		try {
//			HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:4200/").openConnection();
//			connection.setRequestMethod("GET");
//			connection.setConnectTimeout(5000);
//			connection.connect();
//			Assert.assertEquals(connection.getResponseCode(), 200);
//			
//			System.out.println(connection.getResponseCode() == 200 ? "The user is able to verify the health check of the URL" : "The user is not able to verify the health check of the URL");
//			
//		} catch (MalformedURLException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
//		} 
	}
	
	//Verify the Title of the Page
	public    void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Settlement Engine");
		System.out.println("The user is able to verify the title of the page");
	}
	
	//Click on MetaData Button
	public  void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.MetaDataButton));
		driver.findElement(LoginPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}
	
	//Click on Hamburger Menu Button
	public   void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.HamburgerButton));
		driver.findElement(LoginPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}
	
	// Click on Data Quality Assignment Tab
	public void clickDataQualityAssignmentTab() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DataQualityAssignmentTab));
		driver.findElement(DataQualityAssignmentLocators.DataQualityAssignmentTab).click();
		System.out.println("The user is able to click on Data Quality Assignment Tab");
	}
	
	//Click on Add New Button
	public   void clickDQAAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQAAddNewButton));
		driver.findElement(DataQualityAssignmentLocators.DQAAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}
	
	//Enter the Field Value in Data Quality Assignment Category
	public   void enterDQACategoryFieldValue(String sourceTable, String sourceAttribute) {
		//Source Table Dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceTableDropdown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select sourcetabledropdown = new Select(driver.findElement(DataQualityAssignmentLocators.DQASourceTableDropdown));
		sourcetabledropdown.selectByVisibleText(sourceTable);
		System.out.println("Selected Source Table: tallyman_raw");
		//Source Attribute Dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceAttributeDropdown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select sourceattributedropdown = new Select(driver.findElement(DataQualityAssignmentLocators.DQASourceAttributeDropdown));
		sourceattributedropdown.selectByVisibleText(sourceAttribute);
		System.out.println("Selected Source Attribute: product_code");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQRuleDropdown));
		Select dqruledropdown = new Select(driver.findElement(DataQualityAssignmentLocators.DQADQRuleDropdown));
		dqruledropdown.selectByIndex(2);
		System.out.println("Selected DQ Rule by Index: 2");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQStartDate));
		driver.findElement(DataQualityAssignmentLocators.DQADQStartDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQStartDateSelect));
		driver.findElement(DataQualityAssignmentLocators.DQADQStartDateSelect).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQEndDate));
		driver.findElement(DataQualityAssignmentLocators.DQADQEndDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQEndDateSelect));
		driver.findElement(DataQualityAssignmentLocators.DQADQEndDateSelect).click();
		System.out.println("The user is able to enter the field value in Data Quality Assignment Category");
	}
	public void editSourceAttributeValue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceAttributeDropdown));
		Select sourceattributedropdown = new Select(driver.findElement(DataQualityAssignmentLocators.DQASourceAttributeDropdown));
		sourceattributedropdown.selectByIndex(3);
	
	}
	//Click on Submit Button
	public   void clickDQASubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASubmitButton));
		driver.findElement(DataQualityAssignmentLocators.DQASubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Success Popup Message
	public   void verifyDQASuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASuccessPopupMessage));
		String successMessage = driver.findElement(DataQualityAssignmentLocators.DQASuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}
	//Verify the Update Popup Message
		public   void verifyDQAUpdatePopupMessage() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQAUpdatePopupMessage));
			String successMessage = driver.findElement(DataQualityAssignmentLocators.DQAUpdatePopupMessage).getText();
			Assert.assertEquals(successMessage, "Record has been updated successfully..!");
			System.out.println("The user is able to verify the Update Popup Message");
		}
	
	//Click on Source Table Dropdown
	public   void clickDQASourceTableDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceTableDropdown));
		driver.findElement(DataQualityAssignmentLocators.DQASourceTableDropdown).click();
		System.out.println("The user is able to click on Source Table Dropdown");
	}
	
	//Click on Source Table Dropdown and Blank Selection
	public   void clickDQASourceTableDropdownandblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceTableDropdown));
		driver.findElement(DataQualityAssignmentLocators.DQASourceTableDropdown).click();
		driver.findElement(DataQualityAssignmentLocators.DQACategoryTextVisible).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(DataQualityAssignmentLocators.DQASourceTableValidation).getText();
		Assert.assertEquals("Please Select Source Table", actual);
		System.out.println("The user is able to click on Source Table Dropdown and validate the error message");
	}
	
	//Click on DQ Rule Dropdown
	public   void clickDQADQRuleDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQRuleDropdown));
		driver.findElement(DataQualityAssignmentLocators.DQADQRuleDropdown).click();
		String actual = driver.findElement(DataQualityAssignmentLocators.DQADQRuleValidation).getText();
		Assert.assertEquals("Please select DQ Rule", actual);
		System.out.println("The user is able to click on DQ Rule Dropdown and validate the error message");
	}
	
	//Click on DQ Rule Dropdown and Blank Selection
	public   void clickDQADQRuleDropdownandBlankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQRuleDropdown));
		driver.findElement(DataQualityAssignmentLocators.DQADQRuleDropdown).click();
		System.out.println("The user is able to click on DQ Rule Dropdown");
	}
	
	//Click on Source Attribute Dropdown
	public   void clickDQASourceAttributeDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQASourceAttributeDropdown));
		driver.findElement(DataQualityAssignmentLocators.DQASourceAttributeDropdown).click();
		System.out.println("The user is able to click on Source Attribute Dropdown");
	}
	
	//Click on DQ Start Date
	public   void clickDQADQStartDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQStartDate));
		driver.findElement(DataQualityAssignmentLocators.DQADQStartDate).click();
		System.out.println("The user is able to click on DQ Start Date");
	}
	
	//Click on DQ End Date
	public   void clickDQADQEndDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADQEndDate));
		driver.findElement(DataQualityAssignmentLocators.DQADQEndDate).click();
		System.out.println("The user is able to click on DQ End Date");
	}
	
	//Click on Reset Button
	public   void clickDQAResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQAResetButton));
		driver.findElement(DataQualityAssignmentLocators.DQAResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickDQACancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(DataQualityAssignmentLocators.DQACategoryTextVisible).getText();
		Assert.assertEquals("Data Quality Assignment Category", actual);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQACancelButton));
		driver.findElement(DataQualityAssignmentLocators.DQACancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");
		
	}
	
	//Click on Update Button
	public   void clickDQAUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQAUpdateButton));
		driver.findElement(DataQualityAssignmentLocators.DQAUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public   void clickDQAEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQAEditButton));
		driver.findElement(DataQualityAssignmentLocators.DQAEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	//Verify Assignment Category Text is Visible
	public   void verifyDQACategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQACategoryTextVisible));
		boolean category = driver.findElement(DataQualityAssignmentLocators.DQACategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}
	
	//Click on Delete Button
	public   void clickDQADeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteButton));
		driver.findElement(DataQualityAssignmentLocators.DQADeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickDQADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteConfirmationPopupConfirmButton));
		driver.findElement(DataQualityAssignmentLocators.DQADeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickDQADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteConfirmationPopupCancelButton));
		driver.findElement(DataQualityAssignmentLocators.DQADeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String ruleStartTimeStamp = driver.findElement(DataQualityAssignmentLocators.DQADQStartDate).getAttribute("value");
		String ruleEndTimeStamp = driver.findElement(DataQualityAssignmentLocators.DQADQEndDate).getAttribute("value");
		Assert.assertEquals("", ruleStartTimeStamp);
		Assert.assertEquals("", ruleEndTimeStamp);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyDQAAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {
		
		String actual = driver.findElement(DataQualityAssignmentLocators.DQACategoryTextVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println("The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyDQADeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(DataQualityAssignmentLocators.DQADeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyDQADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(DataQualityAssignmentLocators.DQADeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyDQADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataQualityAssignmentLocators.DQADeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(DataQualityAssignmentLocators.DQADeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}
	
// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyDQAFileRemoval() {
		boolean grid = driver.findElement(DataQualityAssignmentLocators.DQAAssignmentGridVisible).isDisplayed();
		Assert.assertTrue(grid);
}}
