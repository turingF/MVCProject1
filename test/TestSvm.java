import edu.nuaa.tool.algorithm.svm.SvmTrain;
import edu.nuaa.tool.algorithm.svm.Svm_Predict;
import edu.nuaa.tool.algorithm.testalgorithm.testSvm;
import libsvm.svm;
import libsvm.svm_model;

import java.util.ArrayList;

public class TestSvm {
    private static int IN=2;
    private static int NUM=100;
    private static ArrayList<ArrayList<Double>> createInTrainList(){
        ArrayList<ArrayList<Double>> result=new ArrayList<ArrayList<Double>>();
        ArrayList<Double> temp=new ArrayList<Double>();
        double count=50;
        for(int i=0;i<NUM;i++)
        {
            temp=new ArrayList<Double>();
            for(int j=0;j<IN;j++)
            {
                temp.add(count);
                count++;
            }
            result.add(temp);
        }
        return result;
    }
    private static ArrayList<Double> createPreOutTrainList( ArrayList<ArrayList<Double>> in){
        ArrayList<Double> result=new ArrayList<Double>();
        double sum=0;
        for(int i=0;i<NUM;i++)
        {
            sum=0;
            for(int j=0;j<IN;j++)
            {
                sum+=in.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }
    private static ArrayList<Double> createClassOutTrainList( ArrayList<ArrayList<Double>> in){
        ArrayList<Double> result=new ArrayList<Double>();
        double sum=0;
        for(int i=0;i<NUM;i++)
        {
            sum=0;
            for(int j=0;j<IN;j++)
            {
                sum+=in.get(i).get(j);
            }
            if(sum>=200)
            result.add(1.0);
            else
                result.add(2.0);
        }
        return result;
    }
    private static ArrayList<ArrayList<Double>> createInPreList(){
        ArrayList<ArrayList<Double>> result=new ArrayList<ArrayList<Double>>();
        ArrayList<Double> temp=new ArrayList<Double>();
        double count=0;
        for(int i=0;i<NUM;i++)
        {
            temp=new ArrayList<Double>();
            for(int j=0;j<IN;j++)
            {
                temp.add(count);
                count++;
            }
            result.add(temp);
        }
        return result;
    }

    private static void testClassSvm(){
        ArrayList<ArrayList<Double>> inputT=createInTrainList();
        ArrayList<Double> outputT=createClassOutTrainList(inputT);
        ArrayList<ArrayList<Double>> inputP=createInPreList();
        ArrayList<Double> test=createClassOutTrainList(inputP);
        ArrayList<Double> pres=new ArrayList<Double>();
        SvmTrain svmt=new SvmTrain();
        double value=0;
        String argv="100;1;1e-3;0.1;1;1";
//        temp="cache_size;C;eps;p;svm_type";
        //训练模型
        try {
            svmt.train(inputT,outputT,argv,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //预测数据
        try {

            pres=Svm_Predict.main("G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",inputP);
            System.out.println("正确率"+ testSvm.testModel(inputP,pres,test,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //测试模型
        for(int i=0;i<NUM;i++)
        {
            for(int j=0;j<IN;j++)
            {
                System.out.println("输入层"+inputP.get(i).get(j));
            }
            System.out.println("原结果："+test.get(i)+" 预测结果"+pres.get(i));
        }


    }
    private static void testPreSvm(){
        ArrayList<ArrayList<Double>> inputT=createInTrainList();
        ArrayList<Double> outputT=createPreOutTrainList(inputT);
        ArrayList<ArrayList<Double>> inputP=createInPreList();
        ArrayList<Double> test=createPreOutTrainList(inputP);
        ArrayList<Double> pres=new ArrayList<Double>();
        SvmTrain svmt=new SvmTrain();
        double value=0;
        String argv="100;1;1e-3;0.1;5;2";
//        temp="cache_size;C;eps;p;svm_type";
        //训练模型
        try {
            svmt.train(inputT,outputT,argv,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //预测数据
        try {

            pres=Svm_Predict.main("G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",inputP);
            System.out.println("正确率"+ testSvm.testModel(inputP,pres,test,"G:\\大数据项目\\ideaworkplace\\MVCProject1\\data\\Model",0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //测试模型
        for(int i=0;i<NUM;i++)
        {
            for(int j=0;j<IN;j++)
            {
                System.out.println("输入层"+inputP.get(i).get(j));
            }
            System.out.println("原结果："+test.get(i)+" 预测结果"+pres.get(i));
        }

    }
    public static void main(String[] args) {
     //   testClassSvm();
       testPreSvm();
    }
}
