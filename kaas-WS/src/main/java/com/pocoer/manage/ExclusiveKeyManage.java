package com.pocoer.manage;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.pocoer.dao.ExclusiveKeyDAO;
import com.pocoer.model.ExclusiveKey;
import com.pocoer.model.Kebsite;

/**
 * 这是存取APIKey的管理类
 * @author roadahead
 *
 */
@Component("exclusiveKeyManage")
public class ExclusiveKeyManage{
	private ExclusiveKeyDAO exclusiveKeyDAO;

	/**
	 * 向数据库中存储一条APIKey数据
	 * @param exclusiveKey 所要存储的APIKey的实体类
	 * @return
	 */
	public boolean add(ExclusiveKey exclusiveKey) {
		exclusiveKeyDAO.save(exclusiveKey);
		return true;
	}
	
	/**
	 * 返回一个APIKey实体类
	 * @param id 所要返回的实体类的ID
	 * @return
	 */
	public ExclusiveKey getExclusiveKey(long id){
		return exclusiveKeyDAO.getExclusiveKey(id);
	}
	
	
	
	public ExclusiveKeyDAO getExclusiveKeyDAO() {
		return exclusiveKeyDAO;
	}
	
	@Resource(name="exclusiveKeyDAOImpl")
	public void setExclusiveKeyDAO(ExclusiveKeyDAO exclusiveKeyDAO) {
		this.exclusiveKeyDAO = exclusiveKeyDAO;
	}

	/**
	 * 判断数据库中是否存在这样的一条APIKey数据
	 * @param keyString 所要检查的APIKey的数据
	 * @return
	 */
	public boolean isHold(StringBuffer keyString) {
		return exclusiveKeyDAO.isHold(keyString.toString());
	}

	/**
	 * 向数据库中存储一条数据
	 * @param kebsite 所要存储的数据的所属的用户
	 * @param keyString 所要存储的数据的APIKey的字符串
	 */
	public void add(Kebsite kebsite, StringBuffer keyString) {
		ExclusiveKey ek = new ExclusiveKey();
		ek.setKebsite(kebsite);
		ek.setKeyString(keyString.toString());
		exclusiveKeyDAO.save(ek);
	}
}
