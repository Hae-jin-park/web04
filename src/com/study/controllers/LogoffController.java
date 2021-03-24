package com.study.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.study.annotation.Component;

@Component("/authentication/logoff.do")
public class LogoffController implements Controller {

	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();
		return "redirect:logon.do";
	}

}
