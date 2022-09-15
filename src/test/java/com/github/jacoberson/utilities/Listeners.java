package com.github.jacoberson.utilities;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.github.jacoberson.utilities.LogSetup.ApplicationLogger;

public class Listeners implements ITestListener, ISuiteListener {
	private ExtentReports extent = ExtentManager.getInstance();
	private ExtentTest test;
	private static Logger logger = ApplicationLogger.getApplicationLogger();

	@Override
	public void onStart(ISuite suite) {
		try {
			TestUtils.clearScreenshots();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getName();

		test = extent.createTest(methodName);
		logger.info(
				String.format("STARTING TEST %s", methodName.toUpperCase()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName();

		test.log(Status.PASS, String.format("%s passed", methodName));
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		Throwable throwable = result.getThrowable();
		String screenshotPath = null;

		try {
			TestUtils.captureScreenshot();
			screenshotPath = System.getProperty("user.dir")
					+ "\\target\\surefire-reports\\screenshots\\"
					+ TestUtils.screenshotName;
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.log(Status.FAIL, String.format("%s failed with exception %s",
				methodName, throwable));
		test.log(Status.INFO, MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotPath).build());
		test.log(Status.INFO, "<a target='_blank' href=" + screenshotPath
				+ ">Fullscreen Screenshot</a>");
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();

		test.log(Status.SKIP, String.format("%s skipped", methodName));
		extent.flush();
	}

}
