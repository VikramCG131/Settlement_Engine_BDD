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
import constants.Element3MappingConstants;
import locators.BrandMappingLocators;
import locators.ClientMappingLocators;
import locators.Element3MappingLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;
public class Element3MappingTab {

	private WebDriver driver;
	public WebDriverWait wait;

	// Constructor to initialize the driver and wait
	public Element3MappingTab() {
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

	// Click on Element 3 Tab
	public void clickElement3MappingTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Element3MappingTab));
		driver.findElement(Element3MappingLocators.EL3Element3MappingTab).click();
		System.out.println("The user is able to click on Element 3 Tab");
	}

	// Click on Add New Button
	public void clickEL3AddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3AddNewButton));
		driver.findElement(Element3MappingLocators.EL3AddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Element 3 Category
	public void enterEL3CategoryFieldValue(String productCode, String el3Code) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3ProductCode));
		driver.findElement(Element3MappingLocators.EL3ProductCode).sendKeys(productCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Element3Code));
		driver.findElement(Element3MappingLocators.EL3Element3Code).sendKeys(el3Code);		
		System.out.println("The user is able to insert the data in the all fields");
	}

	// Click on Submit Button
	public void clickEL3SubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SubmitButton));
		driver.findElement(Element3MappingLocators.EL3SubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyEL3SuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SuccessPopupMessage));
		String successMessage = driver.findElement(Element3MappingLocators.EL3SuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SuccesspopupMessageUploadOk)).click();
	}

	//search for the added record
		public void AddedRecorddSearch() throws InterruptedException
		{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SearchforProductcode)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SearchforProductcode)).sendKeys(Element3MappingConstants.PRODUCT_CODE.getValue()+CommonUtilities.getRandomInteger());
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Searchforstatus)).click();;
			wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Searchforstatus)).sendKeys("NEW");
			Thread.sleep(5000);
		}
	// Verify the Update Popup Message
	public void verifyEL3UpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3UpdatePopupMessage));
		String successMessage = driver.findElement(Element3MappingLocators.EL3UpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickEL3ElementCodeblankSelection() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Element3Code));
		driver.findElement(Element3MappingLocators.EL3Element3Code).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3ProductCode));
		driver.findElement(Element3MappingLocators.EL3ProductCode).click();
		Thread.sleep(2000);
		String actual = driver.findElement(Element3MappingLocators.EL3CodeErrorValidation).getText();
		Assert.assertEquals("Element 3 Code is required.", actual);
		System.out.println("The user is able to click on Element 3 code and validate the error message");
	}

	// Click on Reset Button
	public void clickEL3ResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3ResetButton));
		driver.findElement(Element3MappingLocators.EL3ResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickEL3CancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(Element3MappingLocators.EL3CategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3CancelButton));
		driver.findElement(Element3MappingLocators.EL3CancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("The user is able to click on Cancel Button");

	}

	// Click on Update Button
	public void clickEL3UpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3UpdateButton));
		driver.findElement(Element3MappingLocators.EL3UpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickEL3EditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3EditButton));
		driver.findElement(Element3MappingLocators.EL3EditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Element 3 Text is Visible
	public void verifyEL3CategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3CategoryTextPageVisible));
		boolean category = driver.findElement(Element3MappingLocators.EL3CategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Grid is Text is visible");
	}

	public void editShopCodeValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3Element3Code));
		driver.findElement(Element3MappingLocators.EL3Element3Code).sendKeys("1");

	}

	// Click on Delete Button
	public void clickEL3DeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteButton));
		driver.findElement(Element3MappingLocators.EL3DeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickEL3DeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton));
		driver.findElement(Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickEL3DeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupCancelButton));
		driver.findElement(Element3MappingLocators.EL3DeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String productCode = driver.findElement(Element3MappingLocators.EL3ProductCode).getAttribute("value");
		String el3Code = driver.findElement(Element3MappingLocators.EL3Element3Code).getAttribute("value");

		Assert.assertEquals("", productCode);
		Assert.assertEquals("", el3Code);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyEL3AssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(Element3MappingLocators.EL3CategoryTextPageVisible).getText();
		Assert.assertNotEquals("Common Reference Look Up cotegery", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyEL3DeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(Element3MappingLocators.EL3DeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyEL3DeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyEL3DeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(Element3MappingLocators.EL3DeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyEL3FileRemoval() {
		boolean grid = driver.findElement(Element3MappingLocators.EL3GridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickEL3DownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3DownloadButton));
		driver.findElement(Element3MappingLocators.EL3DownloadButton).click();
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
	public void clickEL3UploadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3UploadButton));
		driver.findElement(Element3MappingLocators.EL3UploadButton).isDisplayed();
		System.out.println("The upload button is visible and is clickable");
	}
	
	//Verify Selection of file and upload
	 public void selectFileToUpload() {
		 WebElement fileInput= driver.findElement(Element3MappingLocators.EL3SelectValidFile);
	        System.out.println("The user is able to select a valid file to upload");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String projectPath = System.getProperty("user.dir");
	        File file = new File(projectPath + "\\src\\test\\resources\\TestData\\El3_Mapping.csv");
	        String absolutePath = file.getAbsolutePath();
	        System.out.println(absolutePath);
	        // Upload the file by sending the path
	        fileInput.sendKeys(absolutePath);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        System.out.println("File uploaded successfully!");
	 }
	 
	//Verify Success message of Upload
	 public void verifyUploadSuccessMessage() {
	    	String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SuccesspopupMessageUpload)).getText();
	        Assert.assertEquals("Record has been uploaded successfully..!", actual);
	        System.out.println("The user is able to upload the file successfully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement((Element3MappingLocators.EL3SuccesspopupMessageUploadOk)).click();
	        System.out.println("The user is able to click on OK button");
	 }
	 
	//Click on Send for Approval button
	 public void clickSendForApprovalButton() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3SendforApprovalButton));
			driver.findElement(Element3MappingLocators.EL3SendforApprovalButton).click();
			 System.out.println("The user is able to click on Send for Approval Button");
	    }

	 //Verify submission of file for approval
	    public void fileSubmittedForApproval() {
	    	WebElement popup = driver.findElement(Element3MappingLocators.EL3ConfirmationPopupSelect);
	        wait.until(ExpectedConditions.visibilityOf(popup));
	        Assert.assertTrue(popup.isDisplayed());
	    }

	    public void ConfirmationMessageConfirmAndCancelButtons() {
	    	 WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton));
	    	 WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Element3MappingLocators.EL3DeleteConfirmationPopupCancelButton));
	        Assert.assertTrue(confirmButton.isDisplayed());
	        Assert.assertTrue(cancelButton.isDisplayed());
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        wait.until(ExpectedConditions.visibilityOf(cancelButton));
	        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	    }


	    public void ConfirmButtonSentForApproval(){
	        WebElement confirmButton = driver.findElement((Element3MappingLocators.EL3DeleteConfirmationPopupConfirmButton));
	        wait.until(ExpectedConditions.visibilityOf(confirmButton));
	        confirmButton.click();
	        System.out.println("The user is able to send the file for approval successfully");
	 
	    }
	    public void el3_map_lkpSlection() throws InterruptedException
	    {
	    	WebElement dropdownElement = driver.findElement(Element3MappingLocators.EL3SourceTabledropdown); 
	    	dropdownElement.click();
	    	Thread.sleep(5000);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("el3_map_lkp"); // Replace 'option_value' with the actual value
	    }
 
}
