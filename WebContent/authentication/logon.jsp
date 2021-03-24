<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
<jsp:include page="/bootstrap_include.jsp"/>
<script>
$(document).ready(function(){
	history.pushState(null,null,location.href);
	window.onpopstate=function(event){
		history.go(1);
	}
	$(".btn-primary").on("click",function(event){
		event.preventDefault();
		
		var pageInfoStash = $("#logonForm");
		pageInfoStash.attr("action","logon.do").attr("method","post");
		pageInfoStash.submit();
	});
})
</script>

</head>
<body>
<!-- <form action="logon.do" method="post">
	아이디<input type="text" name="id"><br>
	비밀번호 <input type="password" name="password"><br>
	<input type="submit" value="로그인">
</form> -->
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form id="logonForm" action="logon.do" method="get">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="id" name="id" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="password" name="password" type="password" value="">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input class="btn btn-primary btn-lg btn-block"type="submit" value="로그인">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>