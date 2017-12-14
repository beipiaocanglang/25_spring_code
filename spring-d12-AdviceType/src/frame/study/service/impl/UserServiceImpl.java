package frame.study.service.impl;

import frame.study.service.IUserService;
/**
 * 模拟一个业务层接口实现类
 * @author canglang
 */
public class UserServiceImpl implements IUserService {

	public void saveUser() {
		int a = 1/0;
		System.out.println("**********保存了一个用户*********");
	}

	public void updateUser(int i,int b) {
		System.out.println("**********更新了一个用户*********");
	}

	public int deleteUser() {
		System.out.println("**********删除了一个用户*********");
		return 1000;
	}

}
