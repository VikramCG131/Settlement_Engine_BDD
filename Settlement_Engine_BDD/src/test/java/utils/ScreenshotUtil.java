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
 
    // Capture screenshot and return file path
    public static String captureScreenshot(WebDriver driver, String stepName) {
        String screenshotPath = "";
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenshotPath = "target/screenshots/" + stepName + "_" + timestamp + ".png";
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
 