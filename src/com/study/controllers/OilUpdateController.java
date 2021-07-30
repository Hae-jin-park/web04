package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.CarDAO;
import com.study.dao.CompDAO;
import com.study.dao.OilDAO;
import com.study.vo.MemberVO;
import com.study.vo.OilVO;

@Component("/Fee/oilUpdate.do")
public class OilUpdateController implements Controller, DataBinding {
	private OilDAO oilDAO;
	private CompDAO compDAO;
	private CarDAO carDAO;

	public OilUpdateController setOilDAO(OilDAO oilDAO) {
		this.oilDAO = oilDAO;
		return this;
	}

	public OilUpdateController setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
		return this;
	}
	public OilUpdateController setCompDAO(CompDAO compDAO) {
		this.compDAO = compDAO;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"oil_no",Integer.class,
				"oilVO", com.study.vo.OilVO.class
		};
	}

	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		MemberVO logonMember = (MemberVO) session.getAttribute("member");
		boolean isInternal = (Boolean)model.get("isInternal");
		String isNull = ((OilVO) model.get("oilVO")).getOil_station();
		OilVO oilVO;
		
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			if(isNull==null) {  //GET
				oilVO = oilDAO.selectOne((Integer) model.get("oil_no"));
				model.put("car_list", carDAO.selectList());
				model.put("comp_list", compDAO.selectList());
				model.put("getPrimaryStn", oilDAO.getPrimaryOilStn());
				model.put("oilVO", oilVO); //selectOne 결과를 oil_update.jsp에 보내기 위해 model에 넣는다.
				
				return "/Fee/oil_update.jsp";
			}else {   //POST : 주유전표 등록/수정 역시 내부접속 & 회원 권한이 ADMIN 두가지 조건을 모두 만족하지 않으면 접근 안됨.
				if(isInternal && logonMember.getAuthority().equals("ADMIN")) {
					oilVO = (OilVO) model.get("oilVO");
					oilDAO.update(oilVO);
					//model.put("isPost", false);
					return "redirect:oil_list.do";
				}else {
					return "/authentication/denied.jsp";
				}
			}
		}
	}
}

