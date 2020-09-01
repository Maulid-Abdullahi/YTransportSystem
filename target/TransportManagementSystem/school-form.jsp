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
style="background-color: #006A4E">
			<div>
				<a href="hhhhhttps://www.javaguides.net" class="navbar-brand"> SCHOOL MANAGEMENT PANEL</a>
			</div>

			<ul class="navbar-nav">
			<li><a href="new"
            	class="nav-link">ADD NEW SCHOOLS</a></li>
				<li><a href="list"
					class="nav-link">List All Schools</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${school != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${school == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${school != null}">
            			Edit School
            		</c:if>
						<c:if test="${school == null}">
            			Add New School
            		</c:if>
					</h2>
				</caption>

				<c:if test="${school != null}">
					<input type="hidden" name="id" value="<c:out value='${school.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>School Name</label> <input type="text"
						value="<c:out value='${school.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>School PhoneNo</label> <input type="text"
						value="<c:out value='${school.phoneNo}' />" class="form-control"
						name="phoneNo">
				</fieldset>
				<fieldset class="form-group">
                					<label>School Email</label> <input type="text"
                						value="<c:out value='${school.email}' />" class="form-control"
                						name="email">
                				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
