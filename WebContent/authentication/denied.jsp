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
</head>
<body>
<jsp:include page="/Header.jsp"/>
<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    <div class="panel-heading">
<h1 class="panel-header">Access Denied</h1>
</div>

<div class="panel-body">
사내 정책에 따라, 관리자가 아니거나 외부에서 접속한 경우 데이터 조작 작업을 할 수 없습니다.<br>
관리자에게 문의하세요.<br>
</div>
<a href="listV2.do">목록으로 가기</a>
</div>
</div>
</div>
</div>
<jsp:include page="/bottom.jsp"/>
</body>
</html>