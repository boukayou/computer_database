<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<!-- Bootstrap -->
<link href="/cdb/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/cdb/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="/cdb/css/main.css" rel="stylesheet" media="screen">
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="dashboard.html"> Application -
				Computer Database </a>
		</div>
	</header>
	<section id="main">
		<div class="container">
			<h1 id="homeTitle">${nbrOfCompFOund}Computers found</h1>
			<div id="actions" class="form-horizontal">
				<div class="pull-left">


					<form id="searchForm" action="#" method="GET" class="form-inline">

						<input type="search" id="searchbox" name="search"
							class="form-control" placeholder="Search name" /> <input
							type="submit" id="searchsubmit" value="Filter by name"
							class="btn btn-primary" />
					</form>
				</div>

				<div class="pull-right">
					<a class="btn btn-success" id="addComputer" href="/cdb/AddComputer">Add
						Computer</a> <a class="btn btn-default" id="editComputer" href="#"
						onclick="$.fn.toggleEditMode();">Edit</a>
				</div>
			</div>
		</div>

		<form id="deleteForm" action="/cdb/DeleteComputer" method="POST">
			<input type="hidden" name="selection" value="">
		</form>

		<div class="container" style="margin-top: 10px;">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<!-- Variable declarations for passing labels as parameters -->
						<!-- Table header for Computer Name -->

						<th class="editMode" style="width: 60px; height: 22px;"><input
							type="checkbox" id="selectall" /> <span
							style="vertical-align: top;"> - <a href="#"
								id="deleteSelected" onclick="$.fn.deleteSelected();"> <i
									class="fa fa-trash-o fa-lg"></i>
							</a>
						</span></th>
						<th><a href="/cdb/Dashboard?sortBycomputer=name">Computer
								name</a></th>
						<th><a
							href="/cdb/Dashboard?sortBycomputer=introduced">Introduced
								date</a></th>
						<!-- Table header for Discontinued Date -->
						<th><a
							href="/cdb/Dashboard?sortBycomputer=discontinued">Discontinued
								date</a></th>
						<!-- Table header for Company -->
						<th><a href="/cdb/Dashboard?sortBycomputer=company.name">Company</a>
						</th>

					</tr>
				</thead>
				<!-- Browse attribute computers -->
				<tbody id="results">
					<c:forEach items="${listComputerDto}" var="computerDto">

						<tr>
							<td class="editMode"><input type="checkbox" name="cb"
								class="cb" value="${computerDto.id}"></td>
							<td><a href="/cdb/EditComputer?idComputer=${computerDto.id}"
								onclick="">${computerDto.name}</a></td>
							<td>${computerDto.introduced}</td>
							<td>${computerDto.discontinued}</td>
							<td>${computerDto.companyName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer class="navbar-fixed-bottom">
		<div class="container text-center">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach items="${listNavigation}" var="navigation">
					<li><a href="/cdb/Dashboard?page=${navigation}">${navigation}</a></li>
				</c:forEach>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>

			<div class="btn-group btn-group-sm pull-right" role="group">
				<a href="/cdb/Dashboard?nbrOfElements=10"><button type="button"
						class="btn btn-default">10</button></a> <a
					href="/cdb/Dashboard?nbrOfElements=50"><button type="button"
						class="btn btn-default">50</button></a> <a
					href="/cdb/Dashboard?nbrOfElements=100"><button type="button"
						class="btn btn-default">100</button></a>
			</div>
		</div>
	</footer>
	<script src="/cdb/js/jquery.min.js"></script>
	<script src="/cdb/js/bootstrap.min.js"></script>
	<script src="/cdb/js/dashboard.js"></script>

</body>
</html>