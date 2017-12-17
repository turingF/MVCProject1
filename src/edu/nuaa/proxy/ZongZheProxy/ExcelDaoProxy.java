package edu.nuaa.proxy.ZongZheProxy;

import edu.nuaa.dao.ZongZheDao.IExcelDao;
import edu.nuaa.dao.impl.ZongZheDaoImpl.ExcelDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.ZongZheVo.Excel;

import java.util.ArrayList;

public class ExcelDaoProxy implements IExcelDao {

    private DataBaseConnection dbc = null;
    private IExcelDao dao = null;

    public ExcelDaoProxy() throws Exception{
        this.dbc = new DataBaseConnection();
        this.dao = new ExcelDaoImpl(this.dbc.getConnection());
    }

    @Override
    public String saveExcelToMysql(String excelname, String excelpath) throws Exception {
        return this.dao.saveExcelToMysql(excelname,excelpath);
    }

    @Override
    public String savePropertyToMysql(String dbname, ArrayList<String> header, ArrayList<String> property) throws Exception {
        return this.dao.savePropertyToMysql(dbname,header,property);
    }

    @Override
    public Excel getExcelDataFromMysql(String dbname) throws Exception {
        return this.dao.getExcelDataFromMysql(dbname);
    }

    @Override
    public String savePreData(String dbname, ArrayList<String> predatas, String header) throws Exception {
        return this.dao.savePreData(dbname,predatas,header);
    }
}
