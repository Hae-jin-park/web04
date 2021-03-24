package com.study.controllers;

import java.net.http.HttpRequest;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.LogOnDAO;
import com.study.vo.MemberVO;

@Component("/authentication/logon.do")
public class LogonController implements Controller, DataBinding {
	private LogOnDAO logonDAO;
	
	public LogonController setLogOnDAO(LogOnDAO logonDAO) {
		this.logonDAO=logonDAO;
		return this;
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		if(model.get("id")!=null) {
			MemberVO vo = logonDAO.exist((String) model.get("id"), (String) model.get("password"));
			if(vo!=null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", vo);
				return "redirect:../Run/listV2.do";
			}
			else {
				return "/authentication/logonFail.jsp";
			}
		}else {
			return "/authentication/logon.jsp";
		}
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"id",String.class,
				"password",String.class,
				"member", com.study.vo.MemberVO.class
		};
	}

}
