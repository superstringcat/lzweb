package com.dao;

public class Student {
private	String id;
private String num;
private String userName;
private String psd;
private String zy;

public Student() {
	super();
}

public Student(String id, String num, String userName, String psd, String zy) {
	super();
	this.id = id;
	this.num = num;
	this.userName = userName;
	this.psd = psd;
	this.zy = zy;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPsd() {
	return psd;
}

public void setPsd(String psd) {
	this.psd = psd;
}

public String getZy() {
	return zy;
}

public void setZy(String zy) {
	this.zy = zy;
}

@Override
public String toString() {
	return "Student [id=" + id + ", num=" + num + ", userName=" + userName + ", psd=" + psd + ", zy=" + zy + "]";
}


}
