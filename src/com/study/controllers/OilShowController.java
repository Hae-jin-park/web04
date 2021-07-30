package com.study.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.OilDAO;
import com.study.util.Criteria;
import com.study.util.PageMaker;
import com.study.vo.MemberVO;

@Component("/Fee/oil_list.do")
public class OilShowController implements Controller, DataBinding {
	private OilDAO oilDAO;
	
	
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
			pageMaker.setTotalCount(oilDAO.getCount());
			
			model.put("oil_fee_list", oilDAO.selectListV2(paramMap));
			model.put("auth_level", logonMember.getAuthority());
			model.put("pageMaker", pageMaker);
			return "/Fee/oil_list.jsp";
		}
	}


	public OilShowController setOilDAO(OilDAO oilDAO) {
		this.oilDAO = oilDAO;
		return this;
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
