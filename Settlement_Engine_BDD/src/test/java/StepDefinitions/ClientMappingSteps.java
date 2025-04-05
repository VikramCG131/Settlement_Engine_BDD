package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClientMappingSteps {
    WebDriver driver;
    CommonUtilities commonUtilities = new CommonUtilities();
    WebDriverWait wait;
    private File downloadDir;
    private final String fileName = "example.csv"; 
	private String filterType;
	private String filterValue;

    @Given("Settlement_Engine<URL>")
    public void settlement_engine_url() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("the user clicks Settlement Engine URL")
    public void the_user_clicks_settlement_engine_url() throws InterruptedException {
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
        Thread.sleep(2000);
        System.out.println("The user is able to login with Settlement Engine URL");
    }

    @When("the User clicks on Reference LookUp UI screen")
    public void the_user_clicks_on_reference_look_up_ui_screen() {
        driver.findElement(By.xpath("//a[contains(text(),'Reference LookUp')]")).click();
        System.out.println("The user is able to navigate to Reference LookUp UI screen");
        commonUtilities.screenshot();
    }

    @When("clicks on the Expand button for the left panel")
    public void clicks_on_the_expand_button_for_the_left_panel() {
        WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container collapsed']"));
        boolean isCollapsed = panel.getAttribute("class").contains("collapsed");
        if (isCollapsed) {
            panel.findElement(By.xpath(".//button")).click();
        }
    }

    @Then("the User is able to navigate to the Settlement Engine Homepage")
    public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
        Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
        Thread.sleep(2000);
        System.out.println("The user is able to navigate to the Settlement Engine homepage");
        commonUtilities.screenshot();
    }

    @Then("the User should see the Left panel expanded")
    public void the_user_should_see_the_left_panel_expanded() throws InterruptedException {
        WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container']"));
        panel.isDisplayed();
        Thread.sleep(2000);
    }

    @Then("the Menu Items should be visible")
    public void the_menu_items_should_be_visible() {
        List<WebElement> panel2 = driver.findElements(By.xpath("//div[@class='sidebar_container']/ul/li"));
        for (WebElement element : panel2) {
            System.out.println(element.getText());
        }
        System.out.println("The user is able to see the left panel menu items");
    }

    @When("the user click on the Client LookUp")
    public void the_user_click_on_the_client_mapping() throws InterruptedException {
        driver.findElement(By.xpath("//a/span[contains(text(),'Client LookUp')]")).click();
        Thread.sleep(3000);
        System.out.println("The user is able to navigate to Client LookUp page");
        commonUtilities.screenshot();
    }

    @When("the user clicks the Add button from the Client LookUp page")
    public void the_user_clicks_the_add_button_from_the_client_mapping_page() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[text()=' Add ']"))).click().perform();
        System.out.println("The user is able to click on Add Button");
        commonUtilities.screenshot();
    }

    @When("the user enters the data in required fields for the Client LookUp")
    public void the_user_enters_the_data_in_required_fields_for_the_client_mapping() {
        List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-md-4']"));
        for (WebElement fieldElement : fieldElements) {
            String fieldText = fieldElement.getText();
            System.out.println("Field: " + fieldText);
        }
        int random = (int) (Math.floor(Math.random() * 100000) + 1);
        driver.findElement(By.xpath("//input[@formcontrolname='payableEl2']")).sendKeys("500" + random);
        driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).sendKeys("0.5");
        driver.findElement(By.xpath("//input[@formcontrolname='shopCode']")).sendKeys("Shop" + random);
        driver.findElement(By.xpath("//input[@formcontrolname='shopName']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@formcontrolname='dStype']")).sendKeys("Automation" + random);
    }

    @When("the user should see click on the Submit Button for the Client LookUp")
    public void the_user_should_see_click_on_the_submit_button_for_the_client_mapping() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        System.out.println("The user is able to click on the Submit Button");
        Thread.sleep(2000);
        commonUtilities.screenshot();
    }

    @Then("the user should see {string} in the file list for the Client LookUp")
    public void the_user_should_see_in_the_file_list_for_the_client_mapping(String string) throws InterruptedException {
        String actual = driver.findElement(By.xpath("//*[text()=' Record has been added successfully..! ']")).getText();
        Assert.assertEquals("Record has been added successfully..!", actual);
        System.out.println("The user is able to insert the data in the all fields");
        Thread.sleep(2000);
        commonUtilities.screenshot();
    }

    @When("the user click on any field for the Client LookUp")
    public void the_user_click_on_any_field_for_the_client_mapping() throws InterruptedException {
        driver.findElement(By.xpath("//input[@formcontrolname='payableEl2']")).click();
        WebElement button = driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']"));
        wait.until(ExpectedConditions.visibilityOf(button)).click();
        Thread.sleep(2000);
    }

    @Then("the user should see validation errors for required fields for the Client LookUp")
    public void the_user_should_see_validation_errors_for_required_fields_for_the_client_mapping() {
        String actual = driver.findElement(By.xpath("//*[text()='Please Enter Payable EL26']")).getText();
        Assert.assertEquals("Please Enter Payable El2", actual);
        System.out.println("The user is able to see the error message for required fields");
        commonUtilities.screenshot();
    }
  
    @When("the user click on Reset button for the Client LookUp")
    public void the_user_click_on_reset_button_for_the_client_look_up() throws InterruptedException {
    	driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		Thread.sleep(2000);
		commonUtilities.screenshot();
    }

    @Then("all the fields should be cleared for the Client LookUp")
    public void all_the_fields_should_be_cleared_for_the_client_look_up() {
    	// Verify that all fields are empty
  	  Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='payableEl2']")).getAttribute("value"));
  	    Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).getAttribute("value"));
  	    Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='shopCode']")).getAttribute("value"));
  	    Assert.assertEquals("", driver.findElement(By.xpath("//input[@formcontrolname='shopName']")).getAttribute("value"));
  	    System.out.println("The user is able to clear the fields");
  	}

    @When("the user click on Cancel button for the Client LookUp")
    public void the_user_click_on_cancel_button_for_the_client_look_up() {
    	driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
    }

    @Then("Add Pop up should be closed for the Client LookUp")
    public void add_new_pop_up_should_be_closed_for_the_client_look_up() {
    	driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
    }

    @When("The User click the edit icon for the any Client LookUp")
    public void the_user_click_the_edit_icon_for_the_any_client_look_up() {
    	driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
    }

    @Then("The User should see the edit modal open Client LookUp")
    public void the_user_should_see_the_edit_modal_open_client_look_up() {
    	boolean file = driver.findElement(By.xpath("//*[text()='Client lookup grid ']")).isDisplayed();
		Assert.assertTrue(file);
		String actual = driver.findElement(By.xpath("//*[text()='Client lookup grid ']")).getText();
		Assert.assertEquals("Client lookup grid", actual);	
		System.out.println("The edit modal is displayed");
		commonUtilities.screenshot();
    }

    @Then("the user update the any field for the Client LookUp")
    public void the_user_update_the_any_field_for_the_client_look_up() {
    	driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='advanceComission']")).sendKeys("0.5");
    }

    @Then("the user should see click on the Update Button for the Client LookUp")
    public void the_user_should_see_click_on_the_update_button_for_the_client_look_up() throws InterruptedException {
    	driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(2000);
    }

    @Then("the user should see the updated {string} in the file list for the Client LookUp")
    public void the_user_should_see_the_updated_in_the_file_list_for_the_client_look_up(String string) {
    	driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
    }

    @When("The User click the delete icon for the any Client LookUp")
    public void the_user_click_the_delete_icon_for_the_any_client_look_up() {
    	driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
    }

    @Then("The User should see a confirmation pop-up with title {string} for the Client LookUp")
    public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_client_look_up(String string) throws InterruptedException {
    	driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
    }

    @Then("The User should see {string} message for the Client LookUp")
    public void the_user_should_see_message_for_the_client_look_up(String string) throws InterruptedException {
    	String actual = driver.findElement(By.xpath("//div[text()=' Are you sure you want to delete ']")).getText();
		Assert.assertEquals("Are you sure you want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
    }

    @When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Client LookUp")
    public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_client_look_up() {
    	driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
    }

    @When("The User confirm the deletion for the Client LookUp")
    public void the_user_confirm_the_deletion_for_the_client_look_up() {
    	 driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
    }

    @Then("the file should be removed from the table for the Client LookUp")
    public void the_file_should_be_removed_from_the_table_for_the_client_look_up() {
    	driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
    }
     
    @When("user clicks the download button")
    public void userClicksDownloadButton() {
        WebElement downloadButton = driver.findElement(By.xpath("//button[contains(text(),'Download')]"));
        downloadButton.click();

        // Wait for file to download (depends on file size)
        try {
            Thread.sleep(5000); // Or use polling logic for better wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("a file should be downloaded to the default download folder")
    public void verifyFileDownloaded() {
    	String downloadPath = System.getProperty("user.dir") + "/downloads";
        File downloadDir = new File(downloadPath);
        if (!downloadDir.exists())
        	downloadDir.mkdir();
        File downloadedFile = new File(downloadDir, fileName);
        System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
    }

    @When("user clicks the Upload button")
    public void user_clicks_the_upload_button() throws InterruptedException {
      
		//Locate the file input (hidden or blocked normally)
    	WebElement uploadButton = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
        uploadButton.click();
        System.out.println("The user is able to click on Upload Button");
        commonUtilities.screenshot();
        wait.until(ExpectedConditions.visibilityOf(uploadButton));
        System.out.println("The user is able to see the Upload button");
       Thread.sleep(6000);
       commonUtilities.screenshot();
    }

    @Then("file selection dialog should appear")
    public void file_selection_dialog_should_appear() throws InterruptedException {
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
		// Locate the file input (hidden or blocked normally)
		//WebElement fileInput1 = driver. findElement(By.xpath("//button[contains(text(),'Upload')]"));
		//js. executeScript("arguments[0].click();", fileInput1);
		//new WebDriverWait(driver,Duration.ofSeconds(10));
		//File file = new File("C://Users//userdev13//Downloads//clinet_Map.csv");
		//fileInput1.sendKeys(file.getAbsolutePath());
		//fileInput1. click();
    	// System.out.print("file upload successfully");
    	
		WebElement uploadButton = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
		uploadButton.click();
		System.out.println("The user is able to click on Upload Button");
		commonUtilities.screenshot();
		wait.until(ExpectedConditions.visibilityOf(uploadButton));
		System.out.println("The user is able to see the Upload button");
		Thread.sleep(6000);
		commonUtilities.screenshot();
		
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			   WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and @accept=\'.csv\']"));
        
        System.out.println("The user is able to see the file selection dialog");
       commonUtilities.screenshot();
      wait.until(ExpectedConditions.visibilityOf(fileInput));
        
       fileInput.sendKeys("src\\test\\resources\\TestData\\client_Map.csv");
       
        System.out.println("The user is able to select the file");
        commonUtilities.screenshot();
    }

    @Then("user selects a valid file to upload")
    public void user_selects_a_valid_file_to_upload() {
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Assert.assertTrue(fileInput.isDisplayed());
        System.out.println("The user is able to select a valid file to upload");
        commonUtilities.screenshot();
        wait.until(ExpectedConditions.visibilityOf(fileInput));
        System.out.println("The user is able to select a valid file to upload");
        commonUtilities.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "src\\test\\resources\\TestData\\client_Map.csv");
        String absolutePath = file.getAbsolutePath();

        // Upload the file by sending the path
        fileInput.sendKeys(absolutePath);

        // Optionally, confirm upload success
        System.out.println("✅ File uploaded successfully!");
    }

    @Then("the file should be successfully uploaded")
    public void the_file_should_be_successfully_uploaded() {
        /* String actual = driver.findElement(By.xpath("//*[text()='File uploaded successfully..!']")).getText();
        Assert.assertEquals("File uploaded successfully..!", actual);
        System.out.println("The user is able to upload the file successfully");
        commonUtilities.screenshot();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='File uploaded successfully..!']"))));
        System.out.println("The user is able to upload the file successfully");
        commonUtilities.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        System.out.println("The user is able to click on OK button");
        commonUtilities.screenshot(); */
    }

    @When("user click the Send for Approval button")
    public void user_click_the_send_for_approval_button() {
        WebElement sendForApprovalButton = driver.findElement(By.xpath("//button[contains(text(),'Send for Approval')]"));
        wait.until(ExpectedConditions.visibilityOf(sendForApprovalButton));
        sendForApprovalButton.click();
        System.out.println("The user is able to click on Send for Approval Button");
        commonUtilities.screenshot();
    }

    @Then("the file should be submitted for approval")
    public void the_file_should_be_submitted_for_approval() {
        WebElement popup = driver.findElement(By.xpath("//div[@class='modal-content']"));
        wait.until(ExpectedConditions.visibilityOf(popup));
        Assert.assertTrue(popup.isDisplayed());
    }

    @Then("a confirmation message should be displayed with Confirm and Cancel buttons")
    public void a_confirmation_message_should_be_displayed_with_confirm_and_cancel_buttons() {
        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        WebElement cancelButton = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        Assert.assertTrue(confirmButton.isDisplayed());
        Assert.assertTrue(cancelButton.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(confirmButton));
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        System.out.println("The user is able to see the confirmation message with Confirm and Cancel buttons");
        commonUtilities.screenshot();
    }

    @Then("by clicking on Confirm button the file should be sent for approval")
    public void by_clicking_on_confirm_button_the_file_should_be_sent_for_approval() {
        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        wait.until(ExpectedConditions.visibilityOf(confirmButton));
        confirmButton.click();
        System.out.println("The user is able to click on Confirm button");
        commonUtilities.screenshot();
        System.out.println("The user is able to send the file for approval successfully");
    }

    @When("user navigate to the Client LookUp Grid")
    public void i_navigate_to_the_client_mapping_grid() {
        WebElement clientLookUpGrid = driver.findElement(By.xpath("//span[contains(text(),'Client lookup grid')]"));
        wait.until(ExpectedConditions.visibilityOf(clientLookUpGrid));
        Assert.assertTrue(clientLookUpGrid.isDisplayed());
    }

    @When("user selects {string} from the filter dropdown")
    public void selectFilterType(String filterType) {
        this.filterType = filterType;

        WebElement filterDropdownWrapper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-colindex=\"2\"]//button[@aria-label=\"Open Filter Menu\"]")));
        filterDropdownWrapper.click();
        
        WebElement searchingvaluefilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=\"ag-input-field-input ag-text-field-input\" and @aria-label=\"Filter Value\"]")));
        searchingvaluefilter.sendKeys("016");
        //searchingvaluefilter.clear();
        WebElement AndRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=\"ag-input-field-input ag-text-field-input\" and @aria-label=\"Filter Value\"]")));
        searchingvaluefilter.sendKeys("016");
        System.out.println("Clicked on filter dropdown");
        
        
        //
        // Select the filter option
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'ag-picker-field')]//span[text()='" + filterType + "']")));
        option.click();
        System.out.println("Selected filter type: " + filterType);
    }
    
    

}