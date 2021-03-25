package com.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.annotation.Component;
import com.study.vo.RunListVO;

@Component("runlistDAO")
public class MySQLRunListDAO implements RunListDAO {
	SqlSessionFactory sqlSessionFactory;
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
	public int update(RunListVO runList) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {	
/*					t_date = #{t_date},
					car_no = #{car_no},
					car_div=#{car_div},
					t_from = #{t_from},
					t_to = #{t_to},
					fee = #{fee},
					bill = #{bill},
					measure_fee = #{measure_fee},
					commission = #{commission},
					detail = #{detail},
					client_code = #{client_code}
				WHERE t_no = #{t_no}*/
			RunListVO origin = sqlSession.selectOne("com.study.dao.RunListDAO.selectOne",runList);
			
			Map<String, Object> paramMap = new HashMap<>();
			
			if(!runList.getT_date().equals(origin.getT_date())) {
				paramMap.put("t_date", runList.getT_date());
			}
			
			if(!runList.getCar_no().equals(origin.getCar_no())) {
				paramMap.put("car_no", runList.getCar_no());
			}
			
			if(!runList.getCar_div().equals(origin.getCar_div())) {
				paramMap.put("car_div", runList.getCar_div());
			}
			
			if(!runList.getT_from().equals(origin.getT_from())) {
				paramMap.put("t_from", runList.getT_from());
			}
			
			if(!runList.getT_to().equals(origin.getT_to())) {
				paramMap.put("t_to", runList.getT_to());
			}
			
			if(runList.getFee()!= origin.getFee()) {
				paramMap.put("fee", runList.getFee());
			}
			
			if(runList.getBill()!= origin.getBill()) {
				paramMap.put("bill", runList.getBill());
			}
			
			if(runList.getMeasure_fee()!= origin.getMeasure_fee()) {
				paramMap.put("measure_fee", runList.getMeasure_fee());
			}
			
			if(runList.getCommission()!= origin.getCommission()) {
				paramMap.put("commission", runList.getCommission());
			}
			
			if(!runList.getDetail().equals(origin.getDetail())) {
				paramMap.put("detail", runList.getDetail());
			}
			
			if(runList.getClient_code()!= origin.getClient_code()) {
				paramMap.put("client_code", runList.getClient_code());
			}
			
			if(paramMap.size()>0) {
				paramMap.put("t_no", runList.getT_no());
				int count = sqlSession.update("com.study.dao.RunListDAO.update",paramMap);
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
