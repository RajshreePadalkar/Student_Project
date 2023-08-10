package com.neebalgurukul.java;

import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Student;

public class StudentTest {
    public static void main(String[] args) {

	StudentDao stud = new StudentDao();
	Student obj = new Student();
	List<Student> studentList = new ArrayList<>();

	try {
	    // to read the table

	    studentList = stud.getStudentDetails();
	    for (Student s : studentList) {
		System.out.println(s);
	    }

	    // to add a student

	    Student toAdd = new Student("komal", "komal@gmail.com", "java", 22);
	    stud.insertDetails(toAdd, null);

	    // to update the table

	    stud.updateCourse(5, "Java");

	    // to delete a student enrty

	    stud.delete(4);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
