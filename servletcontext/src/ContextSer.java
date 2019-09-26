

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContextSer")
public class ContextSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		
		//ServletConfig config = getServletConfig();
		ServletContext context = request.getServletContext();
		String name=context.getServletContextName();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String name1=context.getInitParameter("name");
		String pass=context.getInitParameter("pass");
		Enumeration<String> e1=context.getInitParameterNames();
		String context_name="";
		while(e1.hasMoreElements()){
			context_name=context_name+e1.nextElement()+"<br>";
		}
		context.setAttribute("a", "ahaad");
		context.setAttribute("b", "raza");
		context.setAttribute("c", "ahamad");
		String a=(String)context.getAttribute("a");
		String b=(String)context.getAttribute("b");
		String c=(String)context.getAttribute("c");
		
		Enumeration<String> e2=context.getAttributeNames();
		String attr_name="";
		while(e2.hasMoreElements()){
			attr_name=attr_name+e2.nextElement()+"<br>";
		}
		out.println("<html><body><h2>Parameter Details" +
				"</h2><table border='1'><tr><th>parametername</th>" +
				"<th>parametervalue</th></tr>");
		out.println("<tr><td>driver_class</td><td>"+driver+"</td></tr>");
		out.println("<tr><td>driver_url</td><td>"+url+"</td></tr>");
		out.println("<tr><td>db_name</td><td>"+name1+"</td></tr>");
		out.println("<tr><td>db_pass</td><td>"+pass+"</td></tr>");
		out.println("<tr><td>param_name</td><td>"+context_name+"</td></tr>");
		
		out.println("<tr><td><h2>Attribute Detail</h2></td></tr>");
		out.println("<tr><td>a</td><td>"+a+"</td></tr>");
		out.println("<tr><td>b</td><td>"+b+"</td></tr>");
		out.println("<tr><td>c</td><td>"+c+"</td></tr>");
		out.println("<tr><td>Attribute name</td><td>"+attr_name+"</td></tr>");
		out.println("<tr><td>logical_name</td><td>"+name+"</td></tr>");
		out.println("<tr><td>Foreign Context</td>" +
				"<td>"+context.getContext("/servletconfig")+"</td></tr>");
		out.println("</table></body></html>");
		
	}

}
