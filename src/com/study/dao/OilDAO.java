package com.study.dao;

import java.util.List;
import java.util.Map;

import com.study.vo.CarVO;
import com.study.vo.OilVO;

public interface OilDAO {
	public List<OilVO> selectList() throws Exception;  //전체 주유전표 보기
	public int insert(OilVO vo) throws Exception; //주유전표 등록
	public int delete(int oil_no) throws Exception; //주유전표 삭제
	public int update(OilVO vo) throws Exception; //주유전표 정보 갱신
	public OilVO selectOne(int oil_no) throws Exception; //주유전표 상세보기
	public List<OilVO> selectListV2(Map<String, Object> paramMap) throws Exception;  //전체 주유전표 보기 with 페이지 처리
	public int getCount() throws Exception;
	public String getPrimaryOilStn() throws Exception;
}
