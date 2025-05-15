package locators;

import org.openqa.selenium.By;

public class DataQualityAssignmentLocators {
	
	/******Data Quality Assignment Page******/
	public static final By DataQualityAssignmentTab = By.xpath("//span[contains(text(),'Data Quality Assignment')]");
	public static final By DQAAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By DQASuccessPopupMessage = By.xpath("//div[contains(text(),' Record has been added successfully..! ')]");
	public static final By DQAUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By DQADeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By DQADeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By DQADeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	/******Data Quality Assignment Category******/
	public static final By DQASourceTableDropdown = By.xpath("//select[@formcontrolname='source1']");
	public static final By DQASourceAttributeDropdown = By.xpath("//select[@formcontrolname='source1Attribute']");
	public static final By DQADQRuleDropdown = By.xpath("//select[@formcontrolname='ruleId']");
	public static final By DQADQStartDate = By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public static final By DQADQStartDateSelect= By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 1 ']");
	public static final By DQADQEndDate = By.xpath("(//button[@aria-label='Open calendar'])[2]");
	public static final By DQADQEndDateSelect= By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 15 ']");
	public static final By DQASubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By DQAclickonDQRuleforValidation = By.xpath("//label[contains(text(),'DQ Rule')]");
	public static final By DQASourceTableValidation = By.xpath("//div[contains(text(),' Please select DQ Rule ')]");
	public static final By DQADQRuleValidation = By.xpath("//*[text()=' Please select DQ Rule ']");
	public static final By DQAResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By DQACancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DQAUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By DQACategoryTextVisible = By.xpath("//span[contains(text(),'Data Quality Assignment Grid ')]");
	public static final By DQAErrorDQRuleselection = By.xpath("//option[contains(text(),'Select DQ Rule')]");
	//
	/******Data Quality Assignment Grid******/
	public static final By DQAAssignmentGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By DQAEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By DQADeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	//public static final By DQAFilename = By.xpath("//div[@data-ref='rootWrapperBody']//div[1]//div[1]");
	
}
