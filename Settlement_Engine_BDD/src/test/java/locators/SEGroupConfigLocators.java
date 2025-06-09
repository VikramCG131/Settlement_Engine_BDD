package locators;

import org.openqa.selenium.By;

public class SEGroupConfigLocators {
	
	/******Settlement Grouping Config Page******/
	public static final By SEGroupConfigTab = By.xpath("//span[contains(text(),'SE Group Config')]");
	public static final By SEAddButton = By.xpath("//button[contains(text(),'Add')]");
	public static final By SESuccessPopupMessage = By.xpath("//div[contains(text(),' Record has been added successfully..!') ]");
	public static final By SESuccesspopupMessageUploadOk = By.xpath("//button[contains(text(),'Ok')]");
	public static final By SEUpdatePopupMessage = By.xpath("//div[contains(text(),' Record has been updated successfully')]");
	public static final By SEDeleteConfirmationPopupMessage = By.xpath("//div[text()=' Are you sure you want to delete ']");
	public static final By SEDeleteConfirmationPopupConfirmButton = By.xpath("//button[contains(text(),'Confirm')]");
	public static final By SEDeleteConfirmationPopupCancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	//
	
	/******Settlement Grouping Config Category******/
	
	public static final By SEGroupName = By.xpath("//input[@placeholder='Enter Group Name']");
	public static final By SEConfigeredRules= By.xpath("//div[@class='rule-item form-control ng-star-inserted']");
	public static final By SELeftArrow= By.xpath("//button[contains(text(),'<')]");
	public static final By SERightArrow= By.xpath("//button[contains(text(),'>')]");
	public static final By SEDoubleLeftArrow= By.xpath("//button[contains(text(),'<<')]");
	public static final By SEDoubleRightArrow= By.xpath("//button[contains(text(),'>>')]");
	public static final By SEUpperArrow= By.xpath("//button[contains(text(),'↑')]");
	public static final By SEDownArrow= By.xpath("//button[contains(text(),'↓')]");
	public static final By SEAppliedRulesClick = By.xpath("//div[contains(text(),'Applied Rules')]");
	public static final By SESubmitButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By SEResetButton = By.xpath("//button[contains(text(),'Reset')]");
	public static final By SECancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	public static final By SEUpdateButton = By.xpath("//button[contains(text(),'Update')]");
	public static final By SECategoryTextVisible = By.xpath("//h6[contains(text(),'Settlement Grouping Config Category')]");
	public static final By SEGroupNameValidation = By.xpath("//small[contains(text(),' Please Enter Group Name ')]");
	public static final By SECategoryTextVisibleGrid = By.xpath("//span[contains(text(),'Settlement Grouping Config Grid')]");
	
	/******Settlement Grouping Config Grid******/

	public static final By SEGridVisible = By.xpath("//div[@data-ref='rootWrapperBody']");
	public static final By SEEditButton = By.xpath("(//i[@data-action='edit'])[1]");
	public static final By SEDeleteButton = By.xpath("(//i[@data-action='delete'])[1]");

}
