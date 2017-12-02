package edu.nuaa.dao.ZhouShiQiDao;

import java.util.List;

import edu.nuaa.vo.ZhouShiQiVo.AlgorithmModel;;

public interface IAlgorithmModelDao {

	/**
	 * 创建一个算法模型（预测模型）
	 * @param am
	 * @return
	 * @throws Exception
	 */
	public boolean doCreat(AlgorithmModel am)throws Exception;

	/**
	 * 删除一个已存在的算法模型
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delModel(int id)throws Exception;

	/**
	 * 查询一个已存在的算法模型
	 * @param appid
	 * @return
	 * @throws Exception
	 */
	public List<AlgorithmModel> queryAlModel(int appid)throws Exception;

}
