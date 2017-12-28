package com.prashanth.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.prashanth.Util.DBUtil;
import com.prashanth.modal.Student;

public class StudentDao {
	public static boolean insertStudent(Student s) {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getDBConection();
			String sql = "INSERT INTO REGISTRATION (FIRST_NAME,LAST_NAME,EMAIL_ID,PASSWORD,GENDER,DOB) VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getFirst_name());
			pstmt.setString(2, s.getLast_name());
			pstmt.setString(3, s.getEmail_id());
			pstmt.setString(4, s.getPassword());
			pstmt.setString(5, s.getGender());
			pstmt.setString(6, s.getDob());
			int x = pstmt.executeUpdate();
			if (x > 0) {
				isInserted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isInserted;
	}

}
