package locators;

import org.openqa.selenium.By;

public class ClientLookupLocators {
	
	/******Client Lookup Page******/
	
	public static final By CLUientLookupTab = By.xpath("//a/span[contains(text(),'Client Look Up')]");
	public static final By CLUAddNewButton = By.xpath("//*[text()='Add New']");
	public static final By CLUSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By CLUDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By CLUDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CLUDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLUUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By CLUSelectValidFile= By.xpath("//input[@type='file']");
	public static final By CLUSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By CLUSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By CLUSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By CLUConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By CLUConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLUClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Client Lookup Category******/
	
	public static final By CLUPayableElement2 = By.xpath("//input[@formcontrolname='payableEl2']");
	public static final By CLUAdvanComission = By.xpath("//input[@formcontrolname='advanceComission']");
	public static final By CLUShopCode = By.xpath("//input[@formcontrolname='shopCode']");
	public static final By CLUShopName = By.xpath("//input[@formcontrolname='shopName']");
	public static final By CLUDataSourceType= By.xpath("//input[@formcontrolname='dStype']");
	public static final By CLUSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By CLUASourceErrorValidation = By.xpath("//span[contains(text(),'Please Enter Payable Element 2')]");
	public static final By CLUPageGridValidation = By.xpath("//span[contains(text(),'Client Look Up Grid')]");
	public static final By CLUResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By CLUCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By CLUUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By CLUCategoryTextPageVisible = By.xpath("//span[contains(text(),'Client Look Up Grid')]");
	public static final By CLUConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By CLUDownloadButton= By.xpath("//button[contains(text(),'Download')]");
	
	/******Client Lookup Grid******/
	public static final By CLUGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By CLUEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By CLUDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
