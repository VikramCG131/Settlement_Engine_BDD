package locators;

import org.openqa.selenium.By;

public class ShopLevelRemittanceLookupLocators {
/******ShopLevel Remittance Lookup Page******/
	
	public static final By SLRShopLevelRemittanceLookupTab = By.xpath("//span[text()='Client Mapping']");
	public static final By SLRAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By SLRSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By SLRUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By SLRDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By SLRDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By SLRDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By SLRUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By SLRSelectValidFile= By.xpath("//input[@type='file']");
	public static final By SLRSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By SLRSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By SLRSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By SLRConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By SLRConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By SLRClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******ShopLevel Remittance Lookup Category******/
	
	public static final By SLRPayableEl2 = By.xpath("//input[@placeholder='Enter Payable El2']");
	public static final By SLRShopCode = By.xpath("//input[@placeholder='Enter Shop Code']");
	public static final By SLRAdviceEntity= By.xpath("//input[@placeholder='Enter Advice Entity']");
	public static final By SLRSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By SLRClentCodeErrorValidation = By.xpath("//div[contains(text(),'Payable El2 is required.')]");
	public static final By SLRPageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By SLRResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By SLRCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By SLRUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By SLRCategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category')]");
	public static final By SLRCategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By SLRConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By SLRDownloadButton= By.xpath("//button[contains(text(),'Download All Records')]");
	public static final By SLRDownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Only Approved Records')]");
	public static final By SLRSourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	
	/******ShopLevel Remittance Lookup Grid******/
	public static final By SLRPaysearchbleEL2 = By.xpath("//input[@data-ref='eInput' and @aria-label='Payable El2 Filter Input']");
	public static final By SLRSearchforstatus= By.xpath("//input[@aria-label=' Status Filter Input']");
	public static final By SLRGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By SLREditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By SLRDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
