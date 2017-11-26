package edu.nuaa.dao.impl.ZongZheDaoImpl;

import edu.nuaa.dao.ZongZheDao.IExcelDao;
import edu.nuaa.tool.Sql;
import edu.nuaa.vo.ZongZheVo.Excel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ExcelDaoImpl implements IExcelDao{

    private Connection conn = null;
    private PreparedStatement ps = null;

    public ExcelDaoImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     *初始化excel数据结构接口（将文件中的信息提炼到数据结构中）
     * @param excelname 数据表明
     * @param excelpath 文件路径
     * @param excel 数据结构
     * @return 提取出数据文件信息的excel数据结构
     * @throws Exception 异常
     */
    private Excel initExcel(String excelname,String excelpath, Excel excel) throws Exception{
        excel.setExcelpath(excelpath);
        excel.setDbname(excelname);
        //文件输入流
        FileInputStream filein = null;
        try {
            filein = new FileInputStream(excelpath);//获取文件输入流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //通过excel操做api
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(filein);//将文件数据存入workbook
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取excel文件中的表单
        Sheet sheet1 = null;
        try {
            sheet1 = wb.getSheetAt(0);//获取excel中的表单
            excel.setNumrows(sheet1.getLastRowNum());//获取表单中的行数
            excel.setNumcolomns(sheet1.getRow(0).getLastCellNum());//获取表单中的列数
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //获取excel文件中每个表头中的内容
        ArrayList<String> headers=new ArrayList<String>();//表头链表
        try{
        for(int i=0;i<excel.getNumcolomns();i++)
        {
            headers.add(sheet1.getRow(0).getCell(i).getStringCellValue());//获取表头内容
        }
        }catch(Exception e)
        {
            e.printStackTrace();;
        }

        //获取excel表中数据
        ArrayList<String> temp=null;
        ArrayList<ArrayList<String>> datas=new ArrayList<ArrayList<String>>();
        try {
            for (int i = 0; i < excel.getNumrows(); i++) {
                temp = new ArrayList<String>();
                for (int j = 0; j < excel.getNumcolomns(); j++) {
                    temp.add(sheet1.getRow(i).getCell(j).getStringCellValue());//获取第i,j个数据内容
                }
                datas.add(temp);
            }
            excel.setDatas(datas);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
            return excel;
    }

    /**
     *保存数据信息接口（将数据表中除了表头的部分存入数据库）
     * @param excel 包含数据信息的excel数据结构
     * @return 结果信息
     * @throws Exception 异常
     */
    private String putDataInMysql(Excel excel) throws Exception {
        String result=null;//用来返回异常结果
        for(int i=0;i<excel.getNumrows();i++){
            String sql =Sql.makeInsertSql(excel.getDbname(),excel.getHeaders(),excel.getDatas().get(i));
            this.ps = this.conn.prepareStatement(sql);
            for(int j=1;j<excel.getNumcolomns();j++){
                this.ps.setString(j,excel.getDatas().get(i).get(j));
            }
            if (this.ps.executeUpdate() <=0) {
                result="保存数据失败";
            }
            this.ps.close();//这里如果不关闭可能会出问题
        }
        this.ps.close();
        return result;
    }

    /**
     *保存属性信息接口（将数据模型的属性存入属性表中）
     * @param dbname 数据表明
     * @param headers 属性表对应的数据表的表头
     * @param property 属性内容链表
     * @return 结果信息
     * @throws Exception 异常
     */
    private String putPropertyInMysql(String dbname,ArrayList<String> headers,ArrayList<String> property)throws Exception{
       String result=null;
        String sql=null;

        //创建sql语句
        try {
            sql=Sql.makeInsertSql(dbname,headers,property);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //使用sql语句
        try {
            this.ps = this.conn.prepareStatement(sql);
            for(int j=1;j<headers.size();j++){
                this.ps.setString(j,property.get(j));
            }
            if (this.ps.executeUpdate() <=0) {
                result= "保存属性失败";
            }
            this.ps.close();//这里如果不关闭可能会出问题
        } catch (SQLException e) {
            e.printStackTrace();
            result= "保存属性失败";
        }
        return result;

    }

    /**
     *创建属性表
     * @param dbname 数据表明
     * @param property 数据属性链表
     * @return 结果信息
     * @throws Exception 异常
     */
    private String createPropertyTable(String dbname,ArrayList<String> property) throws Exception {
       String result=null;
        String sql=Sql.makeCopySql(dbname,"property"+dbname);
        ps=conn.prepareStatement(sql);
        try {
            ps.executeUpdate(sql);
        }catch(Exception e)
        {
            result="属性表创建失败";//-7创建属性表失败
            e.printStackTrace();
            ps.close();
            return result;
        }
        ps.close();
        return result;
    }

    /**
     *创建数据表
     * @param excel 初始化过的excel数据结构
     * @return 结果信息
     * @throws Exception 异常
     */
    private String createDataTable(Excel excel) throws Exception {
        String result=null;
        result="创建成功！";
        //获取excel表表头
        ArrayList<String> header=null;
        try {
            header=excel.getHeaders();//获取数据表表头
        }catch(Exception e)
        {
            result="获取数据表头失败";//-6获取数据表表头失败
            e.printStackTrace();
            return result;
        }

        //创建mysql数据表语句
        String sql=Sql.makeCreateSql(excel.getDbname(),excel.getHeaders());
        //获取对象
        ps = conn.prepareStatement(sql);
        try {
            ps.executeUpdate(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            result="create语句执行失败";
            ps.close();
            return result;
        }
        ps.close();
        return result;
    }

    /**
     * 获取数据库表字段个数
     * @param dbname 数据库表名
     * @return 个数
     * @throws Exception 异常
     */
    private int getCountHeaders(String dbname) throws Exception{
        int count=0;
        String sql=null;
        try {
            sql=Sql.makeHeadersCountSql(dbname,"bddb");
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
            rs.close();
            this.ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 获取数据库表字段
     * @param dbname 数据库表名
     * @return 所有字段
     * @throws Exception 异常
     */
    private ArrayList<String> getHeaders(String dbname)throws Exception{
        ArrayList<String> headers=new ArrayList<String>();
        String sql=null;
        try {
            sql=Sql.makeFindHeaderSql(dbname,"dbbd");
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                headers.add(rs.getString(1));
            }
            rs.close();
            this.ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        headers.remove(0);//要把主键那个地方除去
        return headers;
    }

    /**
     * 获取所有属性
     * @param dbname 数据库表名
     * @return 所有属性
     * @throws Exception 异常
     */
    private ArrayList<String> getPreporties(String dbname)throws Exception{
        ArrayList<String> preporities=new ArrayList<String>();
        String sql=null;
        int num=getCountHeaders(dbname);//获取字段数量
        try {
            sql= Sql.makeSelectAllSql("property"+dbname);
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                for(int i=0;i<num;i++) {
                    preporities.add(rs.getString(i+1));
                }
            }
            rs.close();
            this.ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        preporities.remove(0);//要把主键那个地方除去
        return preporities;
    }

    /**
     * 获取数据库数据
     * @param dbname 数据库表名
     * @return 数据库中数据
     * @throws Exception 异常
     */
    private ArrayList<ArrayList<String>> getDatas(String dbname)throws Exception{
        ArrayList<ArrayList<String>> datas=new ArrayList<ArrayList<String>>();
        String sql=null;
        ArrayList<String> temp=null;
        int num=getCountHeaders(dbname);//获取字段数量
        try {
            sql= Sql.makeSelectAllSql(dbname);
            this.ps = this.conn.prepareStatement(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                temp=new ArrayList<String>();
                for(int i=0;i<num;i++) {
                    temp.add(rs.getString(i+1));
                }
                temp.remove(0);//要把主键那个地方除去
                datas.add(temp);
            }
            rs.close();
            this.ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    //外部接口
    @Override
    public String saveExcelToMysql(String excelname,String excelpath, Excel excel) throws Exception {
        String result=null;
        result="创建成功！";

        //初始化excel对象
        try{
            excel=initExcel(excelname,excelpath,excel);//初始化excel对象
        }catch (Exception e)
        {
           result="初始化excel对象失败";
           e.printStackTrace();
           return result;
        }

        //创建数据表
        try{
            result=createDataTable(excel);//创建数据表
        }catch(Exception e)
        {
            e.printStackTrace();
            return result;
        }

        //保存数据
        try{
            result=putDataInMysql(excel);//保存数据
        }catch(Exception e)
        {
            e.printStackTrace();
            return result;
        }
    return result;
    }
    @Override
    public String savePropertyToMysql(String dbname,ArrayList<String> headers,ArrayList<String> property) {
        String result=null;
        result="创建成功！";

        //创建属性表
        try{
            result=createPropertyTable(dbname,property);//创建属性表
        }catch (Exception e)
        {
            e.printStackTrace();
            return result;
        }

        //保存属性
        try{
            result=putPropertyInMysql("property"+dbname,headers,property);//保存属性
        }catch (Exception e)
        {
            e.printStackTrace();
            return result;
        }
       return result;
    }
    @Override
    public Excel getExcelDataFromMysql(String dbname) {
        Excel excel=new Excel();//主要需要的要有表头，要有数据内容，要有属性内容
        ArrayList<ArrayList<String>> datas=new ArrayList<ArrayList<String>>();
        //获取数据表
        try {
            datas=getDatas(dbname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置表名
        excel.setDbname(dbname);//设置表名
        //设置路径为空
        excel.setExcelpath(null);//设置文件路径
        //设置表头
        try {
            excel.setHeaders(getHeaders(dbname));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置属性
        try {
            excel.setProperties(getPreporties(dbname));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置数据
        excel.setDatas(datas);
        //设置行列
        excel.setNumcolomns(datas.get(0).size());//减去主键那一行
        excel.setNumrows(datas.size());
        return excel;
    }

}
