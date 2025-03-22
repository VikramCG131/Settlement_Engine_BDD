package StepDefinitions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the SauceDemo login page")
    public void verifySaucedemoLoginPage() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        System.out.println("User is able to open the SauceDemo URL successfully");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        System.out.println("User is able to enter the Username successfully");
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("User is able to enter the password successfully");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
        System.out.println("User is able to login successfully");
    }

    @Then("I should be redirected to the product page")
    public void i_should_be_redirected_to_the_product_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        driver.quit();
        System.out.println("User is able to see the Product page successfully");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        driver.quit();
        System.out.println("User is able to see the error message successfully");
    }

    @Given("I am logged into SauceDemo")
    public void i_am_logged_into_saucedemo() {
    	verifySaucedemoLoginPage();
        i_enter_username("standard_user");
        i_enter_password("secret_sauce");
        i_click_the_login_button();
        System.out.println("User is able to login successfully");
    }

    @When("I add the product {string} to the cart")
    public void i_add_the_product_to_the_cart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")).click();
        System.out.println("User is able to add the product to the cart successfully");
    }

    @Then("the cart badge should show {string}")
    public void the_cart_badge_should_show(String count) {
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(count, cartBadge);
        driver.quit();
        System.out.println("User is able to see the cart badge successfully");
    }

    @Given("I have a product in my cart")
    public void i_have_a_product_in_my_cart() {
        i_am_logged_into_saucedemo();
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        System.out.println("User is able to see the procuct in my cart");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        System.out.println("User is able to checkout successfully");
    }

    @When("I enter first name {string}")
    public void i_enter_first_name(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    @When("I enter last name {string}")
    public void i_enter_last_name(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    @When("I enter postal code {string}")
    public void i_enter_postal_code(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @When("I click continue")
    public void i_click_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @When("I click finish")
    public void i_click_finish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        driver.quit();
    }
}
