package edu.nuaa.dao.impl.WangLingYangImpl;

import edu.nuaa.dao.WangLingYangDao.IPredectDataDao;
import edu.nuaa.vo.WangLingYangVo.PredictData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PredectDataImpl implements IPredectDataDao {


   private Connection conn = null;
   private PreparedStatement ps = null;
   public PredectDataImpl(Connection conn){
       this.conn = conn;
   }


    @Override
    public boolean doCreate(PredictData predictdata) throws Exception {
        boolean flag = false;
        String sql = "insert into predictdata (appid,dataname) values (?,?)";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1,predictdata.getAppid());
        this.ps.setString(2,predictdata.getDataname());
        if(this.ps.executeUpdate()>0){
            flag = true;
        }
        this.ps.close();
        return flag;
    }

    @Override
    public PredictData findById(int id) throws Exception {
        PredictData predictData = null;
        String sql = "select id,appid,dataname from predictdata where id = ?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1,id);
        ResultSet rs = this.ps.executeQuery();
        if(rs.next()){
            predictData = new PredictData();
            predictData.setId(rs.getInt(1));
            predictData.setAppid(rs.getInt(2));
            predictData.setDataname(rs.getString(3));
        }
        rs.close();
        this.ps.close();
        return predictData;
    }

    @Override
    public boolean delete(int id) throws Exception {
        boolean flag = false;
        String sql = "delete from predictdata where id = ?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setInt(1,id);
        if(this.ps.executeUpdate()>0){
            flag = true;
        }
        this.ps.close();
        return flag;
    }

    @Override
    public List<PredictData> findAll() throws Exception {
       List<PredictData> all = new ArrayList<PredictData>();
       String sql = "select id,appid,dataname from predictdata";
       this.ps = this.conn.prepareStatement(sql);
       ResultSet rs = this.ps.executeQuery();
       PredictData predictData = null;
       while(rs.next()){
           predictData = new PredictData();
           predictData.setId(rs.getInt(1));
           predictData.setAppid(rs.getInt(2));
           predictData.setDataname(rs.getString(3));
           all.add(predictData);
       }
       rs.close();
       this.ps.close();
        return all;
    }
}
