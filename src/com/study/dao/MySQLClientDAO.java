package com.study.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.study.util.ResourceManage;
import com.study.vo.ClientVO;

public class MySQLClientDAO implements ClientDAO {
	private DataSource ds;
	private Connection con;
	private Statement st = null;
	private ResultSet rs = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public List<ClientVO> selectList() throws Exception {
		// TODO Auto-generated method stub
		try {
			con = ds.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clients ORDER BY client_code ASC");
			List<ClientVO> client_list = new ArrayList<ClientVO>();
			while(rs.next()) {
				client_list.add(new ClientVO().setClient_code(rs.getInt("client_code"))
						.setClient_name(rs.getString("client_name"))
						.setClient_detail(rs.getString("client_detail"))
						.setClient_use(rs.getInt("client_use")));
			}
			return client_list;
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, null, rs);
		}
		
	}

	@Override
	public int insert(ClientVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int client_code) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ClientVO vo, int client_code) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ClientVO selectOne(int client_code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
