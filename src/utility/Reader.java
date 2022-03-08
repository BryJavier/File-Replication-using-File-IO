package utility;

//1st step - import the java I/O related classes
import java.io.*;

public class Reader {

	private static BufferedReader getReader() {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
		
		return reader;
	}
	
	public static String readString(String message) /*throws IOException*/ {
		String input = "";
		System.out.print(message + ": ");
		
		try {
			input = getReader().readLine();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return input;
	}
	
	public static int readInt(String message) /*throws IOException*/ {
		int input = 0;
		System.out.print(message + ": ");
		
		try {
			//converts String data type to int primitive data type	
			input = Integer.parseInt(getReader().readLine());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid input: " + nfe.getMessage());
		}
		return input;
	}
	
	public static double readDouble(String message) /*throws IOException*/ {
		double input = 0;
		System.out.print(message + ": ");
		
		try {
			//converts String data type to double primitive data type	
			input = Double.parseDouble(getReader().readLine());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid input: " + nfe.getMessage());
		}
		return input;
	}
	
}
