package edu.nuaa.tool;

import java.util.ArrayList;

//首先读取进来的二维链表中有数字，有#####，有字符串，所以先不急着将他们统一处理为double,先进行属性处理，将所有的属性设置完成后获得到一个二位链表
//这个表中所有的内容都是数字类型的字符串，然后再进行统一转化

public class DealData {
    private static ArrayList<ArrayList<String>> setPreproToDatas(ArrayList<String> preproties,ArrayList<ArrayList<String>> datas) {
          ArrayList<ArrayList<String>> in=new ArrayList<ArrayList<String>>();
          ArrayList<ArrayList<String>> out=new ArrayList<ArrayList<String>>();
          for(int i=0;i<preproties.size();i++){
              String[] temp=preproties.get(i).split("_");
              if(temp[0].equals("1"))//是输入层
              {
                  if (temp[1].equals("1")) {//是数据
                      ArrayList<String> tempin=new ArrayList<String>();
                      for (int j = 0; j < datas.size(); j++) {
                              tempin.add(String.valueOf(Double.valueOf(temp[2]) * Double.valueOf(datas.get(j).get(i))));
                      }
                  in.add(tempin);
                  }
                  if (temp[1].equals("0")) {//是枚举
                      ArrayList<String> tempin=new ArrayList<String>();
                      //这里有个三重循环，不是一个好的设计
                      for (int j = 0; j < datas.size(); j++) {//遍历该列的所有数据
                          for(int k=2;k<temp.length;k++) {//遍历剩下的所有属性
                              if(temp[k].contains(datas.get(j).get(i))){//找到符合的
                                  tempin.add(temp[k].split(":")[1]);//取出符合的数据对应的值
                              }
                          }
                      }
                      in.add(tempin);
                  }
              }
              int a=0;
               if(temp[0].equals("0"))//是输出层
               {
                   if (temp[1].equals("1")) {//是预测
                       ArrayList<String> tempout=new ArrayList<String>();
                       for (int j = 0; j < datas.size(); j++) {
                           tempout.add(String.valueOf(Double.valueOf(temp[2]) * Double.valueOf(datas.get(j).get(i))));
                       }
                       out.add(tempout);
                   }
                       if (temp[1].equals("0")) {//是分类
                           ArrayList<String> tempout=new ArrayList<String>();
                           for (int j = 0; j < datas.size(); j++) {
                               tempout.add(temp[2]);//枚举变量是一个选项，天啊！我要怎么获得每个枚举变量对应的值
                           }
                        out.add(tempout);
                   }
               }
          }
        ArrayList<ArrayList<String>> rein=new ArrayList<ArrayList<String>>();
        for(int i=0;i<in.get(0).size();i++)
        {
            ArrayList<String> temprein=new ArrayList<String>();
            for(int j=0;j<in.size();j++)
            {
                temprein.add(in.get(i).get(j));
            }
            rein.add(temprein);
        }
        for(int i=0;i<out.size();i++) {
            rein.add(out.get(i));
        }
        return rein;
    }

    private static ArrayList<ArrayList<Double>> transSDataToDData(ArrayList<ArrayList<String>> datas){
        ArrayList<ArrayList<Double>> result=new ArrayList<ArrayList<Double>>();
        for(int i=0;i<datas.size();i++)
          {
              ArrayList<Double> temp=new ArrayList<Double>();
              for(int j=0;j<datas.get(i).size();j++)
              {
                  if(datas.get(i).get(j).contains("#")){
                      temp.add(0.0);
                  }
                  else {
                      temp.add(Double.valueOf(datas.get(i).get(j)));
                      //这里针对枚举型变量可能会抛出异常
                      //现在不会了，因为已经在设置属性的时候处理完了
                  }
              }
              result.add(temp);
          }
          return result;
    }
    private static ArrayList<ArrayList<String>> transDDataToSDate(ArrayList<ArrayList<Double>> datas){
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        for(int i=0;i<datas.size();i++)
        {
            ArrayList<String> temp=new ArrayList<String>();
            for(int j=0;j<datas.get(i).size();j++)
            {
                temp.add(String.valueOf(datas.get(i).get(j)));
            }
            result.add(temp);
        }
        return result;
    }
    //其他都是正常的数据，最后一个是输出层的数据
    public static ArrayList<ArrayList<Double>> transToTrainData(ArrayList<String> preproties,ArrayList<ArrayList<String>> datas){
        ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
        data=setPreproToDatas(preproties,datas);//设置数据的属性
        return transSDataToDData(data);//将输入数据由string转化为double
    }
}
