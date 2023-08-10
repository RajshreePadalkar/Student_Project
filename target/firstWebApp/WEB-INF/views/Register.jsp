<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/register.do" method="POST">
        <fieldset>
        <h2>Registration Form</h2>
        <br>username : <input name="username" type="text" /></br>
	<br>password: <input name="password" type="password" /></br>
        
  <p>  <label for="name"> Name :

    <input type="text" name="name" placeholder="Enter name"  id="name"></label></p>
 <p><label name="emailId">Email Id:</label>
 
	<input type="email" name="email" placeholder="Enter email id" id="email" ></p>
 <p>   <label for="course"> Course :
        
    <input type="text" name="course" placeholder="Enter course" id="course" value=""></label></p>
  <p>  <label for="age"> Age :
        
    <input type="text" name="age" placeholder="Enter age" id="age" value=""></label></p>

<br><input type="submit" /></br>

    </fieldset>
    </form>