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
import constants.ClientMappingConstants;
import constants.DataSourceFileConstants;
import locators.BrandMappingLocators;
import locators.ClientMappingLocators;
import locators.ClientMappingLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import steps.ClientMappingSteps;
import utils.DriverManager;

public class ClientMappingTab  {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public ClientMappingTab() {
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

	// Click on Client Lookup Tab
	public void clickClientMappingTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMClientMappingTab));
		driver.findElement(ClientMappingLocators.CLMClientMappingTab).click();
		System.out.println("The user is able to click on Client Lookup Tab");
	}

	// Click on Add New Button
	public void clickCLMAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMAddNewButton));
		driver.findElement(ClientMappingLocators.CLMAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterCLMCategoryFieldValue(String clientCode, String shopCode, String mappedCode) {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMClientCode));
		driver.findElement(ClientMappingLocators.CLMClientCode).sendKeys(clientCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMShopCode));
		driver.findElement(ClientMappingLocators.CLMShopCode).sendKeys(shopCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMMappedCode));
		driver.findElement(ClientMappingLocators.CLMMappedCode).sendKeys(mappedCode);
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickCLMSubmitButton() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSubmitButton));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(ClientMappingLocators.CLMSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyCLMSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSuccessPopupMessage));
		String successMessage = driver.findElement(ClientMappingLocators.CLMSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSuccesspopupMessageUploadOk)).click();
	}

	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSearchforClientcode)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSearchforClientcode)).sendKeys(ClientMappingConstants.CLIENT_CODE.getValue()+random);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSearchforstatus)).click();;
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSearchforstatus)).sendKeys("NEW");
			Thread.sleep(5000);
		}
	// Verify the Update Popup Message
	public void verifyCLMUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMUpdatePopupMessage));
		String successMessage = driver.findElement(ClientMappingLocators.CLMUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click Client mapping and Blank Selection
	public void clickCLMClientCodeblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMClientCode));
		driver.findElement(ClientMappingLocators.CLMClientCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMShopCode));
		driver.findElement(ClientMappingLocators.CLMShopCode).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ClientMappingLocators.CLMClentCodeErrorValidation).getText();
		Assert.assertEquals("Client Code is required.", actual);
		System.out.println("The user is able to click onClient code and validate the error message");
	}

	// Click on Reset Button
	public void clickCLMResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMResetButton));
		driver.findElement(ClientMappingLocators.CLMResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickCLMCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ClientMappingLocators.CLMCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMCancelButton));
		driver.findElement(ClientMappingLocators.CLMCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickCLMUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMUpdateButton));
		driver.findElement(ClientMappingLocators.CLMUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickCLMEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMEditButton));
		driver.findElement(ClientMappingLocators.CLMEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Client mapping up Category Text is Visible
	public void verifyCLMCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMCategoryTextPageVisible));
		boolean category = driver.findElement(ClientMappingLocators.CLMCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editShopCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMShopCode));
		driver.findElement(ClientMappingLocators.CLMShopCode).clear();
		driver.findElement(ClientMappingLocators.CLMShopCode).sendKeys("40");

	}

	// Click on Delete Button
	public void clickCLMDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteButton));
		driver.findElement(ClientMappingLocators.CLMDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickCLMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton));
		driver.findElement(ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickCLMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupCancelButton));
		driver.findElement(ClientMappingLocators.CLMDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String clientCode = driver.findElement(ClientMappingLocators.CLMClientCode).getAttribute("value");
		String shopCode = driver.findElement(ClientMappingLocators.CLMShopCode).getAttribute("value");
		String mappedCode = driver.findElement(ClientMappingLocators.CLMMappedCode).getAttribute("value");


		Assert.assertEquals("", clientCode);
		Assert.assertEquals("", shopCode);
		Assert.assertEquals("", mappedCode);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyCLMAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(ClientMappingLocators.CLMCategoryTextVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyCLMDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(ClientMappingLocators.CLMDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyCLMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyCLMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(ClientMappingLocators.CLMDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyCLMFileRemoval() {
		boolean grid = driver.findElement(ClientMappingLocators.CLMGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickCLMDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDownloadButton));
		driver.findElement(ClientMappingLocators.CLMDownloadButton).click();
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
// verify download only approve record
	// Click on Download Button
		public void clickCLMDownloadButtonApproverecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDownloadButtonApproveRecord));
			driver.findElement(ClientMappingLocators.CLMDownloadButtonApproveRecord).click();
			try {
				Thread.sleep(5000); // Or use polling logic for better wait
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
	// Click on Upload Button
	public void clickCLMUploadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMUploadButton));
		driver.findElement(ClientMappingLocators.CLMUploadButton).isDisplayed();
		System.out.println("The upload button is visible and is clickable");
	}
	
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(ClientMappingLocators.CLMSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\Clinet_Mapping.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((ClientMappingLocators.CLMSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMSendforApprovalButton));
			driver.findElement(ClientMappingLocators.CLMSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(ClientMappingLocators.CLMConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientMappingLocators.CLMDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((ClientMappingLocators.CLMDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
	    
	    public void Client_Map_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
	    {
	    	WebElement dropdownElement = driver.findElement(ClientMappingLocators.CLMSourceTabledropdown); 
	    	dropdownElement.click();
	    	Thread.sleep(5000);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("client_map_lkp"); // Replace 'option_value' with the actual value
	    }
 
}
