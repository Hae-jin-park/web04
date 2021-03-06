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
<title>주유전표 전체목록</title>
<!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
<jsp:include page="/bootstrap_include.jsp"/>

<script>
$(document).ready(function(){
	history.pushState(null,null,location.href);
	window.onpopstate=function(event){
		history.go(1);
	}
	$(".pagination li a").on("click",function(event){
		event.preventDefault();
		var targetPage = $(this).attr("href");
		
		var pageInfoStash = $("#pageInfoStash");
		pageInfoStash.find("[name='page']").val(targetPage);
		pageInfoStash.attr("action","oil_list.do").attr("method","get");
		pageInfoStash.submit();
	});
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
                    <h1 class="page-header">주유전표 관리(시운전중... Trial Run)</h1>
                    <c:choose>
                        <c:when test="${isInternal eq true && auth_level eq 'ADMIN'}">
                        <a class="btn btn-primary" href='oilInsert.do'><span class="fa fa-plus-circle"> 주유전표 등록</span></a>
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
	<th><c:choose>
			<c:when test="${orderByCond eq 'TDATE_ASC'  || orderByCond eq null}">
				<p class="fa fa-sort-amount-asc"><a href="oil_list.do?orderByCond=TDATE_DESC">일자</a></p>
			</c:when>
			<c:when test="${orderByCond eq 'TDATE_DESC' }">
				<p class="fa fa-sort-amount-desc"><a href="oil_list.do?orderByCond=TDATE_ASC">일자</a></p>
			</c:when>
			<c:otherwise>
				<a href="oil_list.do?orderByCond=TDATE_ASC">일자</a>
			</c:otherwise>
		</c:choose></th>
	<th><p>차량번호</p></th>
	<th><p>VAT신고사업자</p></th>
	<th><p>주유소</p></th>
	<th><p>리터</p></th>
	<th><p>금액</p></th>
	<th><p>상세조회</p></th>
	<th><p>삭제?</p></th>
</tr>
<tbody>
<c:forEach var="oil_list" items="${oil_fee_list }">
	<tr id="mainTbl">
		<td><fmt:parseDate value="${oil_list.oil_date }" var="oil_date" pattern="yyyy-mm-dd"/>
		<fmt:formatDate value="${oil_date }" pattern="yyyy-mm-dd"/></td> 
		<td>${oil_list.car_no }</td> 
		<td>${oil_list.compForVAT }</td> 
		<td>${oil_list.oil_station }</td>
		<td>${oil_list.oil_liter }</td>
		<td><fmt:formatNumber value='${oil_list.oil_fee }' groupingUsed="true"/></td>
		<td><a class="btn btn-warning" href="oilUpdate.do?oil_no=${oil_list.oil_no }">상세조회</a>
		<c:choose>
			<c:when test="${isInternal eq true && auth_level eq 'ADMIN'}">
				<td><a class="btn btn-danger" href="oilDelete.do?oil_no=${oil_list.oil_no }" onclick="return confirm('정말 삭제할까요?')">[삭제]</a></td>
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
                <form id="pageInfoStash">
                	<input type="hidden" name="page" value=${pageMaker.cri.page }>
                	<input type="hidden" name="perPageNum" value=${pageMaker.cri.perPageNum }>
                	<input type="hidden" name="orderByCond" value=${orderByCond }>
                </form>
                
                <div class="text-center">
                	<ul class="pagination">
                		<c:if test="${pageMaker.prev }">
                			<li><a href="listV2.do?page=${pageMaker.startPage -1}">&laquo;</a></li>
                		</c:if>
                		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
                			<li <c:out value="${pageMaker.cri.page == idx?'class =active':'' }"/>>
                			<a href="${idx }">${idx }</a></li>
                		</c:forEach>
                		<c:if test="${pageMaker.next }">
                			<li><a href="listV2.do?page=${pageMaker.endPage +1}">&raquo;</a></li>
                		</c:if>
                	</ul>
                </div>
                
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->



<jsp:include page="/bottom.jsp"/>
</body>
</html>