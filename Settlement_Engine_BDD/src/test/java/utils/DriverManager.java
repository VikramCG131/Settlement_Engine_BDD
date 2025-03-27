package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static  void initializeDriver() {
		if (driver.get()== null) {
			System.out.println("Initializing driver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
		} else {
			System.out.println("Driver already initialized");
		}
	}
	
	public static WebDriver getDriver() {
		if (driver.get() == null) {
			System.out.println("Driver is null, initializing driver");
			initializeDriver();
		}
		return driver.get();
	}

	public static void closeDriver() {
		if (driver.get() != null) {
			System.out.println("Closing driver");
			driver.get().quit();
			driver.remove();
		}
	}
}
