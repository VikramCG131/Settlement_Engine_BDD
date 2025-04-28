package utils;
 
import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import utils.ScreenshotUtil;

 
public class ReportUtil {
    private static ExtentReports extent;
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;
    static String screenshotPath;
    private static int passCount = 0;
    private static int failCount = 0;
    private static int skipCount = 0;
 
    // Initialize Extent Reports
    public static void initReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/SparkReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
        						ViewName.DASHBOARD, ViewName.TEST, ViewName.EXCEPTION, ViewName.LOG, ViewName.CATEGORY,
				ViewName.DEVICE, ViewName.AUTHOR
        }).apply();
 
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "Local");
        extent.setSystemInfo("Test Runner", "Cucumber");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Run By", "Shilajeet Chakraborty");
    }
 
     // Create Feature
    public static void createFeature(String featureName) {
        featureTest = extent.createTest(MarkupHelper.createLabel(featureName, ExtentColor.PURPLE).getMarkup());
    }
 
    // Create Scenario as a Child Step
    public static void createScenario(String scenarioName) {
    	if (featureTest == null) {
    		featureTest = extent.createTest("Default Feature");
    	}
        scenarioTest = featureTest.createNode(MarkupHelper.createLabel(scenarioName, ExtentColor.INDIGO).getMarkup());
    }
 
    // Log Step
    public static void logStep(String message, WebDriver driver) {
    	if (scenarioTest != null) {
        scenarioTest.info(MarkupHelper.createLabel("STEP: " + message, ExtentColor.BLUE));
        
        // Capture and attach screenshot
        screenshotPath = ScreenshotUtil.captureScreenshot(driver, message);
        if (screenshotPath != null) {
			// Attach screenshot to the report
        	scenarioTest.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			}
    	}
    }
    
    //Log Info
    public static void logInfo(String message) {
    	if (scenarioTest != null) {
    		scenarioTest.info(MarkupHelper.createLabel("INFO: " + message, ExtentColor.CYAN));
		}	
	}
 
    // Log Pass
    public static void logPass(String message, WebDriver driver) {
    	if (scenarioTest != null) {
        scenarioTest.pass(MarkupHelper.createLabel("PASSED: " + message, ExtentColor.GREEN));
        
        // Capture and attach screenshot
        screenshotPath = ScreenshotUtil.captureScreenshot(driver, "PassedStep");
        scenarioTest.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
        
    	}
    }
 
    // Log Fail
    public static void logFail(String message, WebDriver driver) {
    	if (scenarioTest != null) {
        scenarioTest.fail(MarkupHelper.createLabel("FAILED: " + message, ExtentColor.RED));
 
        // Capture and attach screenshot
        screenshotPath = ScreenshotUtil.captureScreenshot(driver, "FailedStep");
        scenarioTest.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
        
    	}
    }
    // Log Fail with Exception
    public static void logFailWithException(String message, WebDriver driver, Throwable e) {
		if (scenarioTest != null) {
		// Log the failure message
		//scenarioTest.fail(MarkupHelper.createLabel("Exception: " + e.getMessage(), ExtentColor.AMBER));
			 StringWriter sw = new StringWriter();
			 //PrintWriter pw = new PrintWriter(sw);
		        e.printStackTrace(new PrintWriter(sw));
		        String exceptionDetails = sw.toString();
		        scenarioTest.fail(MarkupHelper.createCodeBlock(exceptionDetails));
		}
	}
    
    // Log Skip
    public static void logSkip(String message) {
		if (scenarioTest != null) {
		scenarioTest.skip(MarkupHelper.createLabel("SKIPPED: " + message, ExtentColor.AMBER));
		
		}
	}
    
    public static void assignCategory(String category) {
        if (scenarioTest != null) {
            scenarioTest.assignCategory(category);
        }
    }
    
    // Flush Report
    public static void flushReport() {
        extent.flush();
    }

	
}
 