package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentDemo {
	public static void main(String[] args) {
		try {

			File file = new File("F:/vino--programs-2021/student4.txt");

			Path path = Paths.get(file.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));

			ArrayList<StudentConstructorToString> studentlist = new ArrayList<StudentConstructorToString>();

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] studentarray = line.split(" ");

				for (int i = 0; i < studentarray.length; i++) {

					String studentdata = studentarray[i];

					String[] spliteddata = studentdata.split("-");

					String studentrollno = spliteddata[0];
					String studentname = spliteddata[1];
					String studentgender = spliteddata[2];
					String studentdob = spliteddata[3];
					
                     //create studentconstructortostring object for every student record and add it to arraylist
					
					studentlist
							.add(new StudentConstructorToString(studentrollno, studentname, studentgender, studentdob));

					line = reader.readLine();

					StudentComparator comparator = new StudentComparator(); // create studentcomparator object 

					Collections.sort(studentlist, comparator);

				}

			}

			System.out.println("AFTER SORTING STUDENT NAME");

			System.out.println(studentlist);

			OutputStream student_overwrite = new BufferedOutputStream(Files.newOutputStream(path)); // overwrite in existing file

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (StudentConstructorToString student : studentlist) {
				writer.write(student.rollno);
				writer.write("-" + student.name);
				writer.write("-" + student.gender);
				writer.write("-" + student.dob);
				writer.newLine();
			}
			writer.close();

			InputStream input = Files.newInputStream(path);
			BufferedReader student_read = new BufferedReader(new InputStreamReader(input));

			String student_line = null;
			System.out.println("READ NEW STUDENT RECORD:");
			while ((student_line = student_read.readLine()) != null) {
				System.out.println(student_line);

			}
			student_read.close();
		}

		catch (Exception e) {

		}

	}

}
