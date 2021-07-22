package com.study.dao;

import java.util.List;

import com.study.vo.CarVO;
import com.study.vo.CompVO;
import com.study.vo.OilVO;

public interface OilDAO {
	public List<OilVO> selectList() throws Exception;  //전체 주유전표 보기
	public int insert(OilVO vo) throws Exception; //주유전표 등록
	public int delete(String comp_no) throws Exception; //주유전표 삭제
	public int update(OilVO vo) throws Exception; //주유전표 정보 갱신
	public CarVO selectOne(int oil_no) throws Exception; //주유전표 상세보기
	
}
