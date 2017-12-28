package com.prashanth.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prashanth.Dao.StudentDao;
import com.prashanth.modal.Student;

/**
 * Servlet implementation class RegisterSevlet
 */
@WebServlet("/RegisterSevlet")
public class RegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String email_id = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");

		Student s = new Student();
		s.setFirst_name(first_name);
		s.setLast_name(last_name);
		s.setEmail_id(email_id);
		s.setPassword(password);
		s.setGender(gender);
		s.setDob(dob);
		StudentDao dao=new StudentDao();
		boolean isInserted = dao.insertStudent(s);
		if (isInserted) {
			out.print("successfully Inserted");
		} else {
			out.print("Not Inserted");
		}
	}

}
