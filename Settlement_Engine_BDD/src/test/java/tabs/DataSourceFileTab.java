package tabs;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.DataSourceFileLocators;
import locators.MainPageLocators;
import utils.DriverManager;

public class DataSourceFileTab {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor to initialize the driver and wait
	public DataSourceFileTab() {
		this.driver = DriverManager.getDriver();
		
		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public void openLoginPage() {
		driver.get("http://localhost:4200");
		System.out.println("The user is able to open the login page");
	}
	
	//Verify health check of the URL
	public void verifyHealthCheck() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:4200/");
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
	
	//Verify the Title of the Page
	public    void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Starter Kit PF Angular");
		System.out.println("The user is able to verify the title of the page");
	}
	
	//Click on MetaData Button
	public  void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.MetaDataButton));
		driver.findElement(MainPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}
	
	//Click on Hamburger Menu Button
	public   void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.HamburgerButton));
		driver.findElement(MainPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}
	
	//Click on Data Quality Assignment Tab
	public   void clickDataSourceFileTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DataSourceFileTab));
		driver.findElement(DataSourceFileLocators.DataSourceFileTab).click();
		System.out.println("The user is able to click on Data Quality Assignment Tab");
	}
	
	//Click on Add New Button
	public   void clickDSFAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFAddNewButton));
		driver.findElement(DataSourceFileLocators.DSFAddNewButton).click();
		System.out.println("The user is able to click on Add New Button");
	}
	
	//Enter the Field Value in Data Quality Assignment Category
	public   void enterDSFFieldValue(String sourceTable, String sourceAttribute) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFileName));
		driver.findElement(DataSourceFileLocators.DSFFileName).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFileType));
		driver.findElement(DataSourceFileLocators.DSFFileType).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFilePattern));
		driver.findElement(DataSourceFileLocators.DSFFilePattern).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFilePathRow));
		driver.findElement(DataSourceFileLocators.DSFFilePathRow).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFilePathCleansed));
		driver.findElement(DataSourceFileLocators.DSFFilePathCleansed).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFileMaxSize));
		driver.findElement(DataSourceFileLocators.DSFFileMaxSize).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFTableName));
		driver.findElement(DataSourceFileLocators.DSFTableName).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFileDelimiter));
		driver.findElement(DataSourceFileLocators.DSFFileDelimiter).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFHeaderPresentYes));
		driver.findElement(DataSourceFileLocators.DSFHeaderPresentYes).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFColumnIdentifier));
		driver.findElement(DataSourceFileLocators.DSFColumnIdentifier).click();
		System.out.println("The user is able to enter the field value in Data Quality Assignment Category");
	}
	
	//Click on Submit Button
	public   void clickDSFSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFSubmitButton));
		driver.findElement(DataSourceFileLocators.DSFSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Success Popup Message
	public   void verifyDSFSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFSuccessPopupMessage));
		String successMessage = driver.findElement(DataSourceFileLocators.DSFSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}
	
	//Click on File Pattern and Blank Selection
	public   void clickDSFFilePatternblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFilePattern));
		driver.findElement(DataSourceFileLocators.DSFFilePattern).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFFileType));
		driver.findElement(DataSourceFileLocators.DSFFileType).click();
		
		String actual = driver.findElement(DataSourceFileLocators.DSFFilePatternValidation).getText();
		Assert.assertEquals("Please Enter File Pattern", actual);
		System.out.println("The user is able to click on File Pattern and validate the error message");
	}
	
	//Click on Reset Button
	public   void clickDSFResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFResetButton));
		driver.findElement(DataSourceFileLocators.DSFResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickDSFCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFCancelButton));
		driver.findElement(DataSourceFileLocators.DSFCancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public   void clickDSFUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFUpdateButton));
		driver.findElement(DataSourceFileLocators.DSFUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public   void clickDSFEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFEditButton));
		driver.findElement(DataSourceFileLocators.DSFEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	//Verify Assignment Category Text is Visible
	public   void verifyDSFCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFCategoryTextVisible));
		boolean category = driver.findElement(DataSourceFileLocators.DSFCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the File Information Text is visible");
	}
	
	//Click on Delete Button
	public   void clickDSFDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteButton));
		driver.findElement(DataSourceFileLocators.DSFDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickDSFDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteConfirmationPopupConfirmButton));
		driver.findElement(DataSourceFileLocators.DSFDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickDSFDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteConfirmationPopupCancelButton));
		driver.findElement(DataSourceFileLocators.DSFDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String fileName = driver.findElement(DataSourceFileLocators.DSFFileName).getAttribute("value");
		String fileType = driver.findElement(DataSourceFileLocators.DSFFileType).getAttribute("value");
		String filePattern = driver.findElement(DataSourceFileLocators.DSFFileType).getAttribute("value");
		String filePathRaw = driver.findElement(DataSourceFileLocators.DSFFilePathRow).getAttribute("value");
		String filePathCleansed = driver.findElement(DataSourceFileLocators.DSFFilePathCleansed).getAttribute("value");
		
		Assert.assertEquals("", fileName);
		Assert.assertEquals("", fileType);
		Assert.assertEquals("", filePattern);
		Assert.assertEquals("", filePathRaw);	
		Assert.assertEquals("", filePathCleansed);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
	public   void verifyDSFAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFGridVisible));
		boolean grid = driver.findElement(DataSourceFileLocators.DSFGridVisible).isDisplayed();
		Assert.assertTrue(grid);
		boolean category = driver.findElement(DataSourceFileLocators.DSFCategoryTextVisible).isDisplayed();
		Assert.assertFalse(category);
		System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyDSFDeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(DataSourceFileLocators.DSFDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyDSFDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(DataSourceFileLocators.DSFDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyDSFDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataSourceFileLocators.DSFDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(DataSourceFileLocators.DSFDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}
	
	
}
