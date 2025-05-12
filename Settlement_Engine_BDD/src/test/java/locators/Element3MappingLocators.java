package locators;

import org.openqa.selenium.By;

public class Element3MappingLocators {
/******Element 3 Mapping Page******/
	
	
	public static final By EL3AddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By EL3SuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By EL3UpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By EL3DeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By EL3DeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By EL3DeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EL3UploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By EL3SelectValidFile= By.xpath("//input[@type='file']");
	public static final By EL3SuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By EL3SuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By EL3SendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By EL3ConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By EL3ConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EL3ClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Element 3 Category******/
	
	public static final By EL3ProductCode = By.xpath("//input[@placeholder='Enter Product Code']");
	public static final By EL3Element3Code = By.xpath("//input[@placeholder='Enter Element 3 Code ']");
	public static final By EL3SubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By EL3CodeErrorValidation = By.xpath("//div[contains(text(),'Element 3 Code  is required.')]");
	public static final By EL3ageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By EL3ResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By EL3CancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EL3UpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By EL3CategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category ')]");
	public static final By EL3CategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By EL3ConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By EL3DownloadButton= By.xpath("//button[contains(text(),'Download')]");
	public static final By EL3SourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	public static final By EL3DownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Download All Records')]");
	/******Element 3 Grid******/
	public static final By EL3SearchforProductcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Product Code Filter Input']");
	public static final By EL3Searchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By EL3GridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By EL3EditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By EL3DeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
}