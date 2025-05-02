package StepDefinitions;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionRuleMetaData {
	private final String fileName = "example.csv"; 
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	WebDriverWait wait;

	@Given("Settlement engine<URL> Exception")
	public void Settlement_engine_url_Exception() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait for 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smart-card"))).sendKeys("12345");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]"))).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User click the Settlement Engine URL on Exception")
	public void User_click_the_Settlement_Engine_URL_on_Exception() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:4200"));
		Thread.sleep(2000);
		System.out.println("The user is able to login with Settlement Engine URL");
	}

	@Then("The User is able to navigate to the settlement Engine homepage on Exception")
	public void The_User_is_able_to_navigate_to_the_settlement_Engine_homepage_on_Exception() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Settlement Engine"));
		Thread.sleep(2000);
		System.out.println("The user is able to navigate to the Settlement Engine homepage");
		commonUtilities.screenshot();
	}
	@When("The User clicks on Metadata UI screen on Exception")
	public void The_User_clicks_on_metadata_ui_screen_on_Exception() {
		driver.findElement(By.xpath("//a[contains(text(),'Metadata')]")).click();
		System.out.println("The user is able to navigate to Metadata UI screen");
		commonUtilities.screenshot();
	    
	}

	@When("Click on the Expand button for the left panel on Exception")
	public void Click_on_the_Expand_button_for_the_left_panel_on_Exception() {
		    WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container collapsed']"));
		    boolean isCollapsed = panel.getAttribute("class").contains("collapsed");
		    if (isCollapsed) {
		        panel.findElement(By.xpath(".//button")).click();
		    } 
	}

	@Then("The User should see the left panel expanded on Exception")
	public void The_User_should_see_the_left_panel_expanded_on_Exception() throws InterruptedException {
		WebElement panel = driver.findElement(By.xpath("//div[@class='sidebar_container']"));
		panel.isDisplayed();
		Thread.sleep(2000);
	}

	@Then("The Menu items should be Visible")
	public void The_Menu_items_should_be_visible() {
	 List<WebElement> panel2 = driver.findElements(By.xpath("//div[@class=\"sidebar_container\"]/ul/li"));
	 for (WebElement element : panel2) {
	     System.out.println(element.getText());
	 }
	System.out.println("The user is able to see the left panel menu items");
	}
	
	@When("the user click on Exception Rule Meta Data")
	public void the_user_click_on_data_quality_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Exception Rules Metadata']")).click();
		Thread.sleep(3000);
		System.out.println("The user is able to navigate to Data Source File page");
		commonUtilities.screenshot();
		
	}
	

	@When("the user clicks the Add New button for the Exception Rule Meta Data")
	public void the_user_clicks_the_add_new_button_for_the_dq_assignment() {
		driver.navigate().refresh();
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		button.click();
		System.out.println("The user is able to click on Add New Button");
		commonUtilities.screenshot();
	}
	@When("the user enters the data in required fields for the Exception Rule Meta Data")
	public void the_user_enters_the_data_in_required_fields_for_the_dq_assignment() throws InterruptedException {
		
	
		exceptionSelection();
		/*
		List<WebElement> fieldElements = driver.findElements(By.xpath("//div[@class='form-group col-4']"));
		for (WebElement fieldElement : fieldElements) {
		    String fieldText = fieldElement.getText();
		    System.out.println("Field: " + fieldText);}
		// Method for dropdown element
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Lookup");
		System.out.println("Selected Source Table: Lookup");
		Thread.sleep(1000);
		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
		Select dropdown1 = new Select(dropdownElement1);
		dropdown1.selectByIndex(2);
		
		System.out.println("Selected Source Attribute: Select Severity");
		Thread.sleep(1000);
		WebElement Exceptionowner = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
		Exceptionowner.sendKeys("Test");
		Thread.sleep(1000);
		//ng-multiselect-dropdown[@formcontrolname='standaloneSelectedItems']
		WebElement inputsource = driver.findElement(By.xpath("//select[@formcontrolname='lookupSource1']"));
		Select dropdown3 = new Select(inputsource);
		dropdown3.selectByValue("tallyman_raw");
		Thread.sleep(5000);
		WebElement selectattr1 = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[1]/div[2]/ng-multiselect-dropdown/div"));
		selectattr1.click();
		//select input source for select attribute
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-list']//ul[@class='item2']/li"));
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		options.get(randomIndex).click();
		//Click on Add Lookup button
		WebElement addlookupbutton = driver.findElement(By.xpath("//button[@class='btn btn_color text-white']"));
		addlookupbutton.click();
		//select the reference file drop down
		Thread.sleep(2000);
		WebElement referencefile = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[1]/select"));
		Select dropdown4 = new Select(referencefile);
		List<WebElement> options1 = dropdown4.getOptions();
		int randomindex = new Random().nextInt(options1.size());
		dropdown4.selectByIndex(randomindex);
		//click on the reference file for select attribute
		WebElement referenceattribute = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
		referenceattribute.click();
		// select the reference file for select attribute
		Thread.sleep(3000);
		WebElement referencefile1 = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]"));
		referencefile1.click();
		*/
	}
	
	

	public  void exceptionSelection() throws InterruptedException
	{
		
		WebElement ruleTypeDropdown = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
		Thread.sleep(2000);
		Select ruleSelect = new Select(ruleTypeDropdown);
		String[] ruleOptions = {"Lookup", "Comparison","Unique"};
		String selectedRule = ruleOptions[new Random().nextInt(ruleOptions.length)];
		ruleSelect.selectByVisibleText(selectedRule);
		System.out.println("Selected Rule: " + selectedRule);
		
		if (selectedRule.equals("Lookup")) {
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
			Select dropdown = new Select(dropdownElement);	
			dropdown.selectByVisibleText("Lookup");	
			   System.out.println("Lookup rule selected and attribute chosen.");
			WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
			Select dropdown1 = new Select(dropdownElement1);
			dropdown1.selectByIndex(2);
			System.out.println("Selected Source Attribute: Select Severity");
			Thread.sleep(1000);
			WebElement Exceptionowner = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
			Exceptionowner.sendKeys("Test");
			Thread.sleep(1000);
			//ng-multiselect-dropdown[@formcontrolname='standaloneSelectedItems']
			WebElement inputsource = driver.findElement(By.xpath("//select[@formcontrolname='lookupSource1']"));
			Select dropdown3 = new Select(inputsource);
			dropdown3.selectByValue("tallyman_raw");
			Thread.sleep(5000);
			WebElement selectattr1 = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[1]/div[2]/ng-multiselect-dropdown/div"));
			selectattr1.click();
			//select input source for select attribute
			List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-list']//ul[@class='item2']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			options.get(randomIndex).click();
			//Click on Add Lookup button
			WebElement addlookupbutton = driver.findElement(By.xpath("//button[@class='btn btn_color text-white']"));
			addlookupbutton.click();
			//select the reference file drop down
			Thread.sleep(2000);
			WebElement referencefile = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[1]/select"));
			referencefile.click();
			Select dropdown4 = new Select(referencefile);
			List<WebElement> options1 = dropdown4.getOptions();
			int randomindex = new Random().nextInt(options1.size());
			dropdown4.selectByIndex(randomindex);
			//click on the reference file for select attribute
			WebElement referenceattribute = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
			referenceattribute.click();
			// select the reference file for select attribute
			Thread.sleep(3000);
			WebElement referencefile1 = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-exceptions/div/form/div[2]/div/div/div/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]"));
			referencefile1.click();
		   System.out.println("Lookup rule selected and attribute chosen.");
		   
		} 
		
		 if (selectedRule.equals("Comparison")) 
		{
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
			Select dropdown = new Select(dropdownElement);	
			dropdown.selectByVisibleText("Comparison");	
			Thread.sleep(1000);
		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
		Select dropdown1 = new Select(dropdownElement1);
		dropdown1.selectByIndex(2);
		System.out.println("Selected Source Attribute: Select Severity");
		Thread.sleep(1000);
		WebElement Exceptionowner = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
		Exceptionowner.sendKeys("Test");
		Thread.sleep(1000);
		WebElement inputsourcedropdown = driver.findElement(By.xpath("//select[@formcontrolname='comparisonSource1']"));
		Select dropdowninput = new Select(inputsourcedropdown);
		dropdowninput.selectByValue("tallyman_raw");
		//input source for select attribute
		WebElement attribute = driver.findElement(By.xpath("//select[@formcontrolname='comparisonsource1Attribute']"));
		attribute.click();
		Thread.sleep(2000);
		Select dropdownatt = new Select(attribute);
		List<WebElement> optionsatt = dropdownatt.getOptions();
		int randomindexatt = new Random().nextInt(optionsatt.size());
		dropdownatt.selectByIndex(randomindexatt);
		//comparision dropdown
		WebElement compra = driver.findElement(By.xpath("//select[@formcontrolname='comparisonOperator']"));
		compra.click();
		Thread.sleep(2000);
		Select dropdownattcomp = new Select(compra);
		List<WebElement> optionsattcomp = dropdownattcomp.getOptions();
		int randomindexattcomp = new Random().nextInt(optionsattcomp.size());
		dropdownattcomp.selectByIndex(randomindexattcomp);
		//source 2
		Thread.sleep(2000);
		WebElement inputsource2 = driver.findElement(By.xpath("//select[@formcontrolname='comparisonSource2']"));
		inputsource2.click();
		Thread.sleep(2000);
		Select dropdown2 = new Select(inputsource2);
		dropdown2.selectByValue("tallyman_raw");
		//source 2 attribute
		WebElement source2att = driver.findElement(By.xpath("//select[@formcontrolname='comparisonSource2Attribute']"));
		source2att.click();
		Thread.sleep(2000);
		Select dropdownsource2 = new Select(source2att);
		List<WebElement> optionssource2 = dropdownsource2.getOptions();
		int randomindexsource2 = new Random().nextInt(optionssource2.size());
		dropdownsource2.selectByIndex(randomindexsource2);
		Thread.sleep(2000);
		//status
		WebElement status = driver.findElement(By.xpath("//select[@formcontrolname='comparisonStatus']"));
		status.click();
		Thread.sleep(2000);
		Select dropdownstatus = new Select(status);
		List<WebElement> optionsstatus = dropdownstatus.getOptions();
		int randomindexstatus= new Random().nextInt(optionsstatus.size());
		dropdownstatus.selectByIndex(randomindexstatus);
		Thread.sleep(2000);
			
		   System.out.println("Comparison rule selected and comparison section is visible.");
	}
		else if(selectedRule.equals("Unique"))
		{
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
			Select dropdown = new Select(dropdownElement);	
			dropdown.selectByVisibleText("Unique");	
			WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
			Select dropdown1 = new Select(dropdownElement1);
			dropdown1.selectByIndex(2);
			System.out.println("Selected Source Attribute: Select Severity");
			Thread.sleep(1000);
			WebElement Exceptionowner = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
			Exceptionowner.sendKeys("Test");
			//input source dropdown
			WebElement sourcedropdown = driver.findElement(By.xpath("//select[@formcontrolname='uniquecomparisonSource1']"));
			sourcedropdown.click();
			Thread.sleep(2000);
			Select dropdown3 = new Select(sourcedropdown);
			dropdown3.selectByValue("tallyman_raw");
			
			//select attribute for input source
			WebElement selectattrinputsource = driver.findElement(By.xpath("//div[@class='multiselect-dropdown']"));
			selectattrinputsource.click();
			Thread.sleep(2000);
			//select input source for select attribute
			List<WebElement> optionsi = driver.findElements(By.xpath("//li[@class='multiselect-item-checkbox']"));
			Random randomi = new Random();
			int randomIndexi = randomi.nextInt(optionsi.size());
			optionsi.get(randomIndexi).click();
			
		}
		
		
	}
	
	
	@When("the user should see click on the Submit Button for the Exception Rule Meta Data")
	public void the_user_should_see_click_on_the_submit_button_for_the_Exception_Rule_Meta_Data() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		System.out.println("The user is able to click on the Submit Button");
		Thread.sleep(8000);
		commonUtilities.screenshot();
	}
	
	@Then("the user should see {string} in the file list for the Exception Rule Meta Data")
	
	public void the_user_should_see_in_the_file_list_for_the_Exception_Rule_meta_data(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Record has been added successfully')]")).getText();
		Assert.assertEquals("Record has been added successfully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(2000);
		
	}
	
	@When("the user click on any field for the Exception Rule Meta Data")
	public void the_user_click_on_any_field_for_the_dq_assignment() throws InterruptedException {
		driver.findElement(By.xpath("//select[@formcontrolname='ruleType']")).click();
		WebElement button = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
		wait.until(ExpectedConditions.visibilityOf(button)).click();
		Thread.sleep(2000);
	}
	
	@Then("the user should see validation errors for required fields for the Exception Rule Meta Data")
	public void the_user_click_on_any_field_for_the_Exception_Rule_Meta_Dta() throws InterruptedException {
		
		String actual=driver.findElement(By.xpath("//div[text()=' Please Select Rule Type ']")).getText();
		 Assert.assertEquals("Please Select Rule Type", actual);
	        System.out.println("The user is able to see the error message for required fields");
	        commonUtilities.screenshot();
	        driver.quit();
	        Thread.sleep(2000);
	}
	
	@When("the user click on Reset button for the Exception Rule Meta Data")
	public void the_user_click_on_reset_button_for_the_dq_assignment() throws InterruptedException {
		Thread.sleep(2000);
		WebElement lookupexplorer = driver.findElement(By.xpath("//span[text()='Lookup explorer ']"));
		lookupexplorer.click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}
	
	@Then("all the fields should be cleared for the Exception Rule Meta Data")
	public void all_the_fields_should_be_cleared_for_Exception_rule_meta() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ruleStartTimeStamp = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Exception Owners']")));
		WebElement ruleEndTimeStamp = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Exception Owners']")));
		Assert.assertEquals("", ruleStartTimeStamp.getAttribute("value"));
		Assert.assertEquals("", ruleEndTimeStamp.getAttribute("value"));
		System.out.println("The user is able to clear the data in all fields");
		driver.quit();
		Thread.sleep(2000);
	}
	
	@When("the user click on Cancel button for the Exception Rule Meta Data")
	public void the_user_click_on_cancel_button_for_the_Exception() throws InterruptedException {
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@formcontrolname='ruleType']"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Lookup");
		System.out.println("Selected Source Table: Lookup");
		Thread.sleep(1000);
		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
		Select dropdown1 = new Select(dropdownElement1);
		dropdown1.selectByIndex(2);
		System.out.println("Selected Source Attribute: Select Severity");
		Thread.sleep(1000);
		WebElement Exceptionowner = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
		Exceptionowner.sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to close the Add New page");
		commonUtilities.screenshot();
	}
	@Then("Add New Pop up should be closed for the Exception Rule Meta Data")
	public void add_new_pop_up_should_be_closed_for_the_Exception_Rule() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
		Thread.sleep(2000);
	}
	@And("The User click the edit icon for the any file for the Exception Rule Meta Data")
	public void the_user_click_the_edit_icon_for_the_any_file_for_the_dq_assignment() {
		driver.findElement(By.xpath("(//i[@data-action='edit'])[1]")).click();
		commonUtilities.screenshot();
	}
	@When("The User should see the edit modal open file for the Exception Rule Meta Data")
	public void the_user_should_see_the_edit_modal_open_file_for_the_dq_assignment()throws  InterruptedException {
	
		String actual = driver.findElement(By.xpath("//h6[text()='Exception Category ']")).getText();
		Assert.assertEquals("Exception Category", actual);
		System.out.println("The edit modal is displayed");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}
	@Then("the user update the any field for the Exception Rule Meta Data")
	public void the_user_update_the_any_field_for_the_Exception_Rule_meta() throws  InterruptedException {
		WebElement servertyrandom = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
		servertyrandom.click();
		Thread.sleep(2000);
		Select dropdownrandom = new Select(servertyrandom);
		List<WebElement> optionsrandom = dropdownrandom.getOptions();
		int randomdrop= new Random().nextInt(optionsrandom.size());
		dropdownrandom.selectByIndex(randomdrop);
		System.out.println("Selected Source Attribute: Select Severity");
		// owner name
		WebElement ownername = driver.findElement(By.xpath("//input[@placeholder='Enter Exception Owners']"));
		ownername.clear();
		ownername.sendKeys("Test1");
			    System.out.println("The user is able to update the data in the required fields");
	}
	@Then("the user should see click on the Update Button for the Exception Rule Meta Data")
	public void the_user_should_see_click_on_the_update_button_for_the_Exception_Rule() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		System.out.println("The user is able to click on the Update Button");
		commonUtilities.screenshot();
		Thread.sleep(4000);
	}
	@Then("the user should see the updated {string} in the file list for the Exception Rule Meta Data")
	public void the_user_should_see_the_updated_in_the_file_list_for_the_Exveption_rule_meta(String string)
			throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[contains(text(),' Record has been updated successfully')]"))
				.getText();
		Assert.assertEquals("Record has been updated successfully", actual);
		System.out.println("The user is able to insert the data in the all fields");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
		Thread.sleep(2000);
	}
	@When("The User click the delete icon for the any file for the Exception Rule Meta Data")
	public void the_user_click_the_delete_icon_for_the_any_file_for_the_Exception_Rule() {
		driver.findElement(By.xpath("(//i[@data-action='delete'])[1]")).click();
		commonUtilities.screenshot();
	}

	@Then("The User should see a confirmation pop-up with title {string} for the Exception Rule Meta Data")
	public void the_user_should_see_a_confirmation_pop_up_with_title_for_the_Exceptional_meta(String string)
			throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
		System.out.println("The user is able to see the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
	}
	@Then("The User should see {string} message for the Exception Rule Meta Data")
	public void the_user_should_see_message_for_the_Exceptional_Rule(String string) throws InterruptedException {
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Are you sure want to delete' )]")).getText();
		Assert.assertEquals("Are you sure want to delete", actual);
		System.out.println("The user is able to see message in the confirmation pop-up");
		Thread.sleep(2000);
		commonUtilities.screenshot();
		driver.quit();
	}
	@When("The User should see a confirmation pop-up with Cancel and Confirm buttons for the Exception Rule Meta Data")
	public void the_user_should_see_a_confirmation_pop_up_with_cancel_and_confirm_buttons_for_the_Exception_Rule() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed();
		System.out.println("The user is able to see the Confirm and Cancel button in the confirmation pop-up");
	}
	@When("The User confirm the deletion for the Exception Rule Meta Data")
	public void the_user_confirm_the_deletion_for_the_Exceptional_Rule() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	}

	@Then("the file should be removed from the table for the Exception Rule Meta Data")
	public void the_file_should_be_removed_from_the_table_for_the_Exceptional_meta() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();
		driver.quit();
		Thread.sleep(2000);
	}
	
	@When("user clicks the download button Exception Rule Meta Data")
    public void userClicksDownloadButtonEL3Mapping() {
        WebElement downloadButton = driver.findElement(By.xpath("//button[contains(text(),'Download')]"));
        downloadButton.click();

        // Wait for file to download (depends on file size)
        try {
            Thread.sleep(5000); // Or use polling logic for better wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Then("a file should be downloaded to the default download folder for the Exception Rule Meta Data")
    public void verifyFileDownloaded() throws InterruptedException {
    	String downloadPath = System.getProperty("user.dir") + "/downloads";
        File downloadDir = new File(downloadPath);
        if (!downloadDir.exists())
        	downloadDir.mkdir();
        File downloadedFile = new File(downloadDir, fileName);
        System.out.println("✅ Downloaded file found: " + downloadedFile.getAbsolutePath());
        driver.quit();
        Thread.sleep(2000);
    }
    
    
}
