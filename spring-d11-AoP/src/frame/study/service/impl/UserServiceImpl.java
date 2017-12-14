package frame.study.service.impl;

import frame.study.service.IUserService;
/**
 * 模拟一个业务层接口实现类
 * @author canglang
 */
public class UserServiceImpl implements IUserService {

	@Override
	public void saveUser() {
		System.out.println("**********保存了一个用户*********");
	}

	@Override
	public void updateUser() {
		System.out.println("**********更新了一个用户*********");
	}

	@Override
	public void deleteUser() {
		System.out.println("**********删除了一个用户*********");
	}

}
