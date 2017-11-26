package edu.nuaa.dao;

import edu.nuaa.vo.User;

public interface IUserDao {
	
	/**
	 * 用户登陆验证
	 * @param user 传入VO对象
	 * @return 验证的操作结果
	 * @throws Exception
	 * */
	
	public boolean fingLogin(User user) throws Exception;

}
