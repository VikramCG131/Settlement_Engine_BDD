package locators;

import org.openqa.selenium.By;

public class MetaDataColumnsLocators {
	
	/******MetaData Column Page******/
	public static final By MetaDataColumnTab = By.xpath("//span[contains(text(),'MetaData Column')]");
	public static final By MDCAddNewButton = By.xpath("//*[text()='Add New']");
	public static final By MDCSuccessPopupMessage = By.xpath("//*[contains(text(),'Record has been added successfully..!')]");
	public static final By MDCDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By MDCDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By MDCDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	/******MetaData Column Category******/
	public static final By MDCColumnName = By.xpath("//input[@formcontrolname='columnName']");
	public static final By MDCColumnType = By.id("columnDataType");
	public static final By MDCColumnActive = By.xpath("//div[3]/div[1]/label[@for='columnIsActiveYes']");
	public static final By MDCColumnIsNull = By.xpath("//div[4]/div[2]/label[@for='columnIsNullNo']");
	public static final By MDCMinSize= By.xpath("//input[@formcontrolname='minSize']");
	public static final By MDCMaxSize = By.xpath("(//input[@formcontrolname='maxSize']");
	public static final By MDCColumnOrder= By.xpath("//input[@formcontrolname='columnOrder']");
	public static final By MDCColumnDateFormat = By.xpath("//input[@formcontrolname='columnDateFormat']");
	
	
	
	public static final By MDCFilePatternValidation = By.xpath("//*[text()='Please Enter File Pattern']");
	public static final By MDCSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By MDCResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By MDCCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By MDCUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By MDCCategoryTextVisible = By.xpath("//*[text()='File Information']-");
	
	/******MetaData Column Grid******/
	public static final By MDCGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By MDCEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By MDCDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	//public static final By MDCFilename = By.xpath("//div[@data-ref='rootWrapperBody']//div[1]//div[1]");
	
}
