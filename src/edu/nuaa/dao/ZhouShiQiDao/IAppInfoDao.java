package edu.nuaa.dao.ZhouShiQiDao;



import edu.nuaa.vo.ZhouShiQiVo.AppInfo;

import java.util.List;

public interface IAppInfoDao {

	/**
	 *创建一个应用
	 * @param ai
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(AppInfo ai)throws Exception;

	/**
	 * 删除一个应用
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delApp(int id)throws Exception;

	/**
	 * 查询用户的应用
	 * @param userid
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<AppInfo> queryApp(int userid, String keyword)throws Exception;

	/**
	 * 修改用户已有的某个应用应用名
	 * @param appid
	 * @param newname
	 * @return
	 * @throws Exception
	 */
	public boolean modifyAppName(int appid,String newname)throws Exception;
	
}
