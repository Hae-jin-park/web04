package com.study.vo;

import java.util.Date;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private String authority;
	private Date cre_date;
	private Date mod_date;
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
	public Date getCre_date() {
		return cre_date;
	}
	public MemberVO setCre_date(Date cre_date) {
		this.cre_date = cre_date;
		return this;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public MemberVO setMod_date(Date mod_date) {
		this.mod_date = mod_date;
		return this;
	}
}
