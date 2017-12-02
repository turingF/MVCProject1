package edu.nuaa.proxy.ZhouShiQiProxy;

import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.ZhouShiQiDao.IAlgorithmModelDao;
import edu.nuaa.dao.impl.ZhouShiQiDaoImpl.AlgorithmModelDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.ZhouShiQiVo.AlgorithmModel;

public class AlgorithmModelDaoProxy implements IAlgorithmModelDao{

	private DataBaseConnection dbc = null;
	private IAlgorithmModelDao dao = null;
	
	public AlgorithmModelDaoProxy()throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new AlgorithmModelDaoImpl(this.dbc.getConnnection());
	}

	@Override
	public boolean doCreat(AlgorithmModel am) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			flag = this.dao.doCreat(am);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean delModel(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			flag = this.dao.delModel(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<AlgorithmModel> queryAlModel(int appid) throws Exception {
		// TODO Auto-generated method stub
		List<AlgorithmModel> all = new ArrayList<AlgorithmModel>();
		try{
			all = this.dao.queryAlModel(appid);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
}
