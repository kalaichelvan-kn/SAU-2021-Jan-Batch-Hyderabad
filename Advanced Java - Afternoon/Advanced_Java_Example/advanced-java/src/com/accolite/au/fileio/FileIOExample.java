package com.accolite.au.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIOExample {

	public static void main(String[] args) {
		FileIOExample fileIOExample = new FileIOExample();
		
		try {
//			fileIOExample.read();
//			fileIOExample.write();
			fileIOExample.walkAndFindFiles();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void read() throws IOException {
		String filePath = "C:\\Users\\Abhinav\\Desktop\\Projects\\Learnings\\Spring_AU_21\\AU_workspace\\advanced-java\\src\\com\\accolite\\au\\fileio\\sample.txt";
		System.out.println(Files.readAllLines(Paths.get(filePath)));
	}
	
	void write() throws IOException {
		String filePath = "C:\\Users\\Abhinav\\Desktop\\Projects\\Learnings\\Spring_AU_21\\AU_workspace\\advanced-java\\src\\com\\accolite\\au\\fileio\\sample-write.txt";
		String randomData = "some random lines\n another random line";
		Files.write(Paths.get(filePath), randomData.getBytes());
	}
	
	void walkAndFindFiles() throws IOException {
		String folderPath = "C:\\Users\\Abhinav\\Desktop\\Projects\\Learnings\\Spring_AU_21\\AU_workspace\\advanced-java\\src\\com\\accolite\\au\\fileio";
		Files.find(Paths.get(folderPath), 3, (path, file) -> file.isRegularFile())
		  .forEach(System.out::println);
	}
}
