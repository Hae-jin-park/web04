package com.study.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.bind.DataBinding;
import com.study.vo.Model;

/**
 * Servlet implementation class RESTfulTest
 */
@WebServlet("/RESTfulTest")
public class RESTfulController implements Controller, DataBinding {
	/**
     * @see HttpServlet#HttpServlet()
     */
	private Gson gs = null;
	private Map<String, Model> modelDB = new HashMap<>();
    public RESTfulController() {
        super();
        // TODO Auto-generated constructor stub
        gs = new Gson();
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();
        
        modelDB.put(id1, new Model(id1,"Engine","..base 64 URN.."));
        modelDB.put(id2, new Model(id2,"Hairdryer","..base 64 URN.."));
        modelDB.put(id3, new Model(id3,"Thruster","..base 64 URN.."));
    }
    
    //private void sendAsJSON()


	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				
		};
	}

	@Override
	public String exec(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
