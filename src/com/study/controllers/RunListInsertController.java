package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;
import com.study.bind.DataBinding;
import com.study.dao.CarDAO;
import com.study.dao.ClientDAO;
import com.study.dao.RunListDAO;
import com.study.vo.RunListVO;

@Component("/Run/insert.do")
public class RunListInsertController implements Controller, DataBinding {
	private RunListDAO runDAO;
	private ClientDAO clientDAO;
	private CarDAO carDAO;
	
	public RunListInsertController setRunListDAO(RunListDAO runDAO) {
		// TODO Auto-generated constructor stub
		this.runDAO = runDAO;
		//this.clientDAO=clientDAO;
		return this;
	}
	public RunListInsertController setClientDAO(ClientDAO clientDAO) {
		// TODO Auto-generated constructor stub
		this.clientDAO = clientDAO;
		return this;
	}
	public RunListInsertController setCarDAO(CarDAO carDAO) {
		// TODO Auto-generated constructor stub
		this.carDAO = carDAO;
		return this;
	}
	public Object[] getDataBinders() {
		return new Object[] {
				"runVO",com.study.vo.RunListVO.class,
				"client_list",com.study.vo.ClientVO.class
		};
	}
	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		boolean isInternal = (Boolean)model.get("isInternal");
		RunListVO runVO = (RunListVO) model.get("runVO");
		if(session.getAttribute("member")==null) {
			return "redirect:../authentication/logon.do";
		}else {
			String isNull = runVO.getT_date();

			if(isInternal) {
				if(isNull==null) {
					model.put("client_list", clientDAO.selectList());
					model.put("car_list", carDAO.selectList());
					return "/Run/insert.jsp";
				}else {
					runDAO.insert(runVO);
					return "redirect:listV2.do";
				}
			}else { //외부접속이면? 접근거부
				return "/authentication/denied.jsp";
			}
		}
	}

}
