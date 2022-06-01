let index = {
	init:function(){
		$("#btn-save").on("click",()=>{ // 함수를 사용하지 않은 이유 => 화살 함수를 사용해서 this를 바인딩 하기 위해서
			alert("z");
			this.save();
		});
	},
	save:function(){
		alert("z");
		let data = {
			title: $("title").val(),
			content: $("content").val(),			
		}
	$.ajax({
		// 회원가입 수행 요청 (100초 가정)
		type: "POST",
		url : "/api/board",
		data : JSON.stringify(data), // http body 데이터
		contentType : "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
		dataType : "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열 생긴게 (json이라면) => javascript
	}).done(function(resp){
		alert("글쓰기가 완료되었습니다");
		location.href = "/";
	}).fail(function(error){
		alert(JSON.stringify(error));
	}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	},
	summernote :function(){
	$('.summernote').summernote({
			placeholder : 'Hello Bootstrap 4',
			tabsize : 2,
			height : 100
		});
	}
}

$(function(){
alert("zz");
index.init();
index.summernote();	
	
});

