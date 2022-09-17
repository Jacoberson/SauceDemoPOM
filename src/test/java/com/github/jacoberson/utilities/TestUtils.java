package com.github.jacoberson.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import utilities.readers.ExcelReader;

public class TestUtils {
	private String pathToExcel = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\excelFiles\\ExcelTest.xlsx";
	private ExcelReader excel = new ExcelReader(pathToExcel);
	public static String screenshotName;
	private static Driver driver = WebCoreDriver.getInstance();

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1),
						excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}

	public static void captureScreenshot() throws IOException {
		Date date = new Date();
		screenshotName = date.toString().replace(":", "_").replace(" ", "_")
				+ ".jpg";
		File screenshotFile = driver.captureScreenshot();

		FileUtils.copyFile(screenshotFile,
				new File(System.getProperty("user.dir")
						+ "\\target\\surefire-reports\\screenshots\\"
						+ screenshotName));
	}

	public static void clearScreenshots() throws IOException {
		File screenshotFiles = new File(System.getProperty("user.dir")
				+ "\\target\\surefire-reports\\screenshots\\");

		if (screenshotFiles.exists()) {
			File[] files = screenshotFiles.listFiles();

			for (var file : files) {
				file.delete();
			}

		} else {
			screenshotFiles.mkdir();
		}
	}

	public static String testClassFormatter(String testName) {
		String formattedTestClass = testName.replace("]", "")
				.split("com.github.jacoberson.tests.")[1];

		return formattedTestClass;
	}
}
