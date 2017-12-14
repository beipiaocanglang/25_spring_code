package frame.study.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import frame.study.service.IUserService;
/**
 * 模拟一个业务层接口实现类
 * @author canglang
 */
@Component("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public void saveUser() {
		int a = 1/0;
		System.out.println("**********保存了一个用户*********");
	}

	@Override
	public void updateUser(int a, int b) {
		System.out.println("**********更新了一个用户*********");
	}

	@Override
	public int deleteUser() {
		System.out.println("**********删除了一个用户*********");
		return 1000;
	}

}
