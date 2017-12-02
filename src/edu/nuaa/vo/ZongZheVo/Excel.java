package edu.nuaa.vo.ZongZheVo;


import java.io.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Excel
{
    private String excelpath;//excel文件路径
    private int numrows;//有几行数据
    private int numcolomns;//有几列数据
    private String dbname;//数据表对应的表名
    private ArrayList<String> headers;//excel表的表头
    private ArrayList<String> properties;//每个表头的属性
    private ArrayList<ArrayList<String>> datas;//数据

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public ArrayList<ArrayList<String>> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<ArrayList<String>> datas) {
        this.datas = datas;
    }

    public String getExcelpath() {
        return excelpath;
    }

    public void setExcelpath(String excelpath) {
        this.excelpath = excelpath;
    }

    public int getNumrows() {
        return numrows;
    }

    public void setNumrows(int numrows) {
        this.numrows = numrows;
    }

    public int getNumcolomns() {
        return numcolomns;
    }

    public void setNumcolomns(int numcolomns) {
        this.numcolomns = numcolomns;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<String> headers) {
        this.headers = headers;
    }



}
