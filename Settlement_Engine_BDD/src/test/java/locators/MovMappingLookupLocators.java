package locators;

import org.openqa.selenium.By;

public class MovMappingLookupLocators {

	
	public static final By MMAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By MMSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By MMUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By MMDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By MMDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By MMDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By MMUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By MMSelectValidFile= By.xpath("//input[@type='file']");
	public static final By MMSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By MMSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By MMSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By MMConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By MMConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By MMClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Brand Mapping Category******/
	
	public static final By MMMovemnetType = By.xpath("//input[@placeholder='Enter Movement Type']");
	public static final By MMDescription = By.xpath("//input[@placeholder='Enter Description']");
	public static final By MMSuMMitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By MMErrorValidation = By.xpath("//small[contains(text(),'Movement Type is required.')]");
	public static final By MMPageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By MMResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By MMCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By MMUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By MMCategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category')]");
	public static final By MMCategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By MMConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By MMDownloadButton= By.xpath("//button[contains(text(),'Download All Records')]");
	public static final By MMDownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Only Approved Records')]");
	public static final By MMSourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	/******Brand Mapping Grid******/
	public static final By MMSearchMovementType = By.xpath("//input[@data-ref='eInput' and @aria-label='Movement Type Filter Input']");
	public static final By MMSearchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By MMGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By MMEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By MMDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
