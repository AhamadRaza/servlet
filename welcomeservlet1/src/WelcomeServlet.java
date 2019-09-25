import javax.servlet.*;
import java.io.*;
public class WelcomeServlet implements Servlet{
	
	public void init(ServletConfig config)throws ServletException{

	}
	public void service(ServletRequest req , ServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<html");
		out.println("<body");
		out.println("<font size='7' color='red'>");
		out.println("<b>");
		out.println("Welcome to my first servlet program");
		out.println("<hr></b>");
		out.println("</font></body></html>");

	}
	public ServletConfig getServletConfig(){

		return null;
	}	
	public String getServletInfo(){
		return "";
	}
	public void destroy(){

	}
}