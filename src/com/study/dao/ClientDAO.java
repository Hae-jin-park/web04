package com.study.dao;

import java.util.List;

import com.study.vo.ClientVO;

public interface ClientDAO {
	public List<ClientVO> selectList() throws Exception;
	public int insert(ClientVO vo) throws Exception;
	public int delete(int client_code) throws Exception;
	public int update(ClientVO vo, int client_code) throws Exception;
	public ClientVO selectOne(int client_code) throws Exception;
}
