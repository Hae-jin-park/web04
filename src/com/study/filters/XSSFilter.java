package com.study.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.study.util.RequestWrapper;

public class XSSFilter implements Filter {
	public FilterConfig fc;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain ch)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		ch.doFilter( new RequestWrapper((HttpServletRequest) request),response );
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.fc=null;
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		this.fc=fc;
	}

}
