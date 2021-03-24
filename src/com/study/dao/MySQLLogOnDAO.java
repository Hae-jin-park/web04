package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.study.annotation.Component;
import com.study.util.ResourceManage;
import com.study.vo.MemberVO;

@Component("logonDAO")
public class MySQLLogOnDAO implements LogOnDAO {
	private DataSource dsrc;
	private Connection con;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	public void setDataSource(DataSource dsrc) {
		this.dsrc = dsrc;
	}
	public MemberVO exist(String id, String password) throws Exception{
		try {
			con = dsrc.getConnection();
			pst = con.prepareStatement("SELECT * FROM member WHERE id=? AND password=?");
			pst.setString(1, id);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new MemberVO().setId(rs.getString("id"))
						.setName(rs.getString("name"))
						.setPassword(rs.getString("password"))
						.setEmail(rs.getString("email"))
						.setAuthority(rs.getString("authority"));
			}else {
				return null;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, pst, pst, rs);
		}
	}
}
