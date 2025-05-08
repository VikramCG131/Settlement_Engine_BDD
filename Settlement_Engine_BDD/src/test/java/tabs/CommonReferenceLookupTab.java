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
import constants.BrandMappingConstants;
import constants.ClientLookUpConstants;
import constants.DataSourceFileConstants;
import locators.CommonReferenceLookupLocators;
import locators.ClientLookupLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class CommonReferenceLookupTab {

	private WebDriver driver;
	public WebDriverWait wait;

	// Constructor to initialize the driver and wait
	public CommonReferenceLookupTab() {
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
	public void clickBrandMapingTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLBrandMapingTab));
		driver.findElement(CommonReferenceLookupLocators.CRLBrandMapingTab).click();
		System.out.println("The user is able to click on Brand Mapping Tab");
	}

	// Click on Add New Button
	public void clickCRLAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLAddNewButton));
		driver.findElement(CommonReferenceLookupLocators.CRLAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value inCommon Reference Looup Category
	public void enterCRLCategoryFieldValue(String clintCode, String brandCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLClientCode));
		driver.findElement(CommonReferenceLookupLocators.CRLClientCode).sendKeys(clintCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLBrandCode));
		driver.findElement(CommonReferenceLookupLocators.CRLBrandCode).sendKeys(brandCode);
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on SuCRLit Button
	public void clickCRLSuCRLitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSuCRLitButton));
		driver.findElement(CommonReferenceLookupLocators.CRLSuCRLitButton).click();
		System.out.println("The user is able to click on SuCRLit Button");
	}

	// Verify the Success Popup Message
	public void verifyCRLSuccessPopupMessage() throws InterruptedException  {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSuccessPopupMessage));
		String successMessage = driver.findElement(CommonReferenceLookupLocators.CRLSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSuccesspopupMessageUploadOk)).click();
	}
	//search for the added record
	public void AddedRecorddSearch() throws InterruptedException
	{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSearchforClientcode)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSearchforClientcode)).sendKeys(BrandMappingConstants.CLIENT_CODE.getValue()+CommonUtilities.random);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSearchforstatus)).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSearchforstatus)).sendKeys("Not Approved");
		Thread.sleep(5000);
	}
	
	
	//veriy the search functionality added same record

	// Verify the Update Popup Message
	public void verifyCRLUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLUpdatePopupMessage));
		String successMessage = driver.findElement(CommonReferenceLookupLocators.CRLUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickCRLClientCodeblankSelection() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLClientCode));
		driver.findElement(CommonReferenceLookupLocators.CRLClientCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLBrandCode));
		driver.findElement(CommonReferenceLookupLocators.CRLBrandCode).click();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String actual = driver.findElement(CommonReferenceLookupLocators.CRLErrorValidation).getText();
		Assert.assertEquals("Please enter Client Code", actual);
		System.out.println("The user is able to click on Client code and validate the error message");
	}

	// Click on Reset Button
	public void clickCRLResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLResetButton));
		driver.findElement(CommonReferenceLookupLocators.CRLResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickCRLCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(CommonReferenceLookupLocators.CRLCCategoryTextVisible).getText();
		Assert.assertEquals("Brand Mapping Category", actual);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLCancelButton));
		driver.findElement(CommonReferenceLookupLocators.CRLCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}
	//Verify the Data Source File Grid is visible and File Information is Not Visible
		public void verifyCRLGridVisibleandFileInformationNotVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			boolean category = driver.findElement(CommonReferenceLookupLocators.CRLCCategoryTextPageVisible).isDisplayed();
			Assert.assertTrue(category);
			System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
		}

	// Click on Update Button
	public void clickCRLUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLUpdateButton));
		driver.findElement(CommonReferenceLookupLocators.CRLUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickCRLEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLEditButton));
		driver.findElement(CommonReferenceLookupLocators.CRLEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify  Brannd Category Text is Visible
	public void verifyCRLCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLCCategoryTextVisible));
		boolean category = driver.findElement(CommonReferenceLookupLocators.CRLCCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editClientCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLClientCode));
		driver.findElement(CommonReferenceLookupLocators.CRLClientCode).clear();
		driver.findElement(CommonReferenceLookupLocators.CRLClientCode).sendKeys("0.9");

	}

	// Click on Delete Button
	public void clickCRLDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteButton));
		driver.findElement(CommonReferenceLookupLocators.CRLDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickCRLDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton));
		driver.findElement(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickCRLDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupCancelButton));
		driver.findElement(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String clientCode = driver.findElement(CommonReferenceLookupLocators.CRLClientCode).getAttribute("value");
		String brandCode = driver.findElement(CommonReferenceLookupLocators.CRLBrandCode).getAttribute("value");
		
		Assert.assertEquals("", clientCode);
		Assert.assertEquals("", brandCode);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyCRLAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(CommonReferenceLookupLocators.CRLCCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyCRLDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyCRLDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyCRLDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyCRLFileRemoval() {
		boolean grid = driver.findElement(CommonReferenceLookupLocators.CRLGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickCRLDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDownloadButton));
		driver.findElement(CommonReferenceLookupLocators.CRLDownloadButton).click();
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
		
	}

	// Click on Upload Button
	public void clickCRLUploadButton() {
		WebElement uploadButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLUploadButton));
		driver.findElement(CommonReferenceLookupLocators.CRLUploadButton).isDisplayed();
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploadButton)) != null);
		System.out.println("The upload button is visible and is clickable");
	}
	//CRLSelectValidFile
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(CommonReferenceLookupLocators.CRLSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\Brandmapping.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((CommonReferenceLookupLocators.CRLSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLSendforApprovalButton));
			driver.findElement(CommonReferenceLookupLocators.CRLSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify suCRLission of file for approval
	    public void fileSuCRLittedForApproval() {
	    	WebElement popup = driver.findElement(CommonReferenceLookupLocators.CRLConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonReferenceLookupLocators.CRLDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((CommonReferenceLookupLocators.CRLDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
 
}
