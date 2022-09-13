package utilities.reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	private static String configFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\extentConfig\\extentconfig.xml";

	public static ExtentReports getReportInstance() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "\\target\\surefire-reports\\html\\extentreport.html");

		try {
			spark.loadXMLConfig(configFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		extent.attachReporter(spark);

		return extent;
	}
}
