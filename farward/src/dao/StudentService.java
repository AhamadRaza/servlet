package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Student;
import connection.ConnectionFactory;

public class StudentService {
	ArrayList<Student> list;
	public void add(String sid,String sname,String saddress) {
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setString(1, sid);
			ps.setString(2, sname);
			ps.setString(3, saddress);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Student> getAllStudent(){
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()) {
				Student std=new Student();
				std.setSid(rs.getString(1));
				std.setSname(rs.getString(2));
				std.setSaddress(rs.getString(3));
				list.add(std);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}	
}
