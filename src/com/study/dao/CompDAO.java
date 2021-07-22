package com.study.dao;

import java.util.List;

import com.study.vo.CarVO;
import com.study.vo.CompVO;

public interface CompDAO {
	public List<CompVO> selectList() throws Exception; //운행중인 차량정보 모두 표시
	public int insert(CompVO vo) throws Exception; //차량정보 등록
	public int delete(String comp_no) throws Exception; //차량정보 삭제
	public int update(CompVO vo) throws Exception; //차량정보 갱신
	public CarVO selectOne(String comp_no) throws Exception; //차량정보 상세보기
	
}
