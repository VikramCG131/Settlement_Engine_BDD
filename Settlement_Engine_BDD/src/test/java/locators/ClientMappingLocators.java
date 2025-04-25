package locators;

import org.openqa.selenium.By;

public class ClientMappingLocators {
/******Client Mapping Page******/
	
	public static final By CLMClientMappingTab = By.xpath("//span[text()='Client Mapping']");
	public static final By CLMAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By CLMSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By CLMUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By CLMDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By CLMDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CLMDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLMUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By CLMSelectValidFile= By.xpath("//input[@type='file']");
	public static final By CLMSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By CLMSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By CLMSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By CLMConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CLMConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLMClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Client Mapping Category******/
	
	public static final By CLMClientCode = By.xpath("//input[@formcontrolname='clientCode']");
	public static final By CLMShopCode = By.xpath("//input[@formcontrolname='shopCode']");
	public static final By CLMMappedCode= By.xpath("//input[@formcontrolname='mappedCode']");
	public static final By CLMSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By CLMClentCodeErrorValidation = By.xpath("//span[contains(text(),'Please Enter Client Code')]");
	public static final By CLMPageGridValidation = By.xpath("//span[contains(text(),'Client Mapping Grid')]");
	public static final By CLMResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By CLMCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLMUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By CLMCategoryTextVisible = By.xpath("//h6[contains(text(),'Client Mapping Category')]");
	public static final By CLMCategoryTextPageVisible = By.xpath("//span[contains(text(),'Client Mapping Grid')]");
	public static final By CLMConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By CLMDownloadButton= By.xpath("//button[contains(text(),'Download')]");
	
	/******Client Mapping Grid******/
	public static final By CLMGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By CLMEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By CLMDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
