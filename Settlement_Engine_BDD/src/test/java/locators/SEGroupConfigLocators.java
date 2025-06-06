package locators;

import org.openqa.selenium.By;

public class SEGroupConfigLocators {
	
	/******Settlement Grouping Config Page******/
	public static final By SEGroupConfigTab = By.xpath("//span[contains(text(),'Email Alert')]");
	public static final By SEAddButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By SESuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully ']");
	public static final By SESuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By SEUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By SEDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By SEDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By SEDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	//
	
	/******Settlement Grouping Config Category******/
	public static final By SETemplateTypeDropdown = By.id("templateType");
	public static final By SEEmailAddress = By.xpath("//input[@formcontrolname='emailAddress']");
	public static final By SESubject = By.xpath("//input[@formcontrolname='subject']");
	public static final By SEInsertText = By.xpath("//div[@data-placeholder='Insert text here ...']");
	public static final By SEFilePatternValidation = By.xpath("//*[text()='Please Enter File Pattern']");
	public static final By SESubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By SEResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By SECancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By SEUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By SECategoryTextVisible = By.xpath("//h6[contains(text(),'Compose Email')]");
	public static final By SEEmailAddressValidation = By.xpath("//span[contains(text(),'Please Enter EmailAddress')]");
	public static final By SECategoryTextVisibleGrid = By.xpath("//span[contains(text(),'Email Template Grid')]");
	
	/******Settlement Grouping Config Grid******/
	public static final By SESearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Email Address Filter Input']");
	public static final By SEGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By SEEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By SEDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");

}
