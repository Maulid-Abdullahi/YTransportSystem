<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: yellow">
			<div>
				<a href="hhhhhttps://www.javaguides.net" class="navbar-brand"> STUDENT MANAGEMENT PANEL </a>
			</div>


		</nav>
	</header>
	<br>

	<div class="row">


		<div class="container">
			<h3 class="text-center">LIST OF STUDENTS</h3>
			<hr>
			<div class="container text-left">


					<a href ="new" class="btn btn-success">ADD NEW STUDENTS</a>
                            	&nbsp;&nbsp;&nbsp;
                       <a href="lists" class="btn btn-success">List All STUDENTS</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>RegNo</th>
						<th>School</th>
						<th>StudentInTrip</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="student" items="${listStudents}">

						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.name}" /></td>
							<td><c:out value="${student.regNo}" /></td>
							<td><c:out value="${student.school}" /></td>
							<td><c:out value="${student.studentInTrip}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
