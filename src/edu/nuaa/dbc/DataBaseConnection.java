package edu.nuaa.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	// 定义了MySQL数据库的驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 定义了MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/bddb";
	// 用户名
	public static final String DBUSER = "root";
	// 密码
	public static final String DBPASS = "admin";

	private Connection conn = null;

	// 在构造方法里面进行了数据库连接
	public DataBaseConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}
	}

	// 取得数据库连接
	public Connection getConnection() {
		return this.conn;
	}

	// 数据库关闭
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
