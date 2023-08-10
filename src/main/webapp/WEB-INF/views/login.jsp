<!DOCTYPE html>
<head>
<title>Yahoo!</title>
</head>

<body>
	<section class ="nav">
		<ul><a href="#">Braand</a>
           
            <li><a href="#paris">Home</a>
           	<li><a href="#">Students</a></li>
            <li><a href="#">SA Developers</a></li>
            <li><a href="#">Login</a></li></ul>
        </section>
	<p><font color="red"> <%= request.getAttribute("error message") %></font></p>
	<!-- form action="/BasicWeb/servelt1.do" method="GET" -->
	
	<form action="/login.do" method="post">
	<h1>Hello </h3>
	<br>name : <input name="name" type="text" /></br>
	<br>password: <input name="password" type="password" /></br>
	<br><input type="submit" /></br>
	</form>
</body>
</html>