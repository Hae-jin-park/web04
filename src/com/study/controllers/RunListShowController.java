package com.study.controllers;

import java.net.http.HttpRequest;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.RunListDAO;
import com.study.util.Criteria;
import com.study.vo.MemberVO;

@Component("/Run/list.do")
public class RunListShowController implements Controller {
	private RunListDAO runDAO;
	
	public RunListShowController setRunListDAO(RunListDAO runDAO) {
		this.runDAO = runDAO;
		return this;
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		Criteria crit = (Criteria) model.get("crit");
		MemberVO logonMember = (MemberVO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			model.put("runlist", runDAO.listPageV2(crit));
			model.put("auth_level", logonMember.getAuthority());
			return "/Run/list.jsp";
		}
	}

}
