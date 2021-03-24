package com.study.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	private String url;
	private String username;
	private String password;
	private ArrayList<Connection> conList = new ArrayList<Connection>();
	
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		this.password = password;
		
		Class.forName(driver);
	}
	
	public Connection getConnection() throws Exception{
		if (conList.size()>0){
			Connection con = conList.get(0);
			if(con.isValid(10)) {
				return con;
			}
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	public void returnConnection(Connection con) throws Exception{
		conList.add(con);
	}
	
	public void closeAll() {
		for(Connection con : conList) {
			try {con.close();}catch(Exception e) {}
		}
	}
}
