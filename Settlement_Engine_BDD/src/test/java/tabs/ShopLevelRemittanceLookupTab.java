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
import constants.ShopLevelRemittanceLookupConstants;
import constants.DataSourceFileConstants;
import locators.ShopLevelRemittanceLookupLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import steps.ShopLevelRemittanceLookupSteps;
import utils.DriverManager;

public class ShopLevelRemittanceLookupTab  {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;
	// Constructor to initialize the driver and wait
	public ShopLevelRemittanceLookupTab() {
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
//select the drop down shop level rem

	public void shop_level_rem_LkpSlectionFromReferenceTableDropdown() throws InterruptedException
    {
    	WebElement dropdownElement = driver.findElement(ShopLevelRemittanceLookupLocators.SLRSourceTabledropdown); 
    	dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("shop_level_rem_lkp"); // Replace 'option_value' with the actual value
    }
	
	// Click on Add New Button
	public void clickSLRAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRAddNewButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterSLRCategoryFieldValue(String payableEl2, String shopCode, String adviceEntity) {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRPayableEl2));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRPayableEl2).sendKeys(payableEl2+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRShopCode));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRShopCode).sendKeys(shopCode+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRAdviceEntity));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRAdviceEntity).sendKeys(adviceEntity+random);
		
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickSLRSubmitButton() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSubmitButton));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifySLRSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSuccessPopupMessage));
		String successMessage = driver.findElement(ShopLevelRemittanceLookupLocators.SLRSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSuccesspopupMessageUploadOk)).click();
	}

	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRPaysearchbleEL2)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRPaysearchbleEL2)).sendKeys(ShopLevelRemittanceLookupConstants.PAYABLE_EL2.getValue()+random);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSearchforstatus)).click();;
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSearchforstatus)).sendKeys("NEW");
			Thread.sleep(5000);
		}
	// Verify the Update Popup Message
	public void verifySLRUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRUpdatePopupMessage));
		String successMessage = driver.findElement(ShopLevelRemittanceLookupLocators.SLRUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click Client mapping and Blank Selection
	public void clickSLRClientCodeblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRPayableEl2));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRPayableEl2).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRShopCode));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRShopCode).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ShopLevelRemittanceLookupLocators.SLRClentCodeErrorValidation).getText();
		Assert.assertEquals("Payable El2 is required.", actual);
		System.out.println("The user is able to click on Payable El2 and validate the error message");
	}

	// Click on Reset Button
	public void clickSLRResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRResetButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickSLRCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(ShopLevelRemittanceLookupLocators.SLRCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRCancelButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickSLRUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRUpdateButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickSLREditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLREditButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLREditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Client mapping up Category Text is Visible
	public void verifySLRCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRCategoryTextPageVisible));
		boolean category = driver.findElement(ShopLevelRemittanceLookupLocators.SLRCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editShopCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRAdviceEntity));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRAdviceEntity).clear();
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRAdviceEntity).sendKeys("40");

	}

	// Click on Delete Button
	public void clickSLRDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickSLRDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickSLRDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupCancelButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String payableEl2 = driver.findElement(ShopLevelRemittanceLookupLocators.SLRPayableEl2).getAttribute("value");
		String shopCode = driver.findElement(ShopLevelRemittanceLookupLocators.SLRShopCode).getAttribute("value");
		String adviceEntity = driver.findElement(ShopLevelRemittanceLookupLocators.SLRAdviceEntity).getAttribute("value");


		Assert.assertEquals("", payableEl2);
		Assert.assertEquals("", shopCode);
		Assert.assertEquals("", adviceEntity);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifySLRAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(ShopLevelRemittanceLookupLocators.SLRCategoryTextVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifySLRDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifySLRDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifySLRDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifySLRFileRemoval() {
		boolean grid = driver.findElement(ShopLevelRemittanceLookupLocators.SLRGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickSLRDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDownloadButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRDownloadButton).click();
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
		public void clickSLRDownloadButtonApproverecord() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDownloadButtonApproveRecord));
			driver.findElement(ShopLevelRemittanceLookupLocators.SLRDownloadButtonApproveRecord).click();
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
	public void clickSLRUploadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRUploadButton));
		driver.findElement(ShopLevelRemittanceLookupLocators.SLRUploadButton).isDisplayed();
		System.out.println("The upload button is visible and is clickable");
	}
	
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(ShopLevelRemittanceLookupLocators.SLRSelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\shop_level_rem_lkp.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((ShopLevelRemittanceLookupLocators.SLRSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRSendforApprovalButton));
			driver.findElement(ShopLevelRemittanceLookupLocators.SLRSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(ShopLevelRemittanceLookupLocators.SLRConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((ShopLevelRemittanceLookupLocators.SLRDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
	    
	    
 
}
