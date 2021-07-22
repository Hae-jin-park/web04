package com.study.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.vo.CarVO;
import com.study.vo.OilVO;

@Component("oilDAO")
public class MySQLOilDAO implements OilDAO {
	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public List<OilVO> selectList() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.study.dao.OilDAO.selectList");
		}
		finally {
			sqlSession.close();
		}
	}

	@Override
	public int insert(OilVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert("com.study.dao.OilDAO.insert",vo);
			sqlSession.commit();
			return result;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int delete(String comp_no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.delete("com.study.dao.OilDAO.delete",comp_no);
			sqlSession.commit();
			return result;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(OilVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OilVO origin = sqlSession.selectOne("com.study.dao.OilDAO.selectOne",vo);
			Map<String, Object> paramMap = new HashMap<>();
			
			if(!vo.getOil_date().equals(origin.getOil_date())) {
				paramMap.put("oil_date", vo.getOil_date());
			}
			if(!vo.getCar_no().equals(origin.getCar_no())) {
				paramMap.put("oil_date", vo.getCar_no());
			}
			if(!vo.getCompForVAT().equals(origin.getCompForVAT())) {
				paramMap.put("oil_date", vo.getCompForVAT());
			}
			if(!vo.getOil_station().equals(origin.getOil_station())) {
				paramMap.put("oil_date", vo.getOil_station());
			}
			if(!(vo.getOil_liter()==origin.getOil_liter())) {
				paramMap.put("oil_date", vo.getOil_liter());
			}
			if(!(vo.getOil_fee()==origin.getOil_fee())) {
				paramMap.put("oil_date", vo.getOil_fee());
			}
			
			if(paramMap.size()>0) {
				paramMap.put("oil_no", vo.getOil_no());
				int result = sqlSession.update("com.study.dao.OilDAO.update",paramMap);
				sqlSession.commit();
				return result;
			}else {
				return 0;
			}
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public CarVO selectOne(int oil_no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("com.study.dao.OilDAO.delete",oil_no);
		}finally {
			sqlSession.close();
		}
	}

}
