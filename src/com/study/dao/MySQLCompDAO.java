package com.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.vo.CarVO;
import com.study.vo.CompVO;

@Component("compDAO")
public class MySQLCompDAO implements CompDAO {
	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public List<CompVO> selectList() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.CompDAO.selectList");
		}
		finally {
			sqlSession.close();
		}
	}

	@Override
	public int insert(CompVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int isOK = sqlSession.insert("com.study.dao.CompDAO.insert",vo);
			sqlSession.commit();
			return isOK;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int delete(String comp_no) throws Exception {
		// TODO Auto-generated method stub

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int isOK = sqlSession.delete("com.study.dao.CompDAO.delete",comp_no);
			sqlSession.commit();
			return isOK;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(CompVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CompVO origin = sqlSession.selectOne("com.study.dao.CompDAO.selectOne",vo);
			Map<String, Object> paramMap = new HashMap<>();
			
			if(!vo.getComp_name().equals(origin.getComp_name())) {
				paramMap.put("comp_name", vo.getComp_name());
			}
			if(!vo.getComp_addr().equals(vo.getComp_addr())) {
				paramMap.put("comp_addr", vo.getComp_addr());
			}
			
			if(paramMap.size()>0) {
				paramMap.put("comp_no", vo.getComp_no());
				int action = sqlSession.update("com.study.dao.CompDAO.update",paramMap);
				sqlSession.commit();
				return action;
			}else {
				return 0;
			}
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public CarVO selectOne(String comp_no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("com.study.dao.CompDAO.delete",comp_no);
		}finally {
			sqlSession.close();
		}
	}

}
