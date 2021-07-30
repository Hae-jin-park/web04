package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.OilDAO;
import com.study.vo.MemberVO;

@Component("/Fee/oilDelete.do")
public class OilDeleteController implements Controller, DataBinding {
	private OilDAO oilDAO;
	
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"oil_no", Integer.class
		};
	}

	public OilDeleteController setOilDAO(OilDAO oilDAO) {
		this.oilDAO = oilDAO;
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
			if(isInternal && vo.getAuthority().equals("ADMIN") && abnormalAcc!=null) {
				oilDAO.delete((Integer)model.get("oil_no"));
				return "redirect:oil_list.do";
			}else if(abnormalAcc==null) {
				return "../abnormalAccess.jsp";
			}else {
				return "/authentication/denied.jsp";
			}
		}else {
			return "redirect:../authentication/logon.do";
		}
	}


}
