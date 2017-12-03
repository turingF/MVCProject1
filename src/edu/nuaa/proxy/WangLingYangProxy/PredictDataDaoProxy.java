package edu.nuaa.proxy.WangLingYangProxy;

import edu.nuaa.dao.WangLingYangDao.IPredectDataDao;
import edu.nuaa.dao.impl.WangLingYangImpl.PredectDataImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.WangLingYangVo.PredictData;

import java.util.List;

public class PredictDataDaoProxy implements IPredectDataDao {
    private DataBaseConnection dbc = null;
    private IPredectDataDao dao = null;

    public PredictDataDaoProxy()throws Exception{
        this.dbc = new DataBaseConnection();
        this.dao = new PredectDataImpl(this.dbc.getConnection());
    }
    @Override
    public boolean doCreate(PredictData predictdata) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doCreate(predictdata);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public PredictData findById(int id) throws Exception {
        PredictData predictData = null;
        try {
            predictData = this.dao.findById(id);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return predictData;
    }

    @Override
    public boolean delete(int id) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.delete(id);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<PredictData> findAll() throws Exception {
        List<PredictData> all = null;
        try {
            all = this.dao.findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }
}
