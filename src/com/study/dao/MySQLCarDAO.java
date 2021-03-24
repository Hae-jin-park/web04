package com.study.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import com.study.util.ResourceManage;
import com.study.vo.CarVO;

public class MySQLCarDAO implements CarDAO {
	private DataSource dsrc;
	private Connection con;
	private Statement st = null;
	private ResultSet rs = null;
	
	
	public void setDataSource(DataSource dsrc) {
		this.dsrc = dsrc;
	}
	@Override
	public List<CarVO> selectList() throws Exception {
		// TODO Auto-generated method stub
		try {
			con = dsrc.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM car_list");
			ArrayList<CarVO> cars = new ArrayList<>();
			while(rs.next()) {
				cars.add(new CarVO().setCar_fullNo(rs.getString("full_no"))
						.setCar_no((rs.getString("car_no"))));
			}
			return cars;
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, null, rs);
		}
		
	}

	@Override
	public int insert(CarVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int t_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CarVO vo, int t_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CarVO selectOne(int t_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
