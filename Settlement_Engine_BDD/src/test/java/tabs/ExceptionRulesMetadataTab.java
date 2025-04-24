package tabs;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.ExceptionRulesMetadataConstants;
import locators.DataQualityAssignmentLocators;
import locators.ExceptionalRuleMetaDataLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class ExceptionRulesMetadataTab {

	private WebDriver driver;
	public WebDriverWait wait;

	// Constructor to initialize the driver and wait
	public ExceptionRulesMetadataTab() {
		this.driver = DriverManager.getDriver();

		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Open the login page
	public void openLoginPage() {
		driver.get(LoginPageLocators.SE_URL);
		System.out.println("The user is able to open the login page");
	}

	// Verify health check of the URL
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

	// Verify the Title of the Page
	public void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Settlement Engine");
		System.out.println("The user is able to verify the title of the page");
	}

	// Click on Reference Look Up Button
	public void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.MetaDataButton));
		driver.findElement(LoginPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}

	// Click on Hamburger Menu Button
	public void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.HamburgerButton));
		driver.findElement(LoginPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}

	// Click on Client Lookup Tab
	public void clickExceptionRuleTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDataColumnTab));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRDataColumnTab).click();
		System.out.println("The user is able to click on Exception rules metadata Tab");
	}

	// Click on Add New Button
	public void clickEXRAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRAddNewButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterEXRCategoryFieldValue(String ruleType, String severity, String exceptionOwners, String inputSource, String inputattributes, String refrenceFile, String refattributes) {
		//Rule type drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRRuleTypeDropDown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select ruletypedropdown = new Select(driver.findElement(ExceptionalRuleMetaDataLocators.EXRRuleTypeDropDown));
		ruletypedropdown.selectByVisibleText("Lookup");
		System.out.println("Selected Rule Type: Lookup");
		//Servirity drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRSeverityDropDown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select severitydropdown = new Select(driver.findElement(ExceptionalRuleMetaDataLocators.EXRSeverityDropDown));
		severitydropdown.selectByVisibleText(severity);
		System.out.println("Selected Severity: Medium");
		//Exception Owners
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRExceptionOwners));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRExceptionOwners).sendKeys(exceptionOwners);
		//Input Source drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRInputSourceDropdown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select inputsourcedropdown = new Select(driver.findElement(ExceptionalRuleMetaDataLocators.EXRInputSourceDropdown));
		inputsourcedropdown.selectByVisibleText("tallyman_raw");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRInputSourceTextClick)).click();
		System.out.println("Selected Input Source: tallyman_raw");
		//Input Source Attribute drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRInputSourceAttributeDropdownClick)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> options = driver.findElements(ExceptionalRuleMetaDataLocators.EXRInputSourceAttributeDropdownSelect);
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		options.get(randomIndex).click();
		System.out.println("Selected Input Attributes: ");	
		//Click on Add 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRAddLookUpButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRAddLookUpButton).click();
		//select the reference file drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRReferencefiledropdown)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement referencefiledropdown = driver.findElement(ExceptionalRuleMetaDataLocators.EXRReferencefiledropdown);
		Select dropdownreffile = new Select(referencefiledropdown);
		List<WebElement> options1 = dropdownreffile.getOptions();
		int randomindexreffiledrop = new Random().nextInt(options1.size());
		dropdownreffile.selectByIndex(randomindexreffiledrop);
		System.out.println("Selected Reference File: ");	
		//click on the reference file for select attribute
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRReferencefileAttributedropdownClick)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select refattributedropdown = new Select(driver.findElement(ExceptionalRuleMetaDataLocators.EXRReferencefileAttributedropdownSelect));
		refattributedropdown.selectByVisibleText(refattributes);
		System.out.println("Selected Reference Attributes: ");	
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickEXRSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRSubmitButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyEXRSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRSuccessPopupMessage));
		String successMessage = driver.findElement(ExceptionalRuleMetaDataLocators.EXRSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}

	// Verify the Update Popup Message
	public void verifyEXRUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRUpdatePopUuMessage));
		String successMessage = driver.findElement(ExceptionalRuleMetaDataLocators.EXRUpdatePopUuMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickEXRRuleTypeblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRRuleTypeDropDown));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRRuleTypeDropDown).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRSeverityDropDown));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRSeverityDropDown).click();

		String actual = driver.findElement(ExceptionalRuleMetaDataLocators.EXRValidationErrorRuleType).getText();
		Assert.assertEquals("Please Enter Client Code", actual);
		System.out.println("The user is able to click on Rule Type and validate the error message");
	}

	// Click on Reset Button
	public void clickEXRResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRResetButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickEXRCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ExceptionalRuleMetaDataLocators.EXRGridVisible).getText();
		Assert.assertEquals("Client Look Up Category", actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRCancelButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickEXRUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRUpdateButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickEXREditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXREditButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXREditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Client look up Category Text is Visible
	public void verifyEXRCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRGridVisible));
		boolean category = driver.findElement(ExceptionalRuleMetaDataLocators.EXRGridVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editExceptionOwnerValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRExceptionOwners));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRExceptionOwners).clear();
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRExceptionOwners).sendKeys("Testing Team");;

	}

	// Click on Delete Button
	public void clickEXRDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickEXRDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupConfirmButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickEXRDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupCancelButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String ruletype = driver.findElement(ExceptionalRuleMetaDataLocators.EXRRuleTypeDropDown).getAttribute("value");
		String severity = driver.findElement(ExceptionalRuleMetaDataLocators.EXRSeverityDropDown).getAttribute("value");
		String exrOwners= driver.findElement(ExceptionalRuleMetaDataLocators.EXRExceptionOwners).getAttribute("value");

		Assert.assertEquals("", ruletype);
		Assert.assertEquals("", severity);
		Assert.assertEquals("", exrOwners);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyEXRAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(ExceptionalRuleMetaDataLocators.EXRGridVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyEXRDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyEXRDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyEXRDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(ExceptionalRuleMetaDataLocators.EXRDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyEXRFileRemoval() {
		boolean grid = driver.findElement(ExceptionalRuleMetaDataLocators.EXRGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickEXRDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionalRuleMetaDataLocators.EXRDownloadButton));
		driver.findElement(ExceptionalRuleMetaDataLocators.EXRDownloadButton).click();
		try {
			Thread.sleep(5000); // Or use polling logic for better wait
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The user is able to click on Download Button");
	}

	// Verify Downloaded file
	public void verifyFileDownloaded() {
		String downloadPath = System.getProperty("user.dir") + "/downloads";
		File downloadDir = new File(downloadPath);
		if (!downloadDir.exists())
			downloadDir.mkdir();
		String fileName = "example.csv";
		File downloadedFile = new File(downloadDir, fileName);
		System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
		driver.quit();
	}
}
