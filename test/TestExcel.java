import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.ZongZheVo.Excel;

import java.util.ArrayList;

public class TestExcel {
    private static int IN=2;
    private static int NUM=100;
    //测试正确情况1：在原来没有重复表的情况下，新建一个表，并将所有表中数据导入过程正确。
    //测试正确情况2：如果有重复的表出现，也不怕了
    public static void testCreateDatas(String dbname,String excelpath){
      try {
          System.out.print(DaoFactory.getExcelDaoInstance().saveExcelToMysql(dbname,excelpath));
      } catch (Exception e) {
          e.printStackTrace();
          System.out.print("失败");
      }
  }
   //测试正确情况1：在原来没有重复表的情况下，新建一个表，并将所有表中数据导入过程正确。
   //测试正确情况2：如果有重复的表出现，也不怕了
    private static void testCreateProperty(ArrayList<String> header,ArrayList<String> pre){
        //如何获取属性表表头的表内属性什么都每个给提示的情况下？？
        //这里接口设置的有问题
        //所以现在只能要求前端将表头和属性同时传递给我
        //所有可能会出现有关一致性的bug
        try {
            System.out.print(DaoFactory.getExcelDaoInstance().savePropertyToMysql("Demo",createHeader(),setProperties()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void testGetDatas(){
        Excel temp = new Excel();
        try {
            temp = DaoFactory.getExcelDaoInstance().getExcelDataFromMysql("demo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("一共有"+temp.getNumcolomns()+"行"+" "+"一共有"+temp.getNumrows()+"列");
        for (int i = 0; i < temp.getNumcolomns(); i++) {
            System.out.print(temp.getHeaders().get(i) + "   ");
        }
        System.out.println();
        for (int i = 0; i < temp.getNumrows(); i++)
        {
            for(int j=0;j<temp.getNumcolomns();j++)
            {
                System.out.print(temp.getDatas().get(i).get(j)+"   ");
            }
            System.out.println();
        }
    }
    //生成测试用例
    private static ArrayList<String> createHeader(){
      ArrayList<String> result=new ArrayList<String>();
      result.add("第一个");
      result.add("第二个");
      result.add("和");
      return result;

  }
    private static ArrayList<String> setProperties(){
      ArrayList<String> result=new ArrayList<String>();
      result.add("0.1");
      result.add("0.1");
      result.add("1");
      return result;
  }
    public static void main(String[] args) {
//             testCreateDatas();
//             testCreateProperty();

    }
}
