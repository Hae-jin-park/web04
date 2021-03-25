package com.study.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public List<RunListVO> selectList() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.RunListDAO.selectList");
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int insert(RunListVO vo) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("com.study.dao.RunListDAO.insert",vo);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int delete(int t_no) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			int count = sqlSession.delete("com.study.dao.RunListDAO.delete",t_no);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(RunListVO vo) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			int count = sqlSession.update("com.study.dao.RunListDAO.update",vo);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public RunListVO selectOne(int t_no) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			return sqlSession.selectOne("com.study.dao.RunListDAO.selectOne",t_no);
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<RunListVO> listPageV2(Map<String, Object> paramMap) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.RunListDAO.listPageV2",paramMap);
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public int listTotalCount() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
			return sqlSession.selectOne("com.study.dao.RunListDAO.listTotalCount");
		}finally {
			sqlSession.close();
		}
	}
}
