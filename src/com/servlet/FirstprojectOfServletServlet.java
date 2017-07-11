package com.servlet;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.layout.Background;

@SuppressWarnings("serial")
public class FirstprojectOfServletServlet extends  HttpServlet {
	String b,a;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
	resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HashMap<String, String> real;
		HashMap<String, String> mapobject=new HashMap<>();
		real=SecondServlet.getData();
		if(real==null){
		
		}
		else	mapobject=real;
		//UserData objn=new UserData("rama","123");
		String uname = req.getParameter("uname");
		String upass=req.getParameter("upass");
		for (Entry<String, String> entry : mapobject.entrySet()){
			a=entry.getKey();
			b=entry.getValue();
			if(a.equals(uname)&&b.equals(upass))break;
		}
		
		
	//	out.print(name);
		if(!mapobject.isEmpty()){
			if(uname==""||upass==""){
				out.println("<center>please enter your details without empty</center>");
				out.print("<body background=\"img/Error-Page.png\">\n");
				out.print("<center style=\"margin-top:389px; margin-right=590px\">"+"<br><a href=\"index.html\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");

			}
		else if(uname.equals(a) && upass.equals(b))
		{
			HttpSession session=req.getSession();
			session.setAttribute("username",uname);
			session.setAttribute("userpass", upass);
			//resp.sendRedirect("/welcome");
//			RequestDispatcher rd=req.getRequestDispatcher("/test");
//			req.getRequestDispatcher("/welcome").include(req, resp);	
//			(req, resp);
			resp.sendRedirect("/test");
				
					}
		else{
			
			out.print("<body background=\"img/Error-Page.png\">\n");
			out.print("<center>sorry, you entered a wrong details..</center>");
			out.print("<center style=\"margin-top:389px; margin-right=590px\">"+"<br><a href=\"index.html\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");
			out.print("</body></center>\n");
		}
		}
		else {
			out.println("<center><h4>please signup first</h4></cennter>");
			RequestDispatcher reg= req.getRequestDispatcher("/SignUp.html");
			reg.forward(req, resp);
		}
	}
}
