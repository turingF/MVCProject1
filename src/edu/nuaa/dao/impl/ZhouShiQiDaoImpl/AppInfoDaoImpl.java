package edu.nuaa.dao.impl.ZhouShiQiDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.ZhouShiQiDao.IAppInfoDao;
import edu.nuaa.vo.ZhouShiQiVo.AppInfo;

public class AppInfoDaoImpl implements IAppInfoDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	public AppInfoDaoImpl(Connection connection){
		this.conn = connection;
	}
	@Override
	public boolean doCreate(AppInfo ai) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into appinfo(ID, appname, userid, dataname) values (?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, ai.getId());
		this.ps.setString(2, ai.getAppName());
		this.ps.setInt(3, ai.getUserId());
		this.ps.setString(4, ai.getDataName());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean delApp(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from appinfo where ID like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	

	@Override
	public boolean modifyAppName(int appid, String newname) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update appinfo set appname = ? where ID = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, newname);
		this.ps.setInt(2, appid);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	@Override
	public List<AppInfo> queryApp(int userid, String keyword)throws Exception {
		// TODO Auto-generated method stub
		List<AppInfo> all = new ArrayList<AppInfo>(); 
		String sql = "select ID,appname,userid,dataname from appinfo where userid like ? and appname like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, userid);
		this.ps.setString(2, keyword);
		ResultSet rs = this.ps.executeQuery();
		AppInfo ai = null;
		while(rs.next()){
			ai = new AppInfo();
			ai.setId(rs.getInt(1));
			ai.setAppName(rs.getString(2));
			ai.setUserId(rs.getInt(3));
			ai.setDataName(rs.getString(4));
			all.add(ai);
		}
		rs.close();
		this.ps.close();
		return all;
	}

}
