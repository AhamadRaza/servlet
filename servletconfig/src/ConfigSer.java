

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigSer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		ServletConfig config = getServletConfig();
		String name=config.getServletName();
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		String name1=config.getInitParameter("name");
		String pass=config.getInitParameter("pass");
		Enumeration<String> e=config.getInitParameterNames();
		String param_name="";
		while(e.hasMoreElements()){
			param_name=param_name+e.nextElement()+"<br>";
		}
		out.println("<html><body><h2>Configuration Details" +
				"</h2><table border='1'><tr><th>parametername</th>" +
				"<th>parametervalue></th></tr>");
		out.println("<tr><td>driver_class</td><td>"+driver+"</td></tr>");
		out.println("<tr><td>driver_url</td><td>"+url+"</td></tr>");
		out.println("<tr><td>db_name</td><td>"+name+"</td></tr>");
		out.println("<tr><td>db_pass</td><td>"+pass+"</td></tr>");
		out.println("<tr><td>param_name</td><td>"+param_name+"</td></tr>");
		out.println("<tr><td>logical_name</td><td>"+name+"</td></tr>");
		out.println("</table></body></html>");
	}

}
