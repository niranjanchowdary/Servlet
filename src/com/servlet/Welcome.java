package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		try{
			if(session.getAttribute("username")==null)
			{
				 req.getRequestDispatcher("/index.html").include(req, resp);
				 out.println("welcome");
			}
			else if(session!=null){
				out.println("welcome");
			}
			
			
		}
		finally {
			
		}
	
	
	}
}
