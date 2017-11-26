package edu.nuaa.factory;

import edu.nuaa.dao.IUserDao;
import edu.nuaa.dao.proxy.UserDaoProxy;

public class DaoFactory {
	
	public static IUserDao getIUserDaoInstance(){
		return new UserDaoProxy();
	}

}
