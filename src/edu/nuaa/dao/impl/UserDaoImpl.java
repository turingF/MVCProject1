package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.nuaa.dao.IUserDao;
import edu.nuaa.vo.User;

public class UserDaoImpl implements IUserDao {

	private Connection conn = null;
	private PreparedStatement ps = null;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean fingLogin(User user) throws Exception {
		boolean flag = false;

		try {
			String sql = "select username from user where uid = ? and password = ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, user.getUid());
			this.ps.setString(2, user.getPassword());
			ResultSet rs = this.ps.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString(1));
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.ps != null) {
				try {
					this.ps.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

}
