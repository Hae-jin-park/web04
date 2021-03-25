package com.study.dao;

import java.util.List;
import java.util.Map;

import com.study.util.Criteria;
import com.study.vo.RunListVO;

public interface RunListDAO {
	public List<RunListVO> selectList() throws Exception;
	public int insert(RunListVO vo) throws Exception;
	public int delete(int t_no) throws Exception;
	public int update(RunListVO vo) throws Exception;
	public RunListVO selectOne(int t_no) throws Exception;
	public List<RunListVO> listPageV2(Map<String, Object> paramMap) throws Exception;
	public int listTotalCount() throws Exception;
}
