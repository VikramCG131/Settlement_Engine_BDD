package locators;

import org.openqa.selenium.By;

public class TpMappingLocators {
/******TP Mapping Page******/
	

	public static final By TPAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By TPSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By TPUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By TPDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By TPDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By TPDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By TPUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By TPSelectValidFile= By.xpath("//input[@type='file']");
	public static final By TPSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By TPSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By TPSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By TPConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By TPConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By TPClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Tp Mapping Category******/

	public static final By TPElmCode = By.xpath("//input[@placeholder='Enter Elm Code']");
	public static final By TPName= By.xpath("//input[@placeholder='Enter Name']");
	public static final By TPSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By TPClentCodeErrorValidation = By.xpath("//small[contains(text(),'Elm Code is required.')]");
	public static final By TPPageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By TPResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By TPCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By TPUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By TPCategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category')]");
	public static final By TPCategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By TPConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By TPDownloadButton= By.xpath("//button[contains(text(),'Download All Records')]");
	public static final By TPDownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Only Approved Records')]");
	public static final By TPSourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	
	/******Tp Mapping Grid******/
	public static final By TPSearchforElmCode = By.xpath("//input[@data-ref='eInput' and @aria-label='Elm Code Filter Input']");
	public static final By TPSearchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By TPGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By TPEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By TPDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
