package com.study.dao;

import java.util.List;

import com.study.vo.CarVO;

public interface CarDAO {
	public List<CarVO> selectList() throws Exception; //운행중인 차량정보 모두 표시
	public int insert(CarVO vo) throws Exception; //차량정보 등록
	public int delete(int t_no) throws Exception; //차량정보 삭제
	public int update(CarVO vo, int t_no) throws Exception; //차량정보 갱신
	public CarVO selectOne(int t_no) throws Exception; //차량정보 상세보기
	
}
