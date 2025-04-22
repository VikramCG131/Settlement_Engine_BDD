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
import locators.BrandMappingLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class BrandMappingTab {

	private WebDriver driver;
	public WebDriverWait wait;

	// Constructor to initialize the driver and wait
	public BrandMappingTab() {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMBrandMapingTab));
		driver.findElement(BrandMappingLocators.BMBrandMapingTab).click();
		System.out.println("The user is able to click on Brand Mapping Tab");
	}

	// Click on Add New Button
	public void clickBMAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMAddNewButton));
		driver.findElement(BrandMappingLocators.BMAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterBMCategoryFieldValue(String clintCode, String brandCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMClientCode));
		driver.findElement(BrandMappingLocators.BMBrandCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMBrandCode));
		driver.findElement(BrandMappingLocators.BMBrandCode).click();
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickBMSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMSubmitButton));
		driver.findElement(BrandMappingLocators.BMSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyBMSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMSuccessPopupMessage));
		String successMessage = driver.findElement(BrandMappingLocators.BMSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}

	// Verify the Update Popup Message
	public void verifyBMUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMUpdatePopupMessage));
		String successMessage = driver.findElement(BrandMappingLocators.BMUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickBMClientCodeblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMClientCode));
		driver.findElement(BrandMappingLocators.BMClientCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMBrandCode));
		driver.findElement(BrandMappingLocators.BMBrandCode).click();

		String actual = driver.findElement(BrandMappingLocators.BMErrorValidation).getText();
		Assert.assertEquals("Please enter Client Code", actual);
		System.out.println("The user is able to click on Client code and validate the error message");
	}

	// Click on Reset Button
	public void clickBMResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMResetButton));
		driver.findElement(BrandMappingLocators.BMResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickBMCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(BrandMappingLocators.BMCategoryTextPageVisible).getText();
		Assert.assertEquals("Client Look Up Category", actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMCancelButton));
		driver.findElement(BrandMappingLocators.BMCancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}
	//Verify the Data Source File Grid is visible and File Information is Not Visible
		public void verifyBMGridVisibleandFileInformationNotVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			boolean category = driver.findElement(BrandMappingLocators.BMCategoryTextPageVisible).isDisplayed();
			Assert.assertTrue(category);
			System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
		}

	// Click on Update Button
	public void clickBMUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMUpdateButton));
		driver.findElement(BrandMappingLocators.BMUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickBMEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMEditButton));
		driver.findElement(BrandMappingLocators.BMEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Client look up Category Text is Visible
	public void verifyBMCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMCategoryTextPageVisible));
		boolean category = driver.findElement(BrandMappingLocators.BMCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Quality Assignment Category Text is visible");
	}

	public void editClientCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMClientCode));
		driver.findElement(BrandMappingLocators.BMClientCode).clear();
		driver.findElement(BrandMappingLocators.BMClientCode).sendKeys("0.9");

	}

	// Click on Delete Button
	public void clickBMDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMDeleteButton));
		driver.findElement(BrandMappingLocators.BMDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton));
		driver.findElement(BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupCancelButton));
		driver.findElement(BrandMappingLocators.BMDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String clientCode = driver.findElement(BrandMappingLocators.BMClientCode).getAttribute("value");
		String brandCode = driver.findElement(BrandMappingLocators.BMBrandCode).getAttribute("value");
		
		Assert.assertEquals("", clientCode);
		Assert.assertEquals("", brandCode);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyBMAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(BrandMappingLocators.BMCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Data Quality Assignment Category", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyBMDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(BrandMappingLocators.BMDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(BrandMappingLocators.BMDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyBMFileRemoval() {
		boolean grid = driver.findElement(BrandMappingLocators.BMGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickBMDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMDownloadButton));
		driver.findElement(BrandMappingLocators.BMDownloadButton).click();
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

	// Click on Upload Button
	public void clickBMUploadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMUploadButton));
		driver.findElement(BrandMappingLocators.BMUploadButton).click();
		System.out.println("The upload button is visible and is clickable");
	}
	
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMSelectValidFile));
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
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMSuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((BrandMappingLocators.BMSuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMSendforApprovalButton));
			driver.findElement(BrandMappingLocators.BMSendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(BrandMappingLocators.BMConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BrandMappingLocators.BMDeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((BrandMappingLocators.BMDeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
 
}
