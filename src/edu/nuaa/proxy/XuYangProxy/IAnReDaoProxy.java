package edu.nuaa.proxy.XuYangProxy;


import edu.nuaa.dao.XuYangDao.IAnReDao;
import edu.nuaa.dao.impl.XuYangDaoImpl.IAnReDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;

public class IAnReDaoProxy implements IAnReDao {

    private DataBaseConnection dbc = null;
    private IAnReDao dao = null;

    public IAnReDaoProxy() throws Exception {
        this.dbc = new DataBaseConnection();
        this.dao = new IAnReDaoImpl(this.dbc.getConnection());

    }


    @Override
    public boolean SaveRe(int appid, String path) throws Exception {
        boolean flag = false;

        try {
                flag = this.dao.SaveRe(appid,path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }


        return flag;
    }

    @Override
    public boolean DeleteRe(int appid, String path) throws Exception {
        boolean flag = false;

        try {
                flag = this.dao.DeleteRe(appid,path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }


        return flag;
    }
}
