package frame.study.dao;

/**
 * 用户的持久层接口
 * @author canglang
 *
 */
public interface IUserDao {
	
	/*
	 * 保存用户
	 */
	void saveUser();
	
	/*
	 * 删除用户
	 */
	void deleteUser();
}
