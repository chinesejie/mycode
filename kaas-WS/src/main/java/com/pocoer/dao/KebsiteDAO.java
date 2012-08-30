package com.pocoer.dao;

import com.pocoer.model.Kebsite;

/**
 * 用户信息数据库访问抽象类
 * @author roadahead
 *
 */
public interface KebsiteDAO {
	/**
	 * 返回一个用户信息实体类
	 * @param id 所要返回的实体类的ID
	 * @return
	 */
	public Kebsite getKebsite(Long id);
	
	/**
	 * 返回一条用户信息数据
	 * @param KebsiteName 所要返回的用户信息的用户名
	 * @return
	 */
	public Kebsite getKebsite(String kebsiteName);
	
	/**
	 * 向数据库中存储一条用户信息数据
	 * @param kebsite 所要存储的用户的实体类
	 * @return
	 */
	public boolean save(Kebsite kebsite);
}
