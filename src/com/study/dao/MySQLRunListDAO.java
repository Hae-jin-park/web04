package com.study.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.study.annotation.Component;
import com.study.util.Criteria;
import com.study.util.ResourceManage;
import com.study.vo.RunListVO;

@Component("runlistDAO")
public class MySQLRunListDAO implements RunListDAO {
	//Connection con;
	private DataSource dsrc;
	private Connection con;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public void setDataSource(DataSource dsrc) {
		this.dsrc = dsrc;
	}
	public List<RunListVO> selectList() throws Exception{
		//Connection con = null;
		
		try {
			
			con = dsrc.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT * FROM run_list ORDER BY t_no ASC");
			ArrayList<RunListVO> runlist = new ArrayList<RunListVO>();
			
			while(rs.next()) {
				runlist.add(new RunListVO().setT_date(rs.getString("t_date"))
						.setCar_no(rs.getString("car_no"))
						.setCar_div(rs.getString("car_div"))
						.setT_from(rs.getString("t_from"))
						.setT_to(rs.getString("t_to"))
						.setFee(rs.getInt("fee"))
						.setBill(rs.getInt("bill"))
						.setT_no(rs.getInt("t_no"))
						.setClient_code(rs.getInt("client_code"))
						.setMeasure_fee(rs.getInt("measure_fee"))
						.setCommission(rs.getInt("commission"))
						.setDetail(rs.getString("detail")));
			}
			return runlist;
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	
	public int insert(RunListVO vo) throws Exception{
		
		//PreparedStatement pst = null;
		
		try {
			con = dsrc.getConnection();
			pst = con.prepareStatement("INSERT INTO run_list (t_date,car_no,car_div,t_from,t_to,fee,bill,measure_fee,commission,detail,client_code)" + 
					"VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1,vo.getT_date());
			pst.setString(2, vo.getCar_no());
			pst.setString(3, vo.getCar_div());
			pst.setString(4, vo.getT_from());
			pst.setString(5, vo.getT_to());
			pst.setInt(6, vo.getFee());
			pst.setInt(7, vo.getBill());
			pst.setInt(8, vo.getMeasure_fee());
			pst.setInt(9, vo.getCommission());
			pst.setString(10, vo.getDetail());
			pst.setInt(11, vo.getClient_code());
			return pst.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	
	public int delete(int t_no) throws Exception{
		//PreparedStatement pst = null;
		try {	
			con = dsrc.getConnection();
			pst = con.prepareStatement("DELETE FROM run_list WHERE t_no=?");
			pst.setInt(1, t_no);
			return pst.executeUpdate();
		}catch(Exception e) {
			throw e;	
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	
	public int update(RunListVO vo, int t_no) throws Exception{
		//PreparedStatement pst = null;
		try {
			con = dsrc.getConnection();
			pst = con.prepareStatement("UPDATE run_list " + 
					"SET t_date=?, car_no=?, car_div=?, t_from=?," + 
					"t_to=?, fee=?, bill=?, measure_fee=?, commission=?, detail=?, client_code=? " + 
					"WHERE t_no=?" );
			pst.setString(1, vo.getT_date());
			pst.setString(2, vo.getCar_no());
			pst.setString(3, vo.getCar_div());
			pst.setString(4, vo.getT_from());
			pst.setString(5, vo.getT_to());
			pst.setInt(6, vo.getFee());
			pst.setInt(7, vo.getBill());
			pst.setInt(8, vo.getMeasure_fee());
			pst.setInt(9, vo.getCommission());
			pst.setString(10, vo.getDetail());
			pst.setInt(11, vo.getClient_code());
			pst.setInt(12, t_no);
			return pst.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
			System.out.println("수정성공");
		}
	}
	
	public RunListVO selectOne(int t_no) throws Exception{
		//Statement stm = null;
		//ResultSet rs = null;
		try {
			con = dsrc.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM run_list WHERE t_no="+t_no);
			//response.setContentType("text/html; charset=UTF-8");
			//RunListVO vo = null;
			if(rs.next()) {
			return new RunListVO().setT_date(rs.getString("t_date"))
					.setCar_no(rs.getString("car_no"))
					.setCar_div(rs.getString("car_div"))
					.setT_from(rs.getString("t_from"))
					.setT_to(rs.getString("t_to"))
					.setFee(rs.getInt("fee"))
					.setBill(rs.getInt("bill"))
					.setT_no(rs.getInt("t_no"))
					.setClient_code(rs.getInt("client_code"))
					.setMeasure_fee(rs.getInt("measure_fee"))
					.setCommission(rs.getInt("commission"))
					.setDetail(rs.getString("detail"));
			}else {
				throw new Exception("삭제되었거나 이동한 것 같습니다...");
			}
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	
	public List<RunListVO> listPage(int p) throws Exception{

		try {
			
			con = dsrc.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT * FROM run_list ORDER BY t_no ASC LIMIT "+p+", 10");
			ArrayList<RunListVO> runlist = new ArrayList<RunListVO>();
			if (p<=0) {
				p=1;
			}
			p = (p-1)*10;
			while(rs.next()) {
				runlist.add(new RunListVO().setT_date(rs.getString("t_date"))
						.setCar_no(rs.getString("car_no"))
						.setCar_div(rs.getString("car_div"))
						.setT_from(rs.getString("t_from"))
						.setT_to(rs.getString("t_to"))
						.setFee(rs.getInt("fee"))
						.setBill(rs.getInt("bill"))
						.setT_no(rs.getInt("t_no"))
						.setClient_code(rs.getInt("client_code"))
						.setMeasure_fee(rs.getInt("measure_fee"))
						.setCommission(rs.getInt("commission"))
						.setDetail(rs.getString("detail")));
			}
			return runlist;
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	@Override
	public List<RunListVO> listPageByCrit(Criteria crit) throws Exception {
		// TODO Auto-generated method stub
try {
			
			con = dsrc.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT * FROM run_list ORDER BY t_no ASC LIMIT "+crit.getPageStart()+", "+crit.getPerPageNum());
			ArrayList<RunListVO> runlist = new ArrayList<RunListVO>();
			while(rs.next()) {
				runlist.add(new RunListVO().setT_date(rs.getString("t_date"))
						.setCar_no(rs.getString("car_no"))
						.setCar_div(rs.getString("car_div"))
						.setT_from(rs.getString("t_from"))
						.setT_to(rs.getString("t_to"))
						.setFee(rs.getInt("fee"))
						.setBill(rs.getInt("bill"))
						.setT_no(rs.getInt("t_no"))
						.setClient_code(rs.getInt("client_code"))
						.setMeasure_fee(rs.getInt("measure_fee"))
						.setCommission(rs.getInt("commission"))
						.setDetail(rs.getString("detail")));
			}
			return runlist;
		}catch(Exception e) {
			throw e;
		}finally {
			ResourceManage.closeRes(con, st, pst, rs);
		}
	}
	@Override
	public int listTotalCount() throws Exception {
		// TODO Auto-generated method stub
		int count=0;
		con = dsrc.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("SELECT count(t_no) FROM run_list");
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
		
	}
}
