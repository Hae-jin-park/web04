<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>운송일보 입력</title>
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
<h1 class="page-header">운송일보 등록</h1>
	<form action='insert.do' method='post'>
		<div class="box-header with-border">
									<div class="form-group">
										<label for="t_date">운송일자</label>
										<div class="input-group date">
											<input type="text" name="t_date" id="datepicker" class="form-control" placeholder="운송일자를 입력하세요."><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
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
									</div>
									<div class="form-group">
										
										<div class="col-sm-6 form-group" id="car_div">
										<label>자차/용차 구분</label>
											<select name="car_div" class="form-control">
												<option value="자차">자차</option>
												<option value="용차">용차</option>
											</select>
										</div>
										<script>
											$(document).ready(function(){
												$("#myCar").show();
												$("#myCar select").attr("disabled",false);
												$("#extCar").hide();
												$("#extCar input").attr("disabled",true);
												$("select[name=car_div]").change(function(){
													if($(this).val()=="자차"){
														$("#myCar").show();
														$("#myCar select").attr("disabled",false);
														$("#extCar").hide();
														$("#extCar input").attr("disabled",true);
													}else if($(this).val()=="용차"){
														$("#myCar").hide();
														$("#myCar select").attr("disabled",true);
														$("#extCar").show();
														$("#extCar input").attr("disabled",false);
													}
												});
											});
											</script>
										<div class="col-sm-6 form-group" id="carArea">
											<div class="form-group" id="myCar">
												<label for="exampleInput3">차량번호</label>
												<select name="car_no" class="form-control">
													<c:forEach items="${car_list}" var="carVO">
														<option value="${carVO.car_no}">${carVO.car_fullNo}</option>
													</c:forEach>
												</select>
												
											</div>
											<div class="form-group" id="extCar">
												<label for="car_no">용차번호</label>
												<input type="text" class="form-control" name="car_no">
											</div>
										</div>
									</div>
									</div>
									<div class="box box-success">
									<div class="box-header with-border">
									<div class="col-sm-12 form-group">
										<label for="client_code">거래처명</label>
										<select class="form-control" name="client_code">
						                    <option value="--">--</option>
						                    <c:forEach items="${client_list}" var="clientVO">
						                    	<option value="${clientVO.client_code }">${clientVO.client_name}</option>
						                    </c:forEach>        
						                </select>
									</div>
									
									<div class="col-sm-6 form-group">
										<!-- <div class="form-group"> -->
										<label for="t_from">상차지</label>
										<input type="text" name="t_from" class="form-control" placeholder="상차지를 입력하세요.">
										<!--  </div>-->
									</div>
									<div class="col-sm-6 form-group">
									
										<label for="t_to">하차지</label>
										<input type="text" name="t_to" class="form-control" placeholder="하차지를 입력하세요.">
									
									</div>
									<div class="form-group">
										<label for="fee">운송료</label>
										<input type="text" name="fee" class="form-control" placeholder="운송료를 입력하세요.">
									</div>
									<div class="form-group">
										<label for="bill">거래처 청구금액</label>
										<input type="text" name="bill" class="form-control" placeholder="거래처에 청구할 금액을 입력하세요">
									</div>
									</div>
								</div>
								
								<div class="box box-success">
									<div class="box-header with-border">
								<div class="form-group">
									<label for="measure_fee">계근비</label>
									<input type="text" name="measure_fee" class="form-control" placeholder="계근비를 입력하세요.(발생할 경우)" value=0>
								</div>
								<div class="form-group">
									<label for="commission">수수료</label>
									<input type="text" name="commission" class="form-control" placeholder="수수료를 입력하세요 (김봉규 건의 경우)"value=0>
								</div>
								<div class="form-group">
									<label for="detail">비고</label>
									<textarea name="detail" class="form-control" rows="10" cols="100" placeholder="기타사항을 입력하세요.(선택사항, 단발거래처의 경우 가능한 많은 정보를 입력하세요.)"></textarea>
								</div>
								</div>
							</div>
								<button type="submit" class="btn btn-info" id="addRunBtn">등록</button>
						<button type="button" class="btn btn-danger" onclick="location.href='listV2.do'" data-dismiss="modal">취소</button>
								</form>
								</div>
								</div>
								</div>
								</div>
								<jsp:include page="/bottom.jsp"/>
</body>
</html>