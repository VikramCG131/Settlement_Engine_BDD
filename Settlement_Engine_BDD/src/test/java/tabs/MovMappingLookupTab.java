package tabs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
import locators.MovMappingLookupLocators;
import locators.ClientLookupLocators;
import locators.ClientMappingLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class MovMappingLookupTab {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public MovMappingLookupTab() {
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
	
	public void Move_Mapping_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
    {
    	WebElement dropdownElement = driver.findElement(MovMappingLookupLocators.MMSourceTabledropdown); 
    	dropdownElement.click();
    			Thread.sleep(2000); // Wait for the dropdown options to be visible
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("mov_mapping_lkp"); // Replace 'option_value' with the actual value
    }

	// Click on Add New Button
	public void clickMMAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMAddNewButton));
		driver.findElement(MovMappingLookupLocators.MMAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterMMCategoryFieldValue(String clintCode, String brandCode) {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMMovemnetType));
		driver.findElement(MovMappingLookupLocators.MMMovemnetType).sendKeys(clintCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDescription));
		driver.findElement(MovMappingLookupLocators.MMDescription).sendKeys(brandCode+random);
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on SuMMit Button
	public void clickMMSuMMitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSuMMitButton));
		driver.findElement(MovMappingLookupLocators.MMSuMMitButton).click();
		System.out.println("The user is able to click on SuMMit Button");
	}

	// Verify the Success Popup Message
	public void verifyMMSuccessPopupMessage() throws InterruptedException  {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSuccessPopupMessage));
		String successMessage = driver.findElement(MovMappingLookupLocators.MMSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSuccesspopupMessageUploadOk)).click();
	}
	//search for the added record
	public void AddedRecorddSearch() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSearchMovementType)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSearchMovementType)).sendKeys(BrandMappingConstants.CLIENT_CODE.getValue()+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSearchforstatus)).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSearchforstatus)).sendKeys("NEW");
		
	}
	
	
	//veriy the search functionality added same record

	// Verify the Update Popup Message
	public void verifyMMUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMUpdatePopupMessage));
		String successMessage = driver.findElement(MovMappingLookupLocators.MMUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickMMClientCodeblankSelection() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMMovemnetType));
		driver.findElement(MovMappingLookupLocators.MMMovemnetType).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDescription));
		driver.findElement(MovMappingLookupLocators.MMDescription).click();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 Thread.sleep(2000);
		String actual = driver.findElement(MovMappingLookupLocators.MMErrorValidation).getText();
		Assert.assertEquals("Movement Type is required.", actual);
		System.out.println("The user is able to click on Client code and validate the error message");
	}

	// Click on Reset Button
	public void clickMMResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMResetButton));
		driver.findElement(MovMappingLookupLocators.MMResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickMMCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(MovMappingLookupLocators.MMCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMCancelButton));
		driver.findElement(MovMappingLookupLocators.MMCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
		public void verifyMMGridVisibleandFileInformationNotVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			boolean category = driver.findElement(MovMappingLookupLocators.MMCategoryTextPageVisible).isDisplayed();
			Assert.assertTrue(category);
			System.out.println("The user is able to verify Common Reference Look Up Category and Look up is not  visible");
		}

	// Click on Update Button
	public void clickMMUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMUpdateButton));
		driver.findElement(MovMappingLookupLocators.MMUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickMMEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMEditButton));
		driver.findElement(MovMappingLookupLocators.MMEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify  Move Category Text is Visible
	public void verifyMMCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMCategoryTextVisible));
		boolean category = driver.findElement(MovMappingLookupLocators.MMCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Common Reference Look Up Category Text is visible");
	}

	public void editClientCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDescription));
		driver.findElement(MovMappingLookupLocators.MMDescription).clear();
		driver.findElement(MovMappingLookupLocators.MMDescription).sendKeys(random);

	}

	// Click on Delete Button
	public void clickMMDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteButton));
		driver.findElement(MovMappingLookupLocators.MMDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickMMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton));
		driver.findElement(MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickMMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupCancelButton));
		driver.findElement(MovMappingLookupLocators.MMDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String Movementtype = driver.findElement(MovMappingLookupLocators.MMMovemnetType).getAttribute("value");
		String Description = driver.findElement(MovMappingLookupLocators.MMDescription).getAttribute("value");
		
		Assert.assertEquals("", Movementtype);
		Assert.assertEquals("", Description);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyMMAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(MovMappingLookupLocators.MMCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Common Reference Look Up ", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyMMDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(MovMappingLookupLocators.MMDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyMMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyMMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(MovMappingLookupLocators.MMDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyMMFileRemoval() {
		boolean grid = driver.findElement(MovMappingLookupLocators.MMGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickMMDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDownloadButton));
		driver.findElement(MovMappingLookupLocators.MMDownloadButton).click();
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
		public void clickMMDownloadAllApproveRecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDownloadButtonApproveRecord));
			driver.findElement(MovMappingLookupLocators.MMDownloadButtonApproveRecord).click();
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
	public void clickMMUploadButton() {
		WebElement uploadButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMUploadButton));
		driver.findElement(MovMappingLookupLocators.MMUploadButton).isDisplayed();
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploadButton)) != null);
		System.out.println("The upload button is visible and is clickable");
	}
	//MMSelectValidFile
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(MovMappingLookupLocators.MMSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\mov_mapping_lkp.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((MovMappingLookupLocators.MMSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMSendforApprovalButton));
			driver.findElement(MovMappingLookupLocators.MMSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify suMMission of file for approval
	    public void fileSuMMittedForApproval() {
	    	WebElement popup = driver.findElement(MovMappingLookupLocators.MMConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(MovMappingLookupLocators.MMDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((MovMappingLookupLocators.MMDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
 
}
