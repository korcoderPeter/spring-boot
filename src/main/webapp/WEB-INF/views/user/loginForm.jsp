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
		<form action="/auth/loginProc" method="post">
		
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" name="username" placeholder="Enter username" id="username">
			</div>
			
	
			
			
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" name="password" placeholder="Enter password" id="password">
			</div>
			
			<button id="btn-login" class="btn btn-primary">로그인</button>
		</form>
	</div>
	<br>
	<!-- jquery랑 내가 만든 자바스크립트 아래에 넣어야 실행됨 
	시큐리티 로그인에서는 사용안함 
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/user/user.js"></script>
	-->
	<%@ include file="../layout/footer.jsp"%>

	
</body>
</html>
