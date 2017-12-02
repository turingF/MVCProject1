package edu.nuaa.dao.XuYangDao;

public interface IAnReDao {
    /**
     *保存分析结果图片
     *@param 应用id，图片路径
     *@return 保存结果
     */
    public boolean SaveRe(int appid, String path) throws Exception;


    /**
     *删除保存图片
     * @param 应用id，图片路径
     *@return 删除结果
     *
     */
    public boolean DeleteRe(int appid, String path) throws Exception;

}
