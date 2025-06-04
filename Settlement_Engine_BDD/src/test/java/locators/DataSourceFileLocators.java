package locators;

import org.openqa.selenium.By;

public class DataSourceFileLocators {
	
	/******Data Source File Page******/
	public static final By DataSourceFileTab = By.xpath("//span[contains(text(),'Data Source File')]");
	public static final By DSFAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By DSFSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully ']");
	public static final By DSFSuccesspopupMessageOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By DSFUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By DSFDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By DSFDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By DSFDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	//
	
	/******Data Source File Category******/
	public static final By DSFFileName = By.xpath("//input[@formcontrolname='fileName']");
	public static final By DSFFileType = By.xpath("//select[@formcontrolname='fileType']");
	public static final By DSFFilePattern = By.xpath("//input[@formcontrolname='filePattern']");
	public static final By DSFFilePathRow = By.xpath("//input[@formcontrolname='filePathRaw']");
	public static final By DSFFilePathCleansed= By.xpath("//input[@formcontrolname='filePathCleansed']");
	public static final By DSFFileMaxSize = By.xpath("//input[@formcontrolname='fileSizeMB']");
	public static final By DSFTableName= By.xpath("//input[@formcontrolname='stagingTableName']");
	public static final By DSFFileDelimiter = By.xpath("//select[@formcontrolname='fileDelimiter']");
	public static final By DSFHeaderPresentYes = By.xpath("//div[3]/div[1]/label[@for='headerPresentYes']");
	public static final By DSFIsReferenceyes = By.xpath("//input[@id='isRefYes']");
	public static final By DSFColumnIdentifier = By.xpath("//input[@formcontrolname='columnIdentifier']");
	public static final By DSFFilePatternValidation = By.xpath("//*[text()='Please Enter File Pattern']");
	public static final By DSFSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By DSFResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By DSFCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By DSFUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By DSFCategoryTextVisible = By.xpath("//h6[contains(text(),'File Information')]");
	public static final By DSFCategoryTextVisibleError = By.xpath("//span[contains(text(),'Please Enter File Pattern')]");
	public static final By DSFCategoryTextVisibleGrid = By.xpath("//span[contains(text(),'Data Source File Grid')]");
	public static final By DSFTableCoulmnTableName = By.xpath("//div[@col-id='stagingTableName']");
	//
	
	/******Data Source File Grid******/
	public static final By DSFSearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='File Name Filter Input']");
	public static final By DSFGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By DSFEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By DSFDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	//public static final By DSFFilename = By.xpath("//div[@data-ref='rootWrapperBody']//div[1]//div[1]");
	
}
