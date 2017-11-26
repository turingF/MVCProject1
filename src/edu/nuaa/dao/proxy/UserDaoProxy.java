package edu.nuaa.dao.proxy;

import edu.nuaa.dao.IUserDao;
import edu.nuaa.dao.impl.UserDaoImpl;
import edu.nuaa.factory.dbc.DataBaseConnection;
import edu.nuaa.vo.User;

public class UserDaoProxy implements IUserDao {
	
	private DataBaseConnection dbc = null;
	
	private IUserDao dao = null;
	
	public UserDaoProxy(){
		try{
		this.dbc = new DataBaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		dao = new UserDaoImpl(this.dbc.getConnection()); 
		
	}

	@Override
	public boolean fingLogin(User user) throws Exception {
		boolean flag = false;
		try{
		flag = this.dao.fingLogin(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

}
