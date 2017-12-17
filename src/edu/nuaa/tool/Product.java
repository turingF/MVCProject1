package edu.nuaa.tool;

public class Product {
    
    private double name;    //类别名称
    private double num;        //销量
    
    public Product(double name, Double double1) {
        this.name = name;
        this.num = double1;
    }
    
    public double getName() {
        return name;
    }
    public void setName(double name) {
        this.name = name;
    }
    public double getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
    
} 