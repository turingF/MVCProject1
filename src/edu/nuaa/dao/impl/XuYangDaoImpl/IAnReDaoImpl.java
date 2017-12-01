package edu.nuaa.dao.impl.XuYangDaoImpl;

import edu.nuaa.dao.XuYangDao.IAnReDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IAnReDaoImpl implements IAnReDao{



    private Connection conn=null;
    private PreparedStatement ps = null;

    public IAnReDaoImpl(Connection conn){
        this.conn=conn;
    }

    @Override
    public boolean SaveRe(int appid, String path) throws SQLException {
        boolean flag = false;
        String sql = "insert into analyticresult (appid,resultpath) values (?,?)";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, appid);
        this.ps.setString(2, path);

        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }

        this.ps.close();

        return flag;
    }


    @Override
    public boolean DeleteRe(int appid, String path) throws SQLException {
        boolean flag = false;
        String sql = "DELETE FROM analyticresult WHERE appid=? and resultpath=?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1, appid);
        this.ps.setString(2, path);

        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }

        this.ps.close();

        return flag;
    }
}
