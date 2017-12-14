package frame.study.bean;

public class UserBean {

	//实例化
	public UserBean(){
		System.out.println("实例化：大爷来也！");
	}
	//初始化
	public void init(){
		System.out.println("初始化：大爷准备好了");
	}
	//销毁
	public void destroy(){
		System.out.println("销毁：老夫休矣！");
	}

	public void saveUser(){
		System.out.println("业务方法：老夫只劫财不劫色");
	}
}
