package locators;

import org.openqa.selenium.By;

public class DueDateLookupLocators {
/******Due Date LookUP Page******/
	
	
	public static final By DDLAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By DDLSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By DDLUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By DDLDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By DDLDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By DDLDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DDLUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By DDLSelectValidFile= By.xpath("//input[@type='file']");
	public static final By DDLSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By DDLSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By DDLSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By DDLConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By DDLConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DDLClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Due Date LookUP Category******/
	
	public static final By DDLClientCode = By.xpath("//input[@placeholder='Enter Client Code']");
	public static final By DDLDataSet = By.xpath("//input[@placeholder='Enter Dataset']");
	public static final By DDLCapitalTerms = By.xpath("//input[@placeholder='Enter Capital Terms']");
	public static final By DDLComissionTerms = By.xpath("////input[@placeholder='Enter Commission Terms']");
	public static final By DDLMovementType = By.xpath("//input[@placeholder='Enter Movement Type']");
	public static final By DDLRULEType = By.xpath("//input[@placeholder='Enter Rule Type']");
	public static final By DDLProduceCode = By.xpath("//input[@placeholder='Enter Product Code']");
	public static final By DDLRuleExpression = By.xpath("//input[@placeholder='Enter Rule Expression']");
	public static final By DDLSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By DDLErrorValidation = By.xpath("//div[contains(text(),'Client Code is required.')]");
	public static final By DDLPageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By DDLResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By DDLCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DDLUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By DDLCategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category')]");
	public static final By DDLCategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By DDLConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By DDLDownloadButton= By.xpath("//button[contains(text(),'Download All Records')]");
	public static final By DDLDownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Only Approved Records')]");
	public static final By DDLSourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	
	/******Due Date LookUP Grid******/
	public static final By DDLSearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Client Code Filter Input']");
	public static final By DDLSearchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By DDLGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By DDLEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By DDLDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
