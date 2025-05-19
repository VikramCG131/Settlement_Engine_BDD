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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import constants.BrandMappingConstants;
import constants.ClientLookUpConstants;
import constants.DataSourceFileConstants;
import constants.PricingLookUpConstants;
import locators.PricingLookUpLocators;
import locators.ClientLookupLocators;
import locators.ClientMappingLocators;
import locators.DataQualityAssignmentLocators;
import locators.DataSourceFileLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class PricingLookUpTab {

	private WebDriver driver;
	public WebDriverWait wait;
	static String random;

	// Constructor to initialize the driver and wait
	public PricingLookUpTab() {
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

	// select the pricing lookup dropdown
	public void Pricing_LkpSlectionFromReferenceTableDropdown() throws InterruptedException {
		WebElement dropdownElement = driver.findElement(PricingLookUpLocators.PLSourceTabledropdown);
		dropdownElement.click();
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("pricing_lkp"); // Replace 'option_value' with the actual value
	}

	// Click on Add New Button
	public void clickBMAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLAddNewButton));
		driver.findElement(PricingLookUpLocators.PLAddNewButton).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		System.out.println("The user is able to click on Add New Button");
	}

	// Enter the Field Value in Client Lookup Category
	public void enterBMCategoryFieldValue(String currency, String clientcode, String productCode, String instalments,
			String offerMonths, String loanAmountMin, String loanAmountMax, String rule, String commSubPct,
			String minMaxSubVal, String cntdwnRatePct, String minCntdwnRatePct, String cntdwnAdjust,
			String thirdParty1Encoding, String thirdParty1Rate, String thirdParty2Encoding, String thirdParty2Rate,
			String thirdParty3Encoding, String thirdParty3Rate, String volBonusPct, String headOfficeRebate)
			throws InterruptedException {

		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLActiveFromDate));
		driver.findElement(PricingLookUpLocators.PLActiveFromDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLActiveFromDateSelect));
		driver.findElement(PricingLookUpLocators.PLActiveFromDateSelect).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCurrency));
		driver.findElement(PricingLookUpLocators.PLCurrency).sendKeys(currency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLClientCode));
		driver.findElement(PricingLookUpLocators.PLClientCode).sendKeys(clientcode + random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLProductCode));
		driver.findElement(PricingLookUpLocators.PLProductCode).sendKeys(productCode + random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLInstalments));
		driver.findElement(PricingLookUpLocators.PLInstalments).sendKeys(instalments);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLOfferMonths));
		driver.findElement(PricingLookUpLocators.PLOfferMonths).sendKeys(offerMonths);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLLoanAmountMin));
		driver.findElement(PricingLookUpLocators.PLLoanAmountMin).sendKeys(loanAmountMin);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLLoanAmountMax));
		driver.findElement(PricingLookUpLocators.PLLoanAmountMax).sendKeys(loanAmountMax);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLRule));
		driver.findElement(PricingLookUpLocators.PLRule).sendKeys(rule + random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCommSubPct));
		driver.findElement(PricingLookUpLocators.PLCommSubPct).sendKeys(commSubPct);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLMinMaxSubVal));
		driver.findElement(PricingLookUpLocators.PLMinMaxSubVal).sendKeys(minMaxSubVal);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCntdwnRatePct));
		driver.findElement(PricingLookUpLocators.PLCntdwnRatePct).sendKeys(cntdwnRatePct);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLMinCntdwnRatePct));
		driver.findElement(PricingLookUpLocators.PLMinCntdwnRatePct).sendKeys(minCntdwnRatePct);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCntdwnAdjust));
		driver.findElement(PricingLookUpLocators.PLCntdwnAdjust).sendKeys(cntdwnAdjust);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty1Encoding));
		driver.findElement(PricingLookUpLocators.PLThirdParty1Encoding).sendKeys(thirdParty1Encoding);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty1Rate));
		driver.findElement(PricingLookUpLocators.PLThirdParty1Rate).sendKeys(thirdParty1Rate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty2Encoding));
		driver.findElement(PricingLookUpLocators.PLThirdParty2Encoding).sendKeys(thirdParty2Encoding);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty2Rate));
		driver.findElement(PricingLookUpLocators.PLThirdParty2Rate).sendKeys(thirdParty2Rate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty3Encoding));
		driver.findElement(PricingLookUpLocators.PLThirdParty3Encoding).sendKeys(thirdParty3Encoding);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLThirdParty3Rate));
		driver.findElement(PricingLookUpLocators.PLThirdParty3Rate).sendKeys(thirdParty3Rate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLVolBonusPct));
		driver.findElement(PricingLookUpLocators.PLVolBonusPct).sendKeys(volBonusPct);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLHeadOfficeRebate));
		driver.findElement(PricingLookUpLocators.PLHeadOfficeRebate).sendKeys(headOfficeRebate);
		Thread.sleep(2000);
		System.out.println("The user is able to enter the field values in the Client Lookup Category");
	}

	// Click on Submit Button
	public void clickBMSubmitButton() throws InterruptedException {
		WebElement submitButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSubmitButton));
		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		// Ensure the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		// Click using Actions
		Actions act = new Actions(driver);
		act.moveToElement(submitButton).click().build().perform();
		// Fallback to JavaScript click if necessary
		if (!submitButton.isEnabled() || !submitButton.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
		}
		System.out.println("The user is able to click on Submit Button");
	}

	// Verify the Success Popup Message
	public void verifyBMSuccessPopupMessage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSuccessPopupMessage));
		String successMessage = driver.findElement(PricingLookUpLocators.PLSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSuccesspopupMessageUploadOk))
				.click();
	}

	// search for the added record
	public void AddedRecorddSearch() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSearchforClientcode)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSearchforClientcode))
				.sendKeys(PricingLookUpConstants.CLIENT_CODE.getValue() + random);
	}

	// veriy the search functionality added same record

	// Verify the Update Popup Message
	public void verifyBMUpdatePopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLUpdatePopupMessage));
		String successMessage = driver.findElement(PricingLookUpLocators.PLUpdatePopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been updated successfully..!");
		System.out.println("The user is able to verify the Update Popup Message");
	}

	// Click on Source Table Dropdown and Blank Selection
	public void clickBMClientCodeblankSelection() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLClientCode));
		driver.findElement(PricingLookUpLocators.PLClientCode).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLProductCode));
		driver.findElement(PricingLookUpLocators.PLProductCode).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Thread.sleep(2000);
		String actual = driver.findElement(PricingLookUpLocators.PLErrorValidation).getText();
		Assert.assertEquals("Client code is required.", actual);
		System.out.println("The user is able to click on Client code and validate the error message");
	}

	// Click on Reset Button
	public void clickBMResetButton() throws InterruptedException {
		WebElement ResetButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLResetButton));
		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ResetButton);
		// Ensure the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(ResetButton));
		// Click using Actions
		Actions act = new Actions(driver);
		act.moveToElement(ResetButton).click().build().perform();
		// Fallback to JavaScript click if necessary
		if (!ResetButton.isEnabled() || !ResetButton.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ResetButton);
		}
		System.out.println("The user is able to click on Reset Button");
	}

	// Click on Cancel Button
	public void clickBMCancelButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String actual = driver.findElement(PricingLookUpLocators.PLCategoryTextVisible).getText();
		Assert.assertEquals("Common Reference Look Up Category", actual);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCancelButton));
		driver.findElement(PricingLookUpLocators.PLCancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}

	// Verify the Data Source File Grid is visible and File Information is Not
	// Visible
	public void verifyBMGridVisibleandFileInformationNotVisible() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean category = driver.findElement(PricingLookUpLocators.PLCategoryTextPageVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify Common Reference Look Up Category and Look up is not  visible");
	}

	// Click on Update Button
	public void clickBMUpdateButton() {
		WebElement UpdateButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLUpdateButton));
		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UpdateButton);
		// Ensure the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
		// Click using Actions
		Actions act = new Actions(driver);
		act.moveToElement(UpdateButton).click().build().perform();
		// Fallback to JavaScript click if necessary
		if (!UpdateButton.isEnabled() || !UpdateButton.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", UpdateButton);
		}
		System.out.println("The user is able to click on Update Button");
	}

	// Click on Edit Button
	public void clickBMEditButton() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLEditButton));
		driver.findElement(PricingLookUpLocators.PLEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}

	// Verify Brannd Category Text is Visible
	public void verifyBMCategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLCategoryTextVisible));
		boolean category = driver.findElement(PricingLookUpLocators.PLCategoryTextVisible).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Common Reference Look Up Category Text is visible");
	}

	public void editClientCodeValue() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLProductCode));
		driver.findElement(PricingLookUpLocators.PLProductCode).clear();
		driver.findElement(PricingLookUpLocators.PLProductCode).sendKeys("111");

	}

	// Click on Delete Button
	public void clickBMDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteButton));
		driver.findElement(PricingLookUpLocators.PLDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}

	// Click on Delete Confirmation Popup Confirm Button
	public void clickBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton));
		driver.findElement(PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}

	// Click on Delete Confirmation Popup Cancel Button
	public void clickBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupCancelButton));
		driver.findElement(PricingLookUpLocators.PLDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}

	// Verify All the Fields are Cleared after Reset Button
	public void verifyAllFieldsClearedforResetButton() {
		String currency = driver.findElement(PricingLookUpLocators.PLCurrency).getAttribute("value");
		String clientCode = driver.findElement(PricingLookUpLocators.PLClientCode).getAttribute("value");
		String productCode = driver.findElement(PricingLookUpLocators.PLProductCode).getAttribute("value");
		String instalments = driver.findElement(PricingLookUpLocators.PLInstalments).getAttribute("value");
		String offerMonths = driver.findElement(PricingLookUpLocators.PLOfferMonths).getAttribute("value");
		String loanAmountMin = driver.findElement(PricingLookUpLocators.PLLoanAmountMin).getAttribute("value");
		String loanAmountMax = driver.findElement(PricingLookUpLocators.PLLoanAmountMax).getAttribute("value");
		String rule = driver.findElement(PricingLookUpLocators.PLRule).getAttribute("value");
		String commSubPct = driver.findElement(PricingLookUpLocators.PLCommSubPct).getAttribute("value");
		String minMaxSubVal = driver.findElement(PricingLookUpLocators.PLMinMaxSubVal).getAttribute("value");
		String cntdwnRatePct = driver.findElement(PricingLookUpLocators.PLCntdwnRatePct).getAttribute("value");
		String minCntdwnRatePct = driver.findElement(PricingLookUpLocators.PLMinCntdwnRatePct).getAttribute("value");
		String cntdwnAdjust = driver.findElement(PricingLookUpLocators.PLCntdwnAdjust).getAttribute("value");
		String thirdParty1Encoding = driver.findElement(PricingLookUpLocators.PLThirdParty1Encoding)
				.getAttribute("value");
		String thirdParty1Rate = driver.findElement(PricingLookUpLocators.PLThirdParty1Rate).getAttribute("value");
		String thirdParty2Encoding = driver.findElement(PricingLookUpLocators.PLThirdParty2Encoding)
				.getAttribute("value");
		String thirdParty2Rate = driver.findElement(PricingLookUpLocators.PLThirdParty2Rate).getAttribute("value");
		String thirdParty3Encoding = driver.findElement(PricingLookUpLocators.PLThirdParty3Encoding)
				.getAttribute("value");
		String thirdParty3Rate = driver.findElement(PricingLookUpLocators.PLThirdParty3Rate).getAttribute("value");
		String volBonusPct = driver.findElement(PricingLookUpLocators.PLVolBonusPct).getAttribute("value");
		String headOfficeRebate = driver.findElement(PricingLookUpLocators.PLHeadOfficeRebate).getAttribute("value");
		Assert.assertEquals("", currency);
		Assert.assertEquals("", clientCode);
		Assert.assertEquals("", productCode);
		Assert.assertEquals("", instalments);
		Assert.assertEquals("", offerMonths);
		Assert.assertEquals("", loanAmountMin);
		Assert.assertEquals("", loanAmountMax);
		Assert.assertEquals("", rule);
		Assert.assertEquals("", commSubPct);
		Assert.assertEquals("", minMaxSubVal);
		Assert.assertEquals("", cntdwnRatePct);
		Assert.assertEquals("", minCntdwnRatePct);
		Assert.assertEquals("", cntdwnAdjust);
		Assert.assertEquals("", thirdParty1Encoding);
		Assert.assertEquals("", thirdParty1Rate);
		Assert.assertEquals("", thirdParty2Encoding);
		Assert.assertEquals("", thirdParty2Rate);
		Assert.assertEquals("", thirdParty3Encoding);
		Assert.assertEquals("", thirdParty3Rate);
		Assert.assertEquals("", volBonusPct);
		Assert.assertEquals("", headOfficeRebate);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}

	// Verify the Data Quality Assignment Grid is Visible and Data Assignment
	// Category is Not Visible
	public void verifyBMAssignmentGridVisibleandDataAssignmentCategoryNotVisible() {

		String actual = driver.findElement(PricingLookUpLocators.PLCategoryTextPageVisible).getText();
		Assert.assertNotEquals("Common Reference Look Up ", actual);
		System.out.println(
				"The user is able to verify the Data Quality Assignment Grid is visible and Data Assignment Category is not visible");
	}

	// Verify the Delete Confirmation Popup Message
	public void verifyBMDeleteConfirmationPopupMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(PricingLookUpLocators.PLDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}

	// Verify in the Delete Popup Confirm button is Visible
	public void verifyBMDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton)
				.isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}

	// Verify in the Delete Popup Cancel button is Visible
	public void verifyBMDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(PricingLookUpLocators.PLDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

// 	//Verify the Data Quality Assignment Grid is Visible and Data Assignment Category is Not Visible
	public void verifyBMFileRemoval() {
		boolean grid = driver.findElement(PricingLookUpLocators.PLGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}

	// Click on Download Button
	public void clickBMDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLDownloadButton));
		driver.findElement(PricingLookUpLocators.PLDownloadButton).click();
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
	public void clickBMDownloadAllApproveRecord() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLDownloadButtonApproveRecord));
		driver.findElement(PricingLookUpLocators.PLDownloadButtonApproveRecord).click();
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
/*
	// Click on Upload Button
	public void clickBMUploadButton() {
		WebElement uploadButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLUploadButton));
		driver.findElement(PricingLookUpLocators.PLUploadButton).isDisplayed();
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploadButton)) != null);
		System.out.println("The upload button is visible and is clickable");
	}

	// BMSelectValidFile
	// Verify Selection of file and upload
	public void selectFileToUpload() {
		WebElement fileInput = driver.findElement(PricingLookUpLocators.PLSelectValidFile);
		System.out.println("The user is able to select a valid file to upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "\\src\\test\\resources\\TestData\\Pricing_LookUp.csv");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		// Upload the file by sending the path
		fileInput.sendKeys(absolutePath);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("File uploaded successfully!");
	}

	// Verify Success message of Upload
	public void verifyUploadSuccessMessage() {
		String actual = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSuccesspopupMessageUpload))
				.getText();
		Assert.assertEquals("Record has been uploaded successfully..!", actual);
		System.out.println("The user is able to upload the file successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement((PricingLookUpLocators.PLSuccesspopupMessageUploadOk)).click();
		System.out.println("The user is able to click on OK button");
	}
*/
	// Click on Send for Approval button
	public void clickSendForApprovalButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PricingLookUpLocators.PLSendforApprovalButton));
		driver.findElement(PricingLookUpLocators.PLSendforApprovalButton).click();
		System.out.println("The user is able to click on Send for Approval Button");
	}

	// Verify submission of file for approval
	public void fileSubmittedForApproval() {
		WebElement popup = driver.findElement(PricingLookUpLocators.PLConfirmationPopupSelect);
		wait.until(ExpectedConditions.visibilityOf(popup));
		Assert.assertTrue(popup.isDisplayed());
	}

	public void ConfirmationMessageConfirmAndCancelButtons() {
		WebElement confirmButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton));
		WebElement cancelButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(PricingLookUpLocators.PLDeleteConfirmationPopupCancelButton));
		Assert.assertTrue(confirmButton.isDisplayed());
		Assert.assertTrue(cancelButton.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(confirmButton));
		wait.until(ExpectedConditions.visibilityOf(cancelButton));
		System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
	}

	public void ConfirmButtonSentForApproval() {
		WebElement confirmButton = driver.findElement((PricingLookUpLocators.PLDeleteConfirmationPopupConfirmButton));
		wait.until(ExpectedConditions.visibilityOf(confirmButton));
		confirmButton.click();
		System.out.println("The user is able to send the file for approval successfully");

	}

}
