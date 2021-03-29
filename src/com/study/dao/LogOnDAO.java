package com.study.dao;

import java.util.List;
import java.util.Map;

import com.study.vo.MemberVO;

public interface LogOnDAO {
	public MemberVO exist(String id, String password, String isLogonForm) throws Exception;  //로그인 체크, 회원 상세조회 작업. isLogonForm의 값에 따라 if 태그로 분기.
	public int update(Map<String, Object> paramMap, MemberVO member) throws Exception;  //회원정보 수정 작업
	public int signIn(MemberVO member) throws Exception; //회원정보 등록 작업
	public List<MemberVO> showAllMember() throws Exception; //회원정보 모두 보여주는 작업
}
