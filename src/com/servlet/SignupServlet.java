package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	UserData objn;
	final static HashMap<String, String> mapobject = new HashMap<>();
	String uname1;
	String passa;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("usname");
		String pass = req.getParameter("uspass");
		String pass1 = req.getParameter("uspass1");
		
		if (pass1.equals(pass) && name != "" && pass != "" && pass1 != "") {
			if (!mapobject.containsKey(name)) {
				objn = new UserData(name, pass);
				out.println("<center>successfully registred with ur fields</center>");
				out.print("<body  background=\"img/download111111.jpg\">\n");
				req.getRequestDispatcher("/").forward(req, resp);
				uname1 = objn.getUser();
				passa = objn.getPass();
				mapobject.put(uname1, passa);
			} else {
				out.print("<center>sorry user is already registred with this....");
				req.getRequestDispatcher("/SignUp.html").include(req, resp);
			}
		}
		else if((!pass.equals(pass1))&&name!=""&&pass!=""&&pass1!=""){
			out.print("<center>sorry password must match to access</center>");
			RequestDispatcher reg = req.getRequestDispatcher("/SignUp.html");
			reg.include(req, resp);
			
		}

		else{
			out.print("<center>sorry empty fields con't to access</center>");
			RequestDispatcher reg = req.getRequestDispatcher("/SignUp.html");
			reg.forward(req, resp);
		}
		
		} 
	public static HashMap<String, String> getData() {
		// TODO Auto-generated method stub
		if (mapobject.isEmpty()) {
			return null;

		} else
			return mapobject;
	}

	public void doGet(HttpServletRequest req1, HttpServletResponse resp1) throws ServletException, IOException {

		RequestDispatcher res1 = req1.getRequestDispatcher("/SignUp.html");
		res1.forward(req1, resp1);
	}

}
