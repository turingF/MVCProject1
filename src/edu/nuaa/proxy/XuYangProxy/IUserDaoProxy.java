package edu.nuaa.proxy.XuYangProxy;


import edu.nuaa.dao.XuYangDao.IUserDao;
import edu.nuaa.dao.impl.XuYangDaoImpl.IUserDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.XuYangVo.UserInfo;

public class IUserDaoProxy implements IUserDao {
	private DataBaseConnection dbc = null;
	private IUserDao dao = null;

	public IUserDaoProxy() throws Exception {
		this.dbc = new DataBaseConnection();
		this.dao = new IUserDaoImpl(this.dbc.getConnection());

	}
	
	public boolean login(String account,String password) throws Exception{
		boolean flag=false;

		try {
			flag = this.dao.login(account,password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}

		return flag;
	}

	@Override
	public boolean register(String account, String password) throws Exception {
		boolean flag = false;
		
		try {
			
			if(DaoFactory.getUserDaoInstance().findUserByAccount(account)==null)
			flag = this.dao.register(account,password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		
		
		return flag;
	}



	@Override
	public UserInfo findUserByAccount(String account) throws Exception {
		UserInfo us = null;

		try {

			us = this.dao.findUserByAccount(account);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}

		return us;
	}

	@Override
	public boolean setUserInfo(UserInfo us) throws Exception {
		boolean flag = false;
		try {

			flag=this.dao.setUserInfo(us);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	
}
