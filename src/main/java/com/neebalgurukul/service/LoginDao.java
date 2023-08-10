package com.neebalgurukul.service;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.model.login;

public class LoginDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    DataSource ds = new DataSource();

    public List<login> getLoginDetails() throws SQLException {
	String query = "Select username, password from login";
	conn = ds.getConnection();
	List<login> loginList = new ArrayList<>();
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if (rs != null) {

		while (rs.next()) {
		    login obj = new login();
		    obj.setUname(rs.getString("username"));
		    obj.setPswd(rs.getString("password"));
		    System.out.println(obj.getUname() + ", " + obj.getPswd());
		    loginList.add(obj);
		}
	    }
	    return loginList;
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    return null;
	} finally {

	    conn.close();
	}

    }

    public login getPasswordDetails(String uname) throws Exception {
	String query = "Select Username, password from login where username=? ";
	conn = ds.getConnection();
	// List<login> loginList = new ArrayList<>();
	try {
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1, uname);
	    // stmt.setInt(2, 1);
	    ResultSet rs = stmt.executeQuery();
	    login obj = new login();
	    if (rs != null) {

		while (rs.next()) {

		    obj.setUname(rs.getString("username"));
		    obj.setPswd(rs.getString("password"));

		}
	    } else {
		throw new Exception("No record found");
	    }
	    return obj;
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    return null;
	}
    }

    public boolean insertDetails(login obj) {
	String query1 = "insert into login(username,password, lastModifiedDate, active) values(?,?,?,?)";
	conn = ds.getConnection();
	// List<login> loginList = new ArrayList<>();
	boolean loginCreated = false;
	int row = 0;
	try {

	    java.util.Date newDate = new java.util.Date();
	    java.sql.Date SDate = new java.sql.Date(newDate.getTime());
	    PreparedStatement stmt = conn.prepareStatement(query1);
	    stmt.setString(1, obj.getUname());// stmt.setDate(3, java.sql.Date.valueOf("2023-02-02"));
	    stmt.setString(2, obj.getPswd());
	    // stmt.setDate(3, java.sql.Date.valueOf(obj.setLastModified(null)));
	    stmt.setDate(3, SDate);
	    // stmt.setDate(3, java.sql.Date.valueOf("2023-02-02"));
	    stmt.setInt(4, 1);

	    row = stmt.executeUpdate();
	    if (row != 0) {
		rs = stmt.getGeneratedKeys();
	    }

	    if (rs.next()) {
		int loginId = rs.getInt(1);
		loginCreated = true;
		System.out.println("login id" + loginId);
	    }

	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());

	}
	return loginCreated;
    }

    public int HardDelete(String username) {
	String query = "delete from  login " + "where username=?";

	conn = ds.getConnection();
	int row = 0;
	try {

	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1, username);
	    row = stmt.executeUpdate();

	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	}
	return row;
    }

    public void deleteSoft(String username) throws SQLException {
	String query = "update login set active=0 where username=?";
	conn = ds.getConnection();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		System.out.println(username + " is not active");
	    } else {
		System.out.println("Can not execute the query");

	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
    }

    public boolean getUsernameDetails(String username) {
	boolean flag = false;
	String query = "SELECT * FROM students WHERE username = ?";
	conn = ds.getConnection();

	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    ResultSet rs = pstmt.executeQuery();

	    if (rs.next()) {
		flag = true;
	    }

	    rs.close();
	    pstmt.close();
	    conn.close();

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return flag;
    }

}
