package com.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.vo.MemberVO;
import com.study.vo.RunListVO;

@Component("logonDAO")
public class MySQLLogOnDAO implements LogOnDAO {
	SqlSessionFactory sqlSessionFactory;
	private final String daoPath = "com.study.dao.LogOnDAO";
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	public MemberVO exist(String id, String password, String isLogonForm) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Map<String, Object> params=new HashMap<>();
			params.put("id", id);
			params.put("password", password);
			params.put("isLogonForm", isLogonForm);
			return sqlSession.selectOne(daoPath+".exist",params);
		}finally {
			sqlSession.close();
		}
			
	}
	@Override
	public int update(Map<String, Object> paramMap, MemberVO member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// TODO Auto-generated method stub
		MemberVO origin = sqlSession.selectOne(daoPath+".exist",paramMap);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		try {
			if(!member.getName().equals(origin.getName())) {
				resultMap.put("name", member.getName());
			}
			
			if(!member.getPassword().equals(origin.getPassword())) {
				resultMap.put("password", member.getPassword());
			}
			
			if(!member.getEmail().equals(origin.getEmail())) {
				resultMap.put("email", member.getEmail());
			}
			
			if(!member.getAuthority().equals(origin.getAuthority())) {
				resultMap.put("authority", member.getAuthority());
			}
			
			if(resultMap.size()>0) {
				resultMap.put("id", member.getId());
				int count = sqlSession.update(daoPath+".update",resultMap);
				sqlSession.commit();
				return count;
			}else {
				return 0;
			}
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public int signIn(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<MemberVO> showAllMember() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(daoPath+".showAllMember");
		}finally {
			sqlSession.close();
		}
	}
}
