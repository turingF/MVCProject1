package edu.nuaa.dao.impl.ZhouShiQiDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.ZhouShiQiDao.IAlgorithmModelDao;
import edu.nuaa.vo.ZhouShiQiVo.AlgorithmModel;

public class AlgorithmModelDaoImpl implements IAlgorithmModelDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public AlgorithmModelDaoImpl(Connection connection){
		this.conn = connection;
	}

	@Override
	public boolean doCreat(AlgorithmModel am) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into algorithmmodel (ID, appid, type, modelpath) values (?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, am.getId());
		this.ps.setInt(2, am.getAppid());
		this.ps.setInt(3, am.getType());
		this.ps.setString(4, am.getModelpath());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delModel(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from algorithmmodel where ID = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<AlgorithmModel> queryAlModel(int appid) throws Exception {
		// TODO Auto-generated method stub
		List<AlgorithmModel> all = new ArrayList<AlgorithmModel>();
		String sql = "select * from algorithm where appid = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, appid);
		ResultSet rs = this.ps.executeQuery();
		AlgorithmModel am = new AlgorithmModel();
		while(rs.next()){
			am.setId(rs.getInt(1));
			am.setAppid(rs.getInt(2));
			am.setType(rs.getInt(3));
			am.setModelpath(rs.getString(4));
			all.add(am);
		}
		rs.close();
		this.ps.close();
		return all;
	}

}
