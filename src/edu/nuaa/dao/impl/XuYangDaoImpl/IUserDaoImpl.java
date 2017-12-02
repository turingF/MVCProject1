package edu.nuaa.dao.impl.XuYangDaoImpl;



import edu.nuaa.dao.XuYangDao.IUserDao;
import edu.nuaa.vo.XuYangVo.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class IUserDaoImpl implements IUserDao {

	private Connection conn=null;
	private PreparedStatement ps = null;
	
	public IUserDaoImpl(Connection conn){
		this.conn=conn;
	}
	
	@Override
	public boolean login(String account, String password) throws Exception {
		boolean flag = false;
		String sql = "select id from userData where account = ? and password=? ";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		this.ps.setString(2, password);
		
		System.out.println(account+" "+password);
		ResultSet rs = this.ps.executeQuery();
		
		if(rs.next()){
			flag=true;
		}
		
		rs.close();
		ps.close();
		
		return flag;
	}

	@Override
	public boolean register(String account, String password) throws Exception {
		boolean flag=false;
		String sql = "insert into userData (account,password) values (?,?)";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		this.ps.setString(2, password);
		
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		
		this.ps.close();
		
		return flag;
	}


	@Override
	public UserInfo findUserByAccount(String account) throws Exception {
	String sql = "Select id,account,password from userData where account = ?";
		
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		
		
		
		ResultSet rs = this.ps.executeQuery();
		
		UserInfo us=null;
		
		if(rs.next()){
			us=new UserInfo();
			us = new UserInfo();
            us.setId(rs.getInt(1));
            us.setAccount(rs.getString(2));
            us.setPassword(rs.getString(3));


		}
		
		rs.close();
		ps.close();
		return us;
	}

	@Override
	public boolean setUserInfo(UserInfo us) throws Exception {
		boolean flag = false;
		String account = us.getAccount(),password = us.getPassword();
		String sql="update userData set password=? where account=?";
		this.ps=conn.prepareStatement(sql);

		this.ps.setString(1, password);
		this.ps.setString(2,account);

		
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		
		ps.close();
		return flag;
	}

}
