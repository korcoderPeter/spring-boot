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
	
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
</head>
<body>

	<%@ include file="../layout/header.jsp"%>
	<div class="container">
		<form>
		
			<div class="form-group">
				<label for="username">Username address:</label> <input type="text"
					class="form-control" placeholder="Enter username" id="username">
			</div>
			
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email">
			</div>
			
			
			
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="password">
			</div>
			
		</form>
			<button id="btn-save" class="btn btn-primary">회원가입완료</button>
	</div>
	<br>
	<!-- jquery랑 내가 만든 자바스크립트 아래에 넣어야 실행됨 -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/user/user.js"></script>
	<%@ include file="../layout/footer.jsp"%>


</body>
</html>
