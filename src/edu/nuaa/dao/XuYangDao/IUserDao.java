package edu.nuaa.dao.XuYangDao;


import edu.nuaa.vo.XuYangVo.UserInfo;

public interface IUserDao {

	/**
	 * @param account,password：
	 * @return 结果
	 * @throws Exception 
	 */
	public boolean login(String account, String password) throws Exception;
	
	
	/**
	 * @param account,password：
	 * @return 结果
	 * @throws Exception 
	 */
	public boolean register(String account, String password) throws Exception;
	
	

	
	/**
	 * @param account
	 * @return 用户的VO类
	 * @throws Exception 
	 */
	public UserInfo findUserByAccount(String account) throws Exception;
	
	
	/**
	 * @param us
	 * @return 结果
	 * @throws Exception 
	 */
	public boolean setUserInfo(UserInfo us) throws Exception;
	
}
