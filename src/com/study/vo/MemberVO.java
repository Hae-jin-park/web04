package com.study.vo;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private String authority;
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberVO setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAuthority() {
		return authority;
	}
	public MemberVO setAuthority(String authority) {
		this.authority = authority;
		return this;
	}
}
