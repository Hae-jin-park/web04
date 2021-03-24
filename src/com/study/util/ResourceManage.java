package com.study.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ResourceManage {
	public static void closeRes(Connection con, Statement st, PreparedStatement pst, ResultSet rs) {
		try {if (rs!=null) rs.close();}catch(Exception e) {}
		try {if (st!=null) st.close();}catch(Exception e) {}
		try {if(pst!=null) pst.close(); }catch(Exception e) {}
		try{if(con!=null) con.close();}catch(Exception e){}
	}
}
