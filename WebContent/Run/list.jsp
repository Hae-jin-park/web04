<%-- <%@ page import="com.study.vo.*" %>
<%@ page import="java.util.ArrayList" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>운송일보 전체목록</title>
<!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
<jsp:include page="/bootstrap_include.jsp"/>

<script>
$(document).ready(function(){
	history.pushState(null,null,location.href);
	window.onpopstate=function(event){
		history.go(1);
	}
	$("#mainTbl").on("click",".btn-warning",function())
})
</script>
</head>
<body>
<jsp:include page="/Header.jsp"/>

<%-- <jsp:useBean id="runlist"
scope="request"
class="java.util.ArrayList"
type="java.util.ArrayList<RunListVO>"/> --%>
<%-- <%

for(RunListVO vo : runlist){
%> --%>

<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    <h1 class="page-header">운송목록(시운전중... Trial Run)</h1>
                    <c:choose>
                        <c:when test="${isInternal eq true && auth_level eq 'ADMIN'}">
                        <a class="btn btn-primary" href='insert.do'><span class="fa fa-plus-circle"> 운송일보 등록</span></a>
                        <div class="panel panel-info">
	                        <div class="panel-heading">
	                        	모든 작업 가능
	                        </div>
	                        <div class="panel-body">
	                            <p>내부 네트워크 접속은 읽기/쓰기가 모두 가능합니다.</p>
	                        </div>
                    	</div>
                    	</c:when>
                        
                        <c:when test="${isInternal eq true}">
                        <a class="btn btn-primary" href='insert.do'><span class="fa fa-plus-circle"> 운송일보 등록</span></a>
                        <div class="panel panel-warning">
	                        <div class="panel-heading">
	                        	읽기 전용 모드
	                        </div>
	                        <div class="panel-body">
	                            <p>내부 네트워크 접속이지만, 관리자가 아니기 때문에 읽기만 가능합니다.</p>
	                        </div>
                    	</div>
                    	</c:when>
                        
                        <c:otherwise>
                        <a class="btn btn-primary disabled" href='insert.do'><span class="fa fa-plus-circle"> 운송일보 등록</span></a>
                        <div class="panel panel-warning">
	                        <div class="panel-heading">
	                        	<h5><span class="fa fa-warning"></span> 제한 모드 <span class="fa fa-warning"></span></h5>
	                        </div>
	                        <div class="panel-body">
	                            <p>외부 접속은 무조건 읽기만 가능합니다.</p>
	                        </div>
                    	</div>
                        </c:otherwise>
                        
                    </c:choose>
                        <table class="table table-sm table-hover">
<thead>
<tr>
<th>일자</th>
<th>차번</th>
<th>상차지</th>
<th>하역지</th>
<th>운송료</th>
<th>거래처청구</th>
<th>상세조회</th>
<th>삭제?</th>

</tr>
<tbody>
<c:forEach var="runlist" items="${runlist }">
<tr id="mainTbl">
<td>${runlist.t_date }</td> 
<td>${runlist.car_no }</td> 
<td>${runlist.t_from }</td>
<td>${runlist.t_to }</td>
<td><fmt:formatNumber value='${runlist.fee }' groupingUsed="true"/></td> 
<td><fmt:formatNumber value='${runlist.bill }' groupingUsed="true"/></td>
<td><a class="btn btn-warning" href="update.do?t_no=${runlist.t_no }">상세조회</a>
<c:choose>
	<c:when test="${isInternal eq true && auth_level eq 'ADMIN'}">
		<td><a class="btn btn-danger" href="delete.do?t_no=${runlist.t_no }" onclick="return confirm('정말 삭제할까요?')">[삭제]</a></td>
	</c:when>
	<c:otherwise>
	<style>
		.isDisabled {
	  color: currentColor;
	  cursor: not-allowed;
	  opacity: 0.5;
	  text-decoration: none;
	}
	</style>
		<td><a class="btn btn-danger disabled">삭제 불가</a></td>
	</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</tbody>
</table>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->



<jsp:include page="/bottom.jsp"/>
</body>
</html>