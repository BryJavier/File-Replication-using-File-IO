package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import utility.Reader;

public class AccessFileReplication {
	public static void main(String[] args) {
		String fileName = Reader.readString("Enter a filename");
	
		//Adds "_bak" on the filename  
		String newFileName = "";
		for(int i=0; i<fileName.length(); ++i) {
			if(fileName.charAt(i) == '.') {
				newFileName += "_bak";
				newFileName += fileName.charAt(i);
			}else {
				newFileName += fileName.charAt(i);
			}
		}
		
		//Extracts the new name of the new filename
		String nameOfFile = "";
		boolean isChecked = false;
		for(int i=0; i<newFileName.length(); ++i) {
			if(newFileName.charAt(i) == '.' && isChecked == false) {
				//if the . is found reverse the index until \\ is found
				for(int j=i; ;--j) {
					if(newFileName.charAt(j) == '\\') {
						isChecked = true;
						i = j + 1;
						break;
					}
				}
			}
			
			if(isChecked) {
				nameOfFile += newFileName.charAt(i);
			}
		}
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		boolean isSuccess = false;
		
		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream(newFileName, true);
			
			char data;
			int temp;
			
			do {
				temp = fis.read();
				data = (char) temp;
				
				//prevents the null operator to be written in the file
				if(temp != -1) {
					fos.write(data);
				}
				
				if(temp == -1) {
					isSuccess = true;
				}
				
			}while(!isSuccess);
			
			if(isSuccess) {
				System.out.println("Successfully created backup file.");
			}else {
				System.out.println("Error creating backup file.");
			}
			
			System.out.println(nameOfFile + " on " + newFileName);
		
		}catch(FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		}catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}	
	}
}
