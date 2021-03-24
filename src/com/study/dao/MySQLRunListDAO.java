package com.study.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.util.Criteria;
import com.study.util.ResourceManage;
import com.study.vo.RunListVO;

@Component("runlistDAO")
public class MySQLRunListDAO implements RunListDAO {
	SqlSessionFactory sqlSessionFactory;
	//Connection con;
	private DataSource dsrc;
	private Connection con;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	public void setDataSource(DataSource dsrc) {
		this.dsrc = dsrc;
	}
	public List<RunListVO> selectList() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.MySQLRunListDAO.selectList");
		}finally {
			sqlSession.close();
		}
	}
	
	public int insert(RunListVO vo) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("com.study.dao.MySQLRunListDAO.insert");
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}
	
	public int delete(int t_no) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			int count = sqlSession.delete("com.study.dao.MySQLRunListDAO.delete",t_no);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}
	
	public int update(RunListVO vo) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			int count = sqlSession.update("com.study.dao.MySQLRunListDAO.update",vo);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}
	
	public RunListVO selectOne(int t_no) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			return sqlSession.selectOne("com.study.dao.MySQLRunListDAO.selectOne",t_no);
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<RunListVO> listPageV2(Criteria crit) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.MySQLRunListDAO.listPageV2",crit);
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public int listTotalCount() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			return sqlSession.selectOne("com.study.dao.MySQLRunListDAO.listTotalCount");
		}finally {
			sqlSession.close();
		}
	}
}
