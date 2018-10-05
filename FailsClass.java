import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * @author Erik Ayavaca-Tirado
 *  Program is going to be comparing the 2 files transcript and course list and spitiing out the difference between them.
 *  Orginal implentation ideas:
 *  // posibly use the hasmap
 * 	// Takes in the user's transcript
 * 	// Takes in user's major course list
 * 	// Compares both lists
 * 	// Puts classes not already taken into an array
 * 	// outputs classes as " you still need to complete these"
 * 	// Goes back into Transcript and looks for classes with F,D, 1.5,1,.5 or 0
 * 	// these classes are put into list or array
 * 	// outputs to user as " need to retake this"
 * 	// Output is returned to user
 *
 */
// Can also be used as which classes a user needs to take
public class FailsClass {

	static final String abbreviations = "CSC MAT ENL AIS COM PSY ANT CCS SOC THR WST"
			+ " POL ART HIS ECO PHI BUS FIN BIO HPE EDC EED CHM SPE SWK"
			+ " ENV PHY HON KEY MIS MKT HUM RLN THR MUS SPA MUE ACC SCI"
			+ " NUR NMS FLM THP URB YST REL AUG";

	public static void main(String[] args) throws IOException {
		//GUI does not call any of the code yet
//		GUI window = new GUI();
//		window.setVisible(true);


		//REMOVE COMMENT IF WANT TO RUN FROM COMMAND LINE
		File transcript = new File(args[0]);
		File degree = new File(args[1]);
		//File transcript = new File("Transcript-2.txt");
		//File degree = new File("majorrequirements.txt");

		readFile(transcript, "transcript.txt");
		readFile(degree, "degree.txt");

		Path firstFile = Paths.get("degree.txt");
		Path secondFile = Paths.get("transcript.txt");

		List<String> firstFileContent = Files.readAllLines(firstFile, Charset.defaultCharset());
		List<String> secondFileContent = Files.readAllLines(secondFile, Charset.defaultCharset());
		System.out.println("You still need to take the following classes: " + diffFiles(firstFileContent,secondFileContent));
		System.out.println("these are extra classes you took: " + diffFiles(secondFileContent,firstFileContent));

}

	/**
	 * Reads a file and "outputs a text file containing the course abbreviations
	 * in a nice format."
	 *
	 * @param a the text file to scan through and retrieve course abbreviations
	 */
	/* This method will scan the text file word by word and ONLY compare
	the word to the abbreviations IF AND ONLY IF the scanned word has a length
	of between 6 and 7. */
	public static void readFile(File a, String nameOfFile) {
		Scanner scanLine = null;
		Scanner abbreviationList = null;

		try {
			scanLine = new Scanner(a);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		createFile(nameOfFile, scanLine, abbreviationList);
	}

	/**
	 * This method will create a text file and store in neatly,
	 * the course's abbreviations.
	 *
	 * @param nameOfFile       the name of the file being created
	 * @param scanLine         the Scanner for the text file
	 * @param abbreviationList the Scanner for abbreviations String
	 */
	public static void createFile(String nameOfFile, Scanner scanLine, Scanner abbreviationList) {
		try {
			FileWriter writeToFile = new FileWriter(nameOfFile);
			BufferedWriter out = new BufferedWriter(writeToFile);

			while (scanLine.hasNext()) {
				String word = scanLine.next();
				//System.out.println("String word: " + word); //Testing purpose, uncheck if you want to see how it works
				abbreviationList = new Scanner(abbreviations);

				//only check words with length between 6-7
				while (abbreviationList.hasNext() && word.length() >= 6 && word.length() <= 7) {
					String courseAbbrev = abbreviationList.next();

					if (word.regionMatches(0, courseAbbrev, 0, 3)) {
						out.write(word);
						out.newLine();
						break; //exit out 2nd loop if found a match
					}
				}
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Error - IOException");
		}

		System.out.println(nameOfFile + " text file has been created.");
	}

	/*     Not functional for this at the moment.
	public static void compareListingToTranscript(Map<String, Integer> hm, String s) {
		Scanner sc = null;
		try {
			sc = new Scanner(new String(s));
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		// This loop grabs the string in the listing and asks if it is already in the hash map
		while (sc.hasNext()) {
			String str = sc.next();
			Integer count = hm.get(str);

			hm.put(str, (count == null) ? 1 : count + 1);
		}
		sc.close();
	}
	*/

	// function that prints out the differences in the 2 files

	public static List<String> diffFiles( List<String> firstFileContent,List<String> secondFileContent)
	{
		List<String> diff = new ArrayList<String>();
		for (String line : firstFileContent) {
			if (!secondFileContent.contains(line)) {
				diff.add(line);
			}
		}
		return diff;
	}

}


