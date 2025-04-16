<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div>
		<h2>Welcome ${email}</h2>
		<h2>You can view books available or add new ones by clicking the links below respectively.</h2>
	</div>
	<div>
		<ul>
			<li>
				<a href="books.jsp">View Available Books</a>
			</li>
			<li>
				<a href="new-book.html">Add Book</a>
			</li>
		</ul>
	</div>
</body>
</html>