package edu.nuaa.tool;

import java.util.ArrayList;

//sql类：主要用来生成一些sql语句。
//注意：目前创建表每个类型都是varchar,主键是id,int,
//下个版本开发功能，将数据库连接传递进来后可以通过数据库访问获取数据表中每个字段的值

public class Sql {
    /**
     *创建数据库创建语句
     * @param tablename 创建数据表的名称
     * @param headers   创建数据表的表项
     * @return  创建好的sql语句
     * @throws Exception
     */
    public static String makeCreateSql(String tablename,ArrayList<String> headers)throws Exception{
        int num=headers.size();
        //设置表名与主键自增
        String sql="create table "+tablename+"(id int(255) primary key not null auto_increment,";
        for(int i=0;i<num;i++)
        {
            if(i==num-1)
            {
                sql+= headers.get(i);//添加表头
                sql+=" varchar(255)";
            }
            else {
                sql +=headers.get(i);
                sql += " varchar(255),";
            }
        }
        sql+=");";
        return sql;
    }
    /**
     *创建数据库插入语句
     * @param tablename 要插入的表
     * @param headers  要插入表的表头
     * @param values 要插入的值
     * @return 创建好的sql语句
     * @throws Exception
     */
    public static String makeInsertSql(String tablename,ArrayList<String> headers,ArrayList<String> values)throws Exception{
        int num=headers.size();
        String result=null;
        String sql="insert into "+tablename+"(";
        for(int i=1;i<num;i++)
        {
            if(i==num-1) {
                sql+=headers.get(i);
            }
            else{
                sql+=headers.get(i)+",";
            }
        }
        sql+=" values(";
        for(int i=1;i<num;i++)
        {
            if(i==num-1){
                sql+="'"+values.get(i)+"'";
            }
            else{
                sql+="'"+values.get(i)+"',";
            }

        }
        sql+=");";
//        sql+="id int(255) primary key not null auto_increment,";//设置主键
//        "insert into users(username,password,age,sex) values('小别','123456',22,0)";
        return sql;
    }
    /**
     *创建数据库删除语句
     * @param tablename 要删除操做的表名
     * @param headers  删除的条件表头
     * @param values  删除的条件值
     * @return 创建好的sql语句
     * @throws Exception
     */
    public static String makeDeleteSql(String tablename,ArrayList<String> headers,ArrayList<String> values)throws Exception{
       String sql=null;
       return sql;
    }
    /**
     *创建数据库复制语句
     * @param srctablename  原表名称
     * @param destablename  目的表名称
     * @return 创建好的sql语句
     * @throws Exception
     */
    public static String makeCopySql(String srctablename,String destablename)throws Exception{
        String sql="create table property"+destablename+" like "+srctablename+";";
//        create  table  t2 like t1;
        return sql;
    }
    /**
     * 创建查询表项字段语句
     * @param tablename 数据表名
     * @param databasename 数据库名
     * @return 创建好的sql语句
     * @throws Exception
     */
    public static String makeFindHeaderSql(String tablename,String databasename)throws Exception {
        String sql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = '" + tablename + "' and table_schema = '" + databasename + "';";
        return sql;
    }

    /**
     * 创建查找全部信息语句
     * @param dbname 数据库名
     * @return 创建好的sql语句
     */
    public static String makeSelectAllSql(String dbname){
        String sql="select * from "+dbname+";";
        return sql;
    }

    /**
     *
     * @param tablename 数据库表名
     * @param databasename 数据库名
     * @return 创建好的sql语句
     */
    public static String makeHeadersCountSql(String tablename,String databasename){
        String sql="select count(*) from information_schema.`COLUMNS` where TABLE_SCHEMA='"+databasename+"' and TABLE_NAME='"+tablename+"';";
        return sql;
    }
}
