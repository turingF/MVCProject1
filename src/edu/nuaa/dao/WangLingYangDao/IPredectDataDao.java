package edu.nuaa.dao.WangLingYangDao;

import edu.nuaa.vo.WangLingYangVo.PredictData;

import java.util.List;

public interface IPredectDataDao {
    public boolean doCreate(PredictData predictdata)throws Exception;

    public PredictData findById(int id)throws Exception;

    public boolean delete(int id)throws Exception;

    public List<PredictData> findAll()throws Exception;


}
