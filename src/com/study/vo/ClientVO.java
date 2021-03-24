package com.study.vo;

public class ClientVO {
	private int client_code;
	private String client_name;
	private String client_detail;
	private int client_use;
	public int getClient_code() {
		return client_code;
	}
	public ClientVO setClient_code(int client_code) {
		this.client_code = client_code;
		return this;
	}
	public String getClient_name() {
		return client_name;
	}
	public ClientVO setClient_name(String client_name) {
		this.client_name = client_name;
		return this;
	}
	public String getClient_detail() {
		return client_detail;
	}
	public ClientVO setClient_detail(String client_detail) {
		this.client_detail = client_detail;
		return this;
	}
	public int getClient_use() {
		return client_use;
	}
	public ClientVO setClient_use(int client_use) {
		this.client_use = client_use;
		return this;
	}
	@Override
	public String toString() {
		return "ClientVO [client_code=" + client_code + ", client_name=" + client_name + ", client_detail="
				+ client_detail + ", client_use=" + client_use + "]";
	}
	
}
