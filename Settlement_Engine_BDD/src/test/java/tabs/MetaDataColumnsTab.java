package tabs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.MetaDataColumnsLocators;
import locators.MainPageLocators;
import utils.DriverManager;

public class MetaDataColumnsTab {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor to initialize the driver and wait
	public MetaDataColumnsTab() {
		this.driver = DriverManager.getDriver();
		
		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public void openLoginPage() {
		driver.get("http://localhost:4200");
		System.out.println("The user is able to open the login page");
	}
	
	//Verify health check of the URL
	public void verifyHealthCheck() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:4200/");
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
		Assert.assertEquals(title, "Starter Kit PF Angular");
		System.out.println("The user is able to verify the title of the page");
	}
	
	//Click on MetaData Button
	public  void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.MetaDataButton));
		driver.findElement(MainPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}
	
	//Click on Hamburger Menu Button
	public   void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.HamburgerButton));
		driver.findElement(MainPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}
	
	//Click on Data Quality Assignment Tab
	public   void clickDataQualityAssignmentTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MetaDataColumnTab));
		driver.findElement(MetaDataColumnsLocators.MetaDataColumnTab).click();
		System.out.println("The user is able to click on Data Quality Assignment Tab");
	}
	
	//Click on Add New Button
	public   void clickMDCAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCAddNewButton));
		driver.findElement(MetaDataColumnsLocators.MDCAddNewButton).click();
		System.out.println("The user is able to click on Add New Button");
	}
	
	//Enter the Field Value in Data Quality Assignment Category
	public   void enterMDCCategoryFieldValue(String sourceTable, String sourceAttribute) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSourceTableDropdown));
		Select sourcetabledropdown = new Select(driver.findElement(MetaDataColumnsLocators.MDCSourceTableDropdown));
		sourcetabledropdown.selectByVisibleText(sourceTable);
		System.out.println("Selected Source Table: tallyman_raw");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSourceAttributeDropdown));
		Select sourceattributedropdown = new Select(driver.findElement(MetaDataColumnsLocators.MDCSourceAttributeDropdown));
		sourceattributedropdown.selectByVisibleText(sourceAttribute);
		System.out.println("Selected Source Attribute: product_code");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQRuleDropdown));
		Select dqruledropdown = new Select(driver.findElement(MetaDataColumnsLocators.MDCDQRuleDropdown));
		dqruledropdown.selectByIndex(2);
		System.out.println("Selected DQ Rule by Index: 2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQStartDate));
		driver.findElement(MetaDataColumnsLocators.MDCDQStartDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQStartDateSelect));
		driver.findElement(MetaDataColumnsLocators.MDCDQStartDateSelect).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQEndDate));
		driver.findElement(MetaDataColumnsLocators.MDCDQEndDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQEndDateSelect));
		driver.findElement(MetaDataColumnsLocators.MDCDQEndDateSelect).click();
		System.out.println("The user is able to enter the field value in Data Quality Assignment Category");
	}
	
	//Click on Submit Button
	public   void clickMDCSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSubmitButton));
		driver.findElement(MetaDataColumnsLocators.MDCSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Success Popup Message
	public   void verifyMDCSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSuccessPopupMessage));
		String successMessage = driver.findElement(MetaDataColumnsLocators.MDCSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successFully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}
	
	//Click on Source Table Dropdown
	public   void clickMDCSourceTableDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSourceTableDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCSourceTableDropdown).click();
		System.out.println("The user is able to click on Source Table Dropdown");
	}
	
	//Click on Source Table Dropdown and Blank Selection
	public   void clickMDCSourceTableDropdownandblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSourceTableDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCSourceTableDropdown).click();
		String actual = driver.findElement(MetaDataColumnsLocators.MDCSourceTableValidation).getText();
		Assert.assertEquals("Please select Source Table", actual);
		System.out.println("The user is able to click on Source Table Dropdown and validate the error message");
	}
	
	//Click on DQ Rule Dropdown
	public   void clickMDCDQRuleDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQRuleDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCDQRuleDropdown).click();
		String actual = driver.findElement(MetaDataColumnsLocators.MDCDQRuleValidation).getText();
		Assert.assertEquals("Please select DQ Rule", actual);
		System.out.println("The user is able to click on DQ Rule Dropdown and validate the error message");
	}
	
	//Click on DQ Rule Dropdown and Blank Selection
	public   void clickMDCDQRuleDropdownandBlankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQRuleDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCDQRuleDropdown).click();
		System.out.println("The user is able to click on DQ Rule Dropdown");
	}
	
	//Click on Source Attribute Dropdown
	public   void clickMDCSourceAttributeDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSourceAttributeDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCSourceAttributeDropdown).click();
		System.out.println("The user is able to click on Source Attribute Dropdown");
	}
	
	//Click on DQ Start Date
	public   void clickMDCDQStartDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQStartDate));
		driver.findElement(MetaDataColumnsLocators.MDCDQStartDate).click();
		System.out.println("The user is able to click on DQ Start Date");
	}
	
	//Click on DQ End Date
	public   void clickMDCDQEndDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDQEndDate));
		driver.findElement(MetaDataColumnsLocators.MDCDQEndDate).click();
		System.out.println("The user is able to click on DQ End Date");
	}
	
	//Click on Reset Button
	public   void clickMDCResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCResetButton));
		driver.findElement(MetaDataColumnsLocators.MDCResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickMDCCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCCancelButton));
		driver.findElement(MetaDataColumnsLocators.MDCCancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public   void clickMDCUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCUpdateButton));
		driver.findElement(MetaDataColumnsLocators.MDCUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public   void clickMDCEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCEditButton));
		driver.findElement(MetaDataColumnsLocators.MDCEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	//Verify Assignment Category Text is Visible
	public   void verifyMDCCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCCategoryTextVisible));
		boolean category = driver.findElement(MetaDataColumnsLocators.MDCCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}
	
	//Click on Delete Button
	public   void clickMDCDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickMDCDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickMDCDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String ruleStartTimeStamp = driver.findElement(MetaDataColumnsLocators.MDCDQStartDate).getAttribute("value");
		String ruleEndTimeStamp = driver.findElement(MetaDataColumnsLocators.MDCDQEndDate).getAttribute("value");
		Assert.assertEquals("", ruleStartTimeStamp);
		Assert.assertEquals("", ruleEndTimeStamp);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public   void verifyMDCAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCAssignmentGridVisible));
		boolean grid = driver.findElement(MetaDataColumnsLocators.MDCAssignmentGridVisible).isDisplayed();
		Assert.assertTrue(grid);
		boolean category = driver.findElement(MetaDataColumnsLocators.MDCCategoryTextVisible).isDisplayed();
		Assert.assertFalse(category);
		System.out.println("The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyMDCDeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyMDCDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyMDCDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}
	
	
}
