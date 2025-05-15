package tabs;

import java.io.IOException;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import constants.BrandMappingConstants;
import constants.EmailAlertConstants;
import locators.BrandMappingLocators;
import locators.EmailAlertsLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class EmailAlertsTab {
	private WebDriver driver;
	private WebDriverWait wait;
	static String random;
	//Constructor to initialize the driver and wait
	public EmailAlertsTab() {
		this.driver = DriverManager.getDriver();
		
		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public void openLoginPage() {
		driver.get(LoginPageLocators.SE_URL);
		System.out.println("The user is able to open the login page");
	}
	
	//Verify health check of the URL
	public void verifyHealthCheck() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, LoginPageLocators.SE_URL);
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
	
	//Click on Data Quality Assignment Tab
	public   void clickEmailAlertsTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EmailAlertTab));
		driver.findElement(EmailAlertsLocators.EmailAlertTab).click();
		System.out.println("The user is able to click on Data Source File Tab");
	}
	
	//Click on Add New Button
	public   void clickEAAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAAddNewButton));
		driver.findElement(EmailAlertsLocators.EAAddNewButton).click();
		System.out.println("The user is able to click on Add New Button");
	}
	
	//Enter the Field Value in Data Source File Category
	public   void enterEAFieldValue(String templateType, String emailaddress,String subject, String insertText ){
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EATemplateTypeDropdown));
		Select templatetypedropdown = new Select(driver.findElement(EmailAlertsLocators.EATemplateTypeDropdown));
		templatetypedropdown.selectByIndex(3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAEmailAddress));
		driver.findElement(EmailAlertsLocators.EAEmailAddress).sendKeys(random+emailaddress);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASubject));
		driver.findElement(EmailAlertsLocators.EASubject).sendKeys(subject);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAInsertText));
		driver.findElement(EmailAlertsLocators.EAInsertText).sendKeys(insertText);
		System.out.println("The user is able to enter the field value in Email Alert Category");
	}
	
	//Click on Submit Button
	public   void clickEASubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASubmitButton));
		driver.findElement(EmailAlertsLocators.EASubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Update Popup Message
			public   void verifyEAUpdatePopupMessage() {
				wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAUpdatePopupMessage));
				String successMessage = driver.findElement(EmailAlertsLocators.EAUpdatePopupMessage).getText();
				Assert.assertEquals(successMessage, "Record has been updated successfully");
				System.out.println("The user is able to verify the Update Popup Message");
			}
			
	//Verify the Success Popup Message
	public   void verifyEASuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASuccessPopupMessage));
		String successMessage = driver.findElement(EmailAlertsLocators.EASuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASuccesspopupMessageUploadOk)).click();
	}
	
	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASearchforClientcode)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASearchforClientcode)).sendKeys(random+EmailAlertConstants.EMAIL_ADDRESS.getValue());
			Thread.sleep(2000);
		}
	
	//Click on File Pattern and Blank Selection
	public   void clickEAEmailAddressblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAEmailAddress));
		driver.findElement(EmailAlertsLocators.EAEmailAddress).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EASubject));
		driver.findElement(EmailAlertsLocators.EASubject).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		String actual = driver.findElement(EmailAlertsLocators.EAEmailAddressValidation).getText();
		Assert.assertEquals("Please Enter EmailAddress", actual);
		System.out.println("The user is able to click on Email Address and validate the error message");
	}
	
	//Click on Reset Button
	public   void clickEAResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAResetButton));
		driver.findElement(EmailAlertsLocators.EAResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickEACancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EACategoryTextVisible));
		boolean grid = driver.findElement(EmailAlertsLocators.EACategoryTextVisible).isDisplayed();
		Assert.assertTrue(grid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EACancelButton));
		driver.findElement(EmailAlertsLocators.EACancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public   void clickEAUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAUpdateButton));
		driver.findElement(EmailAlertsLocators.EAUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public void clickEAEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAEditButton));
		driver.findElement(EmailAlertsLocators.EAEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	
	//Verify Assignment Category Text is Visible
	public   void verifyEACategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EACategoryTextVisibleGrid));
		boolean category = driver.findElement(EmailAlertsLocators.EACategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the File Information Text is visible");
	}	
	
	
	//Click on Delete Button
	public   void clickEADeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteButton));
		driver.findElement(EmailAlertsLocators.EADeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteConfirmationPopupConfirmButton));
		driver.findElement(EmailAlertsLocators.EADeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteConfirmationPopupCancelButton));
		driver.findElement(EmailAlertsLocators.EADeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String templateType = driver.findElement(EmailAlertsLocators.EATemplateTypeDropdown).getAttribute("value");
		String emailAddress = driver.findElement(EmailAlertsLocators.EAEmailAddress).getAttribute("value");
		String subject = driver.findElement(EmailAlertsLocators.EASubject).getAttribute("value");
		
		Assert.assertEquals("", templateType);
		Assert.assertEquals("", emailAddress);
		Assert.assertEquals("", subject);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
	public void verifyEAGridVisibleandFileInformationNotVisible() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean category = driver.findElement(EmailAlertsLocators.EACategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyEADeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(EmailAlertsLocators.EADeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	public void editEmailAddressValue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EAEmailAddress));
		driver.findElement(EmailAlertsLocators.EAEmailAddress).clear();
		driver.findElement(EmailAlertsLocators.EAEmailAddress).sendKeys("test123@yahoo.com");
	}
	
	public void verifyEAFileRemoval() {
		boolean grid = driver.findElement(EmailAlertsLocators.EAGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(EmailAlertsLocators.EADeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAlertsLocators.EADeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(EmailAlertsLocators.EADeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}


	
	
}
