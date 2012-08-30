package com.pocoer.manage;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pocoer.dao.KebsiteDAO;
import com.pocoer.model.Kebsite;

/**
 * 这是存取用户信息的管理类
 * @author roadahead
 *
 */
@Component("kebsiteManage")
public class KebsiteManage{
	KebsiteDAO kebsiteDAO;
	
	/**
	 * 向数据库中存储一条用户信息数据
	 * @param kebsite 所要存储的用户的实体类
	 * @return
	 */
	public boolean add(Kebsite kebsite) {
		kebsiteDAO.save(kebsite);
		return true;
	}
	/**
	 * 返回一个用户信息实体类
	 * @param id 所要返回的实体类的ID
	 * @return
	 */
	public Kebsite getKebsite(long id){
		System.out.println(id);
		return kebsiteDAO.getKebsite(id);
	}
	
	/**
	 * 返回一条用户信息数据
	 * @param KebsiteName 所要返回的用户信息的用户名
	 * @return
	 */
	public Kebsite getKebsite(String KebsiteName){
		System.out.println(KebsiteName);
		return kebsiteDAO.getKebsite(KebsiteName);
	}
	
	
	public KebsiteDAO getKebsiteDAO() {
		return kebsiteDAO;
	}
	@Resource(name="kebsiteDAOImpl")
	public void setKebsiteDAO(KebsiteDAO kebsiteDAO) {
		this.kebsiteDAO = kebsiteDAO;
	}

}
