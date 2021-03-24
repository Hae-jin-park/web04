package com.study.dao;

import java.util.List;

import com.study.util.Criteria;
import com.study.vo.RunListVO;

public interface RunListDAO {
	public List<RunListVO> selectList() throws Exception;
	public int insert(RunListVO vo) throws Exception;
	public int delete(int t_no) throws Exception;
	public int update(RunListVO vo) throws Exception;
	public RunListVO selectOne(int t_no) throws Exception;
	public List<RunListVO> listPageV2(Criteria crit) throws Exception;
	public int listTotalCount() throws Exception;
}
