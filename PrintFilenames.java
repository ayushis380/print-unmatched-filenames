import java.io.*;
import java.util.*;

public class PrintFilenames {
	public static void main(String args[]) throws IOException {
		System.out.println("Enter the first path : ");
		Scanner scanner = new Scanner(System.in);
		String filePathOld = scanner.next();
		System.out.println("Enter the second : ");
		String filePathNew = scanner.next();
		System.out.println("Enter the path where text file should be generated : ");
		String filePath = scanner.next();
		File directoryPathOld = new File(filePathOld);
		File directoryPathNew = new File(filePathNew);
		File filesListOld[] = directoryPathOld.listFiles(); // list of files at
															// first path
		File filesListNew[] = directoryPathNew.listFiles(); // list of files at
															// second path
		List<String> matchedFiles = new ArrayList<String>();
		File createPath = new File(filePath);
		createPath.createNewFile();
		FileWriter writeTo = new FileWriter(filePath);
		// Comparing filenames and storing matched filenames in an Array
		for (File fileNew : filesListNew) {
			for (File fileOld : filesListOld) {
				if (fileNew.getName().equals(fileOld.getName())) {
					matchedFiles.add(fileNew.getName());
				}
			}
		}
		// Writing the similar filenames to the text file
		writeTo.write("Similar filenames : " + "\n");
		for (String matchName : matchedFiles) {
			writeTo.write(matchName);
			writeTo.write("\n");
			
		}
		// Appending the different filenames to the text file
		writeTo.write("\n"+ "Different filenames : " + "\n");
		for (File fileMatch : filesListOld) {  // Different filenames at the first location
			int count = 0;
			for (String matchName : matchedFiles) {
				if (fileMatch.getName().equals(matchName)) {
					count++;
				}
			}
			if (count == 0) {
				writeTo.write(fileMatch.getName());
				writeTo.write("\n");
			}
		}
		for (File fileMatch : filesListNew) { // Different filenames at the second location
			int count = 0;
			for (String matchName : matchedFiles) {
				if (fileMatch.getName().equals(matchName)) {
					count++;
				}
			}
			if (count == 0) {
				writeTo.write(fileMatch.getName());
				writeTo.write("\n");
			}
		}
		writeTo.close();
		scanner.close();
	}
}