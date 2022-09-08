package com.github.jacoberson.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import utilities.readers.ExcelReader;

public class TestUtils {
	private String pathToExcel = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\excelFiles\\ExcelTest.xlsx";
	private ExcelReader excel = new ExcelReader(pathToExcel);

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
}
