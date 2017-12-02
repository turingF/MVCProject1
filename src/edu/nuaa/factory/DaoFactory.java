package edu.nuaa.factory;


import edu.nuaa.dao.XuYangDao.IAnReDao;
import edu.nuaa.dao.XuYangDao.IUserDao;
import edu.nuaa.proxy.XuYangProxy.IAnReDaoProxy;
import edu.nuaa.proxy.XuYangProxy.IUserDaoProxy;

public class DaoFactory {

	public static IUserDao getUserDaoInstance()throws Exception{
		return new IUserDaoProxy();
	}


	public static IAnReDao getAnReDaoInstance() throws Exception{
		return new IAnReDaoProxy();
	}
}
