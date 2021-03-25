package com.study.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.bind.DataBinding;
import com.study.dao.RunListDAO;
import com.study.util.Criteria;
import com.study.util.PageMaker;
import com.study.vo.MemberVO;

public class RunListShowV2Controller implements Controller, DataBinding {
	RunListDAO runDAO;
	public RunListShowV2Controller setRunListDAO(RunListDAO runDAO) {
		this.runDAO = runDAO;
		return this;
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		Criteria crit = (Criteria) model.get("crit");
		Map<String, Object> paramMap = new HashMap<>();
		PageMaker pageMaker = new PageMaker();
		MemberVO logonMember = (MemberVO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			paramMap.put("orderByCond", model.get("orderByCond"));
			paramMap.put("crit", crit);
			pageMaker.setCri(crit);
			pageMaker.setTotalCount(runDAO.listTotalCount());
			model.put("runlist", runDAO.listPageV2(paramMap));
			model.put("auth_level", logonMember.getAuthority());
			model.put("pageMaker", pageMaker);
			return "/Run/listV2.jsp";
		}
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"page",String.class,
				"perPageNum",String.class,
				"orderByCond",String.class
		};
	}
	

}
