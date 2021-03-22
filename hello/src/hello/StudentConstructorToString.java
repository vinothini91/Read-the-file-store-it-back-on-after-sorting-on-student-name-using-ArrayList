package hello;

public class StudentConstructorToString {

	String rollno;
	String name;
	String gender;
	String dob;

	public String toString() {

		 return " " + this.rollno +"-"+ this.name +"-" +this.gender +"-"+ this.dob;
		//return " " + this.name;
	}

	public StudentConstructorToString(String rollno, String name, String gender, String dob) {
		this.rollno = rollno;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}

}
