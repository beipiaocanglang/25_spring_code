package frame.study.bean;

import java.util.Date;

public class UserBean1 {
	private String name;
	private Integer age;
	private Date birthday;
	
	public UserBean1(){};
	
	public UserBean1(String name, Integer age, Date birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void saveUser(){
		System.out.println("业务方法：老夫只劫财不劫色");
		System.out.println(name);
		System.out.println(age);
		System.out.println(birthday);
	}
}
