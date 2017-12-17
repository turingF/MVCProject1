package edu.nuaa.dao.ZongZheDao;
import edu.nuaa.vo.ZongZheVo.*;

import java.util.ArrayList;

public interface IExcelDao {

    /**
     * 将excel数据存入数据库
     * @param excelname 数据库表名
     * @param excelpath excel文件路径
     * @param excel 存储excel数据文件路径
     * @return 结果信息
     * @throws Exception 异常
     */
    public String saveExcelToMysql(String excelname, String excelpath)throws Exception;

    /**
     * 将excel数据模型属性存入数据库
     * @param dbname 数据表（注意是该属性对应的数据表明）
     * @param header 数据表的表头
     * @param property 存有属性的链表
     * @return 处理结果
     * @throws Exception 异常
     */
    public String savePropertyToMysql(String dbname, ArrayList<String> header, ArrayList<String> property)throws Exception;
    public Excel getExcelDataFromMysql(String dbname)throws Exception;
    //将预测好的数据存入数据库中
    public String savePreData(String dbname,ArrayList<String> predatas,String header)throws Exception;
}
