package com.study.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

	public RequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if(values==null) {
			return null;
		}
		int count = values.length;
		String[] encodedVals = new String[count];
		for(int i=0;i<count;i++) {
			encodedVals[i] = antiXSS(values[i]);
		}
		
		return encodedVals;
	}
	
	

	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if(value==null) {
			return null;
		}
		return antiXSS(value);
	}
	
	private String antiXSS(String value) {  //실질적 XSS 필터링 작업 : 만약에 추가하고자 할 때는 replace 조건 분석하고 추가만 하면 됨. 
		// TODO Auto-generated method stub
		  value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");         
		  value = value.replaceAll("'", "& #39;");        
		  value = value.replaceAll("eval\\((.*)\\)", "");         
		  value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");         
		  value = value.replaceAll("script", "");         
		  
		  return value;    

		//출처: http://shonm.tistory.com/425 [정윤재의 정리노트]
	}

}
