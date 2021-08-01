package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class JdbcUtils {
public static Connection getConnection() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");//×¢²áÇý¶¯
	String url="jdbc:mysql://127.0.0.1:3306/airports?serverTimezone=Asia/Shanghai";
	Connection con=DriverManager.getConnection(url,"root","qweasdzxc");
	return con;
}
public static String createId() {
	UUID uid=UUID.randomUUID();//234s5-56s7-5f67d-567dfsfas
	String id=uid.toString();
	id=id.replace("-", "");
	return id;
}

}
