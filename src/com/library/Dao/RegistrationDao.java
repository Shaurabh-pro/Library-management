package com.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.library.model.Student;
import com.library.utility.DB;

public class RegistrationDao {
	/*Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps = null;*/
	int i = 0;

	public int AddStudent(Student stu) {
		String query = "insert into student (NAME,EMAIL,PASSWORD,CONTACT, ADDRESS)"
				+ "values(?, ?, ?, ?, ?)";
		try {
			Connection con=DB.getCon();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getEmail());
			ps.setString(3, stu.getPassword());
			ps.setString(4, stu.getContact());
			ps.setString(5, stu.getAddress());
             
			i = ps.executeUpdate();
			if (i!=0) {
				System.out.println("Registration Successfull");
			} else {
				System.out.println("Registration Failed...!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	

}
