package edu.nuaa.proxy.ZhouShiQiProxy;

import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.ZhouShiQiDao.IAppInfoDao;
import edu.nuaa.dao.impl.ZhouShiQiDaoImpl.AppInfoDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.ZhouShiQiVo.AppInfo;

public class AppInfoDaoProxy implements IAppInfoDao{

	private DataBaseConnection dbc = null;
	private IAppInfoDao dao = null;
	
	public AppInfoDaoProxy() throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new AppInfoDaoImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(AppInfo ai) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			flag = this.dao.doCreate(ai);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean delApp(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			flag = this.dao.delApp(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<AppInfo> queryApp(int userid, String keyword) throws Exception {
		// TODO Auto-generated method stub
		List<AppInfo> all = new ArrayList<AppInfo>();
		try{
			all = this.dao.queryApp(userid, keyword);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public boolean modifyAppName(int appid, String newname) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			flag = this.dao.modifyAppName(appid, newname);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	
}
