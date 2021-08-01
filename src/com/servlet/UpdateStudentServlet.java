package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Student;
import com.dao.TestJdbc;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ids");
		TestJdbc t=new TestJdbc();
		try {
			Student st=t.queryStudentById(id);
			request.setAttribute("stu", st);
			RequestDispatcher dis=	request.getRequestDispatcher("toupdate.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
