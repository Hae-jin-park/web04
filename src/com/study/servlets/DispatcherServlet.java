package com.study.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bind.DataBinding;
import com.study.bind.ServletRequestDataBinder;
import com.study.context.ApplicationContext;
import com.study.controllers.Controller;
import com.study.listeners.ContextLoaderListener;
import com.study.util.AccessControl;
import com.study.util.Criteria;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.service(arg0, arg1);
		response.setContentType("text/html; charset=UTF-8");
		String servletPath = request.getServletPath();
		String strReferer = request.getHeader("referer");
		boolean isInternal = AccessControl.isInternalAccess(request);
			try{
				ApplicationContext actx = ContextLoaderListener.getApplicationContext();//ServletContext sctx = this.getServletContext();
				HashMap<String, Object> model = new HashMap<String,Object>();
				Criteria crit = new Criteria();
				model.put("session",request.getSession());
				model.put("isInternal",isInternal);
				model.put("strReferer", strReferer);
				
				if(request.getParameter("page")!=null) {
					crit.setPage(Integer.parseInt(request.getParameter("page")));
				}
				
				if(request.getParameter("perPageNum")!=null) {
					crit.setPerPageNum(Integer.parseInt(request.getParameter("perPageNum")));
				}
				
				if(request.getParameter("orderByCond")!=null) {
					model.put("orderByCond", request.getParameter("orderByCond"));
				}
				
				if(request.getParameter("t_no")!=null) {
					model.put("t_no",Integer.parseInt(request.getParameter("t_no")));
				}
				
				model.put("crit", crit);
				Controller pageController = (Controller) actx.getBean(servletPath);
				
				if(pageController == null) {
					throw new Exception("요청 서비스를 찾을 수 없어요...");
				}
				
				if(pageController instanceof DataBinding) {
					prepareRequestData(request,model,(DataBinding) pageController);
				}
				
				String viewUrl = pageController.exec(model);
				
				for(String key : model.keySet()) {
					request.setAttribute(key, model.get(key));
				}
				
				if(viewUrl.startsWith("redirect:")) {
					response.sendRedirect(viewUrl.substring(9));
					return;
				}else {
					RequestDispatcher rd=request.getRequestDispatcher(viewUrl);
					rd.include(request, response);
				}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
}
	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model,
			DataBinding dataBinding) throws Exception {
		// TODO Auto-generated method stub
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i=0;i<dataBinders.length;i+=2) {
			dataName = (String)dataBinders[i];
			dataType=(Class<?>)dataBinders[i+1];
			dataObj = ServletRequestDataBinder.bind(request,dataType,dataName);
			model.put(dataName, dataObj);
		}
	}
}
