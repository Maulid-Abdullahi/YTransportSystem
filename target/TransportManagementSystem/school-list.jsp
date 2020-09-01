<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>School Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="hhhhhttps://www.javaguides.net" class="navbar-brand"> SCHOOL MANAGEMENT PANEL </a>
			</div>


		</nav>
	</header>
	<br>

	<div class="row">


		<div class="container">
			<h3 class="text-center">LIST OF SCHOOLS</h3>
			<hr>
			<div class="container text-left">


					<a href ="new" class="btn btn-success">ADD NEW SCHOOLS</a>
                            	&nbsp;&nbsp;&nbsp;
                       <a href="list" class="btn btn-success">List All SCHOOLS</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>PhoneNo</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="school" items="${listSchool}">

						<tr>
							<td><c:out value="${school.id}" /></td>
							<td><c:out value="${school.name}" /></td>
							<td><c:out value="${school.phoneNo}" /></td>
							<td><c:out value="${school.email}" /></td>
							<td><a href="edit?id=<c:out value='${school.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${school.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
