package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
	public static final String SE_URL = "http://localhost:4200/login";
	public static final By MetaDataButton = By.xpath("//a[contains(text(),'Metadata')]");
	public static final By HamburgerButton = By.xpath("//*[text() = '☰']");
}
