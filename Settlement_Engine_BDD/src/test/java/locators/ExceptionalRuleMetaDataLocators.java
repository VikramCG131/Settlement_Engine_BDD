package locators;

import org.openqa.selenium.By;

public class ExceptionalRuleMetaDataLocators {
	/******Exception Update ******/
	public static final By EXRAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By EXRDataColumnTab = By.xpath("//span[text()='Exception Rules Metadata']");
	
	/******Lookup Explorer ******/
	
	public static final By EXRInputSourceDropdown = By.xpath("//select[@formcontrolname='lookupSource1']");
	public static final By EXRInputSourceTextClick = By.xpath("//label[contains(text(),'Input Source ')]");
	public static final By EXRInputSourceAttributeDropdownClick = By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[1]/div[2]/ng-multiselect-dropdown/div");
	public static final By EXRInputSourceAttributeDropdownSelect = By.xpath("//div[@class='dropdown-list']//ul[@class='item2']/li");
	public static final By EXRAddLookUpButton = By.xpath("//button[@class='btn btn_color text-white']");
	public static final By EXRReferencefiledropdown = By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[1]/select");
	public static final By EXRReferencefileAttributedropdownClick = By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span");
	public static final By EXRReferencefileAttributedropdownSelect = By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]");
	public static final By EXRSubmitButton = By.xpath("(//button[@type='submit'])[1]");
	public static final By EXRResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By EXRCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EXRUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By EXRLookupExplorerpageValidation = By.xpath("//span[text()='Lookup explorer ']");
	
	
	/******Exception Category******/
	public static final By EXRRuleTypeDropDown = By.xpath("//select[@formcontrolname='ruleType']");
	public static final By EXRSeverityDropDown  = By.xpath("//select[@formcontrolname='severity']");
	public static final By EXRExceptionOwners = By.xpath("//input[@placeholder='Enter Exception Owners']");
	public static final By EXRSuccessPopupMessage = By.xpath("//div[contains(text(),' Record has been added successfully')]");
	public static final By EXRDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By EXRDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By EXRDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By EXRValidationErrorRuleType = By.xpath("//div[text()=' Please Select Rule Type ']");
	public static final By EXRUpdatePopUuMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By EXRAfterDeletingPopup= By.xpath("//button[contains(text(),'Ok')]");
	public static final By EXRClickExceptionCotegeryPage= By.xpath("//h6[text()='Exception Category ']");
	public static final By EXRCotegeryVisible = By.xpath("//span[@class='grid_title_name d-inline-block']");
	/******Exceptional Rules******/
	//
	public static final By EXRSearchforRuleOwner = By.xpath("//input[@data-ref='eInput' and @aria-label='Rule Owner Filter Input']");
	public static final By EXREditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By EXRDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	public static final By EXRDownloadButton= By.xpath("//button[contains(text(),'Download')]");
	//public static final By MDCFilename = By.xpath("//div[@data-ref='rootWrapperBody']//div[1]//div[1]");
	
}
