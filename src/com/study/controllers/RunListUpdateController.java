package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.CarDAO;
import com.study.dao.ClientDAO;
import com.study.dao.RunListDAO;
import com.study.vo.MemberVO;
import com.study.vo.RunListVO;

@Component("/Run/update.do")
public class RunListUpdateController implements Controller, DataBinding {
	private RunListDAO runDAO;
	private ClientDAO clientDAO;
	private CarDAO carDAO;
	
	public RunListUpdateController setRunListDAO(RunListDAO runDAO) {
		this.runDAO = runDAO;
		return this;
	}
	public RunListUpdateController setClientDAO(ClientDAO clientDAO) {
		// TODO Auto-generated constructor stub
		this.clientDAO = clientDAO;
		return this;
	}
	public RunListUpdateController setCarDAO(CarDAO carDAO) {
		// TODO Auto-generated constructor stub
		this.carDAO = carDAO;
		return this;
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		MemberVO logonMember = (MemberVO) session.getAttribute("member");
		boolean isInternal = (Boolean)model.get("isInternal");
		String isNull = ((RunListVO) model.get("runVO")).getT_from();
		RunListVO runVO;
		// TODO Auto-generated method stub
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			if(isNull==null) {
				runVO = runDAO.selectOne((Integer) model.get("t_no"));
				model.put("car_list", carDAO.selectList());
				model.put("client_list", clientDAO.selectList());
				model.put("runVO", runVO);
				//model.put("isPost", true);
				return "/Run/update.jsp";
			}else {
				if(isInternal && logonMember.getAuthority().equals("ADMIN")) {
					runVO = (RunListVO) model.get("runVO");
					runDAO.update(runVO,(Integer) model.get("t_no"));
					//model.put("isPost", false);
					return "redirect:listV2.do";
				}else {
					return "/authentication/denied.jsp";
				}
			}
		}
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"t_no", Integer.class,
				"runVO", com.study.vo.RunListVO.class,
				"isPost", Boolean.class
		};
	}

}
