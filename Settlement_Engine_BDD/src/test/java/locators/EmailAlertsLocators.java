package locators;

import org.openqa.selenium.By;

public class EmailAlertsLocators {
	
	/******Email Alert Page******/
	public static final By EmailAlertTab = By.xpath("//span[contains(text(),'Email Alert')]");
	public static final By EAAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By EASuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully ']");
	public static final By EASuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By EAUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By EADeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By EADeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By EADeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	//
	
	/******Compose Email Category******/
	public static final By EATemplateTypeDropdown = By.id("templateType");
	public static final By EAEmailAddress = By.xpath("//input[@formcontrolname='emailAddress']");
	public static final By EASubject = By.xpath("//input[@formcontrolname='subject']");
	public static final By EAInsertText = By.xpath("//div[@data-placeholder='Insert text here ...']");
	public static final By EAFilePatternValidation = By.xpath("//*[text()='Please Enter File Pattern']");
	public static final By EASubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By EAResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By EACancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EAUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By EACategoryTextVisible = By.xpath("//h6[contains(text(),'Compose Email')]");
	public static final By EAEmailAddressValidation = By.xpath("//span[contains(text(),'Please Enter EmailAddress')]");
	public static final By EACategoryTextVisibleGrid = By.xpath("//span[contains(text(),'Email Template Grid')]");
	
	/******Data Source File Grid******/
	public static final By EASearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Email Address Filter Input']");
	public static final By EAGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By EAEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By EADeleteButton = By.xpath("(//i[@data-action='delete'])[1]");

}
