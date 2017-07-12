package com.servlet;

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

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	String pass1, name1;
static	HashMap<String, String> mapobject = new HashMap<>();
static HashMap<String, String> real;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		real = SignupServlet.getData();
		if (real == null) {

		} else
			mapobject = real;
		// UserData objn=new UserData("rama","123");
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		for (Entry<String, String> entry : mapobject.entrySet()) {
			name1 = entry.getKey();
			pass1 = entry.getValue();
			if (name1.equals(uname) && pass1.equals(upass))
				break;
		}

		// out.print(name);
		if (!mapobject.isEmpty()) {
			if (uname == "" || upass == "") {
				out.println("<center>please enter your details without empty</center>");
				out.print("<body background=\"img/Error-Page.png\">\n");
				out.print("<center style=\"margin-top:389px; margin-right=590px\">"
						+ "<br><a href=\"/\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");

			} else if (uname.equals(name1) && upass.equals(pass1)) {
				HttpSession session = req.getSession();
				session.setAttribute("username", uname);
				// session.setAttribute("userpass", upass);
				// resp.sendRedirect("/test");
				// RequestDispatcher rd=req.getRequestDispatcher("/test");
				// req.getRequestDispatcher("/welcomeuser").forward(req, resp);
				// (req, resp);
				resp.sendRedirect("/welcomeuser");

			} else {

				out.print("<body background=\"img/Error-Page.png\">\n");
				out.print("<center>sorry, you entered a wrong details..</center>");
				out.print("<center style=\"margin-top:389px; margin-right=590px\">"
						+ "<br><a href=\"/\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");
				out.print("</body></center>\n");
			}
		} else {
			out.println("<center><h4>please signup first</h4></cennter>");
			RequestDispatcher reg = req.getRequestDispatcher("/SignUp.html");
			reg.forward(req, resp);
		}
	}
	
}
