package com.github.jacoberson.utilities.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFileWriter {
	private String fileName;
	private String pathToFile = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\textFiles\\";

	public TextFileWriter(String fileName) {
		this.fileName = fileName;
	}

	public void writeFile(List<String> textToWrite) throws IOException {
		File file = new File(pathToFile + fileName + ".txt");

		// Delete old file if exists
		file.delete();

		file.createNewFile();

		FileWriter fileWrite = new FileWriter(file);

		BufferedWriter writer = new BufferedWriter(fileWrite);

		for (String text : textToWrite) {
			writer.write(text);
			writer.newLine();
		}

		fileWrite.close();
		writer.close();
	}
}
