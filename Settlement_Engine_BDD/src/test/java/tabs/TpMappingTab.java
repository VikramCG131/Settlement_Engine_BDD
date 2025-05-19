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
import constants.ClientMappingConstants;
import constants.TpMappingConstants;
import locators.TpMappingLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import steps.TpMappingSteps;
import utils.DriverManager;

public class TpMappingTab  {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public TpMappingTab() {
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

	// Click on Add New Button
	public void clickTPAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPAddNewButton));
		driver.findElement(TpMappingLocators.TPAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add Button");
	}
	//select the dropdown value tp_mapping_lkp
	 public void Tp_Mapping_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
	    {
	    	WebElement dropdownElement = driver.findElement(TpMappingLocators.TPSourceTabledropdown); 
	    	dropdownElement.click();
         Select dropdown = new Select(dropdownElement);
         dropdown.selectByValue("tp_mapping_lkp"); // Replace 'option_value' with the actual value
	    }
	 
	// Enter the Field Value in TP mapping Category
	public void enterTPCategoryFieldValue( String elmCode, String name) {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPElmCode));
		driver.findElement(TpMappingLocators.TPElmCode).sendKeys(elmCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPName));
		driver.findElement(TpMappingLocators.TPName).sendKeys(name);
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickTPSubmitButton() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSubmitButton));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(TpMappingLocators.TPSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyTPSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSuccessPopupMessage));
		String successMessage = driver.findElement(TpMappingLocators.TPSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSuccesspopupMessageUploadOk)).click();
	}

	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSearchforElmCode)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSearchforElmCode)).sendKeys(TpMappingConstants.ELM_CODE.getValue()+random);
			wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSearchforstatus)).click();;
			wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSearchforstatus)).sendKeys("NEW");
			
		}
	// Verify the Update Popup Message
	public void verifyTPUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPUpdatePopupMessage));
		String successMessage = driver.findElement(TpMappingLocators.TPUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click TP mapping and Blank Selection
	public void clickTPClientCodeblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPElmCode));
		driver.findElement(TpMappingLocators.TPElmCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPName));
		driver.findElement(TpMappingLocators.TPName).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(TpMappingLocators.TPClentCodeErrorValidation).getText();
		Assert.assertEquals("Elm Code is required.", actual);
		System.out.println("The user is able to click on Elm code and validate the error message");
	}

	// Click on Reset Button
	public void clickTPResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPResetButton));
		driver.findElement(TpMappingLocators.TPResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickTPCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(TpMappingLocators.TPCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPCancelButton));
		driver.findElement(TpMappingLocators.TPCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickTPUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPUpdateButton));
		driver.findElement(TpMappingLocators.TPUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickTPEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPEditButton));
		driver.findElement(TpMappingLocators.TPEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify TP mapping up Category Text is Visible
	public void verifyTPCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPCategoryTextPageVisible));
		boolean category = driver.findElement(TpMappingLocators.TPCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editShopCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPElmCode));
		driver.findElement(TpMappingLocators.TPElmCode).clear();
		driver.findElement(TpMappingLocators.TPElmCode).sendKeys(random);

	}

	// Click on Delete Button
	public void clickTPDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDeleteButton));
		driver.findElement(TpMappingLocators.TPDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickTPDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupConfirmButton));
		driver.findElement(TpMappingLocators.TPDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickTPDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupCancelButton));
		driver.findElement(TpMappingLocators.TPDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String elmCode = driver.findElement(TpMappingLocators.TPElmCode).getAttribute("value");
		String name = driver.findElement(TpMappingLocators.TPName).getAttribute("value");
	
		Assert.assertEquals("", elmCode);
		Assert.assertEquals("", name);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyTPAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(TpMappingLocators.TPCategoryTextVisible).getText();
		Assert.assertNotEquals("Common Reference Look Up Category", actual);
		System.out.println(
				"The user is able to verify the Common Reference Look Up Grid is visible and Common Reference Look Up Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyTPDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(TpMappingLocators.TPDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyTPDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(TpMappingLocators.TPDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyTPDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(TpMappingLocators.TPDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyTPFileRemoval() {
		boolean grid = driver.findElement(TpMappingLocators.TPGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickTPDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDownloadButton));
		driver.findElement(TpMappingLocators.TPDownloadButton).click();
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
// verify download only approve record
	// Click on Download Button
		public void clickTPDownloadButtonApproverecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDownloadButtonApproveRecord));
			driver.findElement(TpMappingLocators.TPDownloadButtonApproveRecord).click();
			try {
				Thread.sleep(1000); // Or use polling logic for better wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The user is able to click on Download Button");
		}

		// Verify Downloaded file
		public void verifyFileDownloadedForApprove() {
			String downloadPath = System.getProperty("user.dir") + "/downloads";
			File downloadDir = new File(downloadPath);
			if (!downloadDir.exists())
				downloadDir.mkdir();
			String fileName = "example.csv";
			File downloadedFile = new File(downloadDir, fileName);
			System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
			
		}
		/*
	// Click on Upload Button
	public void clickTPUploadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPUploadButton));
		driver.findElement(TpMappingLocators.TPUploadButton).isDisplayed();
		System.out.println("The upload button is visible and is clickable");
	}
	
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(TpMappingLocators.TPSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\Tp_Mapping.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((TpMappingLocators.TPSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 */
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPSendforApprovalButton));
			driver.findElement(TpMappingLocators.TPSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(TpMappingLocators.TPConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(TpMappingLocators.TPDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((TpMappingLocators.TPDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
	    
	   
 
}
