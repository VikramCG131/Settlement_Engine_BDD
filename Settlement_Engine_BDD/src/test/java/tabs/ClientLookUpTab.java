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
import locators.BrandMappingLocators;
import locators.ClientLookupLocators;
import locators.ClientMappingLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class ClientLookUpTab {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public ClientLookUpTab() {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ReferenceLookUpButton));
		driver.findElement(LoginPageLocators.ReferenceLookUpButton).click();
		System.out.println("The user is able to click on Reference Look Up Button");
	}

	
	//select the client lkp
	
	public void Client_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
    {
    	WebElement dropdownElement = driver.findElement(ClientMappingLocators.CLMSourceTabledropdown); 
    	dropdownElement.click();
    	Thread.sleep(3000);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("client_lkp"); // Replace 'option_value' with the actual value
    }
	
	// Click on Add New Button
	public void clickCLUAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUAddNewButton));
		driver.findElement(ClientLookupLocators.CLUAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterCLUCategoryFieldValue(String payableEl2, String advanceComission, String shopCode, String shopName,
			String dStype) throws InterruptedException {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUPayableElement2));
		driver.findElement(ClientLookupLocators.CLUPayableElement2).sendKeys(payableEl2+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUAdvanComission));
		driver.findElement(ClientLookupLocators.CLUAdvanComission).sendKeys(advanceComission);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUShopCode));
		driver.findElement(ClientLookupLocators.CLUShopCode).sendKeys(shopCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUShopName));
		driver.findElement(ClientLookupLocators.CLUShopName).sendKeys(shopName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDescriptionType));
		driver.findElement(ClientLookupLocators.CLUDescriptionType).sendKeys(dStype);
		System.out.println("The user is able to insert the data in the all fields");
		
	}

	// Click on Submit Button
	public void clickCLUSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSubmitButton));
		driver.findElement(ClientLookupLocators.CLUSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyCLUSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSuccessPopupMessage));
		String successMessage = driver.findElement(ClientLookupLocators.CLUSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSuccesspopupMessageUploadOk)).click();
	}
	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSearchforShopcode)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSearchforShopcode)).sendKeys(ClientLookUpConstants.SHOP_CODE.getValue()+random);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUearchforstatus)).click();;
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUearchforstatus)).sendKeys("NEW");
		}
	
	// Verify the Update Popup Message
	public void verifyCLUUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUUpdatePopupMessage));
		String successMessage = driver.findElement(ClientLookupLocators.CLUUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickCLUPayableElement2blankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUPayableElement2));
		driver.findElement(ClientLookupLocators.CLUPayableElement2).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUAdvanComission));
		driver.findElement(ClientLookupLocators.CLUAdvanComission).click();

		String actual = driver.findElement(ClientLookupLocators.CLUASourceErrorValidation).getText();
		Assert.assertEquals("Payable Element 2 is required.", actual);
		System.out.println("The user is able to click on Payable Element 2 and validate the error message");
	}

	// Click on Reset Button
	public void clickCLUResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUResetButton));
		driver.findElement(ClientLookupLocators.CLUResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickCLUCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ClientLookupLocators.CLUCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUCancelButton));
		driver.findElement(ClientLookupLocators.CLUCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickCLUUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUUpdateButton));
		driver.findElement(ClientLookupLocators.CLUUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickCLUEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUEditButton));
		driver.findElement(ClientLookupLocators.CLUEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Client look up Category Text is Visible
	public void verifyCLUCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUCategoryTextPageVisible));
		boolean category = driver.findElement(ClientLookupLocators.CLUCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editadvanceComissionValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUAdvanComission));
		driver.findElement(ClientLookupLocators.CLUAdvanComission).clear();
		driver.findElement(ClientLookupLocators.CLUAdvanComission).sendKeys("0.9");

	}

	// Click on Delete Button
	public void clickCLUDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteButton));
		driver.findElement(ClientLookupLocators.CLUDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickCLUDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton));
		driver.findElement(ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickCLUDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupCancelButton));
		driver.findElement(ClientLookupLocators.CLUDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String payableElement2 = driver.findElement(ClientLookupLocators.CLUPayableElement2).getAttribute("value");
		String advanceCommission = driver.findElement(ClientLookupLocators.CLUAdvanComission).getAttribute("value");
		String shopCode = driver.findElement(ClientLookupLocators.CLUShopCode).getAttribute("value");
		String shopName = driver.findElement(ClientLookupLocators.CLUShopName).getAttribute("value");
		String dataSourceType = driver.findElement(ClientLookupLocators.CLUDescriptionType).getAttribute("value");

		Assert.assertEquals("", payableElement2);
		Assert.assertEquals("", advanceCommission);
		Assert.assertEquals("", shopCode);
		Assert.assertEquals("", shopName);
		Assert.assertEquals("", dataSourceType);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyCLUAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(ClientLookupLocators.CLUCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyCLUDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(ClientLookupLocators.CLUDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyCLUDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyCLUDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(ClientLookupLocators.CLUDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyCLUFileRemoval() {
		boolean grid = driver.findElement(ClientLookupLocators.CLUGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickCLUDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDownloadButton));
		driver.findElement(ClientLookupLocators.CLUDownloadButton).click();
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

	// download approve record
	
	// Click on Download Button
		public void clickCLUDownloadButtonAllapproverecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDownloadButtonApproveRecord));
			driver.findElement(ClientLookupLocators.CLUDownloadButtonApproveRecord).click();
			try {
				Thread.sleep(5000); // Or use polling logic for better wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The user is able to click on Download Button");
		}

		// Verify Downloaded file
		public void verifyFileDownloadedAllApproveRecords() {
			String downloadPath = System.getProperty("user.dir") + "/downloads";
			File downloadDir = new File(downloadPath);
			if (!downloadDir.exists())
				downloadDir.mkdir();
			String fileName = "example.csv";
			File downloadedFile = new File(downloadDir, fileName);
			System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
			
		}
		
	// Click on Upload Button
	public void clickCLUUploadButton() {
		WebElement uploadButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUUploadButton));
		driver.findElement(ClientLookupLocators.CLUUploadButton).isDisplayed();
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploadButton)) != null);
		System.out.println("The upload button is visible and is clickable");

	}

	//Verify Selection of file and upload
	public void selectFileToUpload() {
		WebElement fileInput = driver.findElement(ClientLookupLocators.CLUSelectValidFile);
		System.out.println("The user is able to select a valid file to upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "\\src\\test\\resources\\TestData\\Client_LookUp.csv");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		// Upload the file by sending the path
		fileInput.sendKeys(absolutePath);
		System.out.println("File uploaded successfully!");
	}
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((ClientLookupLocators.CLUSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUSendforApprovalButton));
			driver.findElement(ClientLookupLocators.CLUSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(ClientLookupLocators.CLUConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ClientLookupLocators.CLUDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((ClientLookupLocators.CLUDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
 
}
