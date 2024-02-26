package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import inputcheck.InvalidInputException;
import util.Util;

public class BasicProgramming_FileTask {

	public void createDirectory(String pathOfDirectory, String directoryName)
			throws InvalidInputException, IOException {
		Util.checkNull(pathOfDirectory);
		Util.checkNull(directoryName);
		Path directoryPath = Paths.get(pathOfDirectory, directoryName); 
		if (Files.notExists(directoryPath)) {
			Files.createDirectories(directoryPath);
		}
	}

	public void createFile(String location, String fileName) throws IOException, InvalidInputException {
		Util.checkNull(fileName);
		Util.checkNull(location);
		Path filePath = Paths.get(location, fileName);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	public void putFileInLocation(String fileLocation, String directoryLocation)
			throws InvalidInputException, IOException {
		Util.checkNull(fileLocation);
		Util.checkNull(directoryLocation);
		Path filePath = Paths.get(fileLocation);
		Path directoryPath = Paths.get(directoryLocation);
		directoryPath.resolve(filePath.getFileName());
		Files.copy(filePath, directoryPath, StandardCopyOption.REPLACE_EXISTING);
	}

	public void writeInFile(String filePath, String data) throws InvalidInputException, IOException {
		Util.checkNull(filePath);
		Util.checkNull(data);
		try (FileWriter fileWriter = new FileWriter(filePath);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
			bufferedWriter.write(data);
		}
	}

	public String readInFile(String inputFile) throws InvalidInputException, IOException {
		Util.checkNull(inputFile);
			String fileData = "";
		try (FileReader fileReader = new FileReader(inputFile);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String temp;
			while ((temp = bufferedReader.readLine()) != null) {
				fileData += temp;
			}
		} 
		return fileData;
	}
	public String currentDirectory() {
		return  System.getProperty("user.dir");
	}
}
