package com.github.jacoberson.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	private ExtentReports extent = ExtentManager.getInstance();
	private ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getName();

		test = extent.createTest(methodName);
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

		test.log(Status.FAIL, String.format("%s failed with exception %s",
				methodName, throwable));
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();

		test.log(Status.SKIP, String.format("%s skipped", methodName));
		extent.flush();
	}

}
