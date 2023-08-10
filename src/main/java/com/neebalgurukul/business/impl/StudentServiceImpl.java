package com.neebalgurukul.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.business.StudentAPI;
import com.neebalgurukul.model.Student;

public class StudentServiceImpl {
    StudentAPI studentAPI;

    public StudentServiceImpl(StudentAPI studentAPI) {
	this.studentAPI = studentAPI;
    }

    public List<Student> getStudentStartwithA() {

	List<Student> list = studentAPI.getAllStudents();
	List<Student> listA = new ArrayList<Student>();

	for (Student st : list) {
	    if (st.getName().startsWith("A"))
		listA.add(st);
	}
	return listA;

    }

}
