import edu.nuaa.factory.DaoFactory;
import edu.nuaa.tool.DealData;
import edu.nuaa.vo.ZongZheVo.Excel;

import java.util.ArrayList;

public class TestDealData {
    //在数据库中创建属性表
    private static void testCreateProperty(ArrayList<String> header, ArrayList<String> pre){
        //如何获取属性表表头的表内属性什么都每个给提示的情况下？？
        //这里接口设置的有问题
        //所以现在只能要求前端将表头和属性同时传递给我
        //所有可能会出现有关一致性的bug
        try {
            System.out.print(DaoFactory.getExcelDaoInstance().savePropertyToMysql("Demo",header,pre));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //在数据库中创建数据表
    public static void testCreateDatas(String dbname,String excelpath){
        try {
            System.out.print(DaoFactory.getExcelDaoInstance().saveExcelToMysql(dbname,excelpath));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("失败");
        }
    }
    //从数据库中获取数据
    private static Excel testGetDatas(String dbname){
        Excel temp = new Excel();
        try {
            temp = DaoFactory.getExcelDaoInstance().getExcelDataFromMysql(dbname);
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
        return temp;
    }
    //将获取来的数据与属性进行设置,整理出可以使用的数据
    private static ArrayList<ArrayList<Double>> setPrepro(ArrayList<String> preproties,ArrayList<ArrayList<String>> datas){
        return DealData.transToTrainData(preproties,datas);
    }
    private static ArrayList<String> makePreproties(ArrayList<String> header){
        ArrayList<String> result=new ArrayList<String>();
        for(int i=0;i<header.size();i++)
        {
            String temp="";
            int value = (int)(Math.random()*2);
            temp+=String.valueOf(value)+"_";

            if(value==1){//输入
                value = (int)(Math.random()*2);
                if(i==8||i==20||i==6||i==11) value=0;
                temp+=String.valueOf(value)+"_";

                if(value==1){//数据
                    temp+=Math.random()+"_";
                }
                if(value==0){//枚举
                    temp+="黑色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                    temp+="白色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                    temp+="黄色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                }
            }
            if(value==0){//输出
                value = (int)(Math.random()*2);
                if(i==8||i==20||i==6||i==11) value=0;
                temp+=String.valueOf(value)+"_";

                if(value==0){//枚举
                    temp+="黑色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                    temp+="白色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                    temp+="黄色:";
                    value = (int)(Math.random()*20);
                    temp+=String.valueOf(value)+"_";
                }
                if(value==1){//数据
                    temp+=Math.random()+"_";
                }
            }
            if(value==2)
            {
                temp="#";
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
       testCreateDatas("demo","G:\\大数据项目\\数据集\\123.xlsx");
       Excel temp=testGetDatas("demo");
       ArrayList<String> prepro=makePreproties(temp.getHeaders());
       System.out.println("随机生成的属性是：");
       for(int i=0;i<prepro.size();i++){
           System.out.println(prepro.get(i));
       }
        testCreateProperty(temp.getHeaders(),prepro);
       ArrayList<ArrayList<Double>> data=setPrepro(prepro,temp.getDatas());
        for(int i=0;i<data.size();i++){
            for(int j=0;j<data.get(i).size();j++)
            {
                System.out.print(data.get(i)+" ");
            }
            System.out.println();
        }
    }
}
