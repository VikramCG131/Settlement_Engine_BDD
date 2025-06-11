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
import locators.SEGroupConfigLocators;
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
	
	
	//Verify the Update Popup Message
			public   void verifySECUpdatePopupMessage() {
				wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECUpdatePopupMessage));
				String successMessage = driver.findElement(SECalculationLocators.SECUpdatePopupMessage).getText();
				Assert.assertEquals(successMessage, "Record has been updated successfully..!");
				System.out.println("The user is able to verify the Update Popup Message");
			}
		
	//Verify the Success Popup Message
	public   void verifySECSuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECSuccessPopupMessage));
		String successMessage = driver.findElement(SECalculationLocators.SECSuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Rule has been added successfully");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECSuccesspopupMessageUploadOk)).click();
	}
	
	
	
	//Click on File Pattern and Blank Selection
	public   void clickSECalCulationBlankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECValidate));
		driver.findElement(SECalculationLocators.SECValidate).click();
		String actual = driver.findElement(SECalculationLocators.SECFormulaValidation).getText();
		Assert.assertEquals("Please Enter Valid Formula", actual);
		System.out.println("The user is able to click on Validate Button and validate the error message");
	}
	
	//Click on Reset Button
	public   void clickSECResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECResetButton));
		driver.findElement(SECalculationLocators.SECResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	
	//Click on Update Button
	public   void clickSECUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SEUpdateButton));
		driver.findElement(SECalculationLocators.SEUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public void clickSECEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECditButton));
		driver.findElement(SECalculationLocators.SECditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	//Verify Assignment Category Text is Visible
		public   void verifySECalculationCategoryTextVisible() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCategoryTextVisible));
			boolean category = driver.findElement(SECalculationLocators.SECategoryTextVisibleRules).isDisplayed();
			Assert.assertTrue(category);
			System.out.println("The user is able to verify the File Information Text is visible");
		}	
	
	//Click on Delete Button
	public   void clickSECDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECDeleteButton));
		driver.findElement(SECalculationLocators.SECDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickSECDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECDeleteConfirmationPopupConfirmButton));
		driver.findElement(SECalculationLocators.SECDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECDeleteConfirmationPopupCancelButton));
		driver.findElement(SECalculationLocators.SECDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String RuleName = driver.findElement(SECalculationLocators.SECRuleName).getAttribute("value");
		Assert.assertEquals("", RuleName);
		String VariableName = driver.findElement(SECalculationLocators.SECValriableName).getAttribute("value");
		Assert.assertEquals("", VariableName);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	/*
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
	*/
	public void editGroupNameValue()
	{
		random = CommonUtilities.getRandomInteger();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECValriableName));
		driver.findElement(SECalculationLocators.SECValriableName).clear();
		driver.findElement(SECalculationLocators.SECValriableName).sendKeys("Var"+random);
	}
	
	public void verifySECFileRemoval() {
		boolean grid = driver.findElement(SECalculationLocators.SECGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifySECDeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(SECalculationLocators.SECDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifySECDeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(SECalculationLocators.SECDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}
	// click on Enter Formula
	public void clickOnEnterFormula()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).click();
	}
	
	public void enterValidFormulaInFormulaTextBox() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("select");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECStarOperator));
		driver.findElement(SECalculationLocators.SECStarOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("from employee");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECWhereOperator));
		driver.findElement(SECalculationLocators.SECWhereOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECOpenBracesOperator));
		driver.findElement(SECalculationLocators.SECOpenBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("Department");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECEqualsOperator));
		driver.findElement(SECalculationLocators.SECEqualsOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("'IT'");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECOROperator));
		driver.findElement(SECalculationLocators.SECOROperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys(" Department");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECEqualsOperator));
		driver.findElement(SECalculationLocators.SECEqualsOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("'HR'");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCloseBracesOperator));
		driver.findElement(SECalculationLocators.SECCloseBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECANDOperator));
		driver.findElement(SECalculationLocators.SECANDOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECOpenBracesOperator));
		driver.findElement(SECalculationLocators.SECOpenBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("Status");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECNotEqualsOperator));
		driver.findElement(SECalculationLocators.SECNotEqualsOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("'Inactive'");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCloseBracesOperator));
		driver.findElement(SECalculationLocators.SECCloseBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECANDOperator));
		driver.findElement(SECalculationLocators.SECANDOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECOpenBracesOperator));
		driver.findElement(SECalculationLocators.SECOpenBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("Role");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECINOperator));
		driver.findElement(SECalculationLocators.SECINOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECOpenBracesOperator));
		driver.findElement(SECalculationLocators.SECOpenBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormula));
		driver.findElement(SECalculationLocators.SECFormula).sendKeys("'DEV','QA'");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCloseBracesOperator));
		driver.findElement(SECalculationLocators.SECCloseBracesOperator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECCloseBracesOperator));
		driver.findElement(SECalculationLocators.SECCloseBracesOperator).click();
		Thread.sleep(5000);
	}
	public void clickOnValidateButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECValidate));
		driver.findElement(SECalculationLocators.SECValidate).click();
	}
	//Verify the Formula Validation Message
	public void validateSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECalculationLocators.SECFormulaValidationMessage));
		String validationMessage = driver.findElement(SECalculationLocators.SECFormulaValidationMessage).getText();
		Assert.assertEquals(validationMessage, "Formula is Valid");
		System.out.println("The user is able to verify the Formula Validation Message");
	}
	
}
