import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
		Path firstFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Courselist.txt");
		Path secondFile = Paths.get("/Users/erikayavaca/Desktop/workspace/CourseTest/src/Transcript.txt");
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

}