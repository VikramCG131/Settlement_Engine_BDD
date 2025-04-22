package locators;

import org.openqa.selenium.By;

public class BrandMappingLocators {
/******Brand Mapping Page******/
	
	public static final By BMBrandMapingTab = By.xpath("//span[contains(text(),'Brand Mapping')]");
	public static final By BMAddNewButton = By.xpath("//*[text()='Add New']");
	public static final By BMSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By BMUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By BMDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By BMDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By BMDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By BMUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By BMSelectValidFile= By.xpath("//input[@type='file']");
	public static final By BMSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By BMSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By BMSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By BMConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By BMConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By BMClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Brand Mapping Category******/
	
	public static final By BMClientCode = By.xpath("//input[@formcontrolname='clientCode']");
	public static final By BMBrandCode = By.xpath("//input[@formcontrolname='brandCode']");
	public static final By BMSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By BMErrorValidation = By.xpath("//div[contains(text(),'Please enter Client Code')]");
	public static final By BMPageGridValidation = By.xpath("//span[contains(text(),'Brand Mapping Grid')]");
	public static final By BMResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By BMCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By BMUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By BMCategoryTextPageVisible = By.xpath("//span[contains(text(),'Brand Mapping Grid')]");
	public static final By BMConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By BMDownloadButton= By.xpath("//button[contains(text(),'Download')]");
	
	/******Brand Mapping Grid******/
	public static final By BMGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By BMEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By BMDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
