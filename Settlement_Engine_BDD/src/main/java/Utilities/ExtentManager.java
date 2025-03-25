package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
		private static ExtentReports extent;
	private static String reportFileName = "Test-Automaton-Report" + ".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "TestReport";
	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	public static ExtentReports createInstance() {
	    String fileName = getReportPath(reportFilepath);
	    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    sparkReporter.config().setDocumentTitle(reportFileName);
	    sparkReporter.config().setEncoding("utf-8");
	    sparkReporter.config().setReportName(reportFileName);

	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    return extent;
	}

	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				return reportFileLocation;
			} else {
				return System.getProperty("user.dir");
			}
		} else {
			return reportFileLocation;
		}
	}

}
