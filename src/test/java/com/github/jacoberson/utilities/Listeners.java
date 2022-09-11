package com.github.jacoberson.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	private ExtentReports extent = ExtentManager.getInstance();

	@Override
	public void onTestStart(ITestResult result) {
		// extent.createTest(result.getMethod().getMethodName());
		// extent.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName()).log(Status.PASS,
				String.format("%s passed", result.getMethod().getMethodName()));
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName()).log(Status.FAIL,
				String.format("%s passed", result.getMethod().getMethodName()));
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName()).log(Status.SKIP,
				String.format("%s passed", result.getMethod().getMethodName()));
		extent.flush();
	}

}
