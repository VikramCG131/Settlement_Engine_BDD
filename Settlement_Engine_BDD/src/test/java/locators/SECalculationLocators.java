package locators;

import org.openqa.selenium.By;

public class SECalculationLocators {
	
	/******Settlement Rules Config Metadata - Page******/
	public static final By SECCalculationTab = By.xpath("//span[contains(text(),'SE Calculation')]");	
	public static final By SECUpdatePopupMessage = By.xpath("//div[contains(text(),'Record has been updated successfully')]");
	public static final By SECDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By SECDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By SECDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	//
	
	/******Settlement Rules Config Metadata Explorer******/
	
	public static final By SECRuleName = By.xpath("//input[@id='ruleName']");
	public static final By SECValriableName= By.xpath("//input[@id='varName']");
	public static final By SECFormula= By.xpath("//input[@placeholder='Enter Formula']");
	public static final By SECSuccessPopupMessage = By.xpath("//div[contains(text(),'Rule has been added successfully') ]");
	public static final By SECSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By SECFormulaValidationMessage= By.xpath("//div[contains(text(),' Formula is Valid ')]");
	public static final By SECValidate= By.xpath("//button[contains(text(),' VALIDATE ')]");
	public static final By SECSubmitButton = By.xpath("//button[contains(text(),'Save')]");
	public static final By SECResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By SEUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By SECCategoryTextVisible = By.xpath("//h6[contains(text(),'Settlement Rules Config Metadata Category ')]");
	public static final By SECFormulaValidation = By.xpath("//div[contains(text(),' Please Enter Valid Formula')]");
	public static final By SECategoryTextVisibleRules = By.xpath("//span[contains(text(),'Configured Settlement Rules ')]");
	public static final By SECStarOperator = By.xpath("//button[contains(text(),'*')]");
	public static final By SECOpenBracesOperator = By.xpath("//button[contains(text(),'(')]");
	public static final By SECCloseBracesOperator = By.xpath("//button[contains(text(),')')]");
	public static final By SECWhereOperator = By.xpath("//button[contains(text(),'Where')]");
	public static final By SECifthenelseOperator = By.xpath("//button[contains(text(),'if then else')]");
	public static final By SECANDOperator = By.xpath("//button[contains(text(),'AND')]");
	public static final By SECOROperator = By.xpath("//button[contains(text(),'OR')]");
	public static final By SECNOTOperator = By.xpath("//button[contains(text(),'OR')]");
	public static final By SECEqualsOperator = By.xpath("//button[contains(text(),'=')]");
	public static final By SECNotEqualsOperator = By.xpath("//button[contains(text(),'!=')]");
	public static final By SECLessOperator = By.xpath("//button[contains(text(),'<')]");
	public static final By SECMinusOperator = By.xpath("//button[contains(text(),'-')]");
	public static final By SECForwardslaceOperator = By.xpath("//button[contains(text(),'/')]");
	public static final By SECPLUSOperator = By.xpath("//button[contains(text(),'+')]");
	public static final By SECINOperator = By.xpath("//button[contains(text(),'IN')]");
	public static final By SECGreaterThanOperator = By.xpath("//button[contains(text(),'>')]");
	/******Configured Settlement Rules******/

	public static final By SECGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By SECditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By SECDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");

}
