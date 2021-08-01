package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TestJdbc;
import com.mysql.cj.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uName");
		String passWord=request.getParameter("psw");
		TestJdbc t=new TestJdbc();
			try {
				boolean tag=t.login(name, passWord);
				HttpSession session = request.getSession();
				session.setAttribute("userName",name);
				response.sendRedirect("QueryStudentServlet");//ִ����ת
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
