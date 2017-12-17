//import edu.nuaa.factory.DaoFactory;
//import edu.nuaa.tool.algorithm.svm.SvmTrain;
//import edu.nuaa.tool.algorithm.svm.Svm_Predict;
//import edu.nuaa.tool.algorithm.testalgorithm.testSvm;
//import edu.nuaa.tool.*;
//import edu.nuaa.vo.ZongZheVo.Excel;
//
//import java.util.ArrayList;
//
////注意“-”是敏感字符，不允许出现，因为sql语句中不允许出现“-”
//
//public class DataPredict {
//
//    //*******数据相关操做**********************************************************************************
//    private static int IN=2;
//    private static int NUM=100;
//    //测试正确情况1：在原来没有重复表的情况下，新建一个表，并将所有表中数据导入过程正确。
//    //测试正确情况2：如果有重复的表出现，也不怕了
//    public static void testCreateDatas(String dbname,String excelpath){
//        try {
//            System.out.print(DaoFactory.getExcelDaoInstance().saveExcelToMysql(dbname,excelpath));
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.print("失败");
//        }
//    }
//    //测试正确情况1：在原来没有重复表的情况下，新建一个表，并将所有表中数据导入过程正确。
//    //测试正确情况2：如果有重复的表出现，也不怕了
//    private static void testCreateProperty(){
//        //如何获取属性表表头的表内属性什么都每个给提示的情况下？？
//        //这里接口设置的有问题
//        //所以现在只能要求前端将表头和属性同时传递给我
//        //所有可能会出现有关一致性的bug
//        try {
////            System.out.print(DaoFactory.getExcelDaoInstance().savePropertyToMysql("Demo",createHeader(),setProperties()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private static Excel testGetDatas(){
//        Excel temp = new Excel();
//        try {
//            temp = DaoFactory.getExcelDaoInstance().getExcelDataFromMysql("demo");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("一共有"+temp.getNumcolomns()+"行"+" "+"一共有"+temp.getNumrows()+"列");
//        for (int i = 0; i < temp.getNumcolomns(); i++) {
//            System.out.print(temp.getHeaders().get(i) + "   ");
//        }
//        System.out.println();
//        for (int i = 0; i < temp.getNumrows(); i++)
//        {
//            for(int j=0;j<temp.getNumcolomns();j++)
//            {
//                System.out.print(temp.getDatas().get(i).get(j)+"   ");
//            }
//            System.out.println();
//        }
//        return temp;
//    }
//    //生成测试用例
//    private static ArrayList<String> createHeader(){
//        ArrayList<String> result=new ArrayList<String>();
//        result.add("第一个");
//        result.add("第二个");
//        result.add("和");
//        return result;
//
//    }
//    private static ArrayList<String> setPropertiesRandom(ArrayList<String> header){
//        ArrayList<String> result=new ArrayList<String>();
//        for(int i=0;i<header.size();i++)
//        {
//            String temp="";
//            int value = (int)(Math.random()*2);
//            temp+=String.valueOf(value);
//            if(value==1){
//                value = (int)(Math.random()*2);
//                temp+=String.valueOf(value);
//                if(value==1){
//                    temp+=Math.random();
//                }
//            }
//            if(value==0){
//                value = (int)(Math.random()*2);
//                temp+=String.valueOf(value);
//                if(value==0){
//                    value = (int)(Math.random()*20);
//                    temp+=String.valueOf(value);
//                }
//            }
//            result.add(temp);
//        }
//        return result;
//    }
//
//
//    //********算法相关操作********************************************************************************************
//    private static ArrayList<ArrayList<Double>> createInTrainList(){
//        ArrayList<ArrayList<Double>> result=new ArrayList<ArrayList<Double>>();
//        ArrayList<Double> temp=new ArrayList<Double>();
//        double count=50;
//        for(int i=0;i<NUM;i++)
//        {
//            temp=new ArrayList<Double>();
//            for(int j=0;j<IN;j++)
//            {
//                temp.add(count);
//                count++;
//            }
//            result.add(temp);
//        }
//        return result;
//    }
//    private static ArrayList<Double> createPreOutTrainList( ArrayList<ArrayList<Double>> in){
//        ArrayList<Double> result=new ArrayList<Double>();
//        double sum=0;
//        for(int i=0;i<NUM;i++)
//        {
//            sum=0;
//            for(int j=0;j<IN;j++)
//            {
//                sum+=in.get(i).get(j);
//            }
//            result.add(sum);
//        }
//        return result;
//    }
//    private static ArrayList<Double> createClassOutTrainList( ArrayList<ArrayList<Double>> in){
//        ArrayList<Double> result=new ArrayList<Double>();
//        double sum=0;
//        for(int i=0;i<NUM;i++)
//        {
//            sum=0;
//            for(int j=0;j<IN;j++)
//            {
//                sum+=in.get(i).get(j);
//            }
//            if(sum>=200)
//                result.add(1.0);
//            else
//                result.add(2.0);
//        }
//        return result;
//    }
//    private static ArrayList<ArrayList<Double>> createInPreList(){
//        ArrayList<ArrayList<Double>> result=new ArrayList<ArrayList<Double>>();
//        ArrayList<Double> temp=new ArrayList<Double>();
//        double count=0;
//        for(int i=0;i<NUM;i++)
//        {
//            temp=new ArrayList<Double>();
//            for(int j=0;j<IN;j++)
//            {
//                temp.add(count);
//                count++;
//            }
//            result.add(temp);
//        }
//        return result;
//    }
//    private static void testClassSvm(ArrayList<ArrayList<Double>> inputT,ArrayList<Double> outputT,ArrayList<ArrayList<Double>> inputP){
////        ArrayList<ArrayList<Double>> inputT=createInTrainList();
////        ArrayList<Double> outputT=createClassOutTrainList(inputT);
////        ArrayList<ArrayList<Double>> inputP=createInPreList();
////        ArrayList<Double> test=createClassOutTrainList(inputP);
//        ArrayList<Double> pres=new ArrayList<Double>();
//        SvmTrain svmt=new SvmTrain();
//        double value=0;
//        String argv="100;1;1e-3;0.1;1;1";
////        temp="cache_size;C;eps;p;svm_type";
//        //训练模型
//        try {
//            svmt.train(inputT,outputT,argv,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //预测数据
//        try {
//
//            pres= Svm_Predict.main("G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",inputP);
////            System.out.println("正确率"+ testSvm.testModel(inputP,pres,test,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //测试模型
//        for(int i=0;i<NUM;i++)
//        {
//            for(int j=0;j<IN;j++)
//            {
//                System.out.println("输入层"+inputP.get(i).get(j));
//            }
//            System.out.println("原结果："+test.get(i)+" 预测结果"+pres.get(i));
//        }
//
//
//    }
//    private static void testPreSvm(){
//        ArrayList<ArrayList<Double>> inputT=createInTrainList();
//        ArrayList<Double> outputT=createPreOutTrainList(inputT);
//        ArrayList<ArrayList<Double>> inputP=createInPreList();
//        ArrayList<Double> test=createPreOutTrainList(inputP);
//        ArrayList<Double> pres=new ArrayList<Double>();
//        SvmTrain svmt=new SvmTrain();
//        double value=0;
//        String argv="100;1;1e-3;0.1;5;2";
////        temp="cache_size;C;eps;p;svm_type";
//        //训练模型
//        try {
//            svmt.train(inputT,outputT,argv,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //预测数据
//        try {
//
//            pres=Svm_Predict.main("G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",inputP);
//            System.out.println("正确率"+ testSvm.testModel(inputP,pres,test,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //测试模型
//        for(int i=0;i<NUM;i++)
//        {
//            for(int j=0;j<IN;j++)
//            {
//                System.out.println("输入层"+inputP.get(i).get(j));
//            }
//            System.out.println("原结果："+test.get(i)+" 预测结果"+pres.get(i));
//        }
//
//    }
//
//    public static void main(String[] args) {
//        //第一步：从文件目录中获取一个有训练数据的excel，并读取进数据库
//        testCreateDatas("demo","G:\\大数据项目\\数据集\\123.xlsx");
//        System.out.print("卧槽！！");
//        //第二步：从数据库中取出存入的数据，由用户选择好输入层和输出层后，并且设置完属性后，进行向量机的训练。
//        Excel excel=testGetDatas();
//        //用户选择好要训练的数据（这个应该在属性里有用户选择项）
//        //属性里的用户选择项1.输入层还是输出层。2.输入层数据类型是数据还是枚举3.是数据权重是多少，是枚举权重，数据值是多少
//        //相邻的属性之间用“；”分割开。
//        ArrayList<String> prepro=new ArrayList<String>();//这个属性链表中的内容是从前端发过来的
//        prepro=setPropertiesRandom(excel.getHeaders());//同过随机数产生数据属性
//        //将产生的属性与获取的数据导入算法进行数据预测
//        //获取训练数据
//        ArrayList<ArrayList<Double>> tin=new ArrayList<ArrayList<Double>>();
//        tin=DealData.transToTrainData(prepro,excel.getDatas());
//        //训练svm
//
//
//    }
////    TestExcel.testCreateDatas("demo","G:\\大数据项目\\数据集\\二手车数据.xlsx");
//}
