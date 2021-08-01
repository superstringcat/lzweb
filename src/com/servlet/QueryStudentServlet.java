package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.Student;
import com.dao.TestJdbc;
import com.mysql.cj.xdevapi.JsonArray;
import com.pojo.Page;

/**
 * Servlet implementation class QueryStudentServlet
 */
@WebServlet("/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestJdbc t=new TestJdbc();
		try {
			List<Student> list=t.queryStudent();
			int count=t.queryCount();
			Page page=new Page<>(0, count, "", list);
			String json=JSONObject.toJSONString(page);//将list转换成json格式
			PrintWriter pw=response.getWriter();
			pw.println(json);
			pw.close();
			/*request.setAttribute("params", list);
			RequestDispatcher dis=	request.getRequestDispatcher("list.jsp");
		    dis.forward(request, response);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
