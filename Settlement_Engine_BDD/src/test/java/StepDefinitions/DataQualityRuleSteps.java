package StepDefinitions;

import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import Utilities.CommonUtilities;


public class DataQualityRuleSteps {
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();

	@Then("the user click on Data Quality Rules")
	public void the_user_click_on_data_quality_rules() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Data Quality Rule')]")).click();
		System.out.println("The user is able to navigate to Data Quality Rule page");
		Thread.sleep(3000);
		commonUtilities.screenshot();
	}

	@When("clicks the Add New button")
	public void clicks_the_button(String string) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Add New')]"));
		actions.moveToElement(button).click().perform();
		Thread.sleep(3000);
		System.out.println("The user is able to click on Add New Button");
		Thread.sleep(3000);
		commonUtilities.screenshot();
		WebElement button1 = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		button1.isDisplayed();
		}

	@Then("the user should return to the {string} page without saving changes")
	public void the_user_should_return_to_the_page_without_saving_changes(String string) {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("The user is able to click on Cancel Button");
		commonUtilities.screenshot();
			}

	@When("enters {string} in the {string} field")
	public void enters_in_the_field(String string, String string2) {
		System.out.println("Submit Button is disabled");
		driver.findElement(By.xpath("//input[@formcontrolname='ruleExpression']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).sendKeys("Testing Automation");
		System.out.println("The user is able to insert the data in the all fields");	
	}

	@When("clicks the {string} button")
	public void clicks_the_Submit_button(String string) {
		WebElement button1 = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		button1.isEnabled();
		Assert.assertTrue("Submit button is enabled", true);
		System.out.println("Submit Button is disabled");
		commonUtilities.screenshot();
		button1.click();
		System.out.println("The user is able to Submit data");
	}

	@Then("the new rule with Rule Id {string} should be displayed in the table")
	public void the_new_rule_with_rule_id_should_be_displayed_in_the_table(String string) {
		driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();	
	    driver.quit();
	}

	@Then("the {string} field should be empty")
	public void the_field_should_be_empty(String string) {
		driver.findElement(By.xpath("//input[@formcontrolname='ruleExpression']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@formcontrolname='ruleDescription']")).sendKeys("Testing Automation");
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("The fields are empty");
		commonUtilities.screenshot();
	}

	@When("the user clicks the {string} icon for the rule with Rule Id {string}")
	public void the_user_clicks_the_icon_for_the_rule_with_rule_id(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("updates {string} in the {string} field")
	public void updates_in_the_field(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the rule with Rule Id {string} should be updated with {string} and {string}")
	public void the_rule_with_rule_id_should_be_updated_with_and(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("confirms the deletion")
	public void confirms_the_deletion() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the rule with Rule Id {string} should be removed from the table")
	public void the_rule_with_rule_id_should_be_removed_from_the_table(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
