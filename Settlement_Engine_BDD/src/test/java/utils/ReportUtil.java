package utils;
 
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ReportUtil {
    private static ExtentReports extent;
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;
 
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
        featureTest = extent.createTest(featureName);
    }
 
    // Create Scenario as a Child Step
    public static void createScenario(String scenarioName) {
        scenarioTest = featureTest.createNode(scenarioName);
    }
 
    // Log Step
    public static void logStep(String message, WebDriver driver) {
        scenarioTest.info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
 
        // Capture and attach screenshot
        String screenshotPath = captureScreenshot(driver, message);
        scenarioTest.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
 
    // Log Pass
    public static void logPass(String message) {
        scenarioTest.pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
 
    // Log Fail
    public static void logFail(String message, WebDriver driver) {
        scenarioTest.fail(MarkupHelper.createLabel(message, ExtentColor.RED));
 
        // Capture and attach screenshot
        String screenshotPath = captureScreenshot(driver, "FailedStep");
        scenarioTest.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
 
    // Capture Screenshot and return file path
    private static String captureScreenshot(WebDriver driver, String stepName) {
        String screenshotPath = "";
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenshotPath = "target/screenshots/" + stepName.replace(" ", "_") + "_" + timestamp + ".png";
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
 
    // Flush Report
    public static void flushReport() {
        extent.flush();
    }
}
 