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

	public static void main(String[] args) throws IOException {
		//Replace with own file paths when testing
		//First file MUST be transcript
		//Path firstFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Courselist.txt");
		//Path secondFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Transcript.txt");
		GUI window = new GUI();
		window.setVisible(true);

		String transcript = args[0];
		String listing = args[1];
		Map<String, Integer> abbreviations = new HashMap<>();
		Map<String, Integer> courses = new HashMap<>();		// Holds courses taken in major(2), other courses taken (1), and courses available (0)
		fillAbbrev(abbreviations);
		formatTranscript(courses, abbreviations, transcript);
		compareListingToTranscript(courses, listing);
		printResults(courses);
	}

	public static void compareListingToTranscript(Map<String, Integer> hm, String s){
		Scanner sc = null;
		try {
			sc = new Scanner(new String(s));
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		// This loop grabs the string in the listing and asks if it is already in the hash map
		while(sc.hasNext()){
			String str = sc.next();
			Integer count = hm.get(str);

			hm.put(str, (count == null) ? 1 : count + 1);
		}
		sc.close();
	}

	/*
	 * This function pulls the courses from the transcript and puts them in the hash map hm
	 * @param s is the transcript.txt file
	 * @param hm is the hash map containing the courses that the student has taken
	 * @param abbrev is the hash map of containing the abbreviations of all classes
	 */
	public static void formatTranscript(Map<String, Integer> hm, Map<String, Integer> abbrev, String s) throws FileNotFoundException {
		Scanner sc = null;
		try {
			File source = new File(s);
			sc = new Scanner(source);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		while(sc.hasNext()){
			String str = sc.next();
			String result = str.replaceAll("[^a-z,^A-Z]+", "");
			// Put the string in the hash map. ? is ternary op, shorthand if-else.
			// If the word hasn't appeared, add it and set value to one
			// If it has, increase its count
			System.out.println(result);
			if(abbrev.containsKey(result)){
				hm.put(str, 1);
				System.out.println("hi");
			}
		}
		// Close file
		sc.close();
	}

	/*
	 * This function manually adds all of the available abbreviations from the
	 * university to cross check with the file we are reading in
	 * @param hm is the hashmap for the abbreviated courses in the university's catalog
	 */
	public static void fillAbbrev(Map<String, Integer> hm) {
		hm.put("CSC", 0);
		hm.put("MAT", 0);
		hm.put("ENL", 0);
		hm.put("AIS", 0);
		hm.put("COM", 0);
		hm.put("PSY", 0);
		hm.put("ANT", 0);
		hm.put("CCS", 0);
		hm.put("SOC", 0);
		hm.put("THR", 0);
		hm.put("WST", 0);
		hm.put("POL", 0);
		hm.put("ART", 0);
		hm.put("HIS", 0);
		hm.put("ECO", 0);
		hm.put("PHI", 0);
		hm.put("BUS", 0);
		hm.put("FIN", 0);
		hm.put("BIO", 0);
		hm.put("HPE", 0);
		hm.put("EDC", 0);
		hm.put("EED", 0);
		hm.put("CHM", 0);
		hm.put("SPE", 0);
		hm.put("SWK", 0);
		hm.put("ENV", 0);
		hm.put("PHY", 0);
		hm.put("HON", 0);
		hm.put("KEY", 0);
		hm.put("MIS", 0);
		hm.put("MKT", 0);
		hm.put("HUM", 0);
		hm.put("RLN", 0);
		hm.put("THR", 0);
		hm.put("MUS", 0);
		hm.put("SPA", 0);
		hm.put("MUE", 0);
		hm.put("ACC", 0);
		hm.put("SCI", 0);
		hm.put("NUR", 0);
		hm.put("NMS", 0);
		hm.put("FLM", 0);
		hm.put("THP", 0);
		hm.put("URB", 0);
		hm.put("YST", 0);
	}

	public static void printResults(Map<String, Integer> courseSuggestions){
		for(Map.Entry<String, Integer> entry : courseSuggestions.entrySet()){
			System.out.println("The word: " + entry.getKey()
					+ " appears " + entry.getValue() + " times.");
		}

		System.out.println("If value is a 2, that is a class the user has taken within their major." +
				"If value is a 1, that is a class they've taken outside of their major." +
				"If value is a 0, that is a class in the student's major that they have not taken.");
	}
}