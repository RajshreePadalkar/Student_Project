<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.neebalgurukul.model.Student" %>
<html>
<head>
<title>Yahoo!</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Age</th>
            <th>Delete</th>
        </tr>
        <%
            java.util.List<Student> studentList = (java.util.List<Student>) request.getAttribute("student");
            for (Student stud : studentList) {
        %>
            <tr>
                <td><%= stud.getName() %></td>
                <td><%= stud.getEmail() %></td>
                <td><%= stud.getCourse() %></td>
                <td><%= stud.getAge() %></td>
                <td>
                    <form action="/deleteStudent.do" method="post">
                        <input type="hidden" name="deleteUsername" value="<%= stud.getUsername() %>">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>