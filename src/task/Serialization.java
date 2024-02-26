package task;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import inputcheck.InvalidInputException;
import util.Util;

public class Serialization {

	public void createFile(String fileName, String location) throws IOException, InvalidInputException {
		Util.checkNull(location);
		Util.checkNull(fileName);
		Path path = Paths.get(location, fileName);
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
	}

	public <E>void writeObjects(Object data, String location) throws InvalidInputException {
		Util.checkNull(location);
		Util.checkNull(data);
		try (FileOutputStream fileOut = new FileOutputStream(location, true);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
			objectOut.writeObject(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public <E>List<E>readObjects(String location) throws InvalidInputException {
		Util.checkNull(location);
		List<E> list = new ArrayList<E>();
		try(FileInputStream fileIn = new FileInputStream(location);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
			list = (List<E>) objectIn.readObject();
		}catch (EOFException e) {
			 System.out.println("End of file");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list;
	}
}
