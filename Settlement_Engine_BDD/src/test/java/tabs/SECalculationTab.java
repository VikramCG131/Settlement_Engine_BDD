package tabs;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;

import constants.EmailAlertConstants;

import locators.SECalculationLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class SECalculationTab {
	private WebDriver driver;
	private WebDriverWait wait;
	static String random;
	//Constructor to initialize the driver and wait
	public SECalculationTab() {
		this.driver = DriverManager.getDriver();
		
		if (this.driver == null) {
			throw new IllegalStateException("Driver is null in login page");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Open the login page
	public void openLoginPage() {
		driver.get(LoginPageLocators.SE_URL);
		System.out.println("The user is able to open the login page");
	}
	
	//Verify health check of the URL
	public void verifyHealthCheck() throws IOException {
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
	public    void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Settlement Engine");
		System.out.println("The user is able to verify the title of the page");
	}
	
	//Click on MetaData Button
	public  void clickMetaDataButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.MetaDataButton));
		driver.findElement(LoginPageLocators.MetaDataButton).click();
		System.out.println("The user is able to click on MetaData Button");
	}
	
	//Click on Hamburger Menu Button
	public   void clickHamburgerMenuButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.HamburgerButton));
		driver.findElement(LoginPageLocators.HamburgerButton).click();
		System.out.println("The user is able to click on Hamburger Menu Button");
	}
	
	//Click on Data Quality Assignment Tab
	public   void clickSCalulationTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCalculationTab));
		driver.findElement(SECalculationLocators.SECCalculationTab).click();
		System.out.println("The user is able to click SE Calculation Tab");
	}

	
	//Enter Settlement Rules Config Metadata Category
	public   void enterSECalculationCategoryValues(String RuleName,String VariableName) throws InterruptedException {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECRuleName));
		driver.findElement(SECalculationLocators.SECRuleName).sendKeys(RuleName+random);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECValriableName));
		driver.findElement(SECalculationLocators.SECValriableName).sendKeys(VariableName+random);
		System.out.println("The user is able to enter the field value in SE Group Config Category");
		Thread.sleep(2000);
	}
	
	 
	public void enterRuleConfigMetaDataFieldWithFormula() throws InterruptedException {
		// Step 3: Create a list of values
		List<String> values = Arrays.asList("LENGTH('PostgreSQL');", "ROUND(123.456, 2);",
				"CASE WHEN 1000 > 500 THEN ROUND(1000.55, 2) ELSE 0 END", "100 + 50", "LOWER('HELLO')",
				"LENGTH('test')", "TRUE", "FALSE", "CASE WHEN 10 > 5 THEN 1 ELSE 0 END", "COALESCE(NULL, 'default')");
		// Step 4: Piformulack a random value from the list
		Random selectrandomformula = new Random();
		String selectedValuerandomformula = values.get(selectrandomformula.nextInt(values.size()));
		// Step 5: Find the input field and send the selected value
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		WebElement inputFieldrandom = driver.findElement(SECalculationLocators.SECFormula);
		inputFieldrandom.sendKeys(selectedValuerandomformula);
		System.out.println("The user is able to enter the field value in SE Group Config Category");

	}
	public void clickOnValidateButtonSeeValidateMessafe()  throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECValidate));
		driver.findElement(SECalculationLocators.SECValidate).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormulaValidationMessage));
		String formulavalidationMessage = driver.findElement(SECalculationLocators.SECFormulaValidationMessage).getText();
		Assert.assertEquals(formulavalidationMessage, "Formula is Valid");
		System.out.println("The user is able to click on Validate Button and see the validation message");
	}
	
	//Click on Submit Button
	public   void clickEASubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECSubmitButton));
		driver.findElement(SECalculationLocators.SECSubmitButton).click();
		System.out.println("The user is able to click on Save Button");
	}
	
	/*
	//Verify the Update Popup Message
			public   void verifyEAUpdatePopupMessage() {
				wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEUpdatePopupMessage));
				String successMessage = driver.findElement(SECalculationLocators.SEUpdatePopupMessage).getText();
				Assert.assertEquals(successMessage, "Record has been updated successfully..!");
				System.out.println("The user is able to verify the Update Popup Message");
			}
		*/	
	//Verify the Success Popup Message
	public   void verifyEASuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECSuccessPopupMessage));
		String successMessage = driver.findElement(SECalculationLocators.SECSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Rule has been added successfully");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECSuccesspopupMessageUploadOk)).click();
	}
	/*
	
	
	//Click on File Pattern and Blank Selection
	public   void clickSEGroupConfigblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEGroupName));
		driver.findElement(SECalculationLocators.SEGroupName).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEAppliedRulesClick));
		driver.findElement(SECalculationLocators.SEAppliedRulesClick).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		String actual = driver.findElement(SECalculationLocators.SEGroupNameValidation).getText();
		Assert.assertEquals("Please Enter Group Name", actual);
		System.out.println("The user is able to click on Group name and validate the error message");
	}
	
	//Click on Reset Button
	public   void clickEAResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEResetButton));
		driver.findElement(SECalculationLocators.SEResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickEACancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECategoryTextVisible));
		boolean grid = driver.findElement(SECalculationLocators.SECategoryTextVisible).isDisplayed();
		Assert.assertTrue(grid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECancelButton));
		driver.findElement(SECalculationLocators.SECancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public   void clickEAUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEUpdateButton));
		driver.findElement(SECalculationLocators.SEUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public void clickEAEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEEditButton));
		driver.findElement(SECalculationLocators.SEEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	
	//Verify Assignment Category Text is Visible
	public   void verifyEACategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECategoryTextVisibleGrid));
		boolean category = driver.findElement(SECalculationLocators.SECategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the File Information Text is visible");
	}	
	
	
	//Click on Delete Button
	public   void clickEADeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteButton));
		driver.findElement(SECalculationLocators.SEDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteConfirmationPopupConfirmButton));
		driver.findElement(SECalculationLocators.SEDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteConfirmationPopupCancelButton));
		driver.findElement(SECalculationLocators.SEDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String GroupName = driver.findElement(SECalculationLocators.SEGroupName).getAttribute("value");
		Assert.assertEquals("", GroupName);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
	public void verifyEAGridVisibleandFileInformationNotVisible() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean category = driver.findElement(SECalculationLocators.SECategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyEADeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(SECalculationLocators.SEDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	public void editGroupNameValue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEGroupName));
		driver.findElement(SECalculationLocators.SEGroupName).clear();
		driver.findElement(SECalculationLocators.SEGroupName).sendKeys("GP123");
	}
	
	public void verifyEAFileRemoval() {
		boolean grid = driver.findElement(SECalculationLocators.SEGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(SECalculationLocators.SEDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(SECalculationLocators.SEDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}

*/
	
	
}
