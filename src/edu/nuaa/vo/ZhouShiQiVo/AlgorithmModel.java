package edu.nuaa.vo.ZhouShiQiVo;

public class AlgorithmModel {
	private int id;   //算法模型id
	private int appid;  //对应应用id
	private int type;  //算法模型类型
	private String modelpath;  //模型存储路径
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getModelpath() {
		return modelpath;
	}
	public void setModelpath(String modelpath) {
		this.modelpath = modelpath;
	}

}
