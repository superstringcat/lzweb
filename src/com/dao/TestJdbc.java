package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
public static void main(String[] args) throws Exception {
	TestJdbc t=new TestJdbc();
	//t.saveStudent("4","1004","test","666","JAVA");
	//t.removeStudent("3");
	//t.updateStudent("4", "testroot");
	t.queryPage(0,10);
}
public boolean login(String userName,String passWord) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="select * from student where name=? and pass_word=?";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setString(1, userName);
	pre.setString(2, passWord);
	ResultSet res=pre.executeQuery();//执行sql语句
   //移动游标
	boolean tag=res.next();
	con.close();
	return tag;
}

public void queryPage(int start,int end) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="select * from student limit ?,?";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setInt(1, start);
	pre.setInt(2, end);
	ResultSet res=pre.executeQuery();//执行sql语句
   //移动游标
	List<Student> list=new ArrayList<Student>();
	   //移动游标
		while(res.next()) {
			String id=res.getString(1);
			String num=res.getString(2);
			String userName=res.getString(3);
			String psd=res.getString(4);
			String zy=res.getString(5);
			Student s=new Student(id, num, userName, psd, zy);
			list.add(s);
		}
		System.out.println(list);
	con.close();
}

public int queryCount() throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="select count(*) from student";
	PreparedStatement pre=con.prepareStatement(sql);
	ResultSet res=pre.executeQuery();//执行sql语句
   //移动游标
	boolean tag=res.next();
	int total=0;
	if(tag) {
		 total=res.getInt(1);
		System.out.println(total);
	}
	con.close();
	return total;
}

public List<Student> queryStudent() throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="select * from student ";
	PreparedStatement pre=con.prepareStatement(sql);
	ResultSet res=pre.executeQuery();//执行sql语句
	List<Student> list=new ArrayList<Student>();
   //移动游标
	while(res.next()) {
		String id=res.getString(1);
		String num=res.getString(2);
		String userName=res.getString(3);
		String psd=res.getString(4);
		String zy=res.getString(5);
		Student s=new Student(id, num, userName, psd, zy);
		list.add(s);
	}
	con.close();
	return list;
}

public Student queryStudentById(String ids) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="select * from student where id=?";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setString(1,ids);
	ResultSet res=pre.executeQuery();//执行sql语句
   //移动游标
	Student s=null;
	if(res.next()) {
		String id=res.getString(1);
		String num=res.getString(2);
		String userName=res.getString(3);
		String psd=res.getString(4);
		String zy=res.getString(5);
		 s=new Student(id, num, userName, psd, zy);
	}
	con.close();
	return s;
}


public void updateStudent(String id,String name,String num,String passWord,String zy) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="update student set stu_no=?,name=?,pass_word=?,zhuan_ye=? where id=?";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setString(1, num);
	pre.setString(2, name);
	pre.setString(3, passWord);
	pre.setString(4, zy);
	pre.setString(5, id);
	pre.execute();//执行sql语句
	con.close();
}

public void removeStudent(String id) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="delete from student where id=?";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setString(1, id);
	pre.execute();//执行sql语句
	con.close();
}
public void saveStudent(String id,String num,String name,String passWord,String zy) throws Exception {
	Connection con=JdbcUtils.getConnection();
	String sql="insert into student values(?,?,?,?,?)";
	PreparedStatement pre=con.prepareStatement(sql);
	pre.setString(1, id);
	pre.setString(2, num);
	pre.setString(3, name);
	pre.setString(4, passWord);
	pre.setString(5, zy);
	pre.execute();//执行sql语句
	con.close();
}
}
