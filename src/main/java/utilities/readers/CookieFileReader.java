package utilities.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.Cookie;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;

public class CookieFileReader {
	private static Driver driver = WebCoreDriver.getInstance();

	public static void readFile(String pathToCookieFile) throws IOException {
		File file = new File(pathToCookieFile);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		String line;
		while ((line = reader.readLine()) != null) {
			String nameAndValue = line.replace("[", "").split(";")[0];
			String name = nameAndValue.split("=")[0];
			String value = nameAndValue.split("=")[1];

			Cookie cookie = new Cookie(name, value);
			driver.addCookie(cookie);

		}

		reader.close();
	}
}
