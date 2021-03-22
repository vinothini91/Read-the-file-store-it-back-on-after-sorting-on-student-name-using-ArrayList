package hello;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentConstructorToString>{

	@Override
	public int compare(StudentConstructorToString s1, StudentConstructorToString s2) {
		
		
		return s1.name.compareTo(s2.name);
	}

	
}
