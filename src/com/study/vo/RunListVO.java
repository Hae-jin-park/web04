package com.study.vo;

import java.io.Serializable;

public class RunListVO implements Serializable {
	//운송내역 객체
	/*
	 * t_no = 운송내역 일련번호
	 * t_date = 운송날짜
	 * car_no = 차량번호, 용차가 있을 수 있으므로 c_code대신 사용
	 * car_div = 자차/용차 구분
	 * client_code = 거래처 코드(clients 테이블의 client_code를 참조)
	 * t_from = 상차지
	 * t_to = 하역지
	 * fee = 운송료
	 * bill = 계산서 발행시 청구 금액(몇몇 구간은 수수료 2만 공제)
	 * measure_fee (이전에는 weight였음) = 계근비, 측정비
	 * commission = 수수료
	 * detail = 기타사항
	 * clientVO = Clients테이블 (client_code의 값에 따라 client_name을 얻어내기 위함)
	 * 
	 * */
	private static final long serialVersionUID = 1L;
	private int t_no;
	private String t_date;
	private String car_no;
	private String car_div;
	private int client_code;
	private ClientVO clients;
	private String t_from;
	private String t_to;
	private int fee;
	private int bill;
	private int measure_fee;
	private int commission;
	private String detail;
	
	public String getT_date() {
		return t_date;
	}
	public RunListVO setT_date(String t_date) {
		this.t_date = t_date;
		return this;
	}
	public String getCar_no() {
		return car_no;
	}
	public RunListVO setCar_no(String car_no) {
		this.car_no = car_no;
		return this;
	}
	public String getCar_div() {
		return car_div;
	}
	public RunListVO setCar_div(String car_div) {
		this.car_div=car_div;
		return this;
	}
	public int getClient_code() {
		return client_code;
	}
	public RunListVO setClient_code(int client_code) {
		this.client_code = client_code;
		return this;
	}
	public String getT_from() {
		return t_from;
	}
	public RunListVO setT_from(String t_from) {
		this.t_from = t_from;
		return this;
	}
	public String getT_to() {
		return t_to;
	}
	public RunListVO setT_to(String t_to) {
		this.t_to = t_to;
		return this;
	}
	public int getFee() {
		return fee;
	}
	public RunListVO setFee(int fee) {
		this.fee = fee;
		return this;
	}
	public int getMeasure_fee() {
		return measure_fee;
	}
	public RunListVO setMeasure_fee(int measure_fee) {
		this.measure_fee = measure_fee;
		return this;
	}
	public int getCommission() {
		return commission;
	}
	public RunListVO setCommission(int commission) {
		this.commission = commission;
		return this;
	}
	public String getDetail() {
		return detail;
	}
	public RunListVO setDetail(String detail) {
		this.detail = detail;
		return this;
	}
	public ClientVO getClients() {
		return clients;
	}
	public RunListVO setClients(ClientVO clients) {
		this.clients = clients;
		return this;
	}
	public int getBill() {
		return bill;
	}
	public RunListVO setBill(int bill) {
		this.bill = bill;
		return this;
	}
	@Override
	public String toString() {
		return "RunListVO [t_date=" + t_date + ", car_no=" + car_no + ", client_code=" + client_code
				+ ", t_from=" + t_from + ", t_to=" + t_to + ", fee=" + fee + ", measure_fee=" + measure_fee
				+ ", commission=" + commission + ", detail=" + detail + ", clients=" + clients + "]";
	}
	public int getT_no() {
		return t_no;
	}
	public RunListVO setT_no(int t_no) {
		this.t_no = t_no;
		return this;
	}
}
