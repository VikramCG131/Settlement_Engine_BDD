package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ScreenshotUtil {

    // Capture screenshot and return Base64 string
    public static String captureScreenshot(WebDriver driver, String stepName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String safeStepName = stepName.replaceAll("[^a-zA-Z0-9-_]", "_");
            String screenshotName = safeStepName + "_" + timestamp + ".png";

            String screenshotPath = "target/screenshots/";
            File destFile = new File(screenshotPath + screenshotName);
            FileUtils.copyFile(srcFile, destFile);

            // Convert screenshot to Base64
            byte[] fileContent = FileUtils.readFileToByteArray(destFile);
            return Base64.getEncoder().encodeToString(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if screenshot capture fails
        }
    }
}
