package locators;

import org.openqa.selenium.By;

public class CommonReferenceLookupLocators {
/******Brand Mapping Page******/
	
	public static final By CRLBrandMapingTab = By.xpath("//span[contains(text(),'Brand Mapping')]");
	public static final By CRLAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By CRLSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By CRLUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By CRLDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By CRLDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CRLDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CRLUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By CRLSelectValidFile= By.xpath("//input[@type='file']");
	public static final By CRLSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By CRLSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By CRLSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By CRLConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CRLConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CRLClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Brand Mapping Category******/
	
	public static final By CRLClientCode = By.xpath("//input[@formcontrolname='clientCode']");
	public static final By CRLBrandCode = By.xpath("//input[@formcontrolname='brandCode']");
	public static final By CRLSuCRLitButton = By.xpath("//button[contains(text(),'SuCRLit')]");
	public static final By CRLErrorValidation = By.xpath("//div[contains(text(),'Please enter Client Code')]");
	public static final By CRLPageGridValidation = By.xpath("//span[contains(text(),'Brand Mapping Grid')]");
	public static final By CRLResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By CRLCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CRLUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By CRLCCategoryTextVisible = By.xpath("//h6[contains(text(),'Brand Mapping Category')]");
	public static final By CRLCCategoryTextPageVisible = By.xpath("//span[contains(text(),'Brand Mapping Grid')]");
	public static final By CRLConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By CRLDownloadButton= By.xpath("//button[contains(text(),'Download')]");
	
	/******Brand Mapping Grid******/
	public static final By CRLSearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Client Code Filter Input']");
	public static final By CRLSearchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By CRLGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By CRLEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By CRLDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
