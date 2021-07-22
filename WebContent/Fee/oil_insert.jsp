<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주유내역 입력</title>
<!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script><script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<jsp:include page="/bootstrap_include.jsp"/>

</head>
<body>
<jsp:include page="/Header.jsp"/>
<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
<h1 class="page-header">주유내역 입력</h1>
	<form action='oilInsert.do' method='post'>
		<div class="box-header with-border">
										<div class="col-sm-12 form-group" id="oil_date">
											<label>주유 일자</label>
											<input type="text" name="oil_date" id="datepicker" class="form-control"/>
										</div>
										<script>
        $(function() {
            //input을 datepicker로 선언
            $("#datepicker").datepicker({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                         
            });                    
            
            //초기값을 오늘 날짜로 설정
            $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
        });
    </script>
										<div class="col-sm-12 form-group">
										<label>차량번호</label>
											<select name="car_no" class="form-control">
												<c:forEach items="${car_list}" var="carVO">
													<option value="${carVO.car_fullNo}">${carVO.car_fullNo}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-sm-12 form-group">
											<label>VAT신고를 위한 사업자</label>
											<select name="compForVAT" class="form-control">
												<c:forEach items="${comp_list}" var="ass_comp">
													<option value="${ass_comp.comp_name}">${ass_comp.comp_name}</option>
												</c:forEach>
											</select>
										</div>
									<div class="col-sm-12 form-group">
										<label>주유소</label>
										<input type="text" name="oil_station" class="form-control"/>
										<button type="button" class="btn btn-info">지정주유소 자동입력</button>
									</div>
									<div class="col-sm-6 form-group">
										<label>주유량</label>
										<input type="text" name="oil_liter" class="form-control"/>
									</div>
									<div class="col-sm-6 form-group">
										<label>주유금액</label>
										<input type="text" name="oil_fee" class="form-control"/>
						</div>
			</div>
						<button type="submit" class="btn btn-info" id="addBtn">등록</button>
						<button type="button" class="btn btn-danger" onclick="location.href='oil_list.do'">취소</button>
								</form>
								</div>
							</div>
						</div>
					</div>
			<jsp:include page="/bottom.jsp"/>
</body>
</html>