<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

</head>
<body>

	<%@ include file="layout/header.jsp"%>
	<div class="container">
		<c:forEach var="board" items="${boards.content }">
			<div class="card">

				<div class="card-body">
					<h4 class="card-title">${board.title }</h4>

					<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
				</div>
			</div>
			<br>

		</c:forEach>

		<ul class="pagination justify-content-center">
		
		<c:choose>
		<c:when test="${boards.first }">
			<li class="page-item disabled"><a class="page-link"
				href="?page=${boards.number - 1 }">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link"
				href="?page=${boards.number - 1 }">Previous</a></li>
				
		</c:otherwise>
		
		</c:choose>
		
			<c:choose>
		<c:when test="${boards.last }">
			<li class="page-item disabled"><a class="page-link"
				href="?page=${boards.number + 1 }">Next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link"
				href="?page=${boards.number + 1 }">Next</a></li>
				
		</c:otherwise>
		
		</c:choose>
		


		</ul>





	</div>
	<br>
	<%@ include file="layout/footer.jsp"%>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


