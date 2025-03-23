package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

}

@Then("the user is able to navigate to the Settlement Engine homepage")
public void the_user_is_able_to_navigate_to_the_settlement_engine_homepage() throws InterruptedException {
	Assert.assertTrue(driver.getTitle().contains("Starter Kit PF Angular"));
    Thread.sleep(3000);

}

@Then("the user click on Data Source File")
public void the_user_click_on_data_source_file() throws InterruptedException {

    driver.findElement(By.xpath("//a[contains(text(),'Data Source File')]")).click();
    Thread.sleep(3000);

}

@Then("the user click on Add New Button")
public void the_user_click_on(String string) {
	driver.findElement(By.xpath("//button[text()='Add New']")).click();
}

@Then("the user enter {string} in the {string} field")
public void the_user_enter_in_the_field(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("the user should see {string} in the file list")
public void the_user_should_see_in_the_file_list(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("the user should see validation errors for required fields")
public void the_user_should_see_validation_errors_for_required_fields() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("{string} should not be in the file list")
public void should_not_be_in_the_file_list(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
