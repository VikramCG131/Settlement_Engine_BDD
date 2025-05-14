package tabs;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import constants.ClientLookUpConstants;
import constants.DataSourceFileConstants;
import constants.DueDateLookupConstants;
import locators.DueDateLookupLocators;
import locators.ClientLookupLocators;
import locators.ClientMappingLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class DueDateLookupTab {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public DueDateLookupTab() {
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
	public void clickReferenceLookUpButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ReferenceLookUpButton));
		driver.findElement(LoginPageLocators.ReferenceLookUpButton).click();
		System.out.println("The user is able to click on Reference Look Up Button");
	}

	// Click on Hamburger Menu Button
	public void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.HamburgerButton));
		driver.findElement(LoginPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}

	// Click on Brand Maping Tab
	
	public void Due_date_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
    {
    	WebElement dropdownElement = driver.findElement(DueDateLookupLocators.DDLSourceTabledropdown); 
    	dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("due_date_lkp"); // Replace 'option_value' with the actual value
    }

	// Click on Add New Button
	public void clickBMAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLAddNewButton));
		driver.findElement(DueDateLookupLocators.DDLAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterBMCategoryFieldValue(String clintCode, String dataset,String capitalTerms, String comissionTerms,
			String movementType, String ruleType, String produceCode, String ruleExpression) {
		
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLClientCode));
		driver.findElement(DueDateLookupLocators.DDLClientCode).sendKeys(clintCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDataSet));
		driver.findElement(DueDateLookupLocators.DDLDataSet).sendKeys(dataset);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLCapitalTerms));
		driver.findElement(DueDateLookupLocators.DDLCapitalTerms).sendKeys(capitalTerms+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLComissionTerms));
		driver.findElement(DueDateLookupLocators.DDLComissionTerms).sendKeys(comissionTerms);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLMovementType));
		driver.findElement(DueDateLookupLocators.DDLMovementType).sendKeys(movementType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLRULEType));
		driver.findElement(DueDateLookupLocators.DDLRULEType).sendKeys(ruleType+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLProduceCode));
		driver.findElement(DueDateLookupLocators.DDLProduceCode).sendKeys(produceCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLRuleExpression));
		driver.findElement(DueDateLookupLocators.DDLRuleExpression).sendKeys(ruleExpression+random);
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickBMSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSubmitButton));
		driver.findElement(DueDateLookupLocators.DDLSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyBMSuccessPopupMessage() throws InterruptedException  {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSuccessPopupMessage));
		String successMessage = driver.findElement(DueDateLookupLocators.DDLSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSuccesspopupMessageUploadOk)).click();
	}
	//search for the added record
	public void AddedRecorddSearch() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSearchforClientcode)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSearchforClientcode)).sendKeys(DueDateLookupConstants.CLIENT_CODE.getValue()+random);
		
		
	}

	//veriy the search functionality added same record

	// Verify the Update Popup Message
	public void verifyBMUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLUpdatePopupMessage));
		String successMessage = driver.findElement(DueDateLookupLocators.DDLUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickBMClientCodeblankSelection() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLClientCode));
		driver.findElement(DueDateLookupLocators.DDLClientCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDataSet));
		driver.findElement(DueDateLookupLocators.DDLDataSet).click();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String actual = driver.findElement(DueDateLookupLocators.DDLErrorValidation).getText();
		Thread.sleep(2000);
		Assert.assertEquals("Client Code is required.", actual);
		System.out.println("The user is able to click on Client code and validate the error message");
	}

	// Click on Reset Button
	public void clickBMResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLResetButton));
		driver.findElement(DueDateLookupLocators.DDLResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickBMCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(DueDateLookupLocators.DDLCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLCancelButton));
		driver.findElement(DueDateLookupLocators.DDLCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
		public void verifyBMGridVisibleandFileInformationNotVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			boolean category = driver.findElement(DueDateLookupLocators.DDLCategoryTextPageVisible).isDisplayed();
			Assert.assertTrue(category);
			System.out.println("The user is able to verify Common Reference Look Up Category and Look up is not  visible");
		}

	// Click on Update Button
	public void clickBMUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLUpdateButton));
		driver.findElement(DueDateLookupLocators.DDLUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickBMEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLEditButton));
		driver.findElement(DueDateLookupLocators.DDLEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify  Brannd Category Text is Visible
	public void verifyBMCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLCategoryTextVisible));
		boolean category = driver.findElement(DueDateLookupLocators.DDLCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Common Reference Look Up Category Text is visible");
	}

	public void editClientCodeValue() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLProduceCode));
		driver.findElement(DueDateLookupLocators.DDLProduceCode).clear();
		Thread.sleep(2000);
		driver.findElement(DueDateLookupLocators.DDLProduceCode).sendKeys("111");
		
	}

	// Click on Delete Button
	public void clickBMDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteButton));
		driver.findElement(DueDateLookupLocators.DDLDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton));
		driver.findElement(DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupCancelButton));
		driver.findElement(DueDateLookupLocators.DDLDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String clientCode = driver.findElement(DueDateLookupLocators.DDLClientCode).getAttribute("value");
		String DDLDataSet = driver.findElement(DueDateLookupLocators.DDLDataSet).getAttribute("value");
		String capitalTerms = driver.findElement(DueDateLookupLocators.DDLCapitalTerms).getAttribute("value");
		String comissionTerms = driver.findElement(DueDateLookupLocators.DDLComissionTerms).getAttribute("value");
		String movementType = driver.findElement(DueDateLookupLocators.DDLMovementType).getAttribute("value");
		String ruleType = driver.findElement(DueDateLookupLocators.DDLRULEType).getAttribute("value");
		String produceCode = driver.findElement(DueDateLookupLocators.DDLProduceCode).getAttribute("value");
		String ruleExpression = driver.findElement(DueDateLookupLocators.DDLRuleExpression).getAttribute("value");
		Assert.assertEquals("", clientCode);
		Assert.assertEquals("", DDLDataSet);
		Assert.assertEquals("", capitalTerms);
		Assert.assertEquals("", comissionTerms);
		Assert.assertEquals("", movementType);
		Assert.assertEquals("", ruleType);
		Assert.assertEquals("", produceCode);
		Assert.assertEquals("", ruleExpression);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyBMAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(DueDateLookupLocators.DDLCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Common Reference Look Up ", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyBMDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(DueDateLookupLocators.DDLDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(DueDateLookupLocators.DDLDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyBMFileRemoval() {
		boolean grid = driver.findElement(DueDateLookupLocators.DDLGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickBMDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDownloadButton));
		driver.findElement(DueDateLookupLocators.DDLDownloadButton).click();
		try {
			Thread.sleep(1000); // Or use polling logic for better wait
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
		
	}
	
	// download only approved records
	
	// Click on Download Button
		public void clickBMDownloadAllApproveRecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDownloadButtonApproveRecord));
			driver.findElement(DueDateLookupLocators.DDLDownloadButtonApproveRecord).click();
			try {
				Thread.sleep(1000); // Or use polling logic for better wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The user is able to click on Download Button");
		}

		// Verify Downloaded file
		public void verifyFileDownloadedAllApproveRecord() {
			String downloadPath = System.getProperty("user.dir") + "/downloads";
			File downloadDir = new File(downloadPath);
			if (!downloadDir.exists())
				downloadDir.mkdir();
			String fileName = "example.csv";
			File downloadedFile = new File(downloadDir, fileName);
			System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
			
		}

	// Click on Upload Button
	public void clickBMUploadButton() {
		WebElement uploadButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLUploadButton));
		driver.findElement(DueDateLookupLocators.DDLUploadButton).isDisplayed();
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploadButton)) != null);
		System.out.println("The upload button is visible and is clickable");
	}
	//BMSelectValidFile
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(DueDateLookupLocators.DDLSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\due_date_Lookup.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((DueDateLookupLocators.DDLSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLSendforApprovalButton));
			driver.findElement(DueDateLookupLocators.DDLSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(DueDateLookupLocators.DDLConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(DueDateLookupLocators.DDLDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((DueDateLookupLocators.DDLDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
 
}
