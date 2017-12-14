package frame.study.service;
/**
 * 模拟一个业务层接口
 * 
 * 此接口中的所有方法都叫连接点
 * @author canglang
 */
public interface IUserService {

	/**
	 * 保存用户
	 */
	void saveUser();
	
	/**
	 * 更新用户
	 */
	void updateUser();
	/**
	 * 删除用户
	 */
	void deleteUser();
}
