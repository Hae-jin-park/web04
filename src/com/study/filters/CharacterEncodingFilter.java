package com.study.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	FilterConfig cfg;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain nextFilter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(cfg.getInitParameter("encoding"));
		nextFilter.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.cfg = filterConfig;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
