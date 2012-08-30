package com.pocoer.dao;

import com.pocoer.model.ExclusiveKey;

/**
 * APIKey数据库访问抽象类
 * @author roadahead
 *
 */
public interface ExclusiveKeyDAO {
	/**
	 * 返回一个APIKey实体类
	 * @param id 所要返回的实体类的ID
	 * @return
	 */
	public ExclusiveKey getExclusiveKey(Long id);
	
	/**
	 * 向数据库中存储一条APIKey数据
	 * @param exclusiveKey 所要存储的APIKey的实体类
	 * @return
	 */
	public boolean save(ExclusiveKey kebsite);
	
	/**
	 * 判断数据库中是否存在这样的一条APIKey数据
	 * @param APIKey 所要检查的APIKey
	 * @return
	 */
	public boolean isHold(String APIKey);
}
