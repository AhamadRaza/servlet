package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import dao.StudentService;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String id=req.getParameter("id");
		String name =req.getParameter("name");
		String address=req.getParameter("address");
		
		StudentService std_service=new StudentService();
		std_service.add(id, name, address);
		
		ArrayList<Student> std_list=std_service.getAllStudent();
		pw.println("<html><body><h2>Student Detail</h2><table border='1'>");
		pw.println("<tr><th>ID</th><th>NAME</th><th>ADDRESS</th></tr>");
		Iterator<Student> it=std_list.iterator();
		while(it.hasNext()) {
			Student std=(Student)it.next();
			pw.println("<tr><td>"+std.getSid()+"</td>");
			pw.println("<td>"+std.getSname()+"</td>");
			pw.println("<td>"+std.getSaddress()+"</td></tr>");
		}
		pw.println("</table><hr></body></html>");
		RequestDispatcher rd=req.getRequestDispatcher("addStudent.html");
		rd.forward(req, res);
		
	}

}
