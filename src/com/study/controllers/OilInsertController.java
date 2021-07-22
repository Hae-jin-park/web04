package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.CarDAO;
import com.study.dao.CompDAO;
import com.study.dao.OilDAO;
import com.study.vo.OilVO;

public class OilInsertController implements Controller, DataBinding {
	private CarDAO carDAO;
	private CompDAO compDAO;
	private OilDAO oilDAO;
	
	
	public OilInsertController setCarDAO(CarDAO carDAO) {
		// TODO Auto-generated constructor stub
		this.carDAO = carDAO;
		return this;
	}
	
	public OilInsertController setCompDAO(CompDAO compDAO) {
		// TODO Auto-generated constructor stub
		this.compDAO = compDAO;
		return this;
	}

	public OilInsertController setOilDAO(OilDAO oilDAO) {
		// TODO Auto-generated constructor stub
		this.oilDAO = oilDAO;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
				"oilVO",com.study.vo.OilVO.class,
				"car_list",com.study.vo.ClientVO.class
		};
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		//접근제어부분
		HttpSession session = (HttpSession) model.get("session");
		boolean isInternal = (Boolean)model.get("isInternal");
		String abnormalAcc = (String) model.get("strReferer");
		
		OilVO oilVO = (OilVO) model.get("oilVO");
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			String isNull = oilVO.getOil_date();
			if(abnormalAcc==null) {
				return "../abnormalAccess.jsp";
			}else {
				if(isInternal) {
				if(isNull==null) {
					model.put("car_list", carDAO.selectList());
					model.put("comp_list", compDAO.selectList());
					return "../Fee/oil_insert.jsp";
				}else {
					oilDAO.insert(oilVO);
					return "redirect:../Run/listV2.do";
				}
			}else { //외부접속이면? 접근거부
				return "/authentication/denied.jsp";
			}
			}
		}
	}

}
