<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>Add person</h1>
	<form action="add-person">
	<label>Name:</label>
	<input type="text" name="name" /><br/>
	<label>Age:</label>
	<input type="number" name="age" /><br/>
	<input type="submit" />
	</form>
</div>
<div>
	<h1>Get person</h1>
	<form action="getPerson">
	<label>ID:</label>
	<input type="number" name="id" /><br/>
	<input type="submit" />
	</form>
</div>
</body>
</html>