package tabs;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;

import constants.EmailAlertConstants;

import locators.SEGroupConfigLocators;
import locators.LoginPageLocators;
import locators.SettlementEngineLoginLocators;
import utils.DriverManager;

public class SEGroupConfigTab {
	private WebDriver driver;
	private WebDriverWait wait;
	static String random;
	//Constructor to initialize the driver and wait
	public SEGroupConfigTab() {
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
	public   void clickSeGroupConfigTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEGroupConfigTab));
		driver.findElement(SEGroupConfigLocators.SEGroupConfigTab).click();
		System.out.println("The user is able to click on Data Source File Tab");
	}
	
	//Click on Add New Button
	public   void clickSEAddNewButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEAddButton));
		driver.findElement(SEGroupConfigLocators.SEAddButton).click();
		System.out.println("The user is able to click on Add New Button");
	}
	
	public void clicksAnyArrowIcon() throws InterruptedException
	{	
		List<WebElement> rules = driver.findElements(By.xpath("//div[@class='rule-item form-control ng-star-inserted']"));
	       // Step 2: Get all arrow buttons (adjust this XPath as needed)	      
	       for (int i = 0; i < 3 && i < rules.size(); i++) {
	           rules.get(i).click();  
	           wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SELeftArrow));
		   		driver.findElement(SEGroupConfigLocators.SELeftArrow).click();// Click the rule    		
	       } 
	}
	
	public void appliedRulesAppear() throws InterruptedException
	{
	   		
	   		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDoubleLeftArrow));
	   		driver.findElement(SEGroupConfigLocators.SEDoubleLeftArrow).click();
	   		List<WebElement> rules = driver.findElements(By.xpath("//div[@class='rule-item form-control ng-star-inserted']"));
		       // Step 2: Get all arrow buttons (adjust this XPath as needed)	      
		       for (int i = 0; i < 1 && i < rules.size(); i++) {
		           rules.get(i).click();  
		           wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDownArrow));
			   		driver.findElement(SEGroupConfigLocators.SEDownArrow).click();
			   		
			   		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEUpperArrow));
			   		driver.findElement(SEGroupConfigLocators.SEUpperArrow).click();
			   		
			   		//wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SERightArrow));
			   		//driver.findElement(SEGroupConfigLocators.SERightArrow).click();
			   		
			   		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDoubleLeftArrow));
			   		driver.findElement(SEGroupConfigLocators.SEDoubleRightArrow).click();
			   		// Click the rule  
			   		
		       }
			
	}

	//Enter the Field Value in Data Source File Category
	public   void enterEAFieldValue(String groupName) throws InterruptedException {
		random = CommonUtilities.getRandomInteger();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEGroupName));
		driver.findElement(SEGroupConfigLocators.SEGroupName).sendKeys(groupName+random);
		System.out.println("The user is able to enter the field value in SE Group Config Category");
		
	}
	
	public void AddConfigureRulesInAppliedRulrd() throws InterruptedException
	{
		List<WebElement> ruleselection = driver.findElements(By.xpath("//div[@class='rule-item form-control ng-star-inserted']"));
	       // Step 2: Get all arrow buttons (adjust this XPath as needed)	      
	       for (int i = 0; i < 3 && i < ruleselection.size(); i++) {
	    	   ruleselection.get(i).click();  
	           wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SELeftArrow));
		   		driver.findElement(SEGroupConfigLocators.SELeftArrow).click();
		   		// Click the rule    		
	       } 
	}
	//Click on Submit Button
	public   void clickEASubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SESubmitButton));
		driver.findElement(SEGroupConfigLocators.SESubmitButton).click();
		System.out.println("The user is able to click on Submit Button");
	}
	
	//Verify the Update Popup Message
			public   void verifyEAUpdatePopupMessage() {
				wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEUpdatePopupMessage));
				String successMessage = driver.findElement(SEGroupConfigLocators.SEUpdatePopupMessage).getText();
				Assert.assertEquals(successMessage, "Record has been updated successfully..!");
				System.out.println("The user is able to verify the Update Popup Message");
			}
			
	//Verify the Success Popup Message
	public   void verifyEASuccessPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SESuccessPopupMessage));
		String successMessage = driver.findElement(SEGroupConfigLocators.SESuccessPopupMessage).getText();
		Assert.assertEquals(successMessage, "Record has been added successfully..!");
		System.out.println("The user is able to verify the Success Popup Message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SESuccesspopupMessageUploadOk)).click();
	}
	
	
	
	//Click on File Pattern and Blank Selection
	public   void clickSEGroupConfigblankSelection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEGroupName));
		driver.findElement(SEGroupConfigLocators.SEGroupName).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEAppliedRulesClick));
		driver.findElement(SEGroupConfigLocators.SEAppliedRulesClick).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		String actual = driver.findElement(SEGroupConfigLocators.SEGroupNameValidation).getText();
		Assert.assertEquals("Please Enter Group Name", actual);
		System.out.println("The user is able to click on Group name and validate the error message");
	}
	
	//Click on Reset Button
	public   void clickEAResetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEResetButton));
		driver.findElement(SEGroupConfigLocators.SEResetButton).click();
		System.out.println("The user is able to click on Reset Button");
	}
	
	//Click on Cancel Button
	public   void clickEACancelButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SECategoryTextVisible));
		boolean grid = driver.findElement(SEGroupConfigLocators.SECategoryTextVisible).isDisplayed();
		Assert.assertTrue(grid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SECancelButton));
		driver.findElement(SEGroupConfigLocators.SECancelButton).click();
		System.out.println("The user is able to click on Cancel Button");
	}
	
	//Click on Update Button
	public   void clickEAUpdateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEUpdateButton));
		driver.findElement(SEGroupConfigLocators.SEUpdateButton).click();
		System.out.println("The user is able to click on Update Button");
	}
	
	//Click on Edit Button
	public void clickEAEditButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEEditButton));
		driver.findElement(SEGroupConfigLocators.SEEditButton).click();
		System.out.println("The user is able to click on Edit Button");
	}
	
	
	//Verify Assignment Category Text is Visible
	public   void verifyEACategoryTextVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SECategoryTextVisibleGrid));
		boolean category = driver.findElement(SEGroupConfigLocators.SECategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the File Information Text is visible");
	}	
	
	
	//Click on Delete Button
	public   void clickEADeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteButton));
		driver.findElement(SEGroupConfigLocators.SEDeleteButton).click();
		System.out.println("The user is able to click on Delete Button");
	}
	
	//Click on Delete Confirmation Popup Confirm Button
	public   void clickEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteConfirmationPopupConfirmButton));
		driver.findElement(SEGroupConfigLocators.SEDeleteConfirmationPopupConfirmButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Confirm Button");
	}
	
	//Click on Delete Confirmation Popup Cancel Button
	public   void clickEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteConfirmationPopupCancelButton));
		driver.findElement(SEGroupConfigLocators.SEDeleteConfirmationPopupCancelButton).click();
		System.out.println("The user is able to click on Delete Confirmation Popup Cancel Button");
	}
	
	//Verify All the Fields are Cleared after Reset Button
	public   void verifyAllFieldsClearedforResetButton() {
		String GroupName = driver.findElement(SEGroupConfigLocators.SEGroupName).getAttribute("value");
		Assert.assertEquals("", GroupName);
		System.out.println("The user is able to verify all the fields are cleared after Reset Button");
	}
	
	//Verify the Data Source File Grid is visible and File Information is Not Visible
	public void verifyEAGridVisibleandFileInformationNotVisible() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean category = driver.findElement(SEGroupConfigLocators.SECategoryTextVisibleGrid).isDisplayed();
		Assert.assertTrue(category);
		System.out.println("The user is able to verify the Data Source File Grid is visible and File Information is not visible");
	}
	
	//Verify the Delete Confirmation Popup Message
	public   void verifyEADeleteConfirmationPopupMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteConfirmationPopupMessage));
		String deleteMessage = driver.findElement(SEGroupConfigLocators.SEDeleteConfirmationPopupMessage).getText();
		Assert.assertEquals(deleteMessage, "Are you sure you want to delete");
		System.out.println("The user is able to verify the Delete Confirmation Popup Message");
	}
	
	public void editGroupNameValue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEGroupName));
		driver.findElement(SEGroupConfigLocators.SEGroupName).clear();
		driver.findElement(SEGroupConfigLocators.SEGroupName).sendKeys("GP123");
	}
	
	public void verifyEAFileRemoval() {
		boolean grid = driver.findElement(SEGroupConfigLocators.SEGridVisible).isDisplayed();
		Assert.assertTrue(grid);
	}
	
	//Verify in the Delete Popup Confirm button is Visible
	public   void verifyEADeleteConfirmationPopupConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteConfirmationPopupConfirmButton));
		boolean confirm = driver.findElement(SEGroupConfigLocators.SEDeleteConfirmationPopupConfirmButton).isDisplayed();
		Assert.assertTrue(confirm);
		System.out.println("The user is able to verify the Delete Confirmation Popup Confirm Button");
	}
	
	//Verify in the Delete Popup Cancel button is Visible
	public   void verifyEADeleteConfirmationPopupCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEGroupConfigLocators.SEDeleteConfirmationPopupCancelButton));
		boolean cancel = driver.findElement(SEGroupConfigLocators.SEDeleteConfirmationPopupCancelButton).isDisplayed();
		Assert.assertTrue(cancel);
		System.out.println("The user is able to verify the Delete Confirmation Popup Cancel Button");
	}


	
	
}
