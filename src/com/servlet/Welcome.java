package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		try{
			
			
			if(session!=null){	 
				session.invalidate();
				resp.sendRedirect("/");
				//req.getRequestDispatcher("/index.html").include(req, resp);
			}
			
			
		}
		finally {
			
		}
	
	
	}
}
