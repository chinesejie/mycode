package com.pocoer.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.pocoer.dao.KebsiteDAO;
import com.pocoer.model.Kebsite;


/**
 * 用户信息数据库访问实现类
 * @author roadahead
 *
 */
@Component("kebsiteDAOImpl")
public class KebsiteDAOImpl implements KebsiteDAO {
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 返回一个用户信息实体类
	 * @param id 所要返回的实体类的ID
	 * @return
	 */
	public Kebsite getKebsite(Long id) {
		Kebsite kebsite = null;
		Session session = sessionFactory.getCurrentSession();
		System.out.println("111111111111111111111111111");
		kebsite = (Kebsite)session.get(Kebsite.class,id);
		return kebsite;
	}
	
	/**
	 * 向数据库中存储一条用户信息数据
	 * @param kebsite 所要存储的用户的实体类
	 * @return
	 */
	public boolean save(Kebsite kebsite) {
		//System.out.println("11111111111111111");
		//System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		//System.out.println("222222222222222222222");
		session.save(kebsite);
		return true;
	}
	
	/**
	 * 返回一条用户信息数据
	 * @param KebsiteName 所要返回的用户信息的用户名
	 * @return
	 */
	public Kebsite getKebsite(String kebsiteName) {
		Kebsite kebsite = null;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery("select * from Kebsite kebsite " + " where kebsite.kebsiteName like '"+kebsiteName+"'").addEntity(Kebsite.class);
		List<Kebsite> kebsites = (List<Kebsite>)q.list();
		if(!kebsites.isEmpty()){
			for(Kebsite k : kebsites){
				if(k.getKebsiteName().equals(kebsiteName)){
					kebsite = k;
					return kebsite;
				}
			}
		}
		return kebsite;
	}

}
