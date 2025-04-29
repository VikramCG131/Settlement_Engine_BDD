package utils;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ScreenshotUtil {
	
		private static String screenshotPath;
 
    // Capture screenshot and return file path
    public static String captureScreenshot(WebDriver driver, String stepName) {
        
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String safeStepName = stepName.replaceAll("[^a-zA-Z0-9-_]", "_");
            String screenshotName = safeStepName + "_" + timestamp + ".png";
            
            String screenshotPath = "target/screenshots/";
            File destFile = new File(screenshotPath + screenshotName);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
            return "screenshots/" + screenshotName; // Return relative path for reporting
            
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if screenshot capture fails
        }
    }
}
 