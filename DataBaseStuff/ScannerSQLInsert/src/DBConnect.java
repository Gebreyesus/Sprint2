import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import course.CourseList;
import course.CourseListTextScanner;

import java.util.Random;

import java.sql.*;

public class DBConnect {

	public static void main(String[] args) {

		CourseList cl = getData();
		Random randomID = new Random();

		try {
			// Establish connection and create statement
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projplanner", "root", "12345");
			Statement stmt = con.createStatement();

			for (int i = 0; i < cl.listOfCourses.size(); i++) {

				// Generate random number
				int randomNum = randomID.nextInt((999999 - 100000) + 1) + 100000;
				// Create department abrev. from course number
				String dept = cl.listOfCourses.get(i).getCoursenumber().replaceAll("[0-9]", "");

				// Change System.out.println to stmt.executeUpdate to execute SQL insert
				System.out.println("INSERT INTO coursecatalog VALUES (" + randomNum + ", '"
						+ cl.listOfCourses.get(i).getName() + "', " + cl.listOfCourses.get(i).getCredits() + ", '"
						+ cl.listOfCourses.get(i).getPrereqI() + "', '" + cl.listOfCourses.get(i).getCoursenumber()
						+ "', '" + cl.listOfCourses.get(i).getOfferedIn() + "', '"
						+ cl.listOfCourses.get(i).getDescription() + "', '" + dept + "')");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static CourseList getData() {
		try {
			File file = new File("RequirementText/Requirements.txt"); // File containing good text to read in
			Scanner scanner = new Scanner(file);
			CourseList clts = new CourseList(true); // although sloppy, a bool in the constructor calls the empty
													// constructor
			CourseListTextScanner.AddListOfCourse(scanner, clts);
			String actual = ""; // actual string

			for (int i = 0; i < clts.listOfCourses.size(); i++) { // for every couse in the list of courses
				actual += clts.listOfCourses.get(i).getName(); // append the name of the course
				if (i + 1 != clts.listOfCourses.size()) { // if NOT the last course in the listOfCourses
					actual += ", "; // append this
				}
			}
			return clts;

		} catch (FileNotFoundException e) {
			System.out.println("File not found, Scanner can't be made for test");
			return null;
		}

	}
}