package com.study.vo;


public class OilVO {
	private int oil_no; //전표번호
	private String oil_date;
	private String car_no;
	private String compForVAT;
	private String oil_station;
	private double oil_liter;
	private int oil_fee;
	public int getOil_no() {
		return oil_no;
	}
	public void setOil_no(int oil_no) {
		this.oil_no = oil_no;
	}
	public String getOil_date() {
		return oil_date;
	}
	public void setOil_date(String oil_date) {
		this.oil_date = oil_date;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getCompForVAT() {
		return compForVAT;
	}
	public void setCompForVAT(String compForVAT) {
		this.compForVAT = compForVAT;
	}
	public double getOil_liter() {
		return oil_liter;
	}
	public void setOil_liter(double oil_liter) {
		this.oil_liter = oil_liter;
	}
	public int getOil_fee() {
		return oil_fee;
	}
	public void setOil_fee(int oil_fee) {
		this.oil_fee = oil_fee;
	}
	public String getOil_station() {
		return oil_station;
	}
	public void setOil_station(String oil_station) {
		this.oil_station = oil_station;
	}

}
