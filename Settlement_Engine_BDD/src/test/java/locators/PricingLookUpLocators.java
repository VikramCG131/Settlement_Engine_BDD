package locators;

import org.openqa.selenium.By;

public class PricingLookUpLocators {
/******Pricing LookUp Page******/
	
	
	public static final By PLAddNewButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By PLSuccessPopupMessage = By.xpath("//*[text()=' Record has been added successfully..! ']");
	public static final By PLUpdatePopupMessage = By.xpath("//*[contains(text(),'Record has been updated successfully..!')]");
	public static final By PLDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By PLDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By PLDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By PLUploadButton= By.xpath("//button[contains(text(),'Upload')]");
	public static final By PLSelectValidFile= By.xpath("//input[@type='file']");
	public static final By PLSuccesspopupMessageUpload = By.xpath("//*[text()=' Record has been uploaded successfully..! ']");
	public static final By PLSuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By PLSendforApprovalButton= By.xpath("//button[contains(text(),'Send for Approval')]");
	public static final By PLConfirmationPopupSendForApprovalButtonConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By PLConfirmationPopupSendForApprovalButtonCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By PLClickingOnConfirmButtonSendForApproval = By.xpath("//button[contains(text(),'Confirm')]");
	
	/******Pricing LookUp Category******/
	
	public static final By PLActiveFromDate = By.xpath("(//button[@aria-label='Open calendar'])[1]");
	public static final By PLActiveFromDateSelect = By.xpath("//td[not(contains(@class,'disabled'))]//span[text()=' 1 ']");
	public static final By PLCurrency = By.xpath("//input[@placeholder='Enter Currency']");
	public static final By PLClientCode = By.xpath("//input[@placeholder='Enter Client code']");	
	public static final By PLProductCode = By.xpath("//input[@placeholder='Enter Product Code']");
	public static final By PLInstalments = By.xpath("//input[@placeholder='Enter Instalments']");
	public static final By PLOfferMonths = By.xpath("//input[@placeholder='Enter Offer Month']");
	public static final By PLLoanAmountMin = By.xpath("//input[@placeholder='Enter Loan Amount Min']");
	public static final By PLLoanAmountMax = By.xpath("//input[@placeholder='Enter Loan Amount Max']");
	public static final By PLRule = By.xpath("//input[@placeholder='Enter Rule']");
	public static final By PLCommSubPct = By.xpath("//input[@placeholder='Enter Comm Subs Pct']");
	public static final By PLMinMaxSubVal = By.xpath("//input[@placeholder='Enter Min Max Subs Val']");
	public static final By PLCntdwnRatePct = By.xpath("//input[@placeholder='Enter CNTDWN RATE PCT']");
	public static final By PLMinCntdwnRatePct = By.xpath("//input[@placeholder='Enter MIN CNTDWN RATE PCT']");
	public static final By PLCntdwnAdjust = By.xpath("//input[@placeholder='Enter CNTDWN ADJUST']");
	public static final By PLThirdParty1Encoding = By.xpath("//input[@placeholder='Enter Third Party 1 Encoding ']");
	public static final By PLThirdParty1Rate = By.xpath("//input[@placeholder='Enter Third Party 1 Rate']");
	public static final By PLThirdParty2Encoding = By.xpath("//input[@placeholder='Enter Third Party 2 Encoding']");
	public static final By PLThirdParty2Rate = By.xpath("//input[@placeholder='Enter Third Party 2 Rate']");
	public static final By PLThirdParty3Encoding = By.xpath("//input[@placeholder='Enter Third Party 3 Encoding']");
	public static final By PLThirdParty3Rate = By.xpath("//input[@placeholder='Enter Third Party 3 Rate']");
	public static final By PLVolBonusPct = By.xpath("//input[@placeholder='Enter VOL BONUS PCT']");
	public static final By PLHeadOfficeRebate = By.xpath("//input[@placeholder='Enter Head Office Rebate %']");
	public static final By PLSubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By PLErrorValidation = By.xpath("//div[contains(text(),'Client Code is required.')]");
	public static final By PLPageGridValidation = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By PLResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By PLCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By PLUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By PLCategoryTextVisible = By.xpath("//h6[contains(text(),'Common Reference Look Up Category')]");
	public static final By PLCategoryTextPageVisible = By.xpath("//span[contains(text(),'Common Reference Look Up ')]");
	public static final By PLConfirmationPopupSelect = By.xpath("//div[@class='modal-content']");
	public static final By PLDownloadButton= By.xpath("//button[contains(text(),'Download All Records')]");
	public static final By PLDownloadButtonApproveRecord= By.xpath("//button[contains(text(),'Only Approved Records')]");
	public static final By PLSourceTabledropdown= By.xpath("//select[@formcontrolname='sourceTable']");
	/******Pricing LookUp Grid******/
	public static final By PLSearchforClientcode = By.xpath("//input[@data-ref='eInput' and @aria-label='Client Code Filter Input']");
	public static final By PLSearchforstatus= By.xpath("//input[@aria-label='Status Filter Input']");
	public static final By PLGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By PLEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By PLDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");
	
}
