package com.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Librarian;
import com.library.model.Student;
import com.library.utility.DB;

public class StudentDao {
	
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		public Student StudentLogin(Student stu, Connection con){
			Student st = null;
			String query= "select * from student where (EMAIL='"+stu.getEmail()+"') AND PASSWORD='"+stu.getPassword()+" ' ";
			
			 try{
				 con =DB.getCon();
				 stmt = (Statement)con.createStatement();
				  rs = (ResultSet)stmt.executeQuery(query);
			  while(rs.next()){
				  st = getSingleStoreEntry(rs);
			  }	
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
			    // Always make sure result sets and statements are closed,
			    if (rs != null) {
				      try { rs.close(); } catch (SQLException e) { ; }
				      rs = null;
				    }
			    if (stmt != null) {
			      try { stmt.close(); } catch (SQLException e) { ; }
			      stmt = null;
			    }
			}
		return st;
			
		}
		private Student getSingleStoreEntry(ResultSet rs)throws SQLException{
			Student stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setEmail(rs.getString("email"));
			stu.setPassword(rs.getString("password"));
			
			
			return stu;
			
		}
		
		public static Student viewStudentById(int id){
			Student bean=new Student();
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("select * from student where id=?");
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					bean.setId(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setEmail(rs.getString(3));
					bean.setPassword(rs.getString(4));
					bean.setContact(rs.getString(5));
					bean.setAddress(rs.getString(6));
				}
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
				}
			
			return bean;
		}
		
		public static int updateStudent(Student bean){
			int i=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update student set name=?,email=?,password=? ,contact=?,address=?, where id=?");
				ps.setString(1,bean.getName());
				ps.setString(2,bean.getEmail());
				ps.setString(3,bean.getPassword());
				ps.setString(4,bean.getContact());
				ps.setString(5, bean.getAddress());
				ps.setInt(6,bean.getId());
				i=ps.executeUpdate();
				
				if(i!=0){
					System.out.println("Update successfull");
				}else{
					System.out.println("sorry..Studend not update");
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return i;
		}
		
		public static List<Student> viewListOfStudents(){
			List<Student> list = new ArrayList<Student>();
			try{
				Connection con = DB.getCon();
			    PreparedStatement ps=con.prepareStatement("select * from student");
			    ResultSet rs = ps.executeQuery();
			    while(rs.next()){
			    	Student bean = new Student();
			    	bean.setId(rs.getInt("id"));
			    	bean.setName(rs.getString("name"));
			    	bean.setEmail(rs.getString("email"));
			    	bean.setContact(rs.getString("contact"));
			    	bean.setAddress(rs.getString("address"));
			    	list.add(bean);
			    	
			    }
			    con.close();
			}catch(Exception e){System.out.println(e);}
			
			return list;
		}
		
		public static int deleteStudent(int id){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("delete from student where id=?");
				ps.setInt(1,id);
				status=ps.executeUpdate();
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}
		
	}

