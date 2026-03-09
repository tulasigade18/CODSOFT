package Internship;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
	String name;
	int roll;
	String grade;

	Student(String name, int roll, String grade) {
		this.name = name;
		this.roll = roll;
		this.grade = grade;
	}

	public String toString() {
		return roll + "," + name + "," + grade;
	}
}

public class StudentManagementSystem {
	static ArrayList<Student> students = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static final String FILE = "students.txt";

	public static void main(String[] args) {

		loadFromFile();

		while (true) {
			System.out.println("******* Student Management System *******");
			System.out.println("1. Add Student");
			System.out.println("2. Edit Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Search Student");
			System.out.println("5. Display All");
			System.out.println("6. Exit");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				addStudent();
				break;
			case 2:
				editStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				searchStudent();
				break;
			case 5:
				displayStudents();
				break;
			case 6:
				saveToFile();
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	static void addStudent() {
		System.out.print("Enter Roll Number: ");
		int roll = sc.nextInt();
		sc.nextLine();

		if (findStudent(roll) != null) {
			System.out.println("Roll number already exists!");
			return;
		}

		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		if (name.isEmpty()) {
			System.out.println("Name cannot be empty!");
			return;
		}

		System.out.print("Enter Grade: ");
		String grade = sc.nextLine();

		students.add(new Student(name, roll, grade));
		saveToFile();
		System.out.println("Student added successfully!");
	}

	static void editStudent() {
		System.out.print("Enter Roll Number to edit: ");
		int roll = sc.nextInt();
		sc.nextLine();

		Student s = findStudent(roll);
		if (s == null) {
			System.out.println("Student not found!");
			return;
		}

		System.out.print("Enter New Name: ");
		s.name = sc.nextLine();

		System.out.print("Enter New Grade: ");
		s.grade = sc.nextLine();

		saveToFile();
		System.out.println("Student updated!");
	}

	static void deleteStudent() {
		System.out.print("Enter Roll Number to delete: ");
		int roll = sc.nextInt();

		Student s = findStudent(roll);
		if (s != null) {
			students.remove(s);
			saveToFile();
			System.out.println("Student deleted!");
		} else {
			System.out.println("Student not found!");
		}
	}

	static void searchStudent() {
		System.out.print("Enter Roll Number to search: ");
		int roll = sc.nextInt();

		Student s = findStudent(roll);
		if (s != null) {
			System.out.println("Found: " + s.roll + " " + s.name + " " + s.grade);
		} else {
			System.out.println("Student not found!");
		}
	}

	static void displayStudents() {
		if (students.isEmpty()) {
			System.out.println("No students available.");
			return;
		}

		for (Student s : students) {
			System.out.println(s.roll + " | " + s.name + " | " + s.grade);
		}
	}

	static Student findStudent(int roll) {
		for (Student s : students) {
			if (s.roll == roll)
				return s;
		}
		return null;
	}

	static void saveToFile() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(FILE));
			for (Student s : students) {
				pw.println(s);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error saving file.");
		}
	}

	static void loadFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				students.add(new Student(data[1], Integer.parseInt(data[0]), data[2]));
			}
			br.close();  
		} catch (Exception e) {
			// File may not exist first time
		}
	}

}
