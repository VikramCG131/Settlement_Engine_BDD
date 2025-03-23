package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

public class MetaDataSourceFileSteps {
    WebDriver driver;

@Given("The Settlement Engine<URL>")
public void the_settlement_engine_url() {
	
driver=	WebDriverManager.chromedriver().create();
    driver.manage().window().maximize();
driver.get("http://localhost:50178");	
}


@When("user hit the Settlement Engine URL")
	public void the_user_hits_the_settlement_engine_url() throws InterruptedException {
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:50178"));
        Thread.sleep(3000);
        System.out.println("The user is able to login with Settlent Engine URL");
}

@Then("the user is able to navigate to the Settlement Engine homepage")
public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
	Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
    Thread.sleep(3000);
    System.out.println("The user is able to navigate to the Settlement Engine homepage");
}

@Then("the user click on Data Source File")
public void the_user_click_on_data_source_file() throws InterruptedException {

    driver.findElement(By.xpath("//a[contains(text(),'Data Source File')]")).click();
    Thread.sleep(5000);
    System.out.println("The user is able to navigate to Data Source File page");
}

@Then("the user click on Add New Button")
public void the_user_click_on(String string) throws InterruptedException {
	WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Add New')]"));
	button.isDisplayed();
	button.click();
	Thread.sleep(3000);
	System.out.println("The user is able to click on Add New Button");
	}

@Then("the user enter {string} in the {string} field")
public void the_user_enter_in_the_field(String string, String string2) {
    driver.findElement(By.xpath("//input[@formcontrolname='fileName']")).sendKeys("Testing");
    driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).sendKeys("Pattern");
    driver.findElement(By.xpath("//input[@formcontrolname='filePathRaw']")).sendKeys("Raw");
    driver.findElement(By.xpath("//input[@formcontrolname='filePathCleansed']")).sendKeys("Cleansed");
    driver.findElement(By.xpath("//input[@formcontrolname='fileSizeMB']")).sendKeys("10");
    driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("Type");
    driver.findElement(By.xpath("//input[@formcontrolname='stagingTableName']")).sendKeys("MetadataSourceFile");
    driver.findElement(By.xpath("//input[@formcontrolname='fileDelimiter']")).sendKeys("Delimiter");
    driver.findElement(By.xpath("//input[@formcontrolname='headerIdentifier']")).sendKeys("Header");
    driver.findElement(By.xpath("//input[@formcontrolname='columnIdentifier']")).sendKeys("Column");
}

@Then("the user should see {string} in the file list")
public void the_user_should_see_in_the_file_list(String string) throws InterruptedException {
    driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("Test");
    System.out.println("The user is able to insert the data in the all fields");
    Thread.sleep(2000);
}

@Then("the user should see click on the Submit Button")
public void the_user_should_click_on_the_Submit_button(String string) {
    driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    System.out.println("The user is able to click on the Submit Button");
}

@Then("the user should see validation errors for required fields")
public void the_user_should_see_validation_errors_for_required_fields() {
 driver.findElement(By.xpath("//input[@formcontrolname='fileName']")).sendKeys("Testing");
	driver.findElement(By.xpath("//input[@formcontrolname='filePattern']")).sendKeys("Pattern");
	driver.findElement(By.xpath("//input[@formcontrolname='filePathCleansed']")).sendKeys("Cleansed");
	driver.findElement(By.xpath("//input[@formcontrolname='fileSizeMB']")).sendKeys("10");
	driver.findElement(By.xpath("//input[@formcontrolname='fileType']")).sendKeys("Type");
	driver.findElement(By.xpath("//input[@formcontrolname='fileDelimiter']")).sendKeys("Delimiter");
	driver.findElement(By.xpath("//input[@formcontrolname='headerIdentifier']")).sendKeys("Header");
	driver.findElement(By.xpath("//input[@formcontrolname='columnIdentifier']")).sendKeys("Column");
	driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();   
}

@Then("{string} should not be in the file list")
public void should_not_be_in_the_file_list(String string) {
    driver.findElement(By.xpath("//div[@data-ref='rootWrapperBody']")).isDisplayed();	
    }

@Then("the user click on {string}")
public void the_user_click_on_Cancel(String string) {
  //  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
}

}
