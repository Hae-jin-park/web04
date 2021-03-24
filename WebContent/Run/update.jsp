<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>운송일보 입력</title>
<!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
<jsp:include page="/bootstrap_include.jsp"/>

</head>
<body>
<jsp:include page="/Header.jsp"/>

<%-- <%
RunListVO runVO = (RunListVO)request.getAttribute("runVO");
 %> --%>
 <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
<h1  class="page-header">운송일보 상세조회 및 수정</h1>
	<form action='update.do' method='post'>
		<div class="box-header with-border">
		<input type="hidden" readonly="readonly" value='${runVO.t_no }' name="t_no">
									<div class="form-group">
										<label for="t_date">운송일자</label>
										<div class="input-group date">
											<input type="text" name="t_date" id="datepicker" value='${runVO.t_date }' class="form-control" placeholder="운송일자를 입력하세요."><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										</div>
										
									</div>
									<div class="form-group">
										<label>자차/용차 구분</label>
										
										<div class="form-group">
											<select name="car_div" id="car_div" class="form-control">
												<option value="자차">자차</option>
												<option value="용차">용차</option>
											</select>
											<script>
											$(document).ready(function(){
												var car_div_value = '${runVO.car_div }'
												if(car_div_value=="자차"){
													$("#car_div option:eq(0)").prop("selected",true);
													$("#myCar").show();
													$("#myCar select").attr("disabled",false);
													$("#extCar").hide();
													$("#extCar input").attr("disabled",true);
												}else if(car_div_value=="용차"){
													$("#car_div option:eq(1)").prop("selected",true);
													$("#myCar").hide();
													$("#myCar select").attr("disabled",true);
													$("#extCar").show();
													$("#extCar input").attr("disabled",false);
												}
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
										</div>
										<div class="form-group" id="carArea">
											<div class="form-group" id="myCar">
												<label for="exampleInput3">차량번호</label>
												<select name="car_no" class="form-control">
													<c:forEach items="${car_list}" var="carVO">
													<c:choose>
														<c:when test="${carVO.car_no eq runVO.car_no}">
															<option value="${carVO.car_no}" selected="selected">${carVO.car_fullNo}</option>
														</c:when>
														<c:otherwise>
															<option value="${carVO.car_no}">${carVO.car_fullNo}</option>
														</c:otherwise>
													</c:choose>
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
									<div class="form-group">
										<label for="client_code">거래처코드</label>
										<select class="form-control" name="client_code"><option value="--">--</option>
						                    <c:forEach items="${client_list}" var="clientVO">
						                    	<c:choose>
							                    	<c:when test="${runVO.client_code eq clientVO.client_code }">
							                    		<option value="${clientVO.client_code }" selected="selected">${clientVO.client_name}</option>
							                    	</c:when>
							                    	<c:otherwise>
							                    		<option value="${clientVO.client_code }">${clientVO.client_name}</option>
							                    	</c:otherwise>
						                    	</c:choose>
						                    </c:forEach>        
						                </select>
						                <input type="text" name="client_code" value='${runVO.client_code }'>
									</div>
									
									<div class="col-sm-6">
										<div class="form-group">
										<label for="t_from">상차지</label>
										<input type="text" name="t_from" class="form-control" value='${runVO.t_from }' placeholder="상차지를 입력하세요.">
										</div>
									</div>
									<div class="col-sm-6">
									<div class="form-group">
									
										<label for="t_to">하차지</label>
										<input type="text" name="t_to" class="form-control" value='${runVO.t_to }' placeholder="하차지를 입력하세요.">
									</div>
									</div>
									<div class="form-group">
										<label for="fee">운송료</label>
										<input type="text" name="fee" class="form-control" value='${runVO.fee }' placeholder="운송료를 입력하세요.">
									</div>
									<div class="form-group">
										<label for="bill">거래처 청구금액</label>
										<input type="text" name="bill" class="form-control" value='${runVO.bill }' placeholder="거래처에 청구할 금액을 입력하세요">
									</div>
									</div>
								</div>
								
								<div class="box box-success">
									<div class="box-header with-border">
								<div class="form-group">
									<label for="measure_fee">계근비</label>
									<input type="text" name="measure_fee" class="form-control" value='${runVO.measure_fee }' placeholder="계근비를 입력하세요.(발생할 경우)">
								</div>
								<div class="form-group">
									<label for="commission">수수료</label>
									<input type="text" name="commission" class="form-control" value='${runVO.commission }' placeholder="수수료를 입력하세요 (김봉규 건의 경우)">
								</div>
								<div class="form-group">
									<label for="detail">비고</label>
									<textarea name="detail" class="form-control" rows="10" cols="100" placeholder="기타사항을 입력하세요.(선택사항, 단발거래처의 경우 가능한 많은 정보를 입력하세요.)">${runVO.detail }</textarea>
								</div>
								</div>
							</div>
								<c:choose>
								<c:when test="${isInternal eq true}">
									<button type="submit" class="btn btn-warning" id="addRunBtn">수정</button>
									<button type="button" class="btn btn-danger" onclick="confirm_delete()">삭제</button>
									<script>
										function confirm_delete(){
											if(confirm('정말 삭제할까요?')){
												location.href='delete.do?t_no=${runVO.t_no }'
											}else{
												
											}
										}
										$("#btn btn-danger").click(function(){
											confirm('정말 삭제할까요?')
										});
									</script>
								</c:when>
								</c:choose>
								<button type="button" class="btn btn-info" onclick="location.href='listV2.do'" data-dismiss="modal">목록으로 돌아가기</button>
								</form>
								</div>
								</div>
								</div>
								</div>
<jsp:include page="/bottom.jsp"/>
</body>
</html>