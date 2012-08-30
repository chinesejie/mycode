package com.pocoer.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.pocoer.dao.ExclusiveKeyDAO;
import com.pocoer.model.ExclusiveKey;
import com.pocoer.model.Kebsite;

/**
 * APIKey
 * @author roadahead
 *
 */ 
@Component("exclusiveKeyDAOImpl")
public class ExclusiveKeyDAOImpl implements ExclusiveKeyDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public ExclusiveKey getExclusiveKey(Long id) {
		ExclusiveKey exclusiveKey = null;
		Session session = sessionFactory.getCurrentSession();
		//System.out.println("111111111111111111111111111");
		exclusiveKey = (ExclusiveKey)session.get(ExclusiveKey.class,id);
		return exclusiveKey;
	}

	/**
	 * 
	 * @param exclusiveKey 
	 * @return
	 */
	public boolean save(ExclusiveKey exclusiveKey) {
		Session session = sessionFactory.getCurrentSession();
		//System.out.println("222222222222222222222");
		session.save(exclusiveKey);
		return true;
	}
	/**
	 * 
	 * @param APIKey
	 * @return
	 */
	public boolean isHold(String APIKey) {
		boolean exclusiveKey = false;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery("select * from ExclusiveKey exclusiveKey " + " where exclusiveKey.keyString like '"+APIKey+"'").addEntity(ExclusiveKey.class);
		List<ExclusiveKey> exclusiveKeys = (List<ExclusiveKey>)q.list();
		if(!exclusiveKeys.isEmpty()){
			for(ExclusiveKey e : exclusiveKeys){
				if(e.getKeyString().equals(APIKey)){
					exclusiveKey = true;
					return exclusiveKey;
				}
			}
		}
		return exclusiveKey;
	}

}
