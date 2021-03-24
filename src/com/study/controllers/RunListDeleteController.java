package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.RunListDAO;
import com.study.vo.MemberVO;

@Component("/Run/delete.do")
public class RunListDeleteController implements Controller, DataBinding {
	private RunListDAO runDAO;
	
	public RunListDeleteController setRunListDAO(RunListDAO runDAO) {
		this.runDAO = runDAO;
		return this;
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = (HttpSession) model.get("session");
		boolean isInternal = (Boolean)model.get("isInternal");
		String abnormalAcc = (String) model.get("strReferer");
		MemberVO vo = (MemberVO) session.getAttribute("member");
		if(vo!=null) {
			if(isInternal && vo.getAuthority().equals("ADMIN") && abnormalAcc!=null) {  //내부 접속이고, ADMIN권한이며, 비정상접근이 아니면 삭제처리
				runDAO.delete((Integer) model.get("t_no"));
				return "redirect:listV2.do";
			}else if(abnormalAcc==null) {  // 비정상접근이면 오류페이지 표시.
				return "../abnormalAccess.jsp";
			}else{  //아니면 접근 거부(내부 접속인데 ADMIN이 아니거나, ADMIN인데 외부 접속이면)
				
				return "/authentication/denied.jsp";
			}
		}else { //로그인 정보가 없으면...
			return "redirect:../authentication/logon.do";
		}
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"t_no", Integer.class
		};
	}

}
