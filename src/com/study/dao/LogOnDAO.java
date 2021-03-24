package com.study.dao;

import com.study.vo.MemberVO;

public interface LogOnDAO {
	public MemberVO exist(String id, String password) throws Exception;
}
