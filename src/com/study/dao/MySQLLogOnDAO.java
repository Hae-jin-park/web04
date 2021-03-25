package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.util.ResourceManage;
import com.study.vo.MemberVO;

@Component("logonDAO")
public class MySQLLogOnDAO implements LogOnDAO {
	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	public MemberVO exist(String id, String password) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Map<String, Object> params=new HashMap<>();
			params.put("id", id);
			params.put("password", password);
			return sqlSession.selectOne("com.study.dao.LogOnDAO.exist",params);
		}finally {
			sqlSession.close();
		}
			
	}
}
