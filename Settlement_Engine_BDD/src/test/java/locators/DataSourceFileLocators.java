package locators;

import org.openqa.selenium.By;

public class DataSourceFileLocators {
	
	/******Data Source File Page******/
	public static final By DataSourceFileTab = By.xpath("//span[contains(text(),'Data Source File')]");
	public static final By DSFAddNewButton = By.xpath("//*[text()='Add New']");
	public static final By DSFSuccessPopupMessage = By.xpath("//*[contains(text(),'Record has been added successfully..!')]");
	public static final By DSFDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By DSFDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By DSFDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	/******Data Source File Category******/
	public static final By DSFFileName = By.xpath("//select[@formcontrolname='source1']");
	public static final By DSFFileType = By.xpath("//select[@formcontrolname='source1Attribute']");
	public static final By DSFFilePattern = By.xpath("//select[@formcontrolname='ruleId']");
	public static final By DSFFilePathRow = By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public static final By DSFFilePathCleansed= By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 1 ']");
	public static final By DSFFileMaxSize = By.xpath("(//button[@aria-label='Open calendar'])[2]");
	public static final By DSFTableName= By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 15 ']");
	public static final By DSFFileDelimiter = By.xpath("//button[contains(text(),'Submit')]");
	public static final By DSFHeaderPresentYes = By.xpath("//div[3]/div[1]/label[@for='headerPresentYes']");
	public static final By DSFColumnIdentifier = By.xpath("//input[@formcontrolname='columnIdentifier']");
	public static final By DSFFilePatternValidation = By.xpath("//*[text()='Please Enter File Pattern']");
	public static final By DSFSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By DSFResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By DSFCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DSFUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By DSFCategoryTextVisible = By.xpath("//*[text()='File Information']-");
	
	/******Data Source File Grid******/
	public static final By DSFGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By DSFEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By DSFDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	//public static final By DSFFilename = By.xpath("//div[@data-ref='rootWrapperBody']//div[1]//div[1]");
	
}
