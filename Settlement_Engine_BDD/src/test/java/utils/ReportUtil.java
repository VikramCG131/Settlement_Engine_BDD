package utils;
 
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ReportUtil {
    private static ExtentReports extent;
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;
    static String screenshotPath;
 
    // Initialize Extent Reports
    public static void initReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/SparkReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        //sparkReporter.config().enableTimeline(true);  // Enable Dashboard
 
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
        if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call initializeReport() first.");
        }
        extent.createTest(featureName);
       
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
        	scenarioTest.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
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
        scenarioTest.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    	}
    }
 
    // Log Fail
    public static void logFail(String message, WebDriver driver) {
    	if (scenarioTest != null) {
        scenarioTest.fail(MarkupHelper.createLabel("FAILED: " + message, ExtentColor.RED));
 
        // Capture and attach screenshot
        screenshotPath = ScreenshotUtil.captureScreenshot(driver, "FailedStep");
        scenarioTest.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    	}
    }
 
    // Capture Screenshot and return file path
//    private static String captureScreenshot(WebDriver driver, String stepName) {
//        String screenshotPath = "";
//        try {
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            screenshotPath = "target/screenshots/" + stepName.replace(" ", "_") + "_" + timestamp + ".png";
//            File destFile = new File(screenshotPath);
//            FileUtils.copyFile(srcFile, destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return screenshotPath;
//    }
 
    // Flush Report
    public static void flushReport() {
        extent.flush();
    }
}
 