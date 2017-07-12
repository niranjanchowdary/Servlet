package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class ForgotPage  extends HttpServlet 
{
	String pass1, name1;
	HashMap<String, String> forgotobj=new HashMap<>();
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
  HashMap<String, String> forgot;
	forgot= SignupServlet.getData();
	if(forgot==null)
	{
		
	}
	else
		forgotobj=forgot;
	
	String name=req.getParameter("uname");
	
	if(!forgotobj.isEmpty()){
	for (Entry<String, String> entry : forgot.entrySet()) {
		name1 = entry.getKey();
		pass1 = entry.getValue();
		if (name1.equals(name) )
			break;
	}
	}
	if(!forgotobj.isEmpty()){
	if(forgotobj.containsKey(name))
	{
		
		out.println("<center>password is :"+forgotobj.get(name1)+"</center>");
		out.print("<body background=\"img/download111111.jpg\" style='background-position: center center; background-size: 90% auto;'>\n");
		out.print("<center style=\"margin-top:389px; margin-right=590px\">"
				+ "<br><a href=\"/\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");

	}
	else
	{
		out.print("<body background=\"img/Error-Page.png\">\n");
		out.print("<center>sorry, you entered a wrong details..</center>");
		out.print("<center style=\"margin-top:389px; margin-right=590px\">"
				+ "<br><a href=\"/\"><button type=\"button\" style=\" border-radius: 50%;\">back</button></a>");
		out.print("</body></center>\n");
	}
	}
	else{
		out.print("<body background=\"img/Error-Page.png\">\n");

		out.println("<center>no data available in our data base....<center>");
	}
	
}

}
