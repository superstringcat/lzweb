package com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JdbcUtils;
import com.dao.TestJdbc;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");//��ȡҳ�����
		String na=request.getParameter("userName");//��ȡҳ�����
		String stuNo=request.getParameter("stuNo");//��ȡҳ�����
		String psd=request.getParameter("psd");//��ȡҳ�����
		String zy=request.getParameter("zy");//��ȡҳ�����
		TestJdbc t=new TestJdbc();
		try {
			if(id==null) {
				t.saveStudent(JdbcUtils.createId(), stuNo, na, psd, zy);
			}else {
				t.updateStudent(id, na, stuNo, psd, zy);
			}
			response.sendRedirect("QueryStudentServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
