package com.neebalgurukul.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.Exception.DuplicateEmailException;
import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Student;
import com.neebalgurukul.model.login;

public class LoginService {

    public Boolean isValidUser(String name, String password) throws Exception {
	LoginDao dao = new LoginDao();
	login login = new login();

	login = dao.getPasswordDetails(name);
	if (login.getPswd().equals(password)) {
	    return true;
	}
	return false;

    }

    public Boolean userExist(String name) throws Exception {
	LoginDao dao = new LoginDao();
	login login = new login();

	return dao.getUsernameDetails(name);
    }

    public boolean addLogin(String username, String password) {
	LoginDao dao = new LoginDao();
	login login = new login(username, password);

	if (dao.insertDetails(login)) {
	    return true;
	}
	return false;
    }

    public Boolean addStudent(String name, String email, String course, int age, String username)
	    throws SQLException, DuplicateEmailException {
	StudentDao dao = new StudentDao();
	Student student = new Student(name, email, course, age);

	if (dao.insertDetails(student, username)) {
	    return true;
	}
	return false;
    }

    public List<Student> getStudentDetail(String username) throws SQLException {

	List<Student> list = null;
	StudentDao student = new StudentDao();
	try {
	    list = student.getStudentDetails();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	List<Student> listA = new ArrayList<Student>();

	for (Student st : list) {
	    if (st.getName().startsWith(username))
		listA.add(st);
	}
	return listA;

    }

    public void SetDeactive(String user) throws SQLException {
	LoginDao login = new LoginDao();
	login.deleteSoft(user);
    }

}
