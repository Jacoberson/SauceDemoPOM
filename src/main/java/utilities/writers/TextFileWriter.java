package utilities.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
	private static String pathToFile = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\cookieFiles\\";

	public static void writeFile(String fileName, String textToWrite)
			throws IOException {
		File file = new File(pathToFile + fileName + ".txt");

		// Delete old file if exists
		file.delete();

		file.createNewFile();

		FileWriter fileWrite = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWrite);

		writer.write(textToWrite);
		writer.newLine();

		writer.close();
	}
}
