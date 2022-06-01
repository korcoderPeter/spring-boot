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
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
	

</head>
<body>

	<%@ include file="../layout/header.jsp"%>

	<div class="container">
		<form>

			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" name="title" placeholder="Enter Title"
					id="title">
			</div>



			<div class="form-group">
				<label for="comment">Comment:</label>
				<textarea class="form-control summernote" name="content" rows="5" 
					id="content"></textarea>
			</div>

		</form>
	<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>

	</div>
	<br>
	<script src="/js/user/board.js"></script>
	<%@ include file="../layout/footer.jsp"%>


</body>
</html>


