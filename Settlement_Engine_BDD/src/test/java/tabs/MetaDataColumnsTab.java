package tabs;

import java.io.IOException;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.MetaDataColumnsLocators;
import locators.SettlementEngineLoginLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import utils.DriverManager;

public class MetaDataColumnsTab {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor to initialize the driver and wait
	public MetaDataColumnsTab() {
		this.driver = DriverManager.getDriver();

		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public  void openLoginPage() {
		driver.get(LoginPageLocators.SE_URL);
		System.out.println("The user is able to open the login page");
	}
	//Verify health check of the URL
	public  void verifyHealthCheck() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, LoginPageLocators.SE_URL);
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
	
	//Verify the Title of the Page
	public void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Settlement Engine");
		System.out.println("The user is able to verify the title of the page");
	}
	
	//Click on MetaData Button
	public void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.MetaDataButton));
		driver.findElement(LoginPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}
	
	//Click on Hamburger Menu Button
	public void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.HamburgerButton));
		driver.findElement(LoginPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}
	
	//Click on Data Quality Assignment Tab
	public    void clickMetadataColumnTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MetaDataColumnTab));
		driver.findElement(MetaDataColumnsLocators.MetaDataColumnTab).click();
		System.out.println("The user is able to click on Data Quality Assignment Tab");
	}
	
	//Click on Add New Button
	public    void clickMDCAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCAddNewButton));
		driver.findElement(MetaDataColumnsLocators.MDCAddNewButton).click();
		System.out.println("The user is able to click on Add New Button");
	}
	
	//Enter the Field Value in Data Quality Assignment Category
	public    void enterMDCFieldValue(String name,String dataType, String columnActive, String ColumnIsNull, String minSize, String maxSize, String columnOrder, String columnDateFormat, String tableName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCName));
		driver.findElement(MetaDataColumnsLocators.MDCName).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDataTypeDropdown));
		Select datatypedropdown = new Select(driver.findElement(MetaDataColumnsLocators.MDCDataTypeDropdown));
		datatypedropdown.selectByIndex(3);
		System.out.println("Selected Data Type: "+datatypedropdown);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnActive));
		driver.findElement(MetaDataColumnsLocators.MDCColumnActive).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnIsNull));
		driver.findElement(MetaDataColumnsLocators.MDCColumnIsNull).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCMinSize));
		driver.findElement(MetaDataColumnsLocators.MDCMinSize).sendKeys(minSize);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCMaxSize));
		driver.findElement(MetaDataColumnsLocators.MDCMaxSize).sendKeys(maxSize);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnOrder));
		driver.findElement(MetaDataColumnsLocators.MDCColumnOrder).sendKeys(columnOrder);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnDateFormat));
		driver.findElement(MetaDataColumnsLocators.MDCColumnDateFormat).sendKeys(columnDateFormat);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCTableNameDropdown)).click();
		Select datatypedropdown1 = new Select(driver.findElement(MetaDataColumnsLocators.MDCTableNameDropdown));
		datatypedropdown1.selectByIndex(2);

		System.out.println("The user is able to enter the field value in Columns Information");
	}
	
	//Click on Submit Button
	public    void clickMDCSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSubmitButton));
		driver.findElement(MetaDataColumnsLocators.MDCSubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Success Popup Message
		public   void verifyDSFSuccessPopupMessage() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCSuccessPopupMessage));
			String successMessage = driver.findElement(MetaDataColumnsLocators.MDCSuccessPopupMessage).getText();
			Assert.assertEquals(successMessage, "Record has been added successfully..!");
			System.out.println("The user is able to verify the Success Popup Message");
		}
	//Verify the Success Popup Message
	public void verifyMDCSuccessPopupMessageUpdate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCUpdatePopupMessage));
		String successMessage = driver.findElement(MetaDataColumnsLocators.MDCUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
	}
	
	
	//Click on Source Table Dropdown
	public    void clickMDCDataTypeDropdown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDataTypeDropdown));
		driver.findElement(MetaDataColumnsLocators.MDCDataTypeDropdown).click();
		System.out.println("The user is able to click on Data Type Dropdown");
	}
	
	//Click on Source Table Dropdown and Blank Selection
	public    void clickMDCMinSizeandblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCMinSize));
		driver.findElement(MetaDataColumnsLocators.MDCMinSize).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCName));
		driver.findElement(MetaDataColumnsLocators.MDCName).click();
		String actual = driver.findElement(MetaDataColumnsLocators.MDCMinSizeValidation).getText();
		Assert.assertEquals("Min Size Must be a Number", actual);
		System.out.println("The user is able to click on Min Size field and validate the error message");
	}
	
	//Click on Reset Button
	public    void clickMDCResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCResetButton));
		driver.findElement(MetaDataColumnsLocators.MDCResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public    void clickMDCCancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnInformationVisible));
		boolean grid = driver.findElement(MetaDataColumnsLocators.MDCColumnInformationVisible).isDisplayed();
		Assert.assertTrue(grid);
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public    void clickMDCUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCUpdateButton));
		driver.findElement(MetaDataColumnsLocators.MDCUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public    void clickMDCEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCEditButton));
		driver.findElement(MetaDataColumnsLocators.MDCEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	//Verify Assignment Category Text is Visible
	public void verifyMDCCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCColumnInformationVisible));
		boolean category = driver.findElement(MetaDataColumnsLocators.MDCColumnInformationVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Column Information Text is visible");
	}
	
	public void editValueField()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCMaxSize)).sendKeys("40");;
		
	}
	//Click on Delete Button
	public    void clickMDCDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public    void clickMDCDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public    void clickMDCDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton));
		driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public    void verifyAllFieldsClearedforResetButton() {
		String name = driver.findElement(MetaDataColumnsLocators.MDCName).getAttribute("value");
		String dataType = driver.findElement(MetaDataColumnsLocators.MDCDataTypeDropdown).getAttribute("value");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//String columnActive = driver.findElement(MetaDataColumnsLocators.MDCColumnActive).getAttribute("value");
		//String ColumnIsNull = driver.findElement(MetaDataColumnsLocators.MDCColumnIsNull).getAttribute("value");
		String minSize = driver.findElement(MetaDataColumnsLocators.MDCMinSize).getAttribute("value");
		String maxSize = driver.findElement(MetaDataColumnsLocators.MDCMaxSize).getAttribute("value");
		String columnOrder = driver.findElement(MetaDataColumnsLocators.MDCColumnOrder).getAttribute("value");
		String columnDateFormat = driver.findElement(MetaDataColumnsLocators.MDCColumnDateFormat).getAttribute("value");
		String tableName = driver.findElement(MetaDataColumnsLocators.MDCTableNameDropdown).getAttribute("value");
		
		Assert.assertEquals("", name);
		Assert.assertEquals("", dataType);
		//Assert.assertEquals("", columnActive);
		//Assert.assertEquals("", ColumnIsNull);
		Assert.assertEquals("", minSize);
		Assert.assertEquals("", maxSize);
		Assert.assertEquals("", columnOrder);
		Assert.assertEquals("", columnDateFormat);
		Assert.assertEquals("", tableName);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Metadata Column Grid is Visible and Column Information is Not Visible
	public void verifyMDCAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {
		boolean category = driver.findElement(MetaDataColumnsLocators.MDCCategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Metadata Column Grid is visible and Column Information is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public    void verifyMDCDeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public    void verifyMDCDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public    void verifyMDCDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(MetaDataColumnsLocators.MDCDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}
	
	
}
