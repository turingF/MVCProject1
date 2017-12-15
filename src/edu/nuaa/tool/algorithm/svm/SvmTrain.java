package edu.nuaa.tool.algorithm.svm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import libsvm.*;
import java.io.*;
import java.util.*;

public class SvmTrain {
        private svm_parameter param;		// 用来定义svm相关属性的属性变量
        private svm_problem prob;		     // 用来存入svm输入的变量
        private svm_model model;            //svm模型变量
        private String input_file_name;		 // 输入文件名不需要，因为要使用数据库
        private static String model_file_name; // 模型文件名也不需要，因为要使用数据库
        private String error_msg;//错误信息
        private int cross_validation;
        private int nr_fold;


        private void readProblem(ArrayList<ArrayList<Double>> traininput,ArrayList<Double> trainoutput) throws Exception {
            if(traininput.size()!=trainoutput.size())
            {
                throw new Exception();
            }
            Vector<Double> vy = new Vector<Double>();
            Vector<svm_node[]> vx = new Vector<svm_node[]>();
            int max_index = 0;
            int m=0;
            //循环读取数据
            for(int i=0;i<traininput.size();i++)
            {
                m=traininput.get(i).size();//每一个输入语句有几层
                svm_node[] x = new svm_node[m];
                for(int j=0;j<m;j++)
                {
                    x[j] = new svm_node();
                    x[j].index = j+1;
                    x[j].value = traininput.get(i).get(j);
                }
                if(m>0) max_index = Math.max(max_index, x[m-1].index);
                vx.addElement(x);
                vy.addElement(trainoutput.get(i));//好像就是输出层
            }

            prob = new svm_problem();
            prob.l = vy.size();
            prob.x = new svm_node[prob.l][];
            for(int i=0;i<prob.l;i++)
                prob.x[i] = vx.elementAt(i);
            prob.y = new double[prob.l];
            for(int i=0;i<prob.l;i++)
                prob.y[i] = vy.elementAt(i);

            if(param.gamma == 0 && max_index > 0)
                param.gamma = 1.0/max_index;

            if(param.kernel_type == svm_parameter.PRECOMPUTED)
                for(int i=0;i<prob.l;i++)
                {
                    if (prob.x[i][0].index != 0)
                    {
                        System.err.print("Wrong kernel matrix: first column must be 0:sample_serial_number\n");
                        System.exit(1);
                    }
                    if ((int)prob.x[i][0].value <= 0 || (int)prob.x[i][0].value > max_index)
                    {
                        System.err.print("Wrong input format: sample_serial_number out of range\n");
                        System.exit(1);
                    }
                }
        }
        //自己封装一些函数用试试
        private void setTrainData(ArrayList<ArrayList<Double>> in, ArrayList<Double> out) throws Exception {
            String path="G:\\大数据项目\\ideaworkplace\\Model";
            try {
                readProblem(in,out);
            } catch (Exception e) {
                throw new Exception("ZongZheSvmAlgorithmException");
            }
        }
        private void setSVMParam(String argv,String modelname){
            int i;
            svm_print_interface print_func = null;	// default printing to stdout
            param = new svm_parameter();
            // default values
            param.svm_type = svm_parameter.C_SVC;
            param.kernel_type = svm_parameter.RBF;
            param.degree = 3;
            param.gamma = 0;	// 1/num_features
            param.coef0 = 0;
            param.nu = 0.5;
            param.cache_size = 100;
            param.C = 1;
            param.eps = 1e-3;
            param.p = 0.1;
            param.shrinking = 1;
            param.probability = 0;
            param.nr_weight = 0;
            param.weight_label = new int[0];
            param.weight = new double[0];
            cross_validation = 0;
            model_file_name = modelname;//模型输出文件名

            if(argv!=null){
                String[] argvs=argv.split(";");
                param.cache_size = atof(argvs[0]);//100;//cache大小
                param.C =atof(argvs[1]);// 1; //惩罚系数
                param.eps =atof(argvs[2]);// 1e-3;//中止条件
                param.p =atof(argvs[3]);// 0.1;//损失函数p值
                switch(argvs[4])//选择不同的向量机类型，进行预测或分类
                {
                    case "1":param.svm_type=svm_parameter.C_SVC;break;//分类向量机
                    case "2":param.svm_type=svm_parameter.NU_SVC;break;//分类向量机
                    case "3":param.svm_type=svm_parameter.ONE_CLASS;break;//分类向量机
                    case "4":param.svm_type=svm_parameter.EPSILON_SVR;break;//预测向量机
                    case "5":param.svm_type=svm_parameter.NU_SVR;break;//预测向量机
                }
                switch(argvs[5])
                {
                    case "1":param.kernel_type=svm_parameter.LINEAR;break;
                    case "2":param.kernel_type=svm_parameter.POLY;break;
                    case "3":param.kernel_type=svm_parameter.RBF;break;
                    case "4":param.kernel_type=svm_parameter.SIGMOID;break;
                    case "5":param.kernel_type=svm_parameter.PRECOMPUTED;break;
                }
            }

        }
        public String train(ArrayList<ArrayList<Double>> in, ArrayList<Double> out,String argv,String modelname)throws Exception{
            setSVMParam(argv,modelname);//设置向量机属性
            setTrainData(in,out);//设置训练数据
            error_msg = svm.svm_check_parameter(prob,param);//检查输入数据与svm向量机属性
            if(error_msg != null)
            {
                System.err.print("ERROR: "+error_msg+"\n");
                System.exit(1);
            }
            //如果交叉验证参数不等于0，就交叉验证均方误差
            if(cross_validation != 0)
            {
                do_cross_validation();
            }
            else
            {
                model = svm.svm_train(prob,param);//把设置好的向量机属性与训练数据写入，返回一个模型。
                svm.svm_save_model(model_file_name,model);//把训练好的模型存入相应的文件。
            }
            return model_file_name;
        }
        private static svm_print_interface svm_print_null = new svm_print_interface() {
            public void print(String s) {}
        };
        //好像是用来输出帮助信息的
        private static void exit_with_help() {
            System.out.print(
                    "Usage: svm_train [options] training_set_file [model_file]\n"
                            +"options:\n"
                            +"-s svm_type : set type of SVM (default 0)\n"
                            +"	0 -- C-SVC\n"
                            +"	1 -- nu-SVC\n"
                            +"	2 -- one-class SVM\n"
                            +"	3 -- epsilon-SVR\n"
                            +"	4 -- nu-SVR\n"
                            +"-t kernel_type : set type of kernel function (default 2)\n"
                            +"	0 -- linear: u'*v\n"
                            +"	1 -- polynomial: (gamma*u'*v + coef0)^degree\n"
                            +"	2 -- radial basis function: exp(-gamma*|u-v|^2)\n"
                            +"	3 -- sigmoid: tanh(gamma*u'*v + coef0)\n"
                            +"	4 -- precomputed kernel (kernel values in training_set_file)\n"
                            +"-d degree : set degree in kernel function (default 3)\n"
                            +"-g gamma : set gamma in kernel function (default 1/num_features)\n"
                            +"-r coef0 : set coef0 in kernel function (default 0)\n"
                            +"-c cost : set the parameter C of C-SVC, epsilon-SVR, and nu-SVR (default 1)\n"
                            +"-n nu : set the parameter nu of nu-SVC, one-class SVM, and nu-SVR (default 0.5)\n"
                            +"-p epsilon : set the epsilon in loss function of epsilon-SVR (default 0.1)\n"
                            +"-m cachesize : set cache memory size in MB (default 100)\n"
                            +"-e epsilon : set tolerance of termination criterion (default 0.001)\n"
                            +"-h shrinking : whether to use the shrinking heuristics, 0 or 1 (default 1)\n"
                            +"-b probability_estimates : whether to train a SVC or SVR model for probability estimates, 0 or 1 (default 0)\n"
                            +"-wi weight : set the parameter C of class i to weight*C, for C-SVC (default 1)\n"
                            +"-v n : n-fold cross validation mode\n"
                            +"-q : quiet mode (no outputs)\n"
            );
            System.exit(1);
        }
        //交叉验证均方误差函数
        private void do_cross_validation() {
            int i;
            int total_correct = 0;
            double total_error = 0;
            double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;
            double[] target = new double[prob.l];

            svm.svm_cross_validation(prob,param,nr_fold,target);
            if(param.svm_type == svm_parameter.EPSILON_SVR ||
                    param.svm_type == svm_parameter.NU_SVR)
            {
                for(i=0;i<prob.l;i++)
                {
                    double y = prob.y[i];
                    double v = target[i];
                    total_error += (v-y)*(v-y);
                    sumv += v;
                    sumy += y;
                    sumvv += v*v;
                    sumyy += y*y;
                    sumvy += v*y;
                }
                System.out.print("Cross Validation Mean squared error = "+total_error/prob.l+"\n");
                System.out.print("Cross Validation Squared correlation coefficient = "+
                        ((prob.l*sumvy-sumv*sumy)*(prob.l*sumvy-sumv*sumy))/
                                ((prob.l*sumvv-sumv*sumv)*(prob.l*sumyy-sumy*sumy))+"\n"
                );
            }
            else
            {
                for(i=0;i<prob.l;i++)
                    if(target[i] == prob.y[i])
                        ++total_correct;
                System.out.print("Cross Validation Accuracy = "+100.0*total_correct/prob.l+"%\n");
            }
        }
        //工具函数：将输入字符串s转化为浮点数
        private static double atof(String s) {
            double d = Double.valueOf(s).doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d))
            {
                System.err.print("NaN or Infinity in input\n");
                System.exit(1);
            }
            return(d);
        }
        //工具函数：将输入字符串转化为整型
        private static int atoi(String s)
        {
            return Integer.parseInt(s);
        }
}
