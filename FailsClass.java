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
import java.util.*;

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
		//Path firstFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Courselist.txt");
		//Path secondFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Transcript.txt");
		String args1 = args[0];
		String args2 = args[1];
		Map<String, Integer> abbreviations = new HashMap<>();
		Map<String, Integer> courses = new HashMap<>();
		fillAbbrev(abbreviations);
		List<String> firstFileContent = Files.readAllLines(firstFile, Charset.defaultCharset());
		List<String> secondFileContent = Files.readAllLines(secondFile, Charset.defaultCharset());
		System.out.println("Still need these course: " + diffFiles(firstFileContent, secondFileContent));
	}

	public static List<String> diffFiles(final List<String> firstFileContent, final List<String> secondFileContent)
	{
		List<String> diff = new ArrayList<String>();
		for (String line : firstFileContent) {
			if (!secondFileContent.contains(line)) {
				diff.add(line);
			}
		}
		return diff;
	}

	/*
	* This function manually adds all of the available abbreviations from the
	* university to cross check with the file we are reading in
	* @param hm is the hashmap for the abbreviated courses in the university's catalog
	*/
	public static void fillAbbrev(Map<String, Integer> hm) {
		hm.put(CSC, 0);
		hm.put(MAT, 0);
		hm.put(ENL, 0);
		hm.put(AIS, 0);
		hm.put(COM, 0);
		hm.put(PSY, 0);
		hm.put(ANT, 0);
		hm.put(CCS, 0);
		hm.put(SOC, 0);
		hm.put(THR, 0);
		hm.put(WST, 0);
		hm.put(POL, 0);
		hm.put(ART, 0);
		hm.put(HIS, 0);
		hm.put(ECO, 0);
		hm.put(PHI, 0);
		hm.put(BUS, 0);
		hm.put(FIN, 0);
		hm.put(BIO, 0);
		hm.put(HPE, 0);
		hm.put(EDC, 0);
		hm.put(EED, 0);
		hm.put(CHM, 0);
		hm.put(SPE, 0);
		hm.put(SWK, 0);
		hm.put(ENV, 0);
		hm.put(PHY, 0);
		hm.put(HON, 0);
		hm.put(KEY, 0);
		hm.put(MIS, 0);
		hm.put(MKT, 0);
		hm.put(HUM, 0);
		hm.put(RLN, 0);
		hm.put(THR, 0);
		hm.put(MUS, 0);
		hm.put(SPA, 0);
		hm.put(MUE, 0);
		hm.put(ACC, 0);
		hm.put(SCI, 0);
		hm.put(NUR, 0);
		hm.put(NMS, 0);
		hm.put(FLM, 0);
		hm.put(THP, 0);
		hm.put(URB, 0);
		hm.put(YST, 0);

	}

	/*
    * This function uses a TreeMap to sort the hashmap alphabetically
    * @param Map <K,V> hm is the hashmap to be sorted
    */ 
    public static TreeMap sortByKey(Map<String, Integer> hm) {

        // Create a new TreeMap called sorted
        TreeMap<String, Integer> sorted = new TreeMap<>();

        // Copy data from the hash map into the TreeMap, which will sort the map alphabetically
        sorted.putAll(hm);
        return(sorted);

    }

}